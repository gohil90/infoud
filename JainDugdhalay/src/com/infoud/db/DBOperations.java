package com.infoud.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.BeanProcessor;


public class DBOperations {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Object> getAllRecordsForModel(String query, Class className,
			Object[] params, int[] paramTypes) {

		List<Object> list = new ArrayList<Object>();

		Connection conn = DBConnection.connect();
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			preparedStatement = conn.prepareStatement(query);

			if (params != null) {
				for (int i = 1; i <= params.length; i++) {
					preparedStatement.setObject(i, params[i - 1],
							paramTypes[i - 1]);
				}
			}
			rs = preparedStatement.executeQuery();

			BeanProcessor beanProcessor = new BeanProcessor();
			list = beanProcessor.toBeanList(rs, className);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				preparedStatement.close();
				DBConnection.close(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return list;
	}
	

	@SuppressWarnings("rawtypes")
	public Object getSingleRecordForModel(String query, Class className,
			Object[] params, int[] paramTypes) {

		Object object=new Object();

		Connection conn = DBConnection.connect();
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			preparedStatement = conn.prepareStatement(query);

			if (params != null) {
				for (int i = 1; i <= params.length; i++) {
					preparedStatement.setObject(i, params[i - 1],
							paramTypes[i - 1]);
				}
			}
			rs = preparedStatement.executeQuery();

			BeanProcessor beanProcessor = new BeanProcessor();
			object = beanProcessor.toBean(rs, className);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				preparedStatement.close();
				DBConnection.close(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return object;
	}
	
	public int insertRecordForModel(String query,
			Object[] params, int[] paramTypes) {

		
		int rowsInserted=-1;
		Connection conn = DBConnection.connect();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(query);

			if (params != null) {
				for (int i = 1; i <= params.length; i++) {
					preparedStatement.setObject(i, params[i - 1],
							paramTypes[i - 1]);
				}
			}
			rowsInserted = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				DBConnection.close(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return rowsInserted;
	}
	
	public int updateRecordForModel(String query,
			Object[] params, int[] paramTypes) {

		
		int rowsInserted=-1;
		Connection conn = DBConnection.connect();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(query);

			if (params != null) {
				for (int i = 1; i <= params.length; i++) {
					preparedStatement.setObject(i, params[i - 1],
							paramTypes[i - 1]);
				}
			}
			rowsInserted = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				DBConnection.close(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return rowsInserted;
	}
	
	public int deleteRecordForModel(String query,
			Object[] params, int[] paramTypes) {

		
		int rowsInserted=-1;
		Connection conn = DBConnection.connect();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(query);

			if (params != null) {
				for (int i = 1; i <= params.length; i++) {
					preparedStatement.setObject(i, params[i - 1],
							paramTypes[i - 1]);
				}
			}
			rowsInserted = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				DBConnection.close(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return rowsInserted;
	}
}
