package Order;

import java.sql.*;
import java.util.*;

import ConnectionProvider.ConnectionProvider;

public class OrderController {
	public static int addOrder(Order order) {
		int status = 0;
		
		try {
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into orders (purch_amt, ord_date, customer_id, salesman_id) VALUES (?, ?, ?, ?)");
			ps.setDouble(1, order.getPurchaseAmount());
			ps.setDate(2, order.getOrderDate());
			ps.setInt(3, order.getCustomerId());
			ps.setInt(4, order.getSalesmanId());
			
			status = ps.executeUpdate();
			con.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static List<Order> listOrders() {
		List<Order> salesmenList = new ArrayList<Order>();
		try {
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from orders");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Order order = new Order();
				order.setOrderNumber(rs.getInt("ord_no"));
				order.setPurchaseAmount(rs.getDouble("purch_amt"));
				order.setOrderDate(rs.getDate("ord_date"));
				order.setCustomerId(rs.getInt("customer_id"));
				order.setSalesmanId(rs.getInt("salesman_id"));
				
				salesmenList.add(order);
			}
			
			con.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
		return salesmenList;
	}
	
	public static int updateOrder(int id, Order order) {
		int status = 0;
		
		try {
			Connection con = ConnectionProvider.getConnection();

			PreparedStatement ps = con.prepareStatement("update orders (purch_amt, ord_date, customer_id, salesman_id) VALUES (?, ?, ?, ?) where ord_no = ?");
			ps.setDouble(1, order.getPurchaseAmount());
			ps.setDate(2, order.getOrderDate());
			ps.setInt(3, order.getCustomerId());
			ps.setInt(4, order.getSalesmanId());
			ps.setInt(5, id);
			
			status = ps.executeUpdate();
			con.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return status;
	}
	
	public static int deleteOrder(int id) {
		int status = 0;
		
		try {
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from order where ord_no = ?");
			ps.setInt(1, id);
			
			status = ps.executeUpdate();
			con.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return status;
	}
}