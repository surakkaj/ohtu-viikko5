package ohtu;

public class TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1") {
            m_score1 += 1;
        } else {
            m_score2 += 1;
        }
    }

    public String getScore() {
        String score = "";
        int tempScore = 0;
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
                case 3:
                    score = "Forty-All";
                    break;
                default:
                    score = "Deuce";
                    break;

            }
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            int minusResult = m_score1 - m_score2;
            if (minusResult == 1) {
                score = "Advantage player1";
            } else if (minusResult == -1) {
                score = "Advantage player2";
            } else if (minusResult >= 2) {
                score = "Win for player1";
            } else {
                score = "Win for player2";
            }
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) {
                    tempScore = m_score1;
                } else {
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
                    case 3:
                        score += "Forty";
                        break;
                }
            }
        }
        return test();
    }

    public String test() {
        if (m_score1 >= 4 || m_score2 >= 4) {
            int minusResult = m_score1 - m_score2;
            
            switch (minusResult) {
                case 1:
                    return "Advantage player1";
                case -1:
                    return "Advantage player2";
                case 0:
                    return "Deuce";
                case 2:
                    return "Win for player1";
                case -2:
                    return "Win for player2";
            }

        }
        String[] scores = {"", ""};
        int k = m_score1;
        for (int i = 0; i < 2; i++) {
            if (i == 1) {
                k = m_score2;
            }
            switch (k) {
                case 0:
                    scores[i] = "Love";
                    break;
                case 1:
                    scores[i] = "Fifteen";
                    break;
                case 2:
                    scores[i] = "Thirty";
                    break;
                case 3:
                    scores[i] = "Forty";
                    break;
            }
        }
        if (m_score1 == m_score2) {
            scores[1] = "All";
        }
        return scores[0] + "-" + scores[1];
    }
}
