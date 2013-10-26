package com.infoud.views;

import javax.swing.table.AbstractTableModel;

class MyTableModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] columnNames = { "Name", "Quality", "Price", "Select" };
	private Object[][] data = {
			{ "Item1", new Integer(10), new Integer(100), new Boolean(false) },
			{ "Item2", new Integer(10), new Integer(100), new Boolean(false) },
			{ "Item3", new Integer(10), new Double(100.05), new Boolean(false) } };

	public MyTableModel() {

	}

	public void setColumnNames() {

	}

	public void setData() {

	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return data.length;
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public Object getValueAt(int row, int col) {
		return data[row][col];
	}

	public Class<? extends Object> getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

	/*
	 * Don't need to implement this method unless your table's editable.
	 */
	public boolean isCellEditable(int row, int col) {
		// Note that the data/cell address is constant,
		// no matter where the cell appears onscreen.
		if ((col == 1) || (col == 3)) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Don't need to implement this method unless your table's data can change.
	 */
	public void setValueAt(Object value, int row, int col) {
		data[row][col] = value;
		fireTableCellUpdated(row, col);
	}

}