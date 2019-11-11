package br.edu.utfpr.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import br.edu.utfpr.models.Show;
import br.edu.utfpr.models.TicketRequest;
import br.edu.utfpr.models.User;
import br.edu.utfpr.persistence.PersistenceShow;
import br.edu.utfpr.persistence.PersistenceUser;
import br.edu.utfpr.persistence.PersistenceUtils;

@WebServlet({"/usuarios", "/home", "/ingressos-por-usuario", "/usuarios-por-show", "/maior-doacao", "/ingressos-por-show" })
public class ReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getServletPath().contains("home")) {
			this.getHome(request, response);
		} else if (request.getServletPath().contains("ingressos-por-usuario")) {
			this.getTicketsPerUser(request, response);
		}else if (request.getServletPath().contains("usuarios-por-show")) {
			this.getUsersPerShow(request, response);
		}else if (request.getServletPath().contains("maior-doacao")) {
			this.getBiggestDonation(request, response);
		}else if (request.getServletPath().contains("ingressos-por-show")) {
			this.getTicketsPerShow(request, response);
		}else if (request.getServletPath().contains("usuarios")) {
			this.getUsers(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getServletPath().contains("ingressos-por-usuario")) {
			this.postTicketsPerUser(request, response, Long.parseLong(request.getParameter("usrId")));
		}else if (request.getServletPath().contains("usuarios-por-show")) {
			this.postUsersPerShow(request, response, Long.parseLong(request.getParameter("shwId")));
		}
	}

	private void getHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}
	
	private void getUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> users = new PersistenceUser().findAll();
		request.setAttribute("users", users);
		request.getRequestDispatcher("WEB-INF/views/users.jsp").forward(request, response);		
	}
	
	private void getTicketsPerUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> users = new PersistenceUser().findAll();
		request.setAttribute("users", users);
		request.getRequestDispatcher("WEB-INF/views/tickets-per-user.jsp").forward(request, response);
	}

	private void postTicketsPerUser(HttpServletRequest request, HttpServletResponse response, Long id) throws ServletException, IOException {
		List<User> users = new PersistenceUser().findAll();
		
		Query query = PersistenceUtils.getEntityManager()
				.createQuery( "SELECT DISTINCT t "
							+ " FROM TicketRequest t "
							+ " WHERE t.user.id = :id");
		query.setParameter("id", id);
		
		List<TicketRequest> ticketsRequest = query.getResultList();
		request.setAttribute("users", users);
		request.setAttribute("ticketsRequest", ticketsRequest);
		request.getRequestDispatcher("WEB-INF/views/tickets-per-user.jsp").forward(request, response);		
	}
	
	private void getUsersPerShow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Show> shows = new PersistenceShow().findAll();
		request.setAttribute("shows", shows);
		request.getRequestDispatcher("WEB-INF/views/users-per-show.jsp").forward(request, response);		
	}
	
	private void postUsersPerShow(HttpServletRequest request, HttpServletResponse response, Long id) throws ServletException, IOException {
		List<Show> shows = new PersistenceShow().findAll();
		
		Query query = PersistenceUtils.getEntityManager()
				.createQuery( "SELECT DISTINCT t.user "
							+ " FROM TicketRequest t JOIN t.user u "
							+ " WHERE t.show.id = :id");
		query.setParameter("id", id);
		
		List<User> users = query.getResultList(); 
		request.setAttribute("shows", shows);
		request.setAttribute("users", users);
		request.getRequestDispatcher("WEB-INF/views/users-per-show.jsp").forward(request, response);		
	}
	
	private void getBiggestDonation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long maxValue = (Long) PersistenceUtils.getEntityManager()
				.createQuery( "SELECT MAX(t.donationAmount) FROM TicketRequest t").getSingleResult();
		
		Query query = PersistenceUtils.getEntityManager()
				.createQuery( "SELECT t FROM TicketRequest t WHERE t.donationAmount = :max");
		query.setParameter("max", maxValue);
		
		TicketRequest ticketRequest = (TicketRequest) query.getSingleResult();
		
		JOptionPane.showMessageDialog(null, "Maior valor doado: "+ ticketRequest.getDonationAmount()+", por: "+ticketRequest.getUser().getName());
		response.sendRedirect("home.jsp");
	}
	
	private void getTicketsPerShow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Query query = PersistenceUtils.getEntityManager()
				.createQuery( "SELECT t.show.id, t.show.band, COUNT(t.show.id)"
							+ "FROM TicketRequest t "
							+ "GROUP BY t.show.id, t.show.band");
		
		List<Object> itens = (List<Object>) query.getResultList();
		
		request.setAttribute("itens", itens);
		request.getRequestDispatcher("WEB-INF/views/tickets-per-show.jsp").forward(request, response);
	}
	
}

















