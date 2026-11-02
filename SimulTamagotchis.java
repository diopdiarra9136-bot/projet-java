import java.util.Scanner;

public class SimulTamagotchis {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nombre de tamagotchis
        int n = 0;
        while (n < 1) {
            System.out.print("Combien de tamagotchis ? ");
            try {
                n = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrez un entier positif.");
            }
        }

        // Création : un tableau, une case vide (null) = tamagotchi arrivé au bout
        Tamagotchi[] tab = new Tamagotchi[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Quel nom pour le nouveau tamagotchi : ");
            tab[i] = new Tamagotchi(sc.nextLine().trim());
        }

        int restants = n;
        int cycle = 1;
        boolean perdu = false;

        while (!perdu && restants > 0) {
            System.out.println("-------Cycle no " + cycle + " -------");

            // Tous les tamagotchis vivent un cycle
            for (int i = 0; i < n && !perdu; i++) {
                if (tab[i] != null) {
                    if (!tab[i].vivre()) {
                        perdu = true;                // mort de faim
                    } else if (tab[i].ageLimite()) {
                        tab[i] = null;               // a gagné : il sort du jeu
                        restants--;
                    }
                }
            }

            // L'utilisateur choisit qui nourrir
            if (!perdu && restants > 0) {
                for (int i = 0; i < n; i++) {
                    if (tab[i] != null) {
                        System.out.print("(" + i + ") " + tab[i].getNom() + " ");
                    }
                }
                System.out.print("\nNourrir quel tamagotchi ? ");
                try {
                    int choix = Integer.parseInt(sc.nextLine().trim());
                    if (choix >= 0 && choix < n && tab[choix] != null) {
                        tab[choix].manger();
                    } else {
                        System.out.println("Choix invalide, personne n'est nourri.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Choix invalide, personne n'est nourri.");
                }
            }
            cycle++;
        }

        System.out.println(perdu ? "PERDU !!" : "GAGNÉ !!");
    }
}
