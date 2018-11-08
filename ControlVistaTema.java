package controller;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import bookshop.*;
import java.util.*;
import javax.naming.NamingException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/temaDebate")

public class CatalogController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

		//Comprobar que existe carro de la compra en la sesion o crear uno
		HttpSession session = request.getSession();
		
		if(session.getAttribute("cart") == null){
			List<Book> books = new ArrayList<Book>();
			session.setAttribute("cart", books);
		}
	
		//Recuperar catalogo
		try(DBManager db = new DBManager()){

			List<Book> catalog = db.listBooks();
			request.setAttribute("catalog",catalog);
			//System.out.println(catalog.size());

			//forward
			RequestDispatcher rd = request.getRequestDispatcher("catalog.jsp");
			rd.forward(request,response);

		} catch (SQLException|NamingException e){
			e.printStackTrace();
			response.sendError(500);
		}

	}

}
