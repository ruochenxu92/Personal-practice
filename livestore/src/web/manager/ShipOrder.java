package web.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.impl.BusinessServiceImpl;

/**
 * Servlet implementation class ShipOrder
 */
@WebServlet("/ShipOrder")
public class ShipOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String order_id = request.getParameter("order_id");
			BusinessServiceImpl service = new BusinessServiceImpl();

			service.updateOrder(order_id);
			request.setAttribute("message", "You have already assure shipped now");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", "Failed to shipped now");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
		
		
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
