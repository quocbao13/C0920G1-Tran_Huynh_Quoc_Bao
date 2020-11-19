package _08_clean_code.exercise.refactoring_extraction;

import java.util.Optional;

public class TennisGame {
    public static String getScore(String playerFirstName, String playerFirstScore, int m_score1, int m_score2) {
        StringBuilder score = new StringBuilder();
        if (m_score1==m_score2)
        {
            score = Optional.ofNullable(checkScore(m_score1)).map(StringBuilder::new).orElse(null);
        }
        else if (m_score1>=4 || m_score2>=4)
        {
            score = getStringBuilder(m_score1, m_score2);
        }
        else
        {
            showWinner(m_score1, m_score2, score);
        }
        return score == null ? null : score.toString();
    }

    private static StringBuilder getStringBuilder(int m_score1, int m_score2) {
        StringBuilder score;
        int minusResult = m_score1-m_score2;
        if (minusResult==1) score = new StringBuilder("Advantage player1");
        else if (minusResult ==-1) score = new StringBuilder("Advantage player2");
        else if (minusResult>=2) score = new StringBuilder("Win for player1");
        else score = new StringBuilder("Win for player2");
        return score;
    }

    private static void showWinner(int m_score1, int m_score2, StringBuilder score) {
        int tempScore;
        for (int i = 1; i<3; i++)
        {
            if (i==1) tempScore = m_score1;
            else { score.append("-"); tempScore = m_score2;}
            score.append(checkTempScore(tempScore));
        }
    }

    private static String checkScore(int m_score1){
        String score;
        switch (m_score1)
        {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            case 3:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;

        }
        return score;
    }

    private static String checkTempScore(int tempScore){
        String score = "";
        switch(tempScore)
        {
            case 0:
                score = "Love";
                break;
            case 1:
                score = "Fifteen";
                break;
            case 2:
                score = "Thirty";
                break;
            case 3:
                score = "Forty";
                break;
        }
        return score;
    }

}
