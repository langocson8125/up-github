package GiaiDe3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Form extends JFrame {

	private JPanel contentPane;
	private JTextField tf_search;
	private JTextField tf_newMean;
	Dictionary myDict = new Dictionary();
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
		Dictionary WM = new Dictionary();
		WM.searchWord("afd");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 752, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDictionary = new JLabel("Dictionary");
		lblDictionary.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblDictionary.setBounds(303, 13, 165, 57);
		contentPane.add(lblDictionary);
		
		JButton btn_exit = new JButton("Thoát");
		btn_exit.setBounds(615, 371, 97, 25);
		contentPane.add(btn_exit);
		
		JLabel lblTmKimT = new JLabel("Tìm kiếm từ điển");
		lblTmKimT.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTmKimT.setBounds(24, 81, 155, 34);
		contentPane.add(lblTmKimT);
		
		tf_search = new JTextField();
		tf_search.setBounds(174, 83, 434, 28);
		contentPane.add(tf_search);
		tf_search.setColumns(10);
		
		JButton btn_search = new JButton("Tìm");
		btn_search.setBounds(615, 85, 97, 25);
		contentPane.add(btn_search);
		
		JTextPane tp_result = new JTextPane();
		tp_result.setFont(new Font("Tahoma", Font.PLAIN, 23));
		tp_result.setBounds(24, 191, 406, 139);
		contentPane.add(tp_result);
		
		JLabel lblKtQu = new JLabel("Kết quả");
		lblKtQu.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblKtQu.setBounds(24, 151, 155, 34);
		contentPane.add(lblKtQu);
		
		JButton btn_add = new JButton("Thêm");
		
		btn_add.setBounds(541, 255, 97, 25);
		contentPane.add(btn_add);
		
		tf_newMean = new JTextField();
		tf_newMean.setColumns(10);
		tf_newMean.setBounds(461, 214, 251, 28);
		
		contentPane.add(tf_newMean);
		
		JLabel lbl_nghiaMoi = new JLabel("");
		lbl_nghiaMoi.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_nghiaMoi.setBounds(461, 182, 251, 34);
		
		contentPane.add(lbl_nghiaMoi);
		
		// thiết lập ẩn cho phần thêm
		tf_newMean.setVisible(false);
		lbl_nghiaMoi.setVisible(false);
		btn_add.setVisible(false);
		
		// btn tim kiem
		btn_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String search = tf_search.getText();
				Word wordFound = myDict.searchWord(search);
				if(wordFound != null) {
					tf_search.setText(null);
					tp_result.setText(wordFound.toString());
				}
				else {
					tp_result.setText("Từ mới cần thêm");
					tf_newMean.setVisible(true);
					lbl_nghiaMoi.setText("Thêm nghĩa mới cho từ: " + search);
					lbl_nghiaMoi.setVisible(true);
					btn_add.setVisible(true);
				}
			}
		});
		
		// btn them
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String search = tf_search.getText();
				String newMean = tf_newMean.getText();
				int newID = myDict.getListWord().size();
				myDict.addWord(myDict.initWord(newID, search, newMean));
				
				// message
				JOptionPane.showMessageDialog(null, "Thêm thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
				
				//reset all
				tp_result.setText(null);
				tf_newMean.setText(null);
				tf_search.setText(null);
				tf_newMean.setVisible(false);
		lbl_nghiaMoi.setVisible(false);
		btn_add.setVisible(false);
			}
		});
		
		// button thoat
		btn_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
