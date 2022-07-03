package Salesman;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import ConnectionProvider.ConnectionProvider;

public class SalesmanController {
	public static int addSalesman(Salesman salesman) {
		int status = 0;
		
		try {
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into salesman (name, city, commission) VALUES (?, ?, ?)");
			ps.setString(1, salesman.getName());
			ps.setString(2, salesman.getCity());
			ps.setDouble(3, salesman.getCommission());
			
			status = ps.executeUpdate();
			con.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static List<Salesman> listSalesmen() {
		List<Salesman> salesmenList = new ArrayList<Salesman>();
		try {
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from salesman");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Salesman salesman = new Salesman();
				salesman.setSalesmanId(rs.getInt("salesman_id"));
				salesman.setName(rs.getString("name"));
				salesman.setCity(rs.getString("city"));
				salesman.setCommission(rs.getDouble("commission"));
				
				salesmenList.add(salesman);
			}
			
			con.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
		return salesmenList;
	}
	
	public static int updateSalesman(int id, Salesman salesman) {
		int status = 0;
		
		try {
			Connection con = ConnectionProvider.getConnection();

			PreparedStatement ps = con.prepareStatement("update salesman (name, city, commission) VALUES (?, ?, ?) where salesman_id = ?");
			ps.setString(1, salesman.getName());
			ps.setString(2, salesman.getCity());
			ps.setDouble(3, salesman.getCommission());
			ps.setInt(4, id);
			
			status = ps.executeUpdate();
			con.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return status;
	}
	
	public static int deleteSalesman(int id) {
		int status = 0;
		
		try {
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from salesman where salesman_id = ?");
			ps.setInt(1, id);
			
			status = ps.executeUpdate();
			con.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return status;
	}
}