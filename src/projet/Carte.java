package projet;

public class Carte {

    // attributs : tableau pour les couleurs et les valeurs des cartes
    public static String[] COULEURS = {"❤", "♣", "♠", "♦"};
    public static String[] VALEURS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Dame", "Roi", "As"};

    private final String couleur;
    private final int valeur;

    // Constructeur de la classe Carte initialise la carte
    public Carte(String c, int v) {
        this.couleur = c;
        this.valeur = v;
    }

    // Getter pour obtenir la couleur de la carte
    public String getCouleur() {
        return couleur;
    }

    // Getter pour obtenir la valeur de la carte
    public int getValeur() {
        return valeur;
    }

    // Méthode de comparaison entre deux cartes
    public int compare(Carte c) {
        return Integer.compare(this.valeur, c.valeur);
    }

    // Méthode pour afficher un resultat
    public String toString(){
        return Carte.VALEURS[valeur] + " de " + couleur;
    }
}