package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clase.Almacen;
import metodo.metodoAlmacen;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class v1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNomProducto;
	private JTextField txtBuscar;
	private JTextField txtCodProducto;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					v1 frame = new v1();
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
	public v1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre producto:");
		lblNewLabel.setBounds(10, 26, 116, 12);
		contentPane.add(lblNewLabel);
		
		txtNomProducto = new JTextField();
		txtNomProducto.setBounds(124, 23, 96, 18);
		contentPane.add(txtNomProducto);
		txtNomProducto.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 215, 735, 197);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		JLabel lblNewLabel_1 = new JLabel("Buscar por código:");
		lblNewLabel_1.setBounds(10, 70, 116, 15);
		contentPane.add(lblNewLabel_1);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(124, 68, 96, 18);
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		metodoAlmacen ma = new metodoAlmacen();
		
		JButton btnNewButton = new JButton("Agregar producto");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		
		
		btnNewButton.setBounds(230, 22, 134, 20);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Código producto:");
		lblNewLabel_2.setBounds(10, 48, 116, 12);
		contentPane.add(lblNewLabel_2);
		
		txtCodProducto = new JTextField();
		txtCodProducto.setBounds(124, 45, 96, 18);
		contentPane.add(txtCodProducto);
		txtCodProducto.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Buscar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtS.setText("");
				Almacen mAlmac = ma.Buscar(LeerCodigoProducto());
				if(mAlmac!= null) {
					txtS.append("Código\tNombre producto");
					txtS.append("\n" + mAlmac.getIdProducto() + "\t"+ mAlmac.getNomProducto());
				}
			}
			String LeerNomProducto() {
				return txtNomProducto.getText();
			}
			int LeerCodigoProducto() {
				return Integer.parseInt(txtCodProducto.getText());
			}
		});
		btnNewButton_1.setBounds(230, 67, 84, 20);
		contentPane.add(btnNewButton_1);

	}
}
