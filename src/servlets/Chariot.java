package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Carte_Livres;
import Dao.DbLivre;
import Dao.Livre;

/**
 * Servlet implementation class Chariot
 */
@WebServlet("/Chariot")
public class Chariot extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Chariot() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = request.getParameter("action");
		Carte_Livres c = null;

		if (action.equals("Add To Cart")) {
			int id = Integer.parseInt(request.getParameter("IdLivre"));
			Livre l = DbLivre.getLivresbyId(id);
			l.setQuentite(1);
			boolean test = false;
			if (request.getSession().getAttribute("cart_livre") != null) {
				c = (Carte_Livres) request.getSession().getAttribute("cart_livre");
				for (Livre livre : c.getLivres()) {
					if (livre.getId_Livre() == id) {
						test = true;
					}
				}
				if (test == false) {
					c.getLivres().add(l);
				}
			} else {
				c = new Carte_Livres();
				ArrayList<Livre> lis = new ArrayList<>();
				lis.add(l);
				c.setLivres(lis);
			}

		} else if (action.equals("Delete From Carte")) {
			int id = Integer.parseInt(request.getParameter("idRemove"));
			c = (Carte_Livres) request.getSession().getAttribute("cart_livre");
			for (int i = 0; i < c.getLivres().size(); i++) {
				if (c.getLivres().get(i).getId_Livre() == id) {
					c.getLivres().remove(i);
				}
			}
		} else if (action.equals("Update")) {
			int id = Integer.parseInt(request.getParameter("idLivre"));
			c = (Carte_Livres) request.getSession().getAttribute("cart_livre");
			int Qte = Integer.parseInt(request.getParameter("Qte"));
			for (int i = 0; i < c.getLivres().size(); i++) {
				if (c.getLivres().get(i).getId_Livre() == id) {
					if (Qte != 0) {
						c.getLivres().get(i).setQuentite(Qte);
					} else {
						c.getLivres().get(i).setQuentite(1);
					}
				}
			}
		}
		request.getSession().setAttribute("cart_livre", c);
		this.getServletContext().getRequestDispatcher("/Chariot.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
