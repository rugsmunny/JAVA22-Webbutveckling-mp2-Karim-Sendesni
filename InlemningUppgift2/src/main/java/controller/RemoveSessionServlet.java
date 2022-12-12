package controller;

import java.io.IOException;


import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


@WebServlet("/RemoveSessionServlet")
public class RemoveSessionServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;
 
    public RemoveSessionServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (request.getSession().getAttribute("user") == null) {
			response.sendRedirect("index.jsp");
		} else {
			doPost(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		HttpSession httpSession = request.getSession();
		httpSession.removeAttribute("username");
		httpSession.invalidate();
		response.sendRedirect("index.jsp");
	}

}
