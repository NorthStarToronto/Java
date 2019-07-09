package Core2;

public class Main {

    public static void main(String[] args) {
//        boolean gameOver = true;
//        int score = 800;
//        int levelCompleted = 5;
//        int bonus = 100;

        // save return object and print
        int highScorePosition = calculalteHighScorePosition(100);
        displayHighScorePosition("Tom", highScorePosition);
//        System.out.println("Your final score was " + highScore);

        highScorePosition = calculalteHighScorePosition( 600);
        displayHighScorePosition("Jane", highScorePosition);

        highScorePosition = calculalteHighScorePosition(1100);
        displayHighScorePosition("Mary", highScorePosition);


        // Same as gameOver == true


        // Reassign the variables
        // socre = 100000;
        // levelCompleted = 2;
        // System.out.println("Your second score ");

        // Don't duplicate the code => Use Method "Easier to maintain"
        // Error prone


        int newScore = calculateScore("Tom", 100);
        System.out.println("The new score is " + newScore);
        calculateScore(75);
        calculateScore();

    }


    // Create Methods
    public static void displayHighScorePosition(String playerName, int highScorePosition) {
        System.out.println(playerName + " managed to get into position " +
                highScorePosition + " on the high score table");
    }

    public static int calculalteHighScorePosition(int playerScore) {
//        if (playerScore >= 1000) {
//            return 1;
//        } else if (playerScore >= 500) {
//            // && playerScore < 1000 always true
//            return 2;
//        }  else if (playerScore >= 100) {
//            // && playerScore < 500 always true
//            return 3;
//        }
//        return 4;

        int position = 4; // default position

        if (playerScore >= 1000) {
            position = 1;
        } else if (playerScore >= 500) {
            position = 2;
        } else if (playerScore >= 100) {
            position = 3;
        }
        return position;
    }

    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {
      // local parameter variables are automatically created and deleted after
      // end of the block run
        if (gameOver) {
            int finalScore = score + (levelCompleted * bonus);
            finalScore += 1000;
            return finalScore;
        } else {
            return -1; // -1 => error or invalid value/not found value
        }
    }

    // Overloading


    /* Overloading */
    public static int calculateScore(String playerName, int score) {
        System.out.println("Player " + playerName + " scored"  + score + " points");
        return score * 1000;
    }

    public static int calculateScore(int score) {
        System.out.println("Unnamed player scored + " + score + " points");
        return score * 1000;
    }

    public static int calculateScore() {
        System.out.println("No player name, no player score.");
        return 0;
    }
}
