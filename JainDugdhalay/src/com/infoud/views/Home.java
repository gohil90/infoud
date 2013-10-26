package com.infoud.views;

import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;

import com.infoud.constants.StringConstants;
import com.infoud.controller.MainController;
import com.infoud.model.OrderInfo;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

@SuppressWarnings("serial")
public class Home extends JFrame {

	private JPanel contentPane;
	private static int TOTAL_ORDER_INFO_COUNT = 10;

	private MainController mainController = new MainController();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 630);
		setResizable(false);
		setTitle(StringConstants.CLIENT_HEADER);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setHeader();

		createLeftPanel();
		createRightPanel();
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
	}

	/* Start changes by Nishant J. */
	public String[] getItemName(int i) {
		String itemName[] = { "G/P", "Mk", "BSD", "Item 1", " Item 2",
				"Item 3", "Item 4" };
		return itemName;
	}

	public String[] itemQuantity(int i) {
		String itemQuantity[] = { "500", "50", "10", "20", "30", "505", "600" };
		return itemQuantity;
	}

	/* End changes by Nishant J. */

	public void createLeftPanel() {
		JScrollPane leftScrollPane = new JScrollPane();
		leftScrollPane.setBounds(10, 65, 600, 520);
		contentPane.add(leftScrollPane);

		JPanel mainOrderPanel = new JPanel();
		mainOrderPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		leftScrollPane.setViewportView(mainOrderPanel);
		mainOrderPanel.setLayout(new GridLayout(TOTAL_ORDER_INFO_COUNT, 1, 10,
				10));
		mainOrderPanel.setPreferredSize(new Dimension(550,
				TOTAL_ORDER_INFO_COUNT * 100));

		List<Object> orderList = mainController.fetchAllOrdersInfo();
		if (null != orderList)
			TOTAL_ORDER_INFO_COUNT = orderList.size();

		int i = 0;

		OrderInfoPanel order = null;
		while (i < TOTAL_ORDER_INFO_COUNT) {

			order = new OrderInfoPanel();
			OrderInfo orderInfo = (OrderInfo) orderList.get(i);
			order.setCustomerName(orderInfo.getCustomerName());
			order.setOrderAmount(orderInfo.getAmount()+"");
			/* Start changes by Nishant J. */
			order.setItemName(getItemName(i), itemQuantity(i));
			/* End changes by Nishant J. */
			order.setBorderTitle("21/10 " + (i + 1) + ":00 PM");
			mainOrderPanel.add(order);

			i++;
		}

	}

	public void createRightPanel() {
		/*
		 * Start Select Customer panel.(vab's part to be merge here)
		 */
		JPanel selCust = new JPanel();
		selCust.setBorder(new EmptyBorder(10, 10, 10, 10));
		selCust.setBounds(625, 65, 315, 250);
		selCust.setBorder(new TitledBorder(null,
				StringConstants.SELECT_CUSTOMER_PANEL_TITLE,
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(selCust);
		/*
		 * End Select Customer panel.
		 */

		/*
		 * Start Add New Customer Panel.
		 */
		AddCustomer cust = new AddCustomer();

		JPanel addCust = new JPanel();
		addCust.setBorder(new EmptyBorder(10, 10, 10, 10));
		addCust.setBounds(625, 325, 315, 190);
		addCust.setBorder(new TitledBorder(null,
				StringConstants.ADD_NEW_CUSTOMER_PANEL_TITLE,
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		addCust.setLayout(new GridLayout(1, 2));
		contentPane.add(addCust);
		addCust.add(cust);
		/*
		 * End Add New Customer panel.
		 */
		/* Start changes by Nishant J. */
		JPanel itemDetail = new JPanel();
		itemDetail.setBorder(new EmptyBorder(10, 10, 10, 10));
		itemDetail.setBounds(625, 520, 315, 70);
		itemDetail.setBorder(new TitledBorder(null,
				StringConstants.ITEM_DETAILS_PANEL_TITLE, TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		JButton viewItem = new JButton(
				StringConstants.ITEM_AND_LIST_PRICE_BUTTON_TEXT);
		viewItem.setBounds(80, 10, 200, 25);
		itemDetail.add(viewItem);
		contentPane.add(itemDetail);
		/* End changes by Nishant J. */

	}

}
