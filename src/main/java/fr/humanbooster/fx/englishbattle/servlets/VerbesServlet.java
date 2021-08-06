package fr.humanbooster.fx.englishbattle.servlets;

import fr.humanbooster.fx.englishbattle.business.Verbe;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import static fr.humanbooster.fx.englishbattle.servlets.IndexServlet.verbeService;

public class VerbesServlet {

    /** Cette méthode est invoquée lorsque quelqu'un se rend sur l'url :
     * http://localhost:8080/englishbattle/verbes
     *
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Verbe> verbes = verbeService.recupererVerbes();
        request.setAttribute("verbes", verbes);
        request.getRequestDispatcher("WEB-INF/verbes.jsp").forward(request, response);
    }
}
