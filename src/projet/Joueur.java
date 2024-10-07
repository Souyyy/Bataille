package projet;

import java.util.ArrayList;

public class Joueur {

    // attributs : nom, paquet (tableau ou liste de Carte) et score (compteur de points)
    private final String nom;
    private final ArrayList<Carte> paquet;
    private int score;

    // Constructeur : initialisation du nom du joueur, score à 0, et paquet vide
    public Joueur(String nom) {
        this.nom = nom;
        this.score = 0;
        this.paquet = new ArrayList<>();  // Paquet vide au début
    }

    //getter
    public String getNom() {
        return nom;
    }

    public int getScore() {
        return score;
    }

    public int getPaquet() {
        return paquet.size();
    }

    // Tirer la premiere carte du paquet
    public Carte tirerUneCarte() {
        if (!paquet.isEmpty()) {
            return paquet.removeFirst(); // On retire la première carte
        }
        return null; // Si le paquet est vide
    }

    // Incrémenter le score
    public void setScore() {
        this.score += 1;
    }

    // Ajouter une carte au paquet du joueur
    public void ajouterUneCarte(Carte carte) {
        paquet.add(carte);
    }

    // toString() : Affichage des informations du joueur
    public String toString() {
        return "Joueur : " + nom + ", gagne la partie avec un score de " + score + " points.";
    }
}