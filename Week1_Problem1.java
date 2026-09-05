import java.util.*;

public class RockPaperScissors {

    static String playRound(String playerMove, String computerMove) {

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};

        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.print("Enter number of rounds: ");
        int n = sc.nextInt();

        String[][] table = new String[n][4];

        for (int i = 0; i < n; i++) {

            System.out.print("Enter your move (Rock/Paper/Scissors): ");
            String playerMove = sc.next();

            String computerMove = moves[random.nextInt(3)];

            String result = playRound(playerMove, computerMove);

            if (result.equals("Player Wins"))
                wins++;
            else if (result.equals("Computer Wins"))
                losses++;
            else
                draws++;

            table[i][0] = String.valueOf(i + 1);
            table[i][1] = playerMove;
            table[i][2] = computerMove;
            table[i][3] = result;
        }

        System.out.println("\nFinal Summary");
        System.out.println("---------------------------------------------");
        System.out.println("Round\tPlayer\tComputer\tResult");
        System.out.println("---------------------------------------------");

        for (int i = 0; i < n; i++) {
            System.out.println(table[i][0] + "\t" +
                               table[i][1] + "\t" +
                               table[i][2] + "\t\t" +
                               table[i][3]);
        }

        double winPercentage = (wins * 100.0) / n;

        System.out.println("\nWins   : " + wins);
        System.out.println("Losses : " + losses);
        System.out.println("Draws  : " + draws);
        System.out.println("Win %  : " + winPercentage + "%");

        sc.close();
    }
}