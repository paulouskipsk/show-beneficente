package br.edu.utfpr.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.utfpr.models.LocalShow;
import br.edu.utfpr.models.Show;
import br.edu.utfpr.models.TicketRequest;
import br.edu.utfpr.models.User;
import br.edu.utfpr.persistence.PersistenceLocalShow;
import br.edu.utfpr.persistence.PersistenceShow;
import br.edu.utfpr.persistence.PersistenceTicketRequest;
import br.edu.utfpr.persistence.PersistenceUser;

@WebServlet("/alimentarDB")
public class InsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		insertDatabase();
	}

	private void insertDatabase() {
		PersistenceUser pUser = new PersistenceUser();
		PersistenceLocalShow pLocalShow = new PersistenceLocalShow();
		PersistenceShow pShow = new PersistenceShow();
		PersistenceTicketRequest pTicketRequest = new PersistenceTicketRequest();

		pUser.save(new User(null, "Everton Paulouski", 33));
		pUser.save(new User(null, "Luciana de Fatima", 32));
		pUser.save(new User(null, "Gabriel de Paulo", 18));
		pUser.save(new User(null, "Isabela da Silva", 24));
		pUser.save(new User(null, "João Pedro", 26));
		pUser.save(new User(null, "Osni Marin", 24));
		pUser.save(new User(null, "Mara Maravilha", 50));
		pUser.save(new User(null, "Sergio Malandro", 55));
		pUser.save(new User(null, "Luis Inacio da Silva", 65));
		pUser.save(new User(null, "Mariléia Gomes", 21));
		pUser.save(new User(null, "Charlene dea Costa", 37));
		pUser.save(new User(null, "Michelly Crowller", 34));
		pUser.save(new User(null, "Nilza Noriller", 27));

		pLocalShow.save(new LocalShow(null, this.newDate("10/11/2019"), this.newDate("13/11/2019"), "Guarapuava"));// 1
		pLocalShow.save(new LocalShow(null, this.newDate("10/11/2019"), this.newDate("11/11/2019"), "Pinhão"));// 2
		pLocalShow.save(new LocalShow(null, this.newDate("20/11/2019"), this.newDate("22/11/2019"), "Araraquara"));// 3
		pLocalShow.save(new LocalShow(null, this.newDate("30/11/2019"), this.newDate("30/11/2019"), "Turvo"));// 4
		pLocalShow.save(new LocalShow(null, this.newDate("01/12/2019"), this.newDate("03/12/2019"), "Candói"));// 5
		pLocalShow.save(new LocalShow(null, this.newDate("12/12/2019"), this.newDate("14/12/2019"), "Londrina"));// 6
		pLocalShow.save(new LocalShow(null, this.newDate("20/12/2019"), this.newDate("22/12/2019"), "Santa Maria do Oeste"));// 7
		pLocalShow.save(new LocalShow(null, this.newDate("01/01/2019"), this.newDate("01/01/2020"), "Palmital"));// 8

		pShow.save(new Show(null, this.newDate("10/11/2019"), "Iron Maiden", pLocalShow.find(1L)));
		pShow.save(new Show(null, this.newDate("11/11/2019"), "ACDC", pLocalShow.find(1L)));
		pShow.save(new Show(null, this.newDate("12/11/2019"), "Nirvana", pLocalShow.find(1L)));
		pShow.save(new Show(null, this.newDate("13/11/2019"), "Guns N'Roses", pLocalShow.find(1L)));

		pShow.save(new Show(null, this.newDate("10/11/2019"), "Ivete Sangalo", pLocalShow.find(2L)));
		pShow.save(new Show(null, this.newDate("11/11/2019"), "Chiclete com Banana", pLocalShow.find(2L)));

		pShow.save(new Show(null, this.newDate("20/11/2019"), "Bruno e Marrone", pLocalShow.find(3L)));
		pShow.save(new Show(null, this.newDate("21/11/2019"), "Zezé Di Camargo e Luciano", pLocalShow.find(3L)));
		pShow.save(new Show(null, this.newDate("22/11/2019"), "Daniel", pLocalShow.find(3L)));

		pShow.save(new Show(null, this.newDate("30/11/2019"), "Gaúcho da Fronteira", pLocalShow.find(4L)));

		pShow.save(new Show(null, this.newDate("01/12/2019"), "Roupa Nova", pLocalShow.find(5L)));
		pShow.save(new Show(null, this.newDate("02/12/2019"), "Vando", pLocalShow.find(5L)));
		pShow.save(new Show(null, this.newDate("03/12/2019"), "Nenhum de Nós", pLocalShow.find(5L)));

		pShow.save(new Show(null, this.newDate("12/12/2019"), "Garotos de Ouro", pLocalShow.find(6L)));
		pShow.save(new Show(null, this.newDate("13/12/2019"), "Tchê Garotos", pLocalShow.find(6L)));
		pShow.save(new Show(null, this.newDate("14/12/2019"), "Os Serranos", pLocalShow.find(6L)));

		pShow.save(new Show(null, this.newDate("20/12/2019"), "Grupo Molejo", pLocalShow.find(7L)));
		pShow.save(new Show(null, this.newDate("21/12/2019"), "É o Tchan", pLocalShow.find(7L)));
		pShow.save(new Show(null, this.newDate("22/12/2019"), "Só pra Contrariar", pLocalShow.find(7L)));

		pShow.save(new Show(null, this.newDate("01/01/2020"), "Roberto Carlos", pLocalShow.find(8L)));

		pTicketRequest.save(new TicketRequest(null, (new Random().nextInt(10) + 1), (new Random().nextInt(20000) + 1),
				pShow.find(1L), pUser.find(1L)));
		pTicketRequest.save(new TicketRequest(null, (new Random().nextInt(10) + 1), (new Random().nextInt(20000) + 1),
				pShow.find(2L), pUser.find(2L)));
		pTicketRequest.save(new TicketRequest(null, (new Random().nextInt(10) + 1), (new Random().nextInt(20000) + 1),
				pShow.find(3L), pUser.find(3L)));
		pTicketRequest.save(new TicketRequest(null, (new Random().nextInt(10) + 1), (new Random().nextInt(20000) + 1),
				pShow.find(4L), pUser.find(4L)));

		pTicketRequest.save(new TicketRequest(null, (new Random().nextInt(10) + 1), (new Random().nextInt(20000) + 1),
				pShow.find(5L), pUser.find(5L)));
		pTicketRequest.save(new TicketRequest(null, (new Random().nextInt(10) + 1), (new Random().nextInt(20000) + 1),
				pShow.find(6L), pUser.find(6L)));
		pTicketRequest.save(new TicketRequest(null, (new Random().nextInt(10) + 1), (new Random().nextInt(20000) + 1),
				pShow.find(7L), pUser.find(7L)));
		pTicketRequest.save(new TicketRequest(null, (new Random().nextInt(10) + 1), (new Random().nextInt(20000) + 1),
				pShow.find(8L), pUser.find(8L)));
		pTicketRequest.save(new TicketRequest(null, (new Random().nextInt(10) + 1), (new Random().nextInt(20000) + 1),
				pShow.find(9L), pUser.find(9L)));

		pTicketRequest.save(new TicketRequest(null, (new Random().nextInt(10) + 1), (new Random().nextInt(20000) + 1),
				pShow.find(10L), pUser.find(10L)));
		pTicketRequest.save(new TicketRequest(null, (new Random().nextInt(10) + 1), (new Random().nextInt(20000) + 1),
				pShow.find(11L), pUser.find(11L)));
		pTicketRequest.save(new TicketRequest(null, (new Random().nextInt(10) + 1), (new Random().nextInt(20000) + 1),
				pShow.find(12L), pUser.find(12L)));
		pTicketRequest.save(new TicketRequest(null, (new Random().nextInt(10) + 1), (new Random().nextInt(20000) + 1),
				pShow.find(13L), pUser.find(13L)));

		pTicketRequest.save(new TicketRequest(null, (new Random().nextInt(10) + 1), (new Random().nextInt(20000) + 1),
				pShow.find(14L), pUser.find(1L)));
		pTicketRequest.save(new TicketRequest(null, (new Random().nextInt(10) + 1), (new Random().nextInt(20000) + 1),
				pShow.find(15L), pUser.find(2L)));
		pTicketRequest.save(new TicketRequest(null, (new Random().nextInt(10) + 1), (new Random().nextInt(20000) + 1),
				pShow.find(16L), pUser.find(3L)));
		pTicketRequest.save(new TicketRequest(null, (new Random().nextInt(10) + 1), (new Random().nextInt(20000) + 1),
				pShow.find(17L), pUser.find(4L)));
		pTicketRequest.save(new TicketRequest(null, (new Random().nextInt(10) + 1), (new Random().nextInt(20000) + 1),
				pShow.find(18L), pUser.find(4L)));

		pTicketRequest.save(new TicketRequest(null, (new Random().nextInt(10) + 1), (new Random().nextInt(20000) + 1),
				pShow.find(19L), pUser.find(5L)));
		pTicketRequest.save(new TicketRequest(null, (new Random().nextInt(10) + 1), (new Random().nextInt(20000) + 1),
				pShow.find(20L), pUser.find(5L)));
		pTicketRequest.save(new TicketRequest(null, (new Random().nextInt(10) + 1), (new Random().nextInt(20000) + 1),
				pShow.find(2L), pUser.find(6L)));
		pTicketRequest.save(new TicketRequest(null, (new Random().nextInt(10) + 1), (new Random().nextInt(20000) + 1),
				pShow.find(3L), pUser.find(7L)));
		pTicketRequest.save(new TicketRequest(null, (new Random().nextInt(10) + 1), (new Random().nextInt(20000) + 1),
				pShow.find(4L), pUser.find(8L)));
		pTicketRequest.save(new TicketRequest(null, (new Random().nextInt(10) + 1), (new Random().nextInt(20000) + 1),
				pShow.find(5L), pUser.find(9L)));

		pTicketRequest.save(new TicketRequest(null, (new Random().nextInt(10) + 1), (new Random().nextInt(20000) + 1),
				pShow.find(6L), pUser.find(10L)));
		pTicketRequest.save(new TicketRequest(null, (new Random().nextInt(10) + 1), (new Random().nextInt(20000) + 1),
				pShow.find(7L), pUser.find(11L)));
		pTicketRequest.save(new TicketRequest(null, (new Random().nextInt(10) + 1), (new Random().nextInt(20000) + 1),
				pShow.find(8L), pUser.find(12L)));
		pTicketRequest.save(new TicketRequest(null, (new Random().nextInt(10) + 1), (new Random().nextInt(20000) + 1),
				pShow.find(9L), pUser.find(13L)));

		pTicketRequest.save(new TicketRequest(null, (new Random().nextInt(10) + 1), (new Random().nextInt(20000) + 1),
				pShow.find(10L), pUser.find(1L)));
		pTicketRequest.save(new TicketRequest(null, (new Random().nextInt(10) + 1), (new Random().nextInt(20000) + 1),
				pShow.find(11L), pUser.find(2L)));
		pTicketRequest.save(new TicketRequest(null, (new Random().nextInt(10) + 1), (new Random().nextInt(20000) + 1),
				pShow.find(7L), pUser.find(3L)));
		pTicketRequest.save(new TicketRequest(null, (new Random().nextInt(10) + 1), (new Random().nextInt(20000) + 1),
				pShow.find(12L), pUser.find(4L)));

		pTicketRequest.save(new TicketRequest(null, (new Random().nextInt(10) + 1), (new Random().nextInt(20000) + 1),
				pShow.find(8L), pUser.find(5L)));
		pTicketRequest.save(new TicketRequest(null, (new Random().nextInt(10) + 1), (new Random().nextInt(20000) + 1),
				pShow.find(8L), pUser.find(6L)));
		pTicketRequest.save(new TicketRequest(null, (new Random().nextInt(10) + 1), (new Random().nextInt(20000) + 1),
				pShow.find(8L), pUser.find(7L)));
		pTicketRequest.save(new TicketRequest(null, (new Random().nextInt(10) + 1), (new Random().nextInt(20000) + 1),
				pShow.find(8L), pUser.find(7L)));

	}

	private Date newDate(String stringDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return sdf.parse(stringDate);
		} catch (ParseException e) {
			return null;
		}
	}
}
