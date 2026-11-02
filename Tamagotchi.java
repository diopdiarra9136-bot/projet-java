import java.util.Random;

public class Tamagotchi {

    private static final Random ALEA = new Random();

    private int age;
    private int dureeDeVie;
    private int maxEnergie;
    private int energie;
    private String nom;

    // Question 1
    public Tamagotchi(String nom) {
        this.nom = nom;
        this.age = 0;
        this.dureeDeVie = 9 + ALEA.nextInt(6);                  // entre 9 et 14
        this.maxEnergie = 5 + ALEA.nextInt(5);                  // entre 5 et 9
        this.energie = 3 + ALEA.nextInt(maxEnergie - 3 + 1);    // entre 3 et maxEnergie
    }

    // Question 2
    public void parler() {
        if (energie > 5) {
            System.out.println(nom + " : tout va bien !");      // heureux
        } else {
            System.out.println(nom + " : je suis affamé !");    // affamé
        }
    }

    // Question 3
    public void manger() {
        if (energie >= maxEnergie) {
            System.out.println(nom + " : je n'ai pas faim !!");
        } else {
            int gain = 1 + ALEA.nextInt(3);                     // entre 1 et 3
            energie = Math.min(maxEnergie, energie + gain);     // sans dépasser maxEnergie
            System.out.println(nom + " : Merci !");
        }
    }

    // Question 4
    public boolean ageLimite() {
        return age >= dureeDeVie;
    }

    // Question 5
    public boolean vivre() {
        if (age == dureeDeVie) {                                // cas (a)
            return true;
        }
        if (energie <= 0) {                                     // cas (b)
            System.out.println(nom + " : je meurs... Arrrggh !");
            return false;
        }
        age++;                                                  // cas (c)
        energie--;
        if (ageLimite()) {
            System.out.println(nom + " : c'est gagné pour moi !");
        } else {
            parler();
        }
        return true;
    }

    public String getNom() {
        return nom;
    }
}
