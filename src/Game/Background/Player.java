package Game.Background;

import Game.Graphic.PlayLayout;

public class Player {

    private final Score score = new Score();
    private final Position position;

    public Player(Position position) {
        this.position = position;
    }

    public Score getScore() {
        return score;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(int x, int y) {
        position.setXY(x, y);
    }

    //movementChecker, checks the walls and unauthorized movements
    public boolean movementChecker(int x, int y, Board board) {
        boolean status = board.getWall().wallChecker(x, y, board, position);
        int diffX = position.getX() - x;
        int diffY = position.getY() - y;
        if ((x == position.getX() || y == position.getY()) && status) {
            if (PlayLayout.isBlueTurn()) {
                if (Limiter.player1Select < Limiter.getPlayer1Count()) {
                    if (Math.abs(diffX) > Limiter.player1Limit[Limiter.player1Select] || Math.abs(diffY) > Limiter.player1Limit[Limiter.player1Select])
                        return false;

                    else
                        Limiter.player1Select++;

                }
            } else {
                if (Limiter.player2Select < Limiter.getPlayer2Count())
                    if (Math.abs(diffX) > Limiter.player2Limit[Limiter.player2Select] || Math.abs(diffY) > Limiter.player2Limit[Limiter.player2Select])
                        return false;
                    else Limiter.player2Select++;
            }
            return true;
        } else return false;
    }
}
