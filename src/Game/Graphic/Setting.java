package Game.Graphic;

import Game.Background.Process;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

public class Setting {

    private static int state = 0;
    /******************
     state 0 means null
     state 1 means player1
     state 2 means player2
     state 3 means star
     state 4 means wall
     state 10 and more means limiter
     ******************/
    private static int player1X = -1;
    private static int player1Y;
    private static int player2X = -1;
    private static int player2Y;
    private static String limiterNumber = "1";

    public static String getLimiterNumber() {
        return limiterNumber;
    }

    public static int getState() {
        return state;
    }

    public static int getPlayer1X() {
        return player1X;
    }

    public static void setPlayer1X(int player1X) {
        Setting.player1X = player1X;
    }

    public static int getPlayer1Y() {
        return player1Y;
    }

    public static void setPlayer1Y(int player1Y) {
        Setting.player1Y = player1Y;
    }

    public static int getPlayer2X() {
        return player2X;
    }

    public static void setPlayer2X(int player2X) {
        Setting.player2X = player2X;
    }

    public static int getPlayer2Y() {
        return player2Y;
    }

    public static void setPlayer2Y(int player2Y) {
        Setting.player2Y = player2Y;
    }

    public Setting(int row, int column) {

        JFrame SettingFrame = new JFrame("Setting");
        SettingFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        SettingFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        SettingFrame.setLayout(null);
        SettingFrame.setResizable(false);

        JPanel welcome = new Drawer("welcome");
        welcome.setBounds(0, 0, 1000, 100);
        welcome.setLayout(null);

        JPanel board = new JPanel();
        board.setBounds(0, 100, 1000, 650);
        board.setLayout(null);
        for (int i = 0; i < row; i++)
            for (int j = 0; j < column; j++)
                board.add(new SettingLayout(i, j));

        JPanel initialize = new JPanel();
        initialize.setBounds(1000, 0, 500, 1000);

        JLabel help1 = new JLabel("Complete the form below and create");
        help1.setBounds(20, 40, 400, 40);
        help1.setFont(new Font("Calibri", Font.BOLD, 20));

        JLabel help2 = new JLabel("your game !");
        help2.setBounds(20, 80, 100, 20);
        help2.setFont(new Font("Calibri", Font.BOLD, 20));

        JLabel rows = new JLabel("Rows :   " + CreatTable.getRow());
        rows.setBounds(50, 200, 100, 10);

        JLabel columns = new JLabel("Columns :   " + CreatTable.getColumn());
        columns.setBounds(180, 200, 100, 10);

        JCheckBox player1 = new JCheckBox("Player1");
        player1.setBounds(70, 260, 200, 20);

        JCheckBox player2 = new JCheckBox("Player2");
        player2.setBounds(70, 330, 200, 20);

        JCheckBox star = new JCheckBox("Star");
        star.setBounds(70, 400, 50, 20);

        JCheckBox wall = new JCheckBox("Wall");
        wall.setBounds(70, 470, 50, 20);

        JCheckBox limiter = new JCheckBox("Limiter");
        limiter.setBounds(70, 540, 100, 20);
        SpinnerModel value = new SpinnerNumberModel(1, 1, 1000, 1);
        JSpinner limit = new JSpinner(value);
        limit.setBounds(170, 540, 40, 20);

        JCheckBox clear = new JCheckBox("Clear");
        clear.setBounds(70, 610, 100, 20);

        ButtonGroup checkers = new ButtonGroup();
        checkers.add(player1);
        checkers.add(player2);
        checkers.add(star);
        checkers.add(wall);
        checkers.add(limiter);
        checkers.add(clear);
        // using buttonGroup allow us to only select one checkbox

        JButton start = new JButton("Start Game");
        start.setBounds(120, 650, 120, 50);
        start.setBackground(Color.orange);

        initialize.add(rows);
        initialize.add(columns);
        initialize.add(help1);
        initialize.add(help2);
        initialize.add(player1);
        initialize.add(player2);
        initialize.add(star);
        initialize.add(wall);
        initialize.add(limiter);
        initialize.add(limit);
        initialize.add(start);
        initialize.add(clear);
        initialize.setLayout(null);

        SettingFrame.add(initialize);
        SettingFrame.add(welcome);
        SettingFrame.add(board);
        SettingFrame.setVisible(true);

        player1.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                state = 1;
            }
        });

        player2.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                state = 2;
            }
        });

        star.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED)
                state = 3;
        });

        wall.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED)
                state = 4;
        });

        limiter.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED)
                state = 11;
        });

        limit.addChangeListener(e -> {
            limiterNumber = ("" + ((JSpinner) e.getSource()).getValue());
            state = Integer.parseInt(limiterNumber) + 10;
        });

        clear.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED)
                state = 0;
        });

        start.addActionListener(e -> {
            if (player1X != -1 && player2X != -1) {
                Process process = new Process(row, column);
                process.runGame(SettingLayout.getStatus());
                new Play(row, column, process);
                SettingFrame.dispose();
            } else
                JOptionPane.showMessageDialog(SettingFrame, "You should create two player", "Can't start", JOptionPane.WARNING_MESSAGE);
        });
    }
}
