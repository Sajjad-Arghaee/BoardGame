package Game.Graphic;

import Game.Background.Process;

import javax.swing.*;
import java.awt.*;

public class Play {

    private static Process process;
    private static JFrame playFrame;
    private static final PlayLayout[][] element = new PlayLayout[CreatTable.getRow()][CreatTable.getColumn()];
    // element array save the board buttons
    private static JLabel player1Score;
    private static JLabel player2Score;
    private static JLabel turnBlue;
    private static JLabel turnRed;

    public static Process getProcess() {
        return process;
    }

    public static JFrame getPlayFrame() {
        return playFrame;
    }

    public static PlayLayout[][] getElement() {
        return element;
    }

    public static JLabel getPlayer1Score() {
        return player1Score;
    }

    public static JLabel getPlayer2Score() {
        return player2Score;
    }

    public static JLabel getTurnBlue() {
        return turnBlue;
    }

    public static JLabel getTurnRed() {
        return turnRed;
    }

    public Play(int row, int column, Process process) {

        Play.process = process;
        playFrame = new JFrame("Board Game");
        playFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        playFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        playFrame.setResizable(false);
        playFrame.setLayout(null);

        JPanel informationTable = new JPanel();
        informationTable.setBounds(0, 0, 1400, 100);
        informationTable.setLayout(null);

        // creating information for our table
        String[][] data = new String[][]{{"player 1", "", "", "blue"},
                {"player 2", "", "", "red"}};
        String[] columnItems = {"Name", "Score", "Turn", "Color"};
        JTable jt = new JTable(data, columnItems);
        jt.setEnabled(false);

        JScrollPane table = new JScrollPane(jt);
        table.setBounds(0, 0, 1400, 100);
        informationTable.add(table);

        player1Score = new JLabel("0");
        player1Score.setBounds(520, 18, 50, 20);

        player2Score = new JLabel("0");
        player2Score.setBounds(520, 34, 50, 20);

        turnBlue = new JLabel("yes");
        turnBlue.setBounds(865, 18, 50, 20);

        turnRed = new JLabel("no");
        turnRed.setBounds(865, 34, 50, 20);

        JPanel vs = new Drawer("vs");
        vs.setBounds(1000, 100, 400, 300);
        vs.setLayout(null);

        JPanel help = new JPanel();
        help.setLayout(null);
        help.setBounds(1000, 400, 400, 500);
        help.setBackground(Color.PINK);

        JLabel help1 = new JLabel("The winner is the one who");
        help1.setFont(new Font("Calibri", Font.BOLD, 20));
        help1.setBounds(50, 100, 300, 50);

        JLabel help2 = new JLabel("collects more stars");
        help2.setFont(new Font("Calibri", Font.BOLD, 20));
        help2.setBounds(50, 125, 300, 50);

        JButton exit = new JButton("Exit");
        exit.setBackground(Color.darkGray);
        exit.setForeground(Color.white);
        exit.setBounds(105, 210, 150, 40);

        help.add(exit);
        help.add(help1);
        help.add(help2);

        JPanel board = new JPanel();
        board.setBounds(0, 100, 1000, 650);
        board.setLayout(null);

        for (int i = 0; i < row; i++)
            for (int j = 0; j < column; j++) {
                element[i][j] = new PlayLayout(i, j, SettingLayout.getStatus()[i][j]);
                board.add(element[i][j]);
            }

        playFrame.add(player1Score);
        playFrame.add(player2Score);
        playFrame.add(turnBlue);
        playFrame.add(turnRed);
        playFrame.add(informationTable);
        playFrame.add(vs);
        playFrame.add(help);
        playFrame.add(board);
        playFrame.setVisible(true);

        // use below if, to consider 0 star which is provided by setter client
        if (process.getBoard().getStar().getAllStars() == 0) {
            JOptionPane.showMessageDialog(Play.playFrame, "Draw :) ", "Result", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }

        exit.addActionListener(e -> System.exit(0));
    }
}
