package com.infoud.views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.infoud.constants.StringConstants;

import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class ItemListAndPrice extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ItemListAndPrice frame = new ItemListAndPrice();
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
	public ItemListAndPrice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 630);
		setResizable(false);
		setTitle(StringConstants.CLIENT_HEADER);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		setHeader();
	}

	public void setHeader() {
		JLabel clientNameTitle = new JLabel(StringConstants.CLIENT_HEADER);
		clientNameTitle.setHorizontalAlignment(SwingConstants.CENTER);
		clientNameTitle.setFont(new Font("Arial", Font.BOLD, 22));
		clientNameTitle.setBounds(10, 5, 944, 40);
		contentPane.add(clientNameTitle);

		/*
		 * Start Changes by Nishant for calling Customer Detail Page.
		 */
		JLabel nextScreen = new JLabel(">>");
		nextScreen.setBounds(920, 10, 30, 20);
		contentPane.add(nextScreen);
		nextScreen.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				CustDetail frameobj = new CustDetail();
				frameobj.setVisible(true);

			}
		});
		/*
		 * End Changes by Nishant for calling Customer Detail Page.
		 */

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 50, 934, 10);
		contentPane.add(separator);

		JPanel addItemForm = new JPanel();

		addItemForm.setLayout(null);
		addItemForm.setBorder(new TitledBorder(null, "ADD ITEM",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		addItemForm.setBounds(649, 66, 295, 165);
		contentPane.add(addItemForm);

		JLabel lblItemName = new JLabel("Item Name :");
		lblItemName.setBounds(10, 47, 73, 27);
		addItemForm.add(lblItemName);

		textField = new JTextField();
		textField.setBounds(85, 50, 200, 20);
		addItemForm.add(textField);
		textField.setColumns(10);

		JLabel lblItemPrice = new JLabel("Item Price :");
		lblItemPrice.setBounds(10, 85, 73, 27);
		addItemForm.add(lblItemPrice);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(85, 88, 200, 20);
		addItemForm.add(textField_1);

		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(109, 127, 89, 23);
		addItemForm.add(btnReset);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(10, 127, 89, 23);
		addItemForm.add(btnNewButton);
	}
}
