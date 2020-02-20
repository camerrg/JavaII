package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListItems;

/**
 * Servlet implementation class NaviagtionServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListItemsHelper dao = new ListItemsHelper();
		String act = request.getParameter("doThisToItem");
		String path = "/viewAllPolishServlet";
	
		if (act.equals("delete")) {
			try {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			ListItems itemToDelete = dao.searchForItemById(tempId);
			dao.deleteItem(itemToDelete);
			}catch (NumberFormatException e) {
				System.out.println("Forgot to select an item");
			}	
		
		}
		else if (act.equals("edit")) {
			try {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			ListItems itemToEdit = dao.searchForItemById(tempId);
			request.setAttribute("itemToEdit",itemToEdit);
			path= "/edit-item.jsp";
			}catch (NumberFormatException e) {
				System.out.println("Forgot to select an item");
			}
		}
		else if (act.equals("add")) {
			path = "/index.html";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
