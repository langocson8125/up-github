package GiaiDe4; // nhớ chỉnh lại tên package cho phù hợp nhé :)

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Form extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tf_maHang;
	private JTextField tf_tenHang;
	private JTextField tf_giaBan;
	private JTextField tf_nhaSanXuat;
	private JTextField tf_dungLuong;
	private JTextField tf_mauSac;
	QuanLyDienThoai QLDT = new QuanLyDienThoai();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form frame = new Form();
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
	public Form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 981, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblQunLHng = new JLabel("Quản lý Điện thoại");
		lblQunLHng.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblQunLHng.setBounds(326, 13, 278, 47);
		contentPane.add(lblQunLHng);
		
		JLabel lblMHng = new JLabel("Mã hàng");
		lblMHng.setBounds(33, 124, 56, 16);
		contentPane.add(lblMHng);
		
		tf_maHang = new JTextField();
		tf_maHang.setBounds(101, 121, 116, 22);
		contentPane.add(tf_maHang);
		tf_maHang.setColumns(10);
		
		JLabel lblTnHng = new JLabel("Tên hàng");
		lblTnHng.setBounds(340, 124, 56, 16);
		contentPane.add(lblTnHng);
		
		tf_tenHang = new JTextField();
		tf_tenHang.setColumns(10);
		tf_tenHang.setBounds(408, 121, 116, 22);
		contentPane.add(tf_tenHang);
		
		JLabel lblGiBn = new JLabel("Giá bán");
		lblGiBn.setBounds(669, 124, 56, 16);
		contentPane.add(lblGiBn);
		
		tf_giaBan = new JTextField();
		tf_giaBan.setColumns(10);
		tf_giaBan.setBounds(737, 121, 116, 22);
		contentPane.add(tf_giaBan);
		
		JLabel lblNhSnXut = new JLabel("Nhà sản xuất");
		lblNhSnXut.setBounds(12, 209, 89, 16);
		contentPane.add(lblNhSnXut);
		
		tf_nhaSanXuat = new JTextField();
		tf_nhaSanXuat.setColumns(10);
		tf_nhaSanXuat.setBounds(101, 206, 116, 22);
		contentPane.add(tf_nhaSanXuat);
		
		JLabel lblDungLng = new JLabel("Dung lượng");
		lblDungLng.setBounds(326, 209, 70, 16);
		contentPane.add(lblDungLng);
		
		tf_dungLuong = new JTextField();
		tf_dungLuong.setColumns(10);
		tf_dungLuong.setBounds(408, 206, 116, 22);
		contentPane.add(tf_dungLuong);
		
		JLabel lblMuSc = new JLabel("Màu sắc");
		lblMuSc.setBounds(669, 209, 56, 16);
		contentPane.add(lblMuSc);
		
		tf_mauSac = new JTextField();
		tf_mauSac.setColumns(10);
		tf_mauSac.setBounds(737, 206, 116, 22);
		contentPane.add(tf_mauSac);
		
		JButton btn_them = new JButton("Thêm");
		btn_them.setBounds(269, 290, 97, 25);
		contentPane.add(btn_them);
		
		JButton btn_luu = new JButton("Lưu");
		btn_luu.setBounds(556, 290, 97, 25);
		contentPane.add(btn_luu);
		
		//btn them
		btn_them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ma 			= tf_maHang.getText();
				String ten 			= tf_tenHang.getText();
				float gia 			= Float.parseFloat(tf_giaBan.getText());
				String nhaSanXuat 	= tf_nhaSanXuat.getText();
				int dungLuong 		= Integer.parseInt(tf_dungLuong.getText());
				String mauSac 		= tf_mauSac.getText();
				
				QLDT.themDienThoai(QLDT.initDienThoai(ma, ten, gia, nhaSanXuat, dungLuong, mauSac));
				
				// message
				JOptionPane.showMessageDialog(null, "Thêm thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
				
				tf_maHang.setText(null);
				tf_tenHang.setText(null);
				tf_giaBan.setText(null);
				tf_nhaSanXuat.setText(null);
				tf_dungLuong.setText(null);
				tf_mauSac.setText(null);
			}
		});
		
		// btn luu
		btn_luu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					QLDT.saveData();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}
