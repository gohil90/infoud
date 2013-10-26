package com.infoud.views;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class PlaceOrder extends JPanel implements TableModelListener{
	
	private JLabel date = new JLabel("Date : ");
	private JLabel time = new JLabel("Time : ");
	private JLabel place = new JLabel("Place : ");	

	JTextField idate = new JTextField();
	JTextField itime = new JTextField();
	JTextField iplace = new JTextField();	
	
	JButton placeOrder = new JButton("PLACE ORDER");
	
	public PlaceOrder()
	{
		setLayout(null);
		
		JTable table = new JTable(new MyTableModel());
		table.getModel().addTableModelListener( this);
		JScrollPane scrollPane = new JScrollPane(table);
		
		table.setFillsViewportHeight(true);

		date.setBounds(10, 20, 50, 20);
		
		idate.setBounds(65, 20, 100, 20);

		time.setBounds(220, 20, 50, 20);

		itime.setBounds(285, 20, 100, 20);

		place.setBounds(10, 60, 60, 20);

		iplace.setBounds(80, 60, 305, 20);

		scrollPane.setBounds(10, 100, 400, 300);
		
		placeOrder.setBounds(90, 425, 200, 25);
		
		add(date);
		add(idate);
		add(time);
		add(itime);
		add(place);
		add(iplace);
		add(scrollPane);
		add(placeOrder);
	}	
	public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
        TableModel model = (TableModel)e.getSource();
        String columnName = model.getColumnName(column);
        Object data = model.getValueAt(row, column);       
        //System.out.println(data.toString());
    }
}
