
package DiceGame; // eller org.example

import java.util.Random;
import java.util.Scanner;

class Player {
    private String firstname;
    private String lastname;
    private int score;

    public Player(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.score = 0;
    }

    public void addToScore(int score) {
        this.score += score;
    }

    public int getScore() {
        return score;
    }

    public String getFullName() {
        return firstname + " " + lastname;
    }

    public void resetScore() {
        this.score = 0;
    }
}

public class DiceGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Ange förnamn för spelare 1: ");
        String fn1 = scanner.nextLine();
        System.out.print("Ange efternamn för spelare 1: ");
        String ln1 = scanner.nextLine();
        Player player1 = new Player(fn1, ln1);

        System.out.print("Ange förnamn för spelare 2: ");
        String fn2 = scanner.nextLine();
        System.out.print("Ange efternamn för spelare 2: ");
        String ln2 = scanner.nextLine();
        Player player2 = new Player(fn2, ln2);

        while (true) {
            System.out.print("Skriv 'play' för att spela eller 'quit' för att avsluta: ");
            String command = scanner.nextLine();

            if (command.equalsIgnoreCase("quit")) {
                System.out.println("Spelet avslutas.");
                break;
            } else if (command.equalsIgnoreCase("play")) {
                player1.resetScore();
                player2.resetScore();

                for (int i = 0; i < 2; i++) {
                    int roll = random.nextInt(1, 7);
                    player1.addToScore(roll);
                    System.out.println(player1.getFullName() + " slog en " + roll);
                }

                for (int i = 0; i < 2; i++) {
                    int roll = random.nextInt(1, 7);
                    player2.addToScore(roll);
                    System.out.println(player2.getFullName() + " slog en " + roll);
                }

                System.out.println(player1.getFullName() + " fick totalt: " + player1.getScore());
                System.out.println(player2.getFullName() + " fick totalt: " + player2.getScore());

                if (player1.getScore() > player2.getScore()) {
                    System.out.println("Vinnaren är: " + player1.getFullName());
                } else if (player2.getScore() > player1.getScore()) {
                    System.out.println("Vinnaren är: " + player2.getFullName());
                } else {
                    System.out.println("Det blev oavgjort!");
                }
            } else {
                System.out.println("Ogiltigt kommando, försök igen.");
            }
        }

        scanner.close();
    }
}
