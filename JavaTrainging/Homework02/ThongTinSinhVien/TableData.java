package GiaiDe1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.swing.JLabel;
import java.awt.Font;

public class TableData extends JFrame {

	private JPanel contentPane;
	private JTable table;
	QuanLySinhVien QLSV = new QuanLySinhVien();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableData frame = new TableData();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public TableData() {
		this.QLSV.readFileData();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 919, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DefaultTableModel model = new DefaultTableModel();
		
		/*
		 * ERROR
		 * phần tên cột này có vấn đề
		 * thêm tên cột vào rồi mà ko hiện ra tên cột, chỉ hiện ra dữ liệu
		 * còn lại vẫn chạy bình thường
		 */
		ArrayList<String> arrCols= new ArrayList<String>();
		arrCols.add("Mã Sinh Vien");
		arrCols.add("Họ Tên");
		arrCols.add("Ngày Sinh");
		arrCols.add("Địa chỉ");
		arrCols.add("Giới tính");
		arrCols.add("Email");
		arrCols.add("Điểm tổng kết");
		model.setColumnIdentifiers(arrCols.toArray());
	
		ArrayList<String> arrRows= new ArrayList<String>();
		for (SinhVien SV : QLSV.getListSinhVien()) {
			arrRows.add(SV.getMaSinhVien());
			arrRows.add(SV.getHoTen());
			arrRows.add(SV.getNgaySinh());
			arrRows.add(SV.getDiaChi());
			arrRows.add((SV.isGioiTinh()) ? "nam" : "nữ");
			arrRows.add(SV.getEmail());
			arrRows.add(Float.toString(SV.getDiemTongKet()));
			model.addRow(arrRows.toArray());
			arrRows.clear();
		}
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setModel(model);
		table.setBounds(12, 76, 877, 281);
		contentPane.add(table);
		
		JLabel lblDanhSchSinh = new JLabel("Danh sách Sinh viên");
		lblDanhSchSinh.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblDanhSchSinh.setBounds(275, 13, 303, 48);
		contentPane.add(lblDanhSchSinh);
		
	}
}
