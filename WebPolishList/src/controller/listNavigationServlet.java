package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListDetails;

/**
 * Servlet implementation class listNavigationServlet
 */
@WebServlet("/listNavigationServlet")
public class listNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listNavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ListDetailsHelper ldh = new ListDetailsHelper();
		String act = request.getParameter("doThisToItem");
				
		 if (act.equals("delete")) {
				try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListDetails listToDelete = ldh.searchForListById(tempId);
				ldh.deleteItem(listToDelete);
				}catch (NumberFormatException e) {
					System.out.println("Forgot to select an button");
				}	
			
				getServletContext().getRequestDispatcher( "/viewAllListsServlet").forward(request,response);
			}	
	}

		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	}
