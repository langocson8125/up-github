package GiaiDe02;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Form extends JFrame {

	private JPanel contentPane;
	private JTextField tf_ID;
	private JTextField tf_hoTen;
	private JTextField tf_namSinh;
	private JTextField tf_timKiem;
	private QuanLyCauThu QLCT;
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
		// khởi tạo trình quản quản lý cầu thủ
		this.QLCT = new QuanLyCauThu();
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 908, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quản Lý Cầu Thủ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(342, 13, 210, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(12, 73, 12, 16);
		contentPane.add(lblId);
		
		tf_ID = new JTextField();
		tf_ID.setBounds(35, 70, 116, 22);
		contentPane.add(tf_ID);
		tf_ID.setColumns(10);
		
		JLabel lblHTn = new JLabel("Họ tên");
		lblHTn.setBounds(195, 73, 37, 16);
		contentPane.add(lblHTn);
		
		tf_hoTen = new JTextField();
		tf_hoTen.setColumns(10);
		tf_hoTen.setBounds(242, 70, 116, 22);
		contentPane.add(tf_hoTen);
		
		tf_namSinh = new JTextField();
		tf_namSinh.setBounds(474, 70, 116, 22);
		contentPane.add(tf_namSinh);
		tf_namSinh.setColumns(10);
		
		JLabel lblNmSinh = new JLabel("Năm sinh");
		lblNmSinh.setBounds(409, 73, 56, 16);
		contentPane.add(lblNmSinh);
		
		JButton tbn_thoat = new JButton("Thoát");
		tbn_thoat.setBounds(793, 283, 97, 25);
		contentPane.add(tbn_thoat);
		
		JLabel lblVTr = new JLabel("Vị trí");
		lblVTr.setBounds(622, 73, 28, 16);
		contentPane.add(lblVTr);
		
		JComboBox cbb_viTri = new JComboBox();
		cbb_viTri.setModel(new DefaultComboBoxModel(new String[] {"Thủ môn", "Hậu vệ", "Tiền đạo", "Tiền vệ"}));
		cbb_viTri.setSelectedIndex(0);
		cbb_viTri.setBounds(662, 70, 84, 22);
		contentPane.add(cbb_viTri);
		
		JButton btn_them = new JButton("Thêm");
		btn_them.setBounds(793, 69, 97, 25);
		contentPane.add(btn_them);
		
		JLabel lblTmKim = new JLabel("Tìm kiếm");
		lblTmKim.setBounds(12, 127, 56, 16);
		contentPane.add(lblTmKim);
		
		tf_timKiem = new JTextField();
		tf_timKiem.setBounds(75, 124, 250, 22);
		contentPane.add(tf_timKiem);
		tf_timKiem.setColumns(10);
		
		JButton tbn_timKiem = new JButton("Tìm kiếm");

		tbn_timKiem.setBounds(337, 124, 97, 23);
		contentPane.add(tbn_timKiem);
		
		JTextArea textArea_ketQua = new JTextArea();
		textArea_ketQua.setBounds(12, 194, 878, 76);
		contentPane.add(textArea_ketQua);
		
		JLabel lblKtQu = new JLabel("Kết quả");
		lblKtQu.setBounds(12, 170, 56, 16);
		contentPane.add(lblKtQu);
		
		//btn_thoat
		tbn_thoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		// btn_them
		btn_them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int ID = Integer.parseInt(tf_ID.getText());
				String hoTen 	= tf_hoTen.getText();
				int namSinh 	= Integer.parseInt(tf_namSinh.getText());
				int viTri 		= cbb_viTri.getSelectedIndex();
				
				String strViTri = null;
				if(viTri == 0) {
					strViTri = "thu mon";
				}
				else if(viTri == 1) {
					strViTri = "hau ve";
				}
				else if(viTri == 2) {
					strViTri = "tien dao";
				}
				else if(viTri == 3) {
					strViTri = "tien ve";
				}
				
				try {
					QLCT.themCauThu(QLCT.initCauThu(ID, hoTen, namSinh, strViTri));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				// message
				JOptionPane.showMessageDialog(null, "Thêm thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
				
				// reset form input field
				tf_ID.setText(null);
				tf_hoTen.setText(null);
				tf_namSinh.setText(null);
				cbb_viTri.setSelectedIndex(0);
			}
		});
		
		// btn_tim_kiem
		tbn_timKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String hoTen 	= tf_timKiem.getText();
				String strResult = null;
				
				if(QLCT.timKiemCauThu(hoTen) != null) {
					textArea_ketQua.setText("Thong tin cau thu: ");
					strResult = QLCT.timKiemCauThu(hoTen);
				}
				else {
					strResult = "Khong tim thay";
				}
				
				textArea_ketQua.append(strResult);
			}
		});
	}
}
