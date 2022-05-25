package Game.Graphic;

import javax.swing.*;
import java.awt.*;
// here is main menu of the game
public class Menu {

    public Menu() {
        JFrame menuFrame = new JFrame("Menu");
        menuFrame.setContentPane(new JLabel(new ImageIcon("src\\Game\\Graphic\\Picture\\background.jpg")));
        menuFrame.setBounds(450, 100, 500, 550);
        menuFrame.setResizable(false);
        menuFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton newGame = new JButton("New Game");
        newGame.setBounds(190, 200, 120, 40);
        newGame.setBackground(Color.gray);
        newGame.setForeground(Color.WHITE);
        menuFrame.add(newGame);

        JButton exit = new JButton("Exit");
        exit.setBounds(190, 270, 120, 40);
        exit.setBackground(Color.gray);
        exit.setForeground(Color.WHITE);
        menuFrame.add(exit);

        menuFrame.setVisible(true);

        exit.addActionListener(e -> System.exit(0));

        newGame.addActionListener(e -> {
            menuFrame.dispose();
            new CreatTable();
        });
    }

}
