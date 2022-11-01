
public class TennisGame1 implements TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        String score;
        String scoreEqual = getScoreEqual(m_score1, m_score2);
        String scoreDeuce = getScoreDeuce(m_score1, m_score2);
        if (!scoreEqual.equals("")) {
            score = scoreEqual;
        } else if (!scoreDeuce.equals("")) {
            score = scoreDeuce;
        } else {
            score = getScoreTemp(m_score1, m_score2);
        }
        return score;
    }

    public String getScoreEqual(int m_score1, int m_score2) {
        String score = "";
        if (m_score1 == m_score2) {
            switch (m_score1) {
                case 0:
                    score = "Love-All";
                    break;
                case 1:
                    score = "Fifteen-All";
                    break;
                case 2:
                    score = "Thirty-All";
                    break;
                default:
                    score = "Deuce";
                    break;
            }
        }
        return score;
    }

    public String getScoreDeuce(int m_score1, int m_score2) {
        String score = "";
        if (m_score1 >= 4 || m_score2 >= 4) {
            int minusResult = m_score1 - m_score2;
            if (minusResult == 1) score = "Advantage " + player1Name;
            else if (minusResult == -1) score = "Advantage " + player2Name;
            else if (minusResult >= 2) score = "Win for " + player1Name;
            else score = "Win for " + player2Name;
        }
        return score;
    }

    public String getScoreTemp(int m_score1, int m_score2) {
        String score = "";
        int tempScore = 0;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = m_score1;
            else {
                score += "-";
                tempScore = m_score2;
            }
            switch (tempScore) {
                case 0:
                    score += "Love";
                    break;
                case 1:
                    score += "Fifteen";
                    break;
                case 2:
                    score += "Thirty";
                    break;
                default:
                    score += "Forty";
                    break;
            }
        }

        return score;
    }

}
