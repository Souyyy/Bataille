package projet;

import java.util.ArrayList;
import java.util.Collections;

public class Bataille {

    public static void main(String[] args) {

        // ETAPE 1 : Creer un jeu de 52 cartes.
        ArrayList<Carte> jeuDeCartes = new ArrayList<>();
        //Parcourir chaque couleur disponible dans la classe Carte ainsi que les valeurs , et ajouter la carte à la liste de cartes.
        for (String couleur : Carte.COULEURS) {
            for (int valeur = 0; valeur < Carte.VALEURS.length; valeur++) {
                Carte carte = new Carte(couleur, valeur);
                jeuDeCartes.add(carte);
            }
        }


        // ETAPE 2 : melanger aleatoirement le jeu
        Collections.shuffle(jeuDeCartes);


        // ETAPE 3 : creer les 2 joueurs
        Joueur joueur1 = new Joueur("Player1"); // As de Coeur
        Joueur joueur2 = new Joueur("Player2"); // As de Coeur


        // ETAPE 4 : distribuer le jeu de carte melange au 2 joueurs
        for (int i = 0; i < jeuDeCartes.size(); i++) {
            if (i % 2 == 0) {
                // Joueur 1 reçoit une carte
                joueur1.ajouterUneCarte(jeuDeCartes.get(i));
            } else {
                // Joueur 2 reçoit une carte
                joueur2.ajouterUneCarte(jeuDeCartes.get(i));
            }
        }

        // ETAPE 5 : la partie commence, tant qu'il reste des cartes à au moins un joueur (boucle), on a :
        while (joueur1.getPaquet() > 0 && joueur2.getPaquet() > 0) {
            // Chaque joueur tire une carte de son paquet
            Carte carteJoueur1 = joueur1.tirerUneCarte();
            Carte carteJoueur2 = joueur2.tirerUneCarte();
            // Comparer les deux cartes tirees pour determiner le gagnant
            int resultat = carteJoueur1.compare(carteJoueur2);

            // Si la carte du joueur 1 est plus forte
            if (resultat > 0) {
                System.out.println(joueur1.getNom() + " : " + carteJoueur1 .toString()+ " | " + joueur2.getNom() + " : " + carteJoueur2.toString() + ", " + joueur1.getNom() + " gagne la main.");
                joueur1.setScore();

            // Si la carte du joueur 2 est plus forte
            } else if (resultat < 0) {
                System.out.println(joueur1.getNom() + " : " + carteJoueur1.toString() + " | " + joueur2.getNom() + " : " + carteJoueur2.toString() + ", " + joueur2.getNom() + " gagne la main.");
                joueur2.setScore();

            // Si les cartes sont egales
            } else {
                System.out.println(joueur1.getNom() + " : " + carteJoueur1.toString() + " | " + joueur2.getNom() + " : " + carteJoueur2.toString() + ", Bataille.");

                // Cree une liste pour stocker les cartes gagnees lors de la bataille
                ArrayList<Carte> cartesGagnees = new ArrayList<>();
                cartesGagnees.add(carteJoueur1);
                cartesGagnees.add(carteJoueur2);

                // Boucle infinie pour gerer la bataille tant qu'il y a des cartes
                while (true) {
                    // Verifier s'il y a des cartes disponibles pour la bataille
                    if (joueur1.getPaquet() == 0 || joueur2.getPaquet() == 0) {
                        break;
                    }

                    // Chaque joueur tire une carte pour la bataille
                    Carte carteBatailleJoueur1 = joueur1.tirerUneCarte();
                    Carte carteBatailleJoueur2 = joueur2.tirerUneCarte();

                    cartesGagnees.add(carteBatailleJoueur1);
                    cartesGagnees.add(carteBatailleJoueur2);
                    // Comparer les deux cartes tireees pour determiner le gagnant
                    int resultatBataille = carteBatailleJoueur1.compare(carteBatailleJoueur2);

                    if (resultatBataille > 0) {
                        System.out.println(joueur1.getNom() + " : " + carteBatailleJoueur1 + " | " + joueur2.getNom() + " : " + carteBatailleJoueur2 + ", " + joueur1.getNom() + " gagne la bataille.");
                        joueur1.setScore();
                        break; // Sortir de la boucle de bataille
                    } else if (resultatBataille < 0) {
                        System.out.println(joueur1.getNom() + " : " + carteBatailleJoueur1 + " | " + joueur2.getNom() + " : " + carteBatailleJoueur2 + ", " + joueur2.getNom() + " gagne la bataille.");
                        joueur2.setScore();
                        break; // Sortir de la boucle de bataille
                    } else {
                        // Si egalite, continuer la bataille
                        System.out.println(joueur1.getNom() + " : " + carteJoueur1 + " | " + joueur2.getNom() + " : " + carteJoueur2 + ", Bataille.");
                    }
                }
            }
        }


        // ETAPE 6 : Score
        // Afficher le score pour le gagnant
        if (joueur1.getScore() > joueur2.getScore()) {
            System.out.println(joueur1.getNom() + " gagne la partie avec un score de " + joueur1.getScore() + " points.");
        } else if (joueur2.getScore() > joueur1.getScore()) {
            System.out.println(joueur2.getNom() + " gagne la partie avec un score de " + joueur2.getScore() + " points.");
        } else {
            System.out.println("Égalité -" + joueur1.getScore() + " points. " +"-"+ joueur2.getScore() + " points.");
        }

    }
}