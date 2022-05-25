package Game.Graphic;

import javax.swing.*;
import java.awt.*;

public class CreatTable {

    private static int row = 0;
    private static int column = 0;
    /*
    to selecting suitable picture to be responsive
    we creat our following path :
     */
    private static String picturePath = "src/Game/Graphic/";

    public static int getRow() {
        return row;
    }

    public static String getPicturePath() {
        return picturePath;
    }

    public static int getColumn() {
        return column;
    }

    public CreatTable() {
        String rowS;
        String columnS;
        JFrame frame = new JFrame();
        rowS = JOptionPane.showInputDialog(frame, "Enter rows");
        // validating input from client :
        if (rowS.matches("\\d+")) {
            row = Integer.parseInt(rowS);
        }
        columnS = JOptionPane.showInputDialog(frame, "Enter columns");
        if (columnS.matches("\\d+")) {
            column = Integer.parseInt(columnS);
        }
        //creat suitable path
        if (row < 4 && column < 5)
            picturePath += "BigPicture/";
        else if (row >= 8 && row < 100 && column >= 9 && column < 100)
            picturePath += "SmallPicture/";
        else
            picturePath += "NormalPicture/";
        frame.setBounds(500, 200, 400, 200);
        JLabel rowValue = new JLabel("rows = " + row);
        rowValue.setBounds(100, 50, 150, 20);
        JLabel columnValue = new JLabel("columns = " + column);
        columnValue.setBounds(230, 50, 150, 20);
        frame.add(columnValue);
        frame.add(rowValue);
        JButton continues = new JButton("Continue");
        continues.setBounds(150, 100, 100, 30);
        continues.setBackground(Color.CYAN);
        frame.add(continues);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        continues.addActionListener(e -> {
            frame.dispose();
            new Setting(row, column);
        });
    }

}
