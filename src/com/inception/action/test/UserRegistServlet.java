package com.inception.action.test;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inception.biz.Biz;
import com.inception.dao.UserExistsException;
import com.inception.entity.User;

public class UserRegistServlet extends HttpServlet {

	public UserRegistServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Biz biz = new Biz();
		String username = request.getParameter("username");
		String passwd = request.getParameter("passwd");
		String msg = String.format("<script> alert(' username is %s , passwd is %s') </script>",username, passwd);
		request.setAttribute("res", msg);
		
		User u = new User();
		u.setUserName(username);
		u.setPasswd(passwd);
		try {
			biz.userRegistDefault(u);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (UserExistsException e){
			e.printStackTrace();
		}
		request.getRequestDispatcher("Test").forward(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
