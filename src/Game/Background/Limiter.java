package Game.Background;

import Game.Graphic.PlayLayout;
import Game.Graphic.Play;

public class Limiter {

    private static int player1Count = 0;
    private static int player2Count = 0;
    public static int[] player1Limit = new int[100];
    public static int[] player2Limit = new int[100];
    public static int player1Select = 0;
    public static int player2Select = 0;

    public static int getPlayer1Count() {
        return player1Count;
    }

    public static int getPlayer2Count() {
        return player2Count;
    }

    // this method get all limiter items which are placed in player movement
    public void getLimiter(int x, int y, Position position, Board board) {
        int diffX = position.getX() - x;
        int diffY = position.getY() - y;
        if (diffY == 0) {
            if (diffX <= 0)
                while (diffX < 1) {
                    if (board.getBoardElements()[x + diffX][y] > 5) {
                        if (PlayLayout.isBlueTurn())
                            player2Limit[player2Count++] = board.getBoardElements()[x + diffX][y] - 10;
                        else
                            player1Limit[player1Count++] = board.getBoardElements()[x + diffX][y] - 10;
                        board.setBoardElements(x + diffX, y, 0);
                        Play.getElement()[x + diffX][y].setIcon(null);
                        Play.getElement()[x + diffX][y].setText(null);
                    }
                    diffX++;
                }
            else
                while (diffX > -1) {
                    if (board.getBoardElements()[x + diffX][y] > 5) {
                        if (PlayLayout.isBlueTurn())
                            player2Limit[player2Count++] = board.getBoardElements()[x + diffX][y] - 10;
                        else
                            player1Limit[player1Count++] = board.getBoardElements()[x + diffX][y] - 10;
                        board.setBoardElements(x + diffX, y, 0);
                        Play.getElement()[x + diffX][y].setIcon(null);
                        Play.getElement()[x + diffX][y].setText(null);
                    }
                    diffX--;
                }
        } else {
            if (diffY <= 0) {
                while (diffY < 1) {
                    if (board.getBoardElements()[x][y + diffY] > 5) {
                        if (PlayLayout.isBlueTurn())
                            player2Limit[player2Count++] = board.getBoardElements()[x][y + diffY] - 10;
                        else
                            player1Limit[player1Count++] = board.getBoardElements()[x][y + diffY] - 10;
                        board.setBoardElements(x, y + diffY, 0);
                        Play.getElement()[x][y + diffY].setIcon(null);
                        Play.getElement()[x][y + diffY].setText(null);
                    }
                    diffY++;
                }
            } else
                while (diffY > -1) {
                    if (board.getBoardElements()[x][y + diffY] > 5) {
                        if (PlayLayout.isBlueTurn())
                            player2Limit[player2Count++] = board.getBoardElements()[x][y + diffY] - 10;
                        else
                            player1Limit[player1Count++] = board.getBoardElements()[x][y + diffY] - 10;
                        board.setBoardElements(x, y + diffY, 0);
                        Play.getElement()[x][y + diffY].setIcon(null);
                        Play.getElement()[x][y + diffY].setText(null);
                    }
                    diffY--;
                }
        }
    }

}
