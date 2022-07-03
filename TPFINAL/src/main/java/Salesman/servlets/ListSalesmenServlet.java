package Salesman.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Salesman.*;

@WebServlet("/listarVendedores")
public class ListSalesmenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Salesman> salesmenList = SalesmanController.listSalesmen();
		
		request.setAttribute("salesmen", salesmenList);
		RequestDispatcher rd = request.getRequestDispatcher("Salesman/ListSalesmen.jsp");
		
		rd.forward(request, response);;
	}
}
