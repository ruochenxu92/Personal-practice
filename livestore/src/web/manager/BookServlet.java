package web.manager;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import domain.Book;
import domain.Category;
import domain.Page;
import service.BusinessService;
import service.impl.BusinessServiceImpl;
import utils.WebUtils;


/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if(method.equals("addUI")){
			addUI(request, response);
		}else if(method.equals("listallbooks")){
			listallbooks(request, response);
		}else if(method.equalsIgnoreCase("add")){
			add(request, response);
		}
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			Book book = new Book();	
			book.setName(request.getParameter("name"));
			book.setAuthor(request.getParameter("author"));
			book.setPrice(Double.parseDouble(request.getParameter("price")));
			book.setImage(request.getParameter("image"));
			book.setDescription(request.getParameter("description"));
			book.setCategory_id(request.getParameter("category"));
			book.setId(WebUtils.generateUUID());
			BusinessServiceImpl service = new BusinessServiceImpl();
			service.addBook(book);
			request.setAttribute("message", "successfully add new book!!");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", "failed to add new book!!");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

//	private Book doUpload(HttpServletRequest request) {
//		Book book = new Book();
//		try {
//			DiskFileItemFactory factory = new DiskFileItemFactory();
//			ServletFileUpload upload = new ServletFileUpload(factory);
//			List<FileItem> items = upload.parseRequest(request);
//			
//			for (FileItem item : items) {
//				if (item.isFormField()) {
//					String name = item.getFieldName();
//					String value = item.getString("UTF-8");
//					BeanUtils.setProperty(book, name, value);
//
//				} else {
//					/** 1. get file information **/
//					String filename = item.getName();
//					String savefilename = makeFileName(filename);
//					String savepath = this.getServletContext().getRealPath(
//							"/images");
//
//					/** 2. upload the file **/
//					InputStream in = item.getInputStream();
//					OutputStream out = new FileOutputStream(savepath + "/"
//							+ savefilename);   //defer
//			
//					/** 3. start read file **/
//					int lengthOfRead = 0;
//					byte[] buffer = new byte[1024];
//					while ((lengthOfRead = in.read(buffer)) > 0) {
//						out.write(buffer, 0, lengthOfRead);
//					}
//
//					in.close();
//					out.close();
//
//					item.delete();
//					book.setImage(savefilename);
//				}
//			}
//			return book;
//
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//	}

	public String makeFileName(String filename){
		String ext = filename.substring(filename.lastIndexOf("."));
		return UUID.randomUUID().toString() + ext;
	}


	private void listallbooks(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pagenum = request.getParameter("pagenum");
		BusinessService service = new BusinessServiceImpl();
		Page page = service.getPageData(pagenum);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/manager/listallbooks.jsp").forward(request, response);
	}

	private void addUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BusinessServiceImpl  service = new BusinessServiceImpl();
		List<Category> categories = service.getAllCategory();
		request.setAttribute("categories", categories);
		request.getRequestDispatcher("/manager/addbook.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
