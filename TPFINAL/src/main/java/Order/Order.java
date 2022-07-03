package Order;

import java.time.LocalDate;
import java.time.ZoneId;
import java.sql.Date;

public class Order {
	private int orderNumber;
	private double purchaseAmount;
	private LocalDate orderDate;
	private int customerId;
	private int salesmanId;

	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public double getPurchaseAmount() {
		return purchaseAmount;
	}
	public void setPurchaseAmount(double purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}
	public Date getOrderDate() {
		Date returnDate = Date.valueOf(orderDate);
		return returnDate;
	}
	public void setOrderDate(Date orderDate) {
		LocalDate returnDate = orderDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		this.orderDate = returnDate;
	}
	public void setOrderLocalDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public int getSalesmanId() {
		return salesmanId;
	}
	public void setSalesmanId(int salesmanId) {
		this.salesmanId = salesmanId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
}