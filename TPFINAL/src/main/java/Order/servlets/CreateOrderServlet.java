package Order.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Order.Order;
import Order.OrderController;

@WebServlet("/adicionarPedido")
public class CreateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("Order/CreateOrder.jsp");
		
		rd.forward(request, response);;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Order order = new Order();

		LocalDate orderDate = LocalDate.parse(request.getParameter("date"));
		double purchaseAmount = Double.parseDouble(request.getParameter("amount"));
		int customer = Integer.parseInt(request.getParameter("customer"));
		int salesman = Integer.parseInt(request.getParameter("salesman"));
		
		order.setOrderLocalDate(orderDate);
		order.setPurchaseAmount(purchaseAmount);
		order.setCustomerId(customer);
		order.setSalesmanId(salesman);
		
		int result = OrderController.addOrder(order);
		
		if (result > 0) {
			RequestDispatcher rd = request.getRequestDispatcher("Results/SuccessMessage.jsp");
			rd.forward(request, response);;
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("Results/ErrorMessage.jsp");
			rd.forward(request, response);;
		}
	}
}
