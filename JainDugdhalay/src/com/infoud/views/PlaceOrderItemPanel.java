package com.infoud.views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class PlaceOrderItemPanel extends JPanel {
	private JTextField iQunty = new JTextField();;
	private JTextField iPrice = new JTextField();

	public int id = 0;

	JLabel lblItm = new JLabel("Item ");
	JLabel lblQuty = new JLabel("quty");
	JLabel lblPrc = new JLabel("prc");

	public void setiQunty(String iQunty) {
		this.iQunty.setText(iQunty);
		;
	}

	public String getiQunty() {
		return this.iQunty.getText();
	}

	public void setiPrice(String iPrice) {
		this.iPrice.setText(iPrice);
	}

	public void setLblItm(String lblItm) {
		this.lblItm.setText(lblItm);
	}

	public void setLblQuty(String lblQuty) {
		this.lblQuty.setText(lblQuty);
	}

	public void setLblPrc(String lblPrc) {
		this.lblPrc.setText(lblPrc);
	}

	/**
	 * Create the panel.
	 */
	public PlaceOrderItemPanel(int id,
			PlaceOrder.ChildActionHandler childActionListener) {
		this.id = id;
		setLayout(null);
		lblItm.setBounds(20, 10, 120, 20);
		add(lblItm);

		lblQuty.setBounds(150, 10, 70, 20);
		add(lblQuty);

		lblPrc.setBounds(230, 10, 50, 20);
		add(lblPrc);

		JButton btnEdit = new JButton("E");

		btnEdit.setBounds(290, 10, 45, 20);
		add(btnEdit);

		JButton btnDelete = new JButton("D");
		btnDelete.addActionListener(childActionListener);
		btnDelete.putClientProperty("id", id);
		btnDelete.setBounds(345, 10, 45, 20);
		add(btnDelete);

		iQunty.setBounds(150, 10, 70, 20);
		add(iQunty);
		iQunty.setVisible(false);
		iQunty.setColumns(10);

		iPrice.setBounds(230, 10, 50, 20);
		add(iPrice);
		iPrice.setVisible(false);
		iPrice.setColumns(10);

		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblQuty.setVisible(false);
				lblPrc.setVisible(false);
				iQunty.setVisible(true);
				iPrice.setVisible(true);
				revalidate();
				repaint();
			}
		});

	}

}
