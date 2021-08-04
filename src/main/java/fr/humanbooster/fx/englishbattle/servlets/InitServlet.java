package fr.humanbooster.fx.englishbattle.servlets;

import fr.humanbooster.fx.englishbattle.service.VerbeService;
import fr.humanbooster.fx.englishbattle.service.impl.VerbeServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/index"}, loadOnStartup = 1)
public class InitServlet extends HttpServlet {
    private VerbeService verbeService = new VerbeServiceImpl();

    private static final long serialversionUID = 1L;

    @Override
    public void init() {
        verbeService.importerVerbes();
        System.out.println("nombre de verbes trouvé : " + verbeService.recupererNbVerbes());
    }


}
