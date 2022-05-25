package Game.Background;

//the score determines the final winner
public class Score {
    private int score = 0;

    public int getScore() {
        return score;
    }

    public void increaseScore(int score) {
        this.score += score;

    }
}
