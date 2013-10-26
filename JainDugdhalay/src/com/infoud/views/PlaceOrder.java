package com.infoud.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class PlaceOrder extends JPanel {

	private JLabel date = new JLabel("Date : ");
	private JLabel time = new JLabel("Time : ");
	private JLabel place = new JLabel("Place : ");
	private JLabel seperator = new JLabel(" / ");
	private JLabel seperator2 = new JLabel(" / ");
	private JLabel seperator3 = new JLabel(" : ");
	private int yBound = 0;

	private int childId = 0;

	private Map<Integer, PlaceOrderItemPanel> itemList;

	JTextField iDate = new JTextField();
	JTextField iMonth = new JTextField();
	JTextField iYear = new JTextField();

	JTextField iTime = new JTextField();
	JTextField iSec = new JTextField();

	@SuppressWarnings("rawtypes")
	JComboBox comboBox = new JComboBox();

	JTextField iplace = new JTextField();

	JButton placeOrder = new JButton("PLACE ORDER");
	private JTextField iQuantity;
	private JTextField iPrice;
	private final JPanel panel = new JPanel();
	private final JLabel lblItemName = new JLabel("Item Name");
	private final JLabel lblQuantity_1 = new JLabel("Quantity");
	private final JLabel lblPrice_1 = new JLabel("Price");

	private JPanel AllOrderPanel = new JPanel();

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PlaceOrder() {
		setLayout(null);

		itemList = new HashMap<Integer, PlaceOrderItemPanel>();
		yBound = 0;
		childId = 0;

		date.setBounds(10, 20, 50, 20);

		iDate.setBounds(65, 20, 25, 20);
		seperator.setBounds(92, 20, 15, 20);
		iMonth.setBounds(105, 20, 25, 20);
		seperator2.setBounds(132, 20, 15, 20);
		iYear.setBounds(145, 20, 55, 20);

		time.setBounds(257, 20, 50, 20);

		iTime.setBounds(304, 20, 30, 20);
		seperator3.setBounds(335, 20, 15, 20);
		iSec.setBounds(344, 20, 30, 20);
		comboBox.setBounds(381, 20, 63, 20);

		place.setBounds(10, 60, 60, 20);

		iplace.setBounds(63, 60, 382, 20);

		placeOrder.setBounds(155, 457, 200, 25);

		comboBox.addItem("AM");
		comboBox.addItem("PM");

		add(date);
		add(iDate);
		add(seperator);
		add(iMonth);
		add(seperator2);
		add(iYear);
		add(time);
		add(iTime);
		add(seperator3);
		add(iSec);
		add(comboBox);
		add(place);
		add(iplace);
		add(placeOrder);

		final JComboBox itemCombo = new JComboBox();
		itemCombo.setBounds(65, 101, 108, 20);
		itemCombo.addItem("<select>");

		for (int i = 0; i < 10; i++) {
			itemCombo.addItem("Item" + i);
		}
		add(itemCombo);

		JLabel lblSelectItem = new JLabel("Item :");
		lblSelectItem.setBounds(10, 101, 73, 20);
		add(lblSelectItem);

		JLabel lblQuantity = new JLabel("Quantity :");
		lblQuantity.setBounds(185, 101, 63, 20);
		add(lblQuantity);

		iQuantity = new JTextField();
		iQuantity.setBounds(244, 101, 32, 20);
		add(iQuantity);
		iQuantity.setColumns(10);

		JLabel lblPrice = new JLabel("Price :");
		lblPrice.setBounds(286, 101, 63, 20);
		add(lblPrice);

		iPrice = new JTextField();
		iPrice.setColumns(10);
		iPrice.setBounds(322, 101, 50, 20);
		add(iPrice);

		JButton btnAdd = new JButton("Add");

		btnAdd.setBounds(382, 100, 63, 23);
		add(btnAdd);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(Color.BLACK));
		scrollPane.setBounds(22, 165, 422, 280);
		add(scrollPane);

		scrollPane.setViewportView(AllOrderPanel);

		AllOrderPanel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(22, 144, 422, 25);

		add(panel);
		panel.setLayout(null);
		lblItemName.setBounds(10, 0, 120, 20);

		panel.add(lblItemName);
		lblQuantity_1.setBounds(140, 0, 70, 20);

		panel.add(lblQuantity_1);
		lblPrice_1.setBounds(230, 0, 80, 20);

		panel.add(lblPrice_1);

		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PlaceOrderItemPanel createPane = new PlaceOrderItemPanel(
						childId, new ChildActionHandler());
				createPane.setLblItm(itemCombo.getSelectedItem() + "");
				createPane.setLblQuty(iQuantity.getText());
				createPane.setLblPrc(iPrice.getText());
				createPane.setiPrice(iPrice.getText());
				createPane.setiQunty(iQuantity.getText());

				itemList.put(childId, createPane);
				childId++;

				repaintPlaceOrderPanel();
			}
		});

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void repaintPlaceOrderPanel() {
		yBound = 0;
		AllOrderPanel.removeAll();

		Iterator itr = itemList.entrySet().iterator();
		while (itr.hasNext()) {
			Entry<Integer, PlaceOrderItemPanel> entry = (Entry<Integer, PlaceOrderItemPanel>) itr
					.next();

			int id = entry.getKey();
			PlaceOrderItemPanel child = itemList.get(id);

			AllOrderPanel.add(child);
			child.setBounds(0, yBound, 420, 35);
			yBound += 40;

		}

		AllOrderPanel.setPreferredSize(new Dimension(400, yBound));
		AllOrderPanel.revalidate();
		AllOrderPanel.repaint();
	}

	protected class ChildActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			JButton delete = (JButton) e.getSource();
			int id = (Integer) delete.getClientProperty("id");

			itemList.remove(id);

			System.out.println("Here............" + id);

			repaintPlaceOrderPanel();
		}

	}
}
