package Game.Background;

import Game.Graphic.PlayLayout;

// Process is the first bridge between foreground and background
public class Process {

    private static int row;
    private static int column;
    private Board board;

    public Process(int row, int column) {
        Process.row = row;
        Process.column = column;
    }

    public Board getBoard() {
        return board;
    }

    public void runGame(int[][] status) {
        board = new Board(status);
        for (int i = 0; i < row; i++)
            for (int j = 0; j < column; j++)
                board.setBoardElements(i, j, status[i][j]);

        getAllStars();
    }

    // by using below method, we can understand that when the game is finished
    public void getAllStars() {
        System.out.println();
        for (int i = 0; i < row; i++)
            for (int j = 0; j < column; j++) {
                if (board.getBoardElements()[i][j] == 3)
                    board.getStar().increaseAllStar();
            }
    }

    // Play method access player to move
    public boolean play(int x, int y, Board board, Player player) {

        if (player.movementChecker(x, y, board)) {

            if (PlayLayout.isBlueTurn()) {
                board.getStar().getStar(x, y, new Position(PlayLayout.getPlayer1().getPosition().getX(), PlayLayout.getPlayer1().getPosition().getY()), board, player.getScore());
                board.getLimiter().getLimiter(x, y, new Position(PlayLayout.getPlayer1().getPosition().getX(), PlayLayout.getPlayer1().getPosition().getY()), board);
            } else {
                board.getStar().getStar(x, y, new Position(PlayLayout.getPlayer2().getPosition().getX(), PlayLayout.getPlayer2().getPosition().getY()), board, player.getScore());
                board.getLimiter().getLimiter(x, y, new Position(PlayLayout.getPlayer2().getPosition().getX(), PlayLayout.getPlayer2().getPosition().getY()), board);
            }
            return true;
        } else return false;
    }
}
