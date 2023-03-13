package ConnData;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JFrameStudents extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAge;
	private JTextField txtAdress;
	private JTextField txtScore;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameStudents frame = new JFrameStudents();
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
	public JFrameStudents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1099, 642);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u7BA1\u7406\u30B7\u30B9\u30C6\u30E0");
		lblNewLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 30));
		lblNewLabel.setBounds(408, 37, 307, 64);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u540D\u524D");
		lblNewLabel_1.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(73, 131, 79, 44);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u4F4F\u6240");
		lblNewLabel_1_1.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(73, 348, 66, 42);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\u5E74\u9F62");
		lblNewLabel_1_1_1.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(73, 208, 79, 44);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("\u6027\u5225");
		lblNewLabel_1_1_1_1.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1.setBounds(73, 277, 79, 44);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("\u70B9\u6570");
		lblNewLabel_1_1_1_1_1.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1.setBounds(73, 427, 79, 44);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		txtName = new JTextField();
		txtName.setBounds(148, 140, 190, 33);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setColumns(10);
		txtAge.setBounds(148, 210, 190, 33);
		contentPane.add(txtAge);
		
		txtAdress = new JTextField();
		txtAdress.setColumns(10);
		txtAdress.setBounds(145, 351, 190, 33);
		contentPane.add(txtAdress);
		
		txtScore = new JTextField();
		txtScore.setColumns(10);
		txtScore.setBounds(148, 431, 190, 33);
		contentPane.add(txtScore);
		
		JComboBox cbGender = new JComboBox();
		cbGender.setFont(new Font("MS UI Gothic", Font.PLAIN, 16));
		cbGender.setModel(new DefaultComboBoxModel(new String[] {"\u7537", "\u5973"}));
		cbGender.setBounds(157, 279, 79, 44);
		contentPane.add(cbGender);
		
		JButton btnNewButton = new JButton("\u4FDD\u5B58");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student st = new Student();
				st.setName(txtName.getText());
				st.setAge(Integer.parseInt(txtAge.getText()));
				st.setGender(cbGender.getSelectedIndex());
				st.setAdress(txtAdress.getText());
				st.setScore(Float.parseFloat(txtScore.getText()));
				ConnJDBC.insert(st);
				JOptionPane.showMessageDialog(null, "ï€ë∂Ç≥ÇÍÇ‹ÇµÇΩ! ");
				showData(ConnJDBC.findAll());
			}
		});
		btnNewButton.setFont(new Font("MS UI Gothic", Font.PLAIN, 25));
		btnNewButton.setBounds(174, 513, 111, 44);
		contentPane.add(btnNewButton);
		
		JButton btnDelete = new JButton("\u524A\u9664");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student st  = new Student();
				st.setName(txtName.getText());
				ConnJDBC.delete(st);
				showData(ConnJDBC.findAll());
			}
		});
		btnDelete.setFont(new Font("MS UI Gothic", Font.PLAIN, 25));
		btnDelete.setBounds(315, 513, 111, 44);
		contentPane.add(btnDelete);
		
		JButton btnFind = new JButton("\u63A2\u3059");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student st = new Student();
				st.setName(txtName.getText());
				showData(ConnJDBC.findByName(st));
				
			}
		});
		btnFind.setFont(new Font("MS UI Gothic", Font.PLAIN, 25));
		btnFind.setBounds(457, 513, 111, 44);
		contentPane.add(btnFind);
		
		JButton btnRefresh = new JButton("\u66F4\u65B0");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				txtAge.setText("");
				txtAdress.setText("");
				txtScore.setText("");
			}
		});
		btnRefresh.setFont(new Font("MS UI Gothic", Font.PLAIN, 25));
		btnRefresh.setBounds(783, 513, 136, 44);
		contentPane.add(btnRefresh);
		
		JButton btnUpdate = new JButton("\u30A2\u30C3\u30D7\u30C7\u30FC\u30C8");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student st = new Student();
				st.setName(txtName.getText());
				st.setAge(Integer.parseInt(txtAge.getText()));
				st.setGender(cbGender.getSelectedIndex());
				st.setAdress(txtAdress.getText());
				st.setScore(Float.parseFloat(txtScore.getText()));
				ConnJDBC.Update(st);
				JOptionPane.showMessageDialog(null, "ï€ë∂Ç≥ÇÍÇ‹ÇµÇΩ! ");
				showData(ConnJDBC.findAll());
			}
		});
		btnUpdate.setFont(new Font("MS UI Gothic", Font.PLAIN, 25));
		btnUpdate.setBounds(594, 513, 156, 44);
		contentPane.add(btnUpdate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(379, 177, 648, 266);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Name", "Gender", "Age", "Adress", "Score"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(0).setMinWidth(30);
		table.getColumnModel().getColumn(1).setMinWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setMinWidth(50);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(3).setMinWidth(50);
		table.getColumnModel().getColumn(4).setMinWidth(50);
		table.getColumnModel().getColumn(5).setPreferredWidth(50);
		table.getColumnModel().getColumn(5).setMinWidth(50);
		table.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		scrollPane.setViewportView(table);
		showData(ConnJDBC.findAll());
	}
	
	public void showData(List<Student>studentL) {
		
		List<Student>listStudent = new ArrayList<>();
		listStudent = studentL;
		DefaultTableModel tableModel;
		table.getModel();
		tableModel = (DefaultTableModel)table.getModel();
		tableModel.setRowCount(0);
		listStudent.forEach((student)->{
			String gender;
			if(student.getGender() == 0)gender = "íj";
			else {gender = "èó";}
			tableModel.addRow(new Object[] {
				student.getId(), student.getName(), student.getAge(),
				gender, student.getAdress(), student.getScore()
			});
		});
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
