package fr.humanbooster.fx.englishbattle.servlets;

import fr.humanbooster.fx.englishbattle.business.Partie;
import fr.humanbooster.fx.englishbattle.business.Question;
import fr.humanbooster.fx.englishbattle.business.Verbe;
import fr.humanbooster.fx.englishbattle.service.JoueurService;
import fr.humanbooster.fx.englishbattle.service.PartieService;
import fr.humanbooster.fx.englishbattle.service.QuestionService;
import fr.humanbooster.fx.englishbattle.service.VerbeService;
import fr.humanbooster.fx.englishbattle.service.impl.JoueurServiceImpl;
import fr.humanbooster.fx.englishbattle.service.impl.PartieServiceImpl;
import fr.humanbooster.fx.englishbattle.service.impl.QuestionServiceImpl;
import fr.humanbooster.fx.englishbattle.service.impl.VerbeServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns="/jeu", loadOnStartup = 1)

public class QuestionServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    JoueurService joueurService = new JoueurServiceImpl();
    VerbeService verbeService = new VerbeServiceImpl();
    QuestionService questionService = new QuestionServiceImpl();
    PartieService partieService = new PartieServiceImpl();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Verbe monVerbe = verbeService.recupererVerbeAleatoire();
        Partie partie = (Partie) req.getSession().getAttribute("partie");
        Question question = questionService.ajouterQuestion(partie, monVerbe);

        req.getSession().setAttribute("question", question);
        req.setAttribute("sessionScope", req.getSession());

        req.getRequestDispatcher("WEB-INF/question.jsp").forward(req, resp);

    }

}
