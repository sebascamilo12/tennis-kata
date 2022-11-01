
public class TennisGame2 implements TennisGame {
    protected int P1point = 0;
    protected int P2point = 0;

    protected String P1res = "";
    protected String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String score;
        String scoreEqual = getScoreEqual(P1point, P2point);
        String scoreTempWithCero = getScoreTempWithCero(P1point, P2point);
        String scoreTemp = getScoreTemp(P1point, P2point);
        String scoreDeuce = getScoreDeuce(P1point, P2point);
        String win = getWin(P1point, P2point);

        if (!scoreEqual.equals("")) {
            score = scoreEqual;
        } else if (!scoreTempWithCero.equals("")) {
            score = scoreTempWithCero;
        } else if (!scoreTemp.equals("")) {
            score = scoreTemp;
        } else if (!scoreDeuce.equals("")) {
            score = scoreDeuce;
        }else {
            score = win;
        }

        return score;
    }

    public String getScoreEqual(int P1point, int P2point) {
        String score = "";
        if (P1point == P2point) {
            if (P1point == 0)
                score = "Love";
            if (P1point == 1)
                score = "Fifteen";
            if (P1point == 2)
                score = "Thirty";
            score += "-All";
        }
        if (P1point == P2point && P1point >= 3)
            score = "Deuce";
        return score;
    }

    public String getScoreTempWithCero(int P1point, int P2point) {
        String score = "";
        if (P1point > 0 && P1point <4 && P2point == 0 ) {
            if (P1point == 1)
                P1res = "Fifteen";
            if (P1point == 2)
                P1res = "Thirty";
            if (P1point == 3)
                P1res = "Forty";

            P2res = "Love";
            score = P1res + "-" + P2res;
        }
        if (P2point > 0 && P2point <4 && P1point == 0) {
            if (P2point == 1)
                P2res = "Fifteen";
            if (P2point == 2)
                P2res = "Thirty";
            if (P2point == 3)
                P2res = "Forty";

            P1res = "Love";
            score = P1res + "-" + P2res;
        }
        return score;
    }

    public String getScoreTemp(int P1point, int P2point) {
        String score = "";
        if (P1point > P2point && P1point < 4) {
            if (P1point == 2)
                P1res = "Thirty";
            if (P1point == 3)
                P1res = "Forty";
            if (P2point == 1)
                P2res = "Fifteen";
            if (P2point == 2)
                P2res = "Thirty";
            score = P1res + "-" + P2res;
        }
        if (P2point > P1point && P2point < 4) {
            if (P2point == 2)
                P2res = "Thirty";
            if (P2point == 3)
                P2res = "Forty";
            if (P1point == 1)
                P1res = "Fifteen";
            if (P1point == 2)
                P1res = "Thirty";
            score = P1res + "-" + P2res;
        }

        return score;
    }

    public String getScoreDeuce(int P1point, int P2point) {
        String score = "";
        if (P1point > P2point && P2point >= 3 && (P1point - P2point) < 2) {
            score = "Advantage " + player1Name;
        }
        if (P2point > P1point && P1point >= 3 && (P2point - P1point) < 2) {
            score = "Advantage " + player2Name;
        }

        return score;
    }

    public String getWin(int P1point, int P2point){
        String score= "";
        if (P1point >= 4 && P2point >= 0 && (P1point - P2point) >= 2) {
            score = "Win for player1";
        }
        if (P2point >= 4 && P1point >= 0 && (P2point - P1point) >= 2) {
            score = "Win for player2";
        }
        return score;
    }


    public void P1Score() {
        P1point++;
    }

    public void P2Score() {
        P2point++;
    }

    public void wonPoint(String player) {
        if (player.equals(player1Name))
            P1Score();
        else
            P2Score();
    }
}