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
import java.util.Map;

/**
 * urlPawtterns : URL(s) sur laquelle/lesquelles la servlet va écouter
 * Servlet implémentation class InscriptionServlet
 * */
@WebServlet(urlPatterns = {"/inscription", "/signin"}, loadOnStartup = 1)
public class InscriptionServlet extends HttpServlet {

    //public static final String
    private static final long serialVersionUID = 1L;

    //La servlet peut uniquement faire appel à des services
    private JoueurService joueurService = new JoueurServiceImpl();
    private NiveauService niveauService = new NiveauServiceImpl();
    private VilleService villesService = new VilleServiceImpl();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public  InscriptionServlet(){
        super();
    }

    private static final List<Ville> villes = new ArrayList<>();
    private static final List<Niveau> niveaux = new ArrayList<>();

    /**
     * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse resp)
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // On enrichit l'objet request avec la liste des niveaux
        req.setAttribute("niveaux", niveauService.recupererNiveaux());

        // On enrichit l'objet req avec la liste des villes
        req.setAttribute("villes", villesService.recupererVilles());

        // On fait suivre à la JSP inscription.jsp
        req.getRequestDispatcher("WEB-INF/inscription.jsp").forward(req, resp);
    }

/*
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

 */

    //ajouter joueur
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, String[]> map = req.getParameterMap();

        //On parcourt l'ensemble des clés à la requête HTTP

        //Récupération de la valeur des champs saisi dans le form
        /*
        String lastname = req.getParameter("LASTNAME");
        String firstname = req.getParameter("FIRSTNAME");
        String email = req.getParameter("EMAIL");
        String password = req.getParameter("PASSWORD");

         */

        // On parcourt l'ensemble des clés de la map
        for (String cle : map.keySet()) {
            String[] tableauDeValeursPourCeParametre = (String[]) map.get(cle);
            for (String valeur : tableauDeValeursPourCeParametre) {
                System.out.println("Clé=" + cle + ", valeur=" + valeur);
            }
        }
        String email = map.get("EMAIL")[0];
        String nom = map.get("FIRSTNAME")[0];
        String prenom = map.get("LASTNAME")[0];
        String motDePasse = map.get("PASSWORD")[0];

        Long idNiveau = Long.parseLong(map.get("LEVEL")[0]);
        Long idVille = Long.parseLong(map.get("CITY")[0]);
        joueurService.ajouterJoueur(email, nom, prenom, motDePasse, idNiveau, idVille);
        resp.sendRedirect("index");

        /*
        String address = req.getParameter("ADDRESS");
        Long idVille = Long.parseLong(req.getParameter("CITY"));
        Long idNiveau = Long.parseLong(req.getParameter("LEVEL"));

        //Création d'un nouveau joueur && ajout dans la BDD
        //Joueur joueur = joueurService.ajouterJoueur(email, password, lastname, firstname, villesService.recupererVille(idVille), niveauService.recupererNiveau(idNiveau));
        req.setAttribute("joueur", joueur);

        System.out.println(joueur);
        //ajouterJoueur(joueur);

        resp.sendRedirect("index");
        //req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, resp);
         */

    }


}
