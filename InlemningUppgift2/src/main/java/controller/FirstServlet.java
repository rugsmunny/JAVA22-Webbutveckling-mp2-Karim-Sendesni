package controller;

import java.io.IOException;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.UserBean;


@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public FirstServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		if (request.getSession().getAttribute("user") == null) {
			request.setAttribute("errorMessage", "Something went wrong");
			response.sendRedirect("index.jsp");
		} else {
			response.sendRedirect("views/LoginPage.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		UserBean userBean = new UserBean(request.getParameter("username"), request.getParameter("password"));
		if(userBean.checkValidUser() || userBean.checkValidUser2()) {
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("user", userBean);
			httpSession.setMaxInactiveInterval(10);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/LoginPage.jsp");
			requestDispatcher.forward(request, response);
		} else {
			request.setAttribute("errorMessage", "Something went wrong");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
			requestDispatcher.forward(request, response);
		}

		
	}

}
