package view;

import engine.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StartScreen extends JPanel{

    private JButton playBtn;
    private JButton exitBtn;

    public StartScreen(String txt){
        //((FlowLayout)getLayout()).setAlignment(FlowLayout.LEADING);
        //setAlignmentX(JPanel.RIGHT_ALIGNMENT);
        setLayout(null);
        JLabel label = new JLabel(txt);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds((int) (GameView.W/2- (0.73 * GameView.W)/2), (int) (0.25 * GameView.H), (int) (0.73 * GameView.W),(int) (60 * GameView.H/960.0));
        label.setFont(new Font("Elephant",Font.BOLD, (int) (60 * GameView.H/960.0)));
//        label.setBorder(new LineBorder(Color.black,2));
//        label.setBackground(Color.gray);
//        label.setOpaque(true);
        label.setForeground(Color.white);

//        ImageIcon icon = new ImageIcon("src/pics/Captain America.png");
//        label.setIcon(icon);
        add(label);

        playBtn = new JButton("Play");
        playBtn.setActionCommand("NEXT");
        playBtn.setFocusable(false);
        playBtn.setSize(new Dimension((int)(0.1 * GameView.W),(int)(0.05 * GameView.W)));
        playBtn.setBounds(GameView.W/2-playBtn.getWidth()/2, (int) (0.5 * GameView.H),playBtn.getWidth(), playBtn.getHeight());

        exitBtn = new JButton("Exit");
        exitBtn.setActionCommand("EXIT");
        exitBtn.setFocusable(false);
        exitBtn.setSize(new Dimension((int)(0.1 * GameView.W),(int)(0.05 * GameView.W)));
        exitBtn.setBounds(GameView.W/2-playBtn.getWidth()/2, (int) (0.52 * GameView.H) + playBtn.getHeight(),playBtn.getWidth(), playBtn.getHeight());

        add(playBtn);
        add(exitBtn);

    }

    public JButton getPlayBtn() {
        return playBtn;
    }

    public JButton getExitBtn() {
        return exitBtn;
    }

    public void addBtnListeners(ActionListener al){
        playBtn.addActionListener(al);
        exitBtn.addActionListener(al);
    }

    Image bgImage = (new ImageIcon("src/pics/bgImage2.jpg")).getImage();
    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.drawImage(bgImage, 0, 0, null);
    }
    
}
