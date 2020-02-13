package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.InchesFeetConverter;

/**
 * Servlet implementation class getInchesServlet
 */
@WebServlet("/getInchesServlet")
public class getInchesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getInchesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userInches = request.getParameter("userInches");
		
		InchesFeetConverter userMeasure = new
		InchesFeetConverter(Double.parseDouble(userInches));
		
				
		request.setAttribute("userInchInput", userMeasure);
		
		getServletContext().getRequestDispatcher("/resultInches.jsp").forward(request, response);
		
		PrintWriter writer = response.getWriter();
		writer.println(userMeasure.toString());
		writer.close();
		
		
		
	}

}
