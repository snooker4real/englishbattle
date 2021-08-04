package fr.humanbooster.fx.englishbattle.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * urlPawtterns : URL(s) sur laquelle/lesquelles la servlet va écouter
 * Servlet implémentation class InscriptionServlet
 * */
@WebServlet(urlPatterns = {"/inscription","/signin"}, loadOnStartup = 1)
public class InscriptionServlet extends HttpServlet {

    //public static final String

    //Envoie à la vue les villes et niveau
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/inscription.jsp").forward(req, resp);
    }
}
