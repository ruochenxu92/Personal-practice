package web.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Category;
import domain.Page;
import domain.Parameters;
import service.BusinessService;
import service.impl.BusinessServiceImpl;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BusinessService service = new BusinessServiceImpl();
		List<Category> categories = service.getAllCategory();
		request.setAttribute("categories", categories);
		
		
		
		String category_id = request.getParameter("category_id");
		System.out.println("category_id = "+category_id);
		
		
		String method = request.getParameter("method");
		String pagenum = request.getParameter("pagenum");
		Page p;
		if(method == null){
			 p = service.getPageData(pagenum);
			request.setAttribute("page", p);
			
			
		}else{
			p = service.getPageData(pagenum,category_id);
			request.setAttribute("page", p);
			Parameters para = new Parameters(category_id, method);
			request.setAttribute("para", para);
		}
		request.getRequestDispatcher("/client/body.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
