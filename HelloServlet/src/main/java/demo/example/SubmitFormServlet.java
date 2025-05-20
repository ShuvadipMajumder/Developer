package demo.example;

import java.io.*;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//Three ways to initiate a servlet: 
//Servlet interface, GenericServlet class, HttpServlet class

//Servlet interface
//public class SubmitFormServlet implements Servlet{
//
//	@Override
//	public void destroy() {
//		// TODO Auto-generated method stub
//		System.out.println("Inside destroy");
//		
//	}
//
//	@Override
//	public ServletConfig getServletConfig() {
//		// TODO Auto-generated method stub
//		System.out.println("Inside getServletConfig");
//		return null;
//	}
//
//	@Override
//	public String getServletInfo() {
//		// TODO Auto-generated method stub
//		System.out.println("Inside getServletInfo");
//		return null;
//	}
//
//	@Override
//	public void init(ServletConfig arg0) throws ServletException {
//		// TODO Auto-generated method stub
//		System.out.println("Inside init");
//	}
//
//	@Override
//	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
//		System.out.println("Inside service");
//		// Get form data
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String password = request.getParameter("password");
//        System.out.println("Inside service name email password : "+name+" "+email+" "+password);
//        // Set the content type for the response (HTML)
//        response.setContentType("text/html");
//
//        // Get the writer object to send the response
//        PrintWriter out = response.getWriter();
//
//        // Generate HTML response
//        out.println("<html><body>");
//        out.println("<h2>Form Submitted Successfully!</h2>");
//        out.println("<p><strong>Name:</strong> " + name + "</p>");
//        out.println("<p><strong>Email:</strong> " + email + "</p>");
//        out.println("<p><strong>Password:</strong> " + password + "</p>");
//        out.println("</body></html>");
//		
//	}}


//GenericServlet class
public class SubmitFormServlet extends GenericServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Inside service");
		// Get form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println("Inside service name email password : "+name+" "+email+" "+password);
        // Set the content type for the response (HTML)
        response.setContentType("text/html");

        // Get the writer object to send the response
        PrintWriter out = response.getWriter();

        // Generate HTML response
        out.println("<html><body>");
        out.println("<h2>Form Submitted Successfully!</h2>");
        out.println("<p><strong>Name:</strong> " + name + "</p>");
        out.println("<p><strong>Email:</strong> " + email + "</p>");
        out.println("<p><strong>Password:</strong> " + password + "</p>");
        out.println("</body></html>");
		
	}
}

//HttpServlet class
//public class SubmitFormServlet extends HttpServlet {
//    /**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // Get form data
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String password = request.getParameter("password");
//        System.out.println("Inside doPost name email password : "+name+" "+email+" "+password);
//        // Set the content type for the response (HTML)
//        response.setContentType("text/html");
//
//        // Get the writer object to send the response
//        PrintWriter out = response.getWriter();
//
//        // Generate HTML response
//        out.println("<html><body>");
//        out.println("<h2>Form Submitted Successfully!</h2>");
//        out.println("<p><strong>Name:</strong> " + name + "</p>");
//        out.println("<p><strong>Email:</strong> " + email + "</p>");
//        out.println("<p><strong>Password:</strong> " + password + "</p>");
//        out.println("</body></html>");
//    }}



