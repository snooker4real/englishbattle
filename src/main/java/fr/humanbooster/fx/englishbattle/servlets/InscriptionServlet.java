package fr.humanbooster.fx.englishbattle.servlets;

import fr.humanbooster.fx.englishbattle.business.Joueur;
import fr.humanbooster.fx.englishbattle.business.Niveau;
import fr.humanbooster.fx.englishbattle.business.Ville;
import fr.humanbooster.fx.englishbattle.service.JoueurService;
import fr.humanbooster.fx.englishbattle.service.NiveauService;
import fr.humanbooster.fx.englishbattle.service.VilleService;
import fr.humanbooster.fx.englishbattle.service.impl.JoueurServiceImpl;
import fr.humanbooster.fx.englishbattle.service.impl.NiveauServiceImpl;
import fr.humanbooster.fx.englishbattle.service.impl.VilleServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * urlPawtterns : URL(s) sur laquelle/lesquelles la servlet va écouter
 * Servlet implémentation class InscriptionServlet
 * */
@WebServlet(urlPatterns = {"/inscription","/signin"}, loadOnStartup = 1)
public class InscriptionServlet extends HttpServlet {

    //public static final String
    private static final long serialVersionUID = 1L;

    private JoueurService joueurService = new JoueurServiceImpl();
    private NiveauService niveauService = new NiveauServiceImpl();
    private VilleService villesService = new VilleServiceImpl();

    private static final List<Ville> villes = new ArrayList<>();
    private static final List<Niveau> niveaux = new ArrayList<>();
    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    /**
     *
     * @see HttpServlet#HttpServlet()
     */

    public InscriptionServlet(){
        super();
    }

    //Envoie à la vue les villes et niveau
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("villes", villesService.recupererVilles());
        req.setAttribute("niveau", niveauService.recupererNiveaux());

        req.getRequestDispatcher("WEB-INF/inscription.jsp").forward(req, resp);
    }

    private Ville getVille(Long idVille){
        for(Ville ville : villes){
            if (ville.getId().equals(idVille)){
                return ville;
            }
        }
        return null;
    }

    private Niveau getNiveau(Long idNiveau){
        for(Niveau niveau : niveaux){
            if (niveau.getId().equals(idNiveau)){
                return niveau;
            }
        }
        return null;
    }

    //ajouter joueur
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Récupération de la valeur des champs saisi dans le form
        String firstname = req.getParameter("FIRSTNAME");
        String lastname = req.getParameter("LASTNAME");
        String email = req.getParameter("EMAIL");
        String password = req.getParameter("PASSWORD");
        String address = req.getParameter("ADDRESS");
        Long idVille = Long.parseLong(req.getParameter("CITY"));
        Long idNiveau = Long.parseLong(req.getParameter("LEVEL"));

        //Création d'un nouveau joueur
        Joueur joueur = new Joueur();
        //Hydratation du joueur avec ses attributs
        joueur.setNom(lastname);
        joueur.setPrenom(firstname);
        joueur.setEmail(email);
        joueur.setMotDePasse(password);
        joueur.setVille(getVille(idVille));
        joueur.setNiveau(getNiveau(idNiveau));

        req.setAttribute("joueur", joueur);

        System.out.println(joueur);

        req.getRequestDispatcher("WEB-INF/inscription.jsp").forward(req, resp);


    }


}
