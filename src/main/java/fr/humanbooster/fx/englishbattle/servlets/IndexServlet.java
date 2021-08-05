package fr.humanbooster.fx.englishbattle.servlets;
import fr.humanbooster.fx.englishbattle.business.Joueur;
import fr.humanbooster.fx.englishbattle.service.*;
import fr.humanbooster.fx.englishbattle.service.impl.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet(urlPatterns = {"/index"}, loadOnStartup = 1)
public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private JoueurService joueurService = null;
    private PartieService partieService = null;
    static VerbeService verbeService = new VerbeServiceImpl();
    //private NiveauService niveauService = new NiveauServiceImpl();
    //private VilleService villeService = new VilleServiceImpl();

    /*
     * Default constructor
     */
    public IndexServlet(){
        joueurService = new JoueurServiceImpl();
        partieService = new PartieServiceImpl();
        verbeService = new VerbeServiceImpl();
        verbeService.importerVerbes();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Récupère tous les joueurs et les envoie à la JSP
        req.setAttribute("nbVerbes", verbeService.recupererNbVerbes());
        List<Joueur> joueurs = joueurService.recupererJoueursDuHallOfFame();
        req.setAttribute("joueurs", joueurs);
        req.getRequestDispatcher("WEB-INF/index.jsp").include(req, resp);

    }
}
