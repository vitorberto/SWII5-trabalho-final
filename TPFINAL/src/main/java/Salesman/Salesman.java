package Salesman;

public class Salesman {
	private long salesmanId;
	private String name;
	private String city;
	private double commission;
	
	public Salesman() {}
	
	public long getSalesmanId() {
		return salesmanId;
	}
	
	public void setSalesmanId(long salesmanId) {
		this.salesmanId = salesmanId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getCommission() {
		return commission;
	}

	public void setCommission(double commission) {
		this.commission = commission;
	}
}