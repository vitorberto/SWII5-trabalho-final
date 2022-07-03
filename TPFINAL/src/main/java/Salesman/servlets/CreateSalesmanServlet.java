package Salesman.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Salesman.Salesman;
import Salesman.SalesmanController;

/**
 * Servlet implementation class CreateSalesmanServlet
 */

@WebServlet("/adicionarVendedor")
public class CreateSalesmanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("Salesman/CreateSalesman.jsp");
		
		rd.forward(request, response);;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Salesman salesman = new Salesman();

		String name = (String) request.getParameter("name");
		String city = (String) request.getParameter("city");
		int commission = Integer.parseInt(request.getParameter("commission"));
		
		salesman.setName(name);
		salesman.setCity(city);
		salesman.setCommission(commission);
		
		int result = SalesmanController.addSalesman(salesman);
		
		if (result > 0) {
			RequestDispatcher rd = request.getRequestDispatcher("Results/SuccessMessage.jsp");
			rd.forward(request, response);;
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("Results/ErrorMessage.jsp");
			rd.forward(request, response);;
		}
	}
}
