package view.game_scene;

import view.GameView;

import javax.swing.*;
import java.awt.*;

public class WinPnl extends JPanel {

    JLabel winner;
    public WinPnl(){

        setPreferredSize(new Dimension(500,500));
        setBackground(Color.BLACK);


        winner = new JLabel();
        winner = new JLabel(" Winner is " + "Shady");
        winner.setPreferredSize(new Dimension(500,500));
        winner.setFont(GameView.gameFont.deriveFont(30f));
        winner.setAlignmentX(JLabel.CENTER);
        winner.setAlignmentY(CENTER_ALIGNMENT);
        winner.setForeground(Color.white);
        winner.setVerticalTextPosition(SwingConstants.CENTER);
        winner.setHorizontalAlignment(SwingConstants.CENTER);
        winner.setVerticalAlignment(SwingConstants.CENTER);

        ImageIcon ii = new ImageIcon(
                "src/vfx/fire.gif");
        winner.setIcon(ii);
        add(winner);
        // show it
        this.setVisible(true);

        add(winner);
    }


    public static void main(String[]args){

        JFrame frame = new JFrame();
        frame.setSize(1000,800);
        frame.setBounds(350,100,500,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(new WinPnl());

        frame.revalidate();
        frame.repaint();
    }
}
