package Game.Graphic;

import javax.swing.*;
import java.awt.*;

public class SettingLayout extends JButton {

    private static final int[][] status = new int[CreatTable.getRow()][CreatTable.getColumn()];
    private static int background = 0;

    public static int[][] getStatus() {
        return status;
    }

    public SettingLayout(int x, int y) {
        String path = CreatTable.getPicturePath();
        status[x][y] = 0;
        // 1000 and 650 are width and height of panel
        setBounds(y * (1000 / CreatTable.getColumn()), x * (650 / CreatTable.getRow()), 1000 / CreatTable.getColumn(), 650 / CreatTable.getRow());
        if (background % 2 == 0)
            setBackground(Color.WHITE);
        else
            setBackground(Color.BLACK);
        background++;

        addActionListener(e -> {
            if (Setting.getState() == 0) {
                setIcon(null);
                setText(null);
                status[x][y] = 0;
                if (x == Setting.getPlayer1X() && y == Setting.getPlayer1Y()) {
                    Setting.setPlayer1X(-1);
                    Setting.setPlayer1Y(-1);
                } else if (x == Setting.getPlayer2X() && y == Setting.getPlayer2Y()) {
                    Setting.setPlayer2X(-1);
                    Setting.setPlayer2Y(-1);
                }
            }
            if (!((x == Setting.getPlayer1X() && y == Setting.getPlayer1Y()) || (x == Setting.getPlayer2X() && y == Setting.getPlayer2Y()))) {

                if (Setting.getState() == 1 && Setting.getPlayer1X() == -1) {
                    ImageIcon im = new ImageIcon(path + "blue.jpg");
                    setIcon(im);
                    // we have to set the text "null", because of possible limiter icon
                    setText(null);
                    Setting.setPlayer1X(x);
                    Setting.setPlayer1Y(y);
                    status[x][y] = Setting.getState();
                } else if (Setting.getState() == 2 && Setting.getPlayer2X() == -1) {
                    ImageIcon im = new ImageIcon(path + "red.jpg");
                    setIcon(im);
                    setText(null);
                    Setting.setPlayer2X(x);
                    Setting.setPlayer2Y(y);
                    status[x][y] = Setting.getState();
                } else if (Setting.getState() == 3) {
                    ImageIcon im = new ImageIcon(path + "star.jpg");
                    setIcon(im);
                    setText(null);
                    status[x][y] = Setting.getState();
                } else if (Setting.getState() == 4) {
                    ImageIcon im = new ImageIcon(path + "wall.jpg");
                    setIcon(im);
                    setText(null);
                    status[x][y] = Setting.getState();
                } else if (Setting.getState() >= 10) {
                    ImageIcon im = new ImageIcon(path + "limiter.jpg");
                    setIcon(im);
                    setText(Setting.getLimiterNumber());
                    setHorizontalTextPosition(CENTER);
                    setFont(new Font("Calibri", Font.BOLD, 50));
                    setForeground(Color.BLUE);
                    status[x][y] = Setting.getState();
                }
            }
        });
    }

}
