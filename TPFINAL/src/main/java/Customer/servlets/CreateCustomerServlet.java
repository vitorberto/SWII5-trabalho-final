package Customer.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Customer.Customer;
import Customer.CustomerController;

@WebServlet("/adicionarCliente")
public class CreateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("Customer/CreateCustomer.jsp");
		
		rd.forward(request, response);;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Customer customer = new Customer();

		String name = (String) request.getParameter("name");
		String city = (String) request.getParameter("city");
		int grade = Integer.parseInt(request.getParameter("grade"));
		
		customer.setName(name);
		customer.setCity(city);
		customer.setGrade(grade);
		
		int result = CustomerController.addCustomer(customer);
		
		if (result > 0) {
			RequestDispatcher rd = request.getRequestDispatcher("Results/SuccessMessage.jsp");
			rd.forward(request, response);;
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("Results/ErrorMessage.jsp");
			rd.forward(request, response);;
		}
	}

}
