package Game.Background;

import Game.Graphic.PlayLayout;

public class Board {
    private final int[][] boardElements;
    private final Wall wall = new Wall();
    private final Limiter limiter = new Limiter();
    private final Star star = new Star();
    private final Player player1 = PlayLayout.getPlayer1();
    private final Player player2 = PlayLayout.getPlayer2();

    //set board elements
    public Board(int[][] board) {
        this.boardElements = board;
    }

    public int[][] getBoardElements() {
        return boardElements;
    }

    public void setBoardElements(int i, int j, int input) {
        boardElements[i][j] = input;
    }

    public Wall getWall() {
        return wall;
    }

    public Limiter getLimiter() {
        return limiter;
    }

    public Star getStar() {
        return star;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}
