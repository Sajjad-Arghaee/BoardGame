package Game.Background;

import Game.Graphic.PlayLayout;
import Game.Graphic.Play;

import javax.swing.*;

public class Star {

    private int allStars = 0;

    public int getAllStars() {
        return allStars;
    }

    //Counting all stars which are placed in board
    public void increaseAllStar() {
        allStars++;
    }

    // this method get all star items which are placed in player movement
    public void getStar(int x, int y, Position position, Board board, Score score) {
        int rate = 0;
        int diffX = position.getX() - x;
        int diffY = position.getY() - y;
        if (diffY == 0) {
            if (diffX <= 0)
                while (diffX < 1) {
                    if (board.getBoardElements()[x + diffX][y] == 3) {
                        rate++;
                        board.setBoardElements(x + diffX, y, 0);
                        Play.getElement()[x + diffX][y].setIcon(null);
                    }
                    diffX++;
                }

            else
                while (diffX > -1) {
                    if (board.getBoardElements()[x + diffX][y] == 3) {
                        rate++;
                        board.setBoardElements(x + diffX, y, 0);
                        Play.getElement()[x + diffX][y].setIcon(null);
                    }
                    diffX--;
                }
        } else {
            if (diffY <= 0) {
                while (diffY < 1) {
                    if (board.getBoardElements()[x][y + diffY] == 3) {
                        rate++;
                        board.setBoardElements(x, y + diffY, 0);
                        Play.getElement()[x][y + diffY].setIcon(null);
                    }
                    diffY++;
                }
            } else
                while (diffY > -1) {
                    if (board.getBoardElements()[x][y + diffY] == 3) {
                        rate++;
                        board.setBoardElements(x, y + diffY, 0);
                        Play.getElement()[x][y + diffY].setIcon(null);
                    }
                    diffY--;
                }
        }
        score.increaseScore(rate);

        if (PlayLayout.isBlueTurn())
            Play.getPlayer1Score().setText("" + score.getScore());

        else
            Play.getPlayer2Score().setText("" + score.getScore());

        allStars -= rate;
        if (allStars == 0) {
            if (board.getPlayer1().getScore().getScore() > board.getPlayer2().getScore().getScore())
                JOptionPane.showMessageDialog(Play.getPlayFrame(), "Player 1 win :) ", "Result", JOptionPane.INFORMATION_MESSAGE);
            else if (board.getPlayer2().getScore().getScore() > board.getPlayer1().getScore().getScore())
                JOptionPane.showMessageDialog(Play.getPlayFrame(), "Player 2 win :) ", "Result", JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(Play.getPlayFrame(), "Draw :) ", "Result", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }

    }

}
