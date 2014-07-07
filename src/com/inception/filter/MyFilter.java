package com.inception.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inception.entity.User;

public class MyFilter implements Filter  {

	private User user;
	

	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletResponse  res = (HttpServletResponse )response;
		HttpServletRequest req = (HttpServletRequest) request;
		
		user = (User) req.getSession().getAttribute("user");
		
		if( user == null ){
			res.sendRedirect("/Inception/User/login.jsp");
		}
		else{
			String path = req.getServletPath();
			res.sendRedirect(path);
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

}
