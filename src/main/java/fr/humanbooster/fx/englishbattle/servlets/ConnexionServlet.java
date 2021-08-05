package fr.humanbooster.fx.englishbattle.servlets;

import fr.humanbooster.fx.englishbattle.business.Joueur;
import fr.humanbooster.fx.englishbattle.service.JoueurService;
import fr.humanbooster.fx.englishbattle.service.PartieService;
import fr.humanbooster.fx.englishbattle.service.VerbeService;
import fr.humanbooster.fx.englishbattle.service.impl.JoueurServiceImpl;
import fr.humanbooster.fx.englishbattle.service.impl.PartieServiceImpl;
import fr.humanbooster.fx.englishbattle.service.impl.VerbeServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/connexion")
public class ConnexionServlet extends HttpServlet {
    private static long serialVersionUID = 1L;

    private JoueurService joueurService = null;
    private PartieService partieService = null;
    private VerbeService verbeService = null;

    /**
     * Default constructor
     */
    public ConnexionServlet(){
        joueurService = new JoueurServiceImpl();
        partieService = new PartieServiceImpl();
        verbeService = new VerbeServiceImpl();
        verbeService.importerVerbes();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest req, HttpServletResponse resp)
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (verbeService.recupererNbVerbes() == 0){
            req.setAttribute("erreur","il n'est pas possible de jouer, la base de verbes irréguliers est vide");
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
        //On récupère les données saisies sur le formulaire de connexion
        String email = req.getParameter("EMAIL");
        String motDePasse = req.getParameter("PASSWORD");

        //On essaie de récupérer un joueur avec ces données
        Joueur joueur = joueurService.recupererJoueurParEmailEtMotDePasse(email, motDePasse);
        if (joueur != null){
            //Le joueur a saisie le bon email + mdp
            joueur.setEstEnLigne(true);
            System.out.println("Connexion de " + joueur.getPrenom());
            joueurService.mettreAJourJoueur(joueur.getId(), joueur.getEmail(), joueur.getNom(), joueur.getPrenom(), joueur.getMotDePasse(), joueur.getVille(), joueur.getNiveau(), true);
            //Ajout d'une partie et mise en session de cette partie
            req.getSession().setAttribute("partie", partieService.ajouterPartie(joueur));
            //On passe le relai à la servlet QuestionServlet
            resp.sendRedirect("jeu");
            //.forward(req, resp);
        } else {
            req.setAttribute("erreur","email et/ou mot de passe incorrect");
            req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, resp);
        }
    }
}
