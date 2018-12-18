package Homework02.TienDien;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JOptionPane;
public class Form extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldMaKhachHang;
	private JTextField textFieldHoTen;
	private JTextField textFieldNgayRaHoaDon;
	private JTextField textFieldSoLuong;
	private JTextField textFieldDonGia;
	private JTextField textFieldQuocTich;
	private JTextField textFieldDinhMuc;
	private static TrinhQuanLyHoaDonDien QLHDD;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLHDD = new TrinhQuanLyHoaDonDien();
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
		setResizable(false);
		setTitle("Quản lý hoa đơn tiền điện");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1021, 799);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChngTrnhQun = new JLabel("Chương trình quản lý hóa đơn tiền điện");
		lblChngTrnhQun.setForeground(new Color(0, 51, 255));
		lblChngTrnhQun.setBounds(181, 13, 626, 51);
		lblChngTrnhQun.setFont(new Font("Tahoma", Font.BOLD, 32));
		contentPane.add(lblChngTrnhQun);
		
		JLabel lblMaKhachHang = new JLabel("Mã Khách Hàng");
		lblMaKhachHang.setBounds(48, 119, 139, 26);
		lblMaKhachHang.setToolTipText("Mã Khách Hàng");
		lblMaKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblMaKhachHang);
		
		textFieldMaKhachHang = new JTextField();
		textFieldMaKhachHang.setBounds(219, 115, 139, 41);
		contentPane.add(textFieldMaKhachHang);
		textFieldMaKhachHang.setColumns(10);
		
		JLabel lblHoTen = new JLabel("Họ Tên");
		lblHoTen.setBounds(48, 193, 65, 26);
		lblHoTen.setToolTipText("Họ Tên");
		lblHoTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblHoTen);
		
		textFieldHoTen = new JTextField();
		textFieldHoTen.setBounds(219, 189, 139, 41);
		textFieldHoTen.setColumns(10);
		contentPane.add(textFieldHoTen);
		
		JLabel labelNgayRaHoaDon = new JLabel("Ngày ra hóa đơn");
		labelNgayRaHoaDon.setBounds(48, 263, 154, 26);
		labelNgayRaHoaDon.setToolTipText("Ngày ra hóa đơn");
		labelNgayRaHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(labelNgayRaHoaDon);
		
		textFieldNgayRaHoaDon = new JTextField();
		textFieldNgayRaHoaDon.setBounds(219, 256, 139, 41);
		textFieldNgayRaHoaDon.setColumns(10);
		contentPane.add(textFieldNgayRaHoaDon);
		
		JLabel lblSoLuong = new JLabel("Số Lượng");
		lblSoLuong.setToolTipText("Số Lượng");
		lblSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSoLuong.setBounds(421, 119, 83, 26);
		contentPane.add(lblSoLuong);
		
		textFieldSoLuong = new JTextField();
		textFieldSoLuong.setColumns(10);
		textFieldSoLuong.setBounds(516, 115, 139, 41);
		contentPane.add(textFieldSoLuong);
		
		JLabel lblDonGia = new JLabel("Đơn Giá");
		lblDonGia.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDonGia.setToolTipText("Đơn Giá");
		lblDonGia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDonGia.setBounds(421, 193, 83, 26);
		contentPane.add(lblDonGia);
		
		textFieldDonGia = new JTextField();
		textFieldDonGia.setColumns(10);
		textFieldDonGia.setBounds(516, 188, 139, 42);
		contentPane.add(textFieldDonGia);
		
		JRadioButton rdbtnVietNam = new JRadioButton("Việt Nam");

		rdbtnVietNam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnVietNam.setSelected(true);
		rdbtnVietNam.setBounds(457, 264, 111, 25);
		contentPane.add(rdbtnVietNam);
		
		JRadioButton rdbtnNuocNgoai = new JRadioButton("Nước Ngoài");

		rdbtnNuocNgoai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnNuocNgoai.setBounds(606, 264, 131, 25);
		contentPane.add(rdbtnNuocNgoai);
		
		ButtonGroup groupRadioButton = new ButtonGroup();
		groupRadioButton.add(rdbtnVietNam);
		groupRadioButton.add(rdbtnNuocNgoai);
		
		JLabel lblQuocTich = new JLabel("Quốc Tịch");
		lblQuocTich.setToolTipText("Quốc Tịch");
		lblQuocTich.setVisible(false);
		lblQuocTich.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblQuocTich.setBounds(708, 119, 88, 26);
		contentPane.add(lblQuocTich);
		
		textFieldQuocTich = new JTextField();
		textFieldQuocTich.setColumns(10);
		textFieldQuocTich.setVisible(false);
		textFieldQuocTich.setBounds(808, 115, 139, 41);
		contentPane.add(textFieldQuocTich);
		
		JLabel lblDinhMuc = new JLabel("Định Mức");
		lblDinhMuc.setToolTipText("Định Mức");
		lblDinhMuc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDinhMuc.setBounds(708, 193, 88, 26);
		contentPane.add(lblDinhMuc);
		
		textFieldDinhMuc = new JTextField();
		textFieldDinhMuc.setColumns(10);
		textFieldDinhMuc.setBounds(808, 189, 139, 41);
		contentPane.add(textFieldDinhMuc);
		
		JComboBox comboBoxDoiTuong = new JComboBox();
		comboBoxDoiTuong.setModel(new DefaultComboBoxModel(new String[] {"Sinh hoạt", "Kinh doanh", "Sản xuất"}));
		comboBoxDoiTuong.setSelectedIndex(0);
		comboBoxDoiTuong.setBounds(808, 119, 139, 37);
		contentPane.add(comboBoxDoiTuong);
		
		JLabel labelDoiTuong = new JLabel("Đối tượng");
		labelDoiTuong.setToolTipText("Đối tượng");
		labelDoiTuong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelDoiTuong.setBounds(708, 119, 88, 26);
		
		// radio button event checked
		contentPane.add(labelDoiTuong);
		
		JTextArea textAreaOutput = new JTextArea();
		textAreaOutput.setEditable(false);
		textAreaOutput.setRows(1000);
		textAreaOutput.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textAreaOutput.setBounds(48, 449, 899, 248);
		contentPane.add(textAreaOutput);
		
		JLabel lblOutput = new JLabel("Dữ liệu ra:");
		lblOutput.setForeground(new Color(0, 51, 255));
		lblOutput.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblOutput.setBounds(48, 410, 139, 26);
		contentPane.add(lblOutput);
		
		JButton btnNewButton = new JButton("Thoát");		
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(850, 710, 97, 41);
		contentPane.add(btnNewButton);
		
		JLabel lblChucNang = new JLabel("Chức năng:");
		lblChucNang.setForeground(new Color(0, 51, 255));
		lblChucNang.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblChucNang.setBounds(48, 302, 154, 26);
		contentPane.add(lblChucNang);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setBackground(Color.GREEN);
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnThem.setBounds(808, 246, 139, 46);
		contentPane.add(btnThem);
		
		JButton btnXuatTatCaHoaDon = new JButton("Xuất tất cả hóa đơn");
		btnXuatTatCaHoaDon.setBackground(Color.CYAN);
		btnXuatTatCaHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXuatTatCaHoaDon.setBounds(48, 352, 222, 45);
		contentPane.add(btnXuatTatCaHoaDon);
		
		JButton btnTongSoLuong = new JButton("Tổng số lượng");
		btnTongSoLuong.setBackground(Color.CYAN);
		btnTongSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTongSoLuong.setBounds(282, 352, 166, 45);
		contentPane.add(btnTongSoLuong);
		
		JButton btnTrungBinhThanhTien = new JButton("Trung bình thành tiền");
		btnTrungBinhThanhTien.setBackground(Color.CYAN);
		btnTrungBinhThanhTien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTrungBinhThanhTien.setBounds(457, 352, 243, 45);
		contentPane.add(btnTrungBinhThanhTien);
		
		JButton btnXuatHoaDon92013 = new JButton("Xuất hóa đơn 9/2013");
		btnXuatHoaDon92013.setBackground(Color.CYAN);
		btnXuatHoaDon92013.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXuatHoaDon92013.setBounds(712, 352, 235, 45);
		contentPane.add(btnXuatHoaDon92013);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(Color.ORANGE);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnReset.setBounds(808, 302, 139, 46);
		contentPane.add(btnReset);
		rdbtnVietNam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblDinhMuc.setVisible(true);
				textFieldDinhMuc.setVisible(true);
				comboBoxDoiTuong.setVisible(true);
				labelDoiTuong.setVisible(true);
				lblQuocTich.setVisible(false);
				textFieldQuocTich.setVisible(false);
			}
		});
		
		rdbtnNuocNgoai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblQuocTich.setVisible(true);
				textFieldQuocTich.setVisible(true);
				lblDinhMuc.setVisible(false);
				textFieldDinhMuc.setVisible(false);
				comboBoxDoiTuong.setVisible(false);
				labelDoiTuong.setVisible(false);
			}
		});
		
		// button them
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String maKhachHang  = textFieldMaKhachHang.getText();
				String hoTen		= textFieldHoTen.getText(); 
				String ngayRaHoaDon	= textFieldNgayRaHoaDon.getText();
				int soLuong			= Integer.parseInt(textFieldSoLuong.getText());
				float donGia		= Float.parseFloat(textFieldDonGia.getText());
				boolean checkAdd 	= false;
				
				if(rdbtnVietNam.isSelected()) {
					int dinhMuc		= Integer.parseInt(textFieldDinhMuc.getText());
					int indexSlt 	= comboBoxDoiTuong.getSelectedIndex();
					String doiTuong = null;
					
					if(indexSlt == 0) {
						doiTuong = "sinh hoat";
					}
					else if(indexSlt == 1) {
						doiTuong = "kinh doanh";
					}
					else if(indexSlt == 2) {
						doiTuong = "san xuat";
					}
					
					checkAdd = QLHDD.NhapHoaDonTienDienVietNam(QLHDD.initHoaDonTienDienVietNam(maKhachHang, hoTen, ngayRaHoaDon, soLuong, donGia, doiTuong, dinhMuc));
				}
				else if(rdbtnNuocNgoai.isSelected()) {
					String quocTich = textFieldQuocTich.getText();
					
					checkAdd = QLHDD.NhapHoaDonTienDienNuocNgoai(QLHDD.initHoaDonTienDienNuocNgoai(maKhachHang, hoTen, ngayRaHoaDon, soLuong, donGia, quocTich));
				}
				if(checkAdd == true) {
					JOptionPane.showMessageDialog(null, "Thêm thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
					
					//reset field
					textFieldMaKhachHang.setText(null);
					textFieldHoTen.setText(null);
					textFieldNgayRaHoaDon.setText(null);
					textFieldSoLuong.setText(null);
					textFieldDonGia.setText(null);
					textFieldDinhMuc.setText(null);
					textFieldQuocTich.setText(null);
				}
				else {
					JOptionPane.showMessageDialog(null, "Hóa đơn đã tồn tại","Thông báo", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		// button reset
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldMaKhachHang.setText(null);
				textFieldHoTen.setText(null);
				textFieldNgayRaHoaDon.setText(null);
				textFieldSoLuong.setText(null);
				textFieldDonGia.setText(null);
				textFieldDinhMuc.setText(null);
				textFieldQuocTich.setText(null);
			}
		});
		
		// button xuat tat ca
		btnXuatTatCaHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaOutput.setText(null);
				textAreaOutput.setText("Danh sách hóa đơn:\n");
				if(rdbtnVietNam.isSelected()) {
					textAreaOutput.append(QLHDD.XuatHoaDonTienDienVietNam());
				}
				else if(rdbtnNuocNgoai.isSelected()) {
					textAreaOutput.append(QLHDD.XuatHoaDonTienDienNuocNgoai());
				}
			}
		});
		
		// button tinh trung binh
		btnTrungBinhThanhTien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaOutput.setText(null);
				textAreaOutput.setText("Trung bình cộng thành tiền:\n");
				if(rdbtnVietNam.isSelected()) {
					textAreaOutput.append(String.format("%3.3f", QLHDD.trungBinhCongThanhTienHoaDonTienDienVietNam()));
				}
				else if(rdbtnNuocNgoai.isSelected()) {
					textAreaOutput.append(String.format("%3.3f", QLHDD.trungBinhCongThanhTienHoaDonTienDienNuocNgoai()));
				}
			}
		});
		
		// button hoa don 9/2013
		btnXuatHoaDon92013.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaOutput.setText(null);
				textAreaOutput.setText("Danh sách hóa đơn tháng 9/2013:\n");
				if(rdbtnVietNam.isSelected()) {
					textAreaOutput.append(QLHDD.XuatHoaDonTienDienVietNam());
				}
				else if(rdbtnNuocNgoai.isSelected()) {
					textAreaOutput.append(QLHDD.XuatHoaDonTienDienNuocNgoai());
				}
			}
		});
		
		// button thoat
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
	}
}
