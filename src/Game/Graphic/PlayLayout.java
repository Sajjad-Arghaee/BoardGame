package Game.Graphic;

import Game.Background.*;

import javax.swing.*;
import java.awt.*;

public class PlayLayout extends JButton {
    private static boolean turn = true;
    /****
    true -> blue turn
    false -> red turn
     ****/
    private static final Player player1 = new Player(new Position(-1, -1));
    private static final Player player2 = new Player(new Position(-1, -1));
    // negative number means that player piece is not set

    public static boolean isBlueTurn() {
        return turn;
    }

    public static Player getPlayer1() {
        return player1;
    }

    public static Player getPlayer2() {
        return player2;
    }

    public PlayLayout(int x, int y, int color) {
        String path = CreatTable.getPicturePath();
        setBounds(y * (1000 / CreatTable.getColumn()), x * (650 / CreatTable.getRow()), 1000 / CreatTable.getColumn(), 650 / CreatTable.getRow());
        if (color == 0 && (x + y) % 2 == 0)
            setBackground(Color.WHITE);
        else if (color == 0 && (x + y) % 2 == 1)
            setBackground(Color.BLACK);
        else if (color == 1) {

            if ((x + y) % 2 == 0)
                setBackground(Color.WHITE);
            else
                setBackground(Color.BLACK);

            ImageIcon im = new ImageIcon(path + "blue.jpg");
            setIcon(im);
            player1.setPosition(x, y);
        } else if (color == 2) {

            if ((x + y) % 2 == 0)   // by (x + y) % 2 , we can create checkered page
                setBackground(Color.WHITE);
            else
                setBackground(Color.BLACK);

            ImageIcon im = new ImageIcon(path + "red.jpg");
            setIcon(im);
            player2.setPosition(x, y);
        } else if (color == 3) {

            if ((x + y) % 2 == 0)
                setBackground(Color.WHITE);
            else
                setBackground(Color.BLACK);

            ImageIcon im = new ImageIcon(path + "star.jpg");
            setIcon(im);
        } else if (color == 4) {

            if ((x + y) % 2 == 0)
                setBackground(Color.WHITE);
            else
                setBackground(Color.BLACK);

            ImageIcon im = new ImageIcon(path + "wall.jpg");
            setIcon(im);
        } else if (color >= 5) {

            if ((x + y) % 2 == 0)
                setBackground(Color.WHITE);
            else
                setBackground(Color.BLACK);

            ImageIcon im = new ImageIcon(path + "limiter.jpg");
            setIcon(im);
            setText("" + (color - 10));
            setHorizontalTextPosition(CENTER);
            setFont(new Font("Calibri", Font.BOLD, 50));
            setForeground(Color.BLUE);
        }

        addActionListener(e -> {
            if (turn) {
                if ((x != player2.getPosition().getX() || y != player2.getPosition().getY()) && Play.getProcess().play(x, y, Play.getProcess().getBoard(), player1)) {
                    ImageIcon im = new ImageIcon(path + "blue.jpg");
                    setIcon(im);
                    Play.getElement()[player1.getPosition().getX()][player1.getPosition().getY()].setIcon(null);
                    player1.setPosition(x, y);
                    turn = false;
                    Play.getTurnBlue().setText("no");
                    Play.getTurnRed().setText("yes");
                    // and putting above statement in table...
                } else
                    JOptionPane.showMessageDialog(Play.getPlayFrame(), "Invalid movement ! Please try again", "Unauthorized", JOptionPane.WARNING_MESSAGE);

            } else {
                if ((x != player1.getPosition().getX() || y != player1.getPosition().getY()) && Play.getProcess().play(x, y, Play.getProcess().getBoard(), player2)) {
                    ImageIcon im = new ImageIcon(path + "red.jpg");
                    setIcon(im);
                    Play.getElement()[player2.getPosition().getX()][player2.getPosition().getY()].setIcon(null);
                    player2.setPosition(x, y);
                    turn = true;
                    Play.getTurnBlue().setText("yes");
                    Play.getTurnRed().setText("no");
                } else
                    JOptionPane.showMessageDialog(Play.getPlayFrame(), "Invalid movement ! Please try again", "Unauthorized", JOptionPane.WARNING_MESSAGE);
            }
        });
    }
}
