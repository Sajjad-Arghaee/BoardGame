package Game.Background;

public class Wall {

    // this method get all wall items which are placed in player movement
    // it is similar to star and limiter checker
    public boolean wallChecker(int x, int y, Board board, Position position) {
        int status = 0;
        int diffX = position.getX() - x;
        int diffY = position.getY() - y;

        if (diffX == 0 && diffY == 0)
            return false;
        if (diffY == 0) {
            if (diffX <= 0) {
                while (diffX < 1) {
                    if (board.getBoardElements()[x + diffX][y] == 4)
                        status++;
                    diffX++;
                }
            } else
                while (diffX > -1) {
                    if (board.getBoardElements()[x + diffX][y] == 4)
                        status++;
                    diffX--;
                }
        } else {
            if (diffY <= 0) {
                while (diffY < 1) {
                    if (board.getBoardElements()[x][y + diffY] == 4)
                        status++;
                    diffY++;
                }
            } else
                while (diffY > -1) {
                    if (board.getBoardElements()[x][y + diffY] == 4)
                        status++;
                    diffY--;
                }
        }
        return status == 0;
    }
}
