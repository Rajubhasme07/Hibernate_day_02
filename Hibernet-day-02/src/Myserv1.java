

import java.beans.Customizer;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Model.Customer;


@WebServlet("/serv1")
public class Myserv1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	
	
	Configuration cfg = new Configuration();
	cfg.configure("hibernate.cfg.xml");

	SessionFactory factory=cfg.buildSessionFactory();
	Session session = factory.openSession();	
		String cname=request.getParameter("cname");
		String cadd1=request.getParameter("cadd");
		
		Customer c=new Customer(cname,cadd1);
	
	Transaction tx = session.beginTransaction();
	
	session.save(c);
	tx.commit();
	out.print("Data Insetrted Successfully");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
