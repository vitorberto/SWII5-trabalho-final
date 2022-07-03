package Customer;

import java.sql.*;
import java.util.*;

import ConnectionProvider.ConnectionProvider;

public class CustomerController {
	public static int addCustomer(Customer customer) {
		int status = 0;
		
		try {
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into customer (cust_name, city, grade) VALUES (?, ?, ?)");
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getCity());
			ps.setInt(3, customer.getGrade());
			
			status = ps.executeUpdate();
			con.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static List<Customer> listCustomers() {
		List<Customer> salesmenList = new ArrayList<Customer>();
		try {
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from customer");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Customer customer = new Customer();
				customer.setCustomerId(rs.getInt("customer_id"));
				customer.setName(rs.getString("name"));
				customer.setCity(rs.getString("city"));
				customer.setGrade(rs.getInt("grade"));
				
				salesmenList.add(customer);
			}
			
			con.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
		return salesmenList;
	}
	
	public static int updateCustomer(int id, Customer customer) {
		int status = 0;
		
		try {
			Connection con = ConnectionProvider.getConnection();

			PreparedStatement ps = con.prepareStatement("update customer (cust_name, city, grade) VALUES (?, ?, ?) where customer_id = ?");
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getCity());
			ps.setInt(3, customer.getGrade());
			ps.setInt(4, id);
			
			status = ps.executeUpdate();
			con.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return status;
	}
	
	public static int deleteCustomer(int id) {
		int status = 0;
		
		try {
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from customer where customer_id = ?");
			ps.setInt(1, id);
			
			status = ps.executeUpdate();
			con.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return status;
	}
}