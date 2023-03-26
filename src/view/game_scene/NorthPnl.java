package view.game_scene;

import engine.Game;
import engine.Player;
import model.effects.Effect;
import model.world.AntiHero;
import model.world.Champion;
import model.world.Hero;
import view.GameView;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.*;
import java.io.*;

public class NorthPnl extends JPanel {

    Dimension btnDim;

    JPanel p1Pnl;
    JPanel p2Pnl;
    JLabel p1Name;
    JLabel p2Name;
    JPanel p1BtnPnl;
    JPanel p2BtnPnl;
    ImageIcon dataIcon;

    ArrayList<JButton> p1Champs = new ArrayList<>();
    ArrayList<JButton> p2Champs = new ArrayList<>();

    JButton l1Btn = new JButton();
    JButton l2Btn = new JButton();

    //Constructors

    public NorthPnl(){
        setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        setPreferredSize(new Dimension(0, (int) (0.14* GameView.H)));
        setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        setBackground(new Color(0x14,0x13,0x1c,150));

        bg  = new ImageIcon((new ImageIcon("src/pics/North Pnl.png")).getImage().getScaledInstance(GameView.W,getPreferredSize().height,Image.SCALE_SMOOTH));
        btnDim = new Dimension((int)(0.45 * getPreferredSize().height),(int)(0.45 * getPreferredSize().height));
        dataIcon = new ImageIcon((new ImageIcon("src/pics/data.png").getImage().getScaledInstance(300,getPreferredSize().height,Image.SCALE_SMOOTH)));

        //Player 1
        p1Pnl = new JPanel();
        p1Pnl.setOpaque(false);
        p1Pnl.setLayout(new BoxLayout(p1Pnl,BoxLayout.X_AXIS));
        p1Pnl.setAlignmentX(RIGHT_ALIGNMENT);
        p1Pnl.setPreferredSize(new Dimension((int) (GameView.W/2.2),getPreferredSize().height));


        p1Name = new JLabel("Shady");
        p1Name.setFont(GameView.gameFont.deriveFont(65f));

        p1Name.setForeground(Color.white);
        p1Name.setAlignmentY(CENTER_ALIGNMENT);
        p1Name.setVerticalTextPosition(SwingConstants.CENTER);
        p1Name.setHorizontalAlignment(SwingConstants.CENTER);
        p1Name.setVerticalAlignment(SwingConstants.CENTER);

        p1BtnPnl = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        p1BtnPnl.setMaximumSize(new Dimension(2000, (int) (btnDim.height*1.2)));
        p1BtnPnl.setAlignmentY(CENTER_ALIGNMENT);
        p1BtnPnl.setOpaque(false);

        JPanel p1Main = new JPanel();
        p1Main.setLayout(new BoxLayout(p1Main,BoxLayout.X_AXIS));
        p1Main.setPreferredSize(new Dimension(getPreferredSize().width,getPreferredSize().height));
        p1Main.setOpaque(false);
        p1Main.setBorder(new LineBorder(Color.red));
        p1Main.add(new JLabel(dataIcon));
        p1Main.add(Box.createHorizontalGlue());
        p1Main.add(p1Pnl);

        p1Pnl.add(p1BtnPnl);
        p1Pnl.add(Box.createRigidArea(new Dimension(30,0)));
        p1Pnl.add(p1Name);
        p1Pnl.add(Box.createRigidArea(new Dimension(25,0)));


        //Player 2
        {
            p2Pnl = new JPanel();

            p2Pnl.setLayout(new BoxLayout(p2Pnl, BoxLayout.X_AXIS));
            p2Pnl.setOpaque(false);
            p2Pnl.setAlignmentX(LEFT_ALIGNMENT);
            p2Pnl.setPreferredSize(new Dimension((int) (GameView.W/2.2),getPreferredSize().height));

            p2Name = new JLabel("Mazen");
            p2Name.setVisible(true);

            p2Name.setFont(GameView.gameFont.deriveFont(65f));
            p2Name.setAlignmentX(LEFT_ALIGNMENT);
            p2Name.setForeground(Color.white);
            p2Name.setHorizontalAlignment(SwingConstants.CENTER);
            p2Name.setVerticalAlignment(SwingConstants.CENTER);

            p2BtnPnl = new JPanel(new FlowLayout(FlowLayout.LEADING));
            p2BtnPnl.setAlignmentX(LEFT_ALIGNMENT);
            p2BtnPnl.setOpaque(false);
            p2BtnPnl.setMaximumSize(new Dimension(2000, (int) (btnDim.height*1.2)));

            p2Pnl.add(Box.createRigidArea(new Dimension(25,0)));
            p2Pnl.add(p2Name);
            p2Pnl.add(Box.createRigidArea(new Dimension(30,0)));
            p2Pnl.add(p2BtnPnl);
        }

        JLabel vs = new JLabel("Vs");
        vs.setForeground(Color.white);
        vs.setFont(GameView.gameFont2.deriveFont(80f));

        add(p1Pnl);
        add(Box.createHorizontalGlue());
        add(vs);
        add(Box.createHorizontalGlue());
        add(p2Pnl);


//        ImageIcon icon = new ImageIcon("src/pics/leader.png");
//        Image image = icon.getImage().getScaledInstance((int)(btnDim.width*0.75),(int)(btnDim.height*0.75),java.awt.Image.SCALE_SMOOTH);
//        icon = new ImageIcon(image);
//
//        l1Btn = new JButton();
//        l1Btn.setName("First Player Leader Ability");
//        l1Btn.setPreferredSize(new Dimension((int)(btnDim.width*0.75),(int)(btnDim.height*0.75)));
//        l1Btn.setContentAreaFilled(false);
//        l1Btn.setBorder(null);
//        l1Btn.setIcon(icon);
//        l1Btn.setToolTipText("First Player Leader Ability");
//
//        p1BtnPnl.add(l1Btn);
//
//        l2Btn = new JButton();
//        l2Btn.setName("Second Player Leader Ability");
//        l2Btn.setPreferredSize(new Dimension((int)(btnDim.width*0.75),(int)(btnDim.height*0.75)));
//        l2Btn.setContentAreaFilled(false);
//        l2Btn.setIcon(icon);
//        l2Btn.setToolTipText("Second Player Leader Ability");
//
//        p2BtnPnl.add(l2Btn);

    }

    ImageIcon bg;


    public void setNorthChampBtns(Game game, ArrayList<Champion> t1, ArrayList<Champion> t2){

        ImageIcon icon = new ImageIcon("src/pics/leader.png");
        Image image = icon.getImage().getScaledInstance((int)(btnDim.width*0.75),(int)(btnDim.height*0.75),java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);

        l2Btn.setName("Second Player Leader Ability");
        l2Btn.setPreferredSize(new Dimension((int)(btnDim.width*0.75),(int)(btnDim.height*0.75)));
        l2Btn.setContentAreaFilled(false);
        l2Btn.setIcon(icon);
        l2Btn.setToolTipText("Second Player Leader Ability");
        l2Btn.setBorder(null);

        p2BtnPnl.add(l2Btn);

        for(Champion c : t1){
            JButton btn = new JButton();
            btn.setName(c.getName());
            btn.setPreferredSize(btnDim);
            btn.setIcon(new ImageIcon("src/pics/icons/"+c.getName()+".jpg"));
            btn.setToolTipText(getOtherChampInfo(game,c));
            p1Champs.add(btn);
            p1BtnPnl.add(btn);
        }
        for(Champion c : t2){
            JButton btn = new JButton();
            btn.setName(c.getName());
            btn.setPreferredSize(btnDim);
            btn.setIcon(new ImageIcon("src/pics/icons/"+c.getName()+".jpg"));
            btn.setToolTipText(getOtherChampInfo(game,c));
            p2Champs.add(btn);
            p2BtnPnl.add(btn);
        }

        l1Btn.setName("First Player Leader Ability");
        l1Btn.setPreferredSize(new Dimension((int)(btnDim.width*0.75),(int)(btnDim.height*0.75)));
        l1Btn.setContentAreaFilled(false);
        l1Btn.setBorder(null);
        l1Btn.setIcon(icon);
        l1Btn.setToolTipText("First Player Leader Ability");

        p1BtnPnl.add(l1Btn);



    }

    public void refreshNorthPnl(Game game){
        //Update champion info
        for(JButton btn : p1Champs){
            Champion c = null;
            for(Champion x : game.getFirstPlayer().getTeam())
                if(x.getName().equals(btn.getName())) {
                    c = x;
                    break;
                }
            if(c != null)
                btn.setToolTipText(getOtherChampInfo(game,c));
            else
                btn.setEnabled(false);
        }
        for(JButton btn : p2Champs){
            Champion c = null;
            for(Champion x : game.getSecondPlayer().getTeam())
                if(x.getName().equals(btn.getName())) {
                    c = x;
                    break;
                }
            if(c != null)
                btn.setToolTipText(getOtherChampInfo(game,c));
            else
                btn.setEnabled(false);
        }
    }

    public String getOtherChampInfo(Game game, Champion c){
        String s = c.getName()
                + "\n" + c.getCurrentHP()+"/"+c.getMaxHP()+" HP"
                + "\nType: " + ((c instanceof Hero)?"Hero":(c instanceof AntiHero)?"AntiHero":"Villain")
                + "\nIs Leader: " + ((c==game.getFirstPlayer().getLeader() || c==game.getSecondPlayer().getLeader())?"Yes":"No");
        String effStr = "\nApplied Effects: ";
        for(Effect e : c.getAppliedEffects()){
            effStr += "\n" + e.getName() + "   ,   Duration: "+e.getDuration();
        }
        s += effStr;

        Player first_player = game.getFirstPlayer();
        Champion champ1 = first_player.getLeader();
        boolean f1 = !(game.isFirstLeaderAbilityUsed());
        if(f1){
//            l1Btn.setBorder(BorderFactory.createLineBorder(Color.orange));
            String str = "<html><center>" +
                    "Name: <font color=orange>" + champ1.getName();
            l1Btn.setToolTipText(str);
        }
        else{
            l1Btn.setVisible(false);
            l1Btn.setEnabled(false);
        }

        Player second_player = game.getSecondPlayer();
        Champion champ2 = second_player.getLeader();
        boolean f2 = !(game.isSecondLeaderAbilityUsed());
        if(f2){
//            l2Btn.setBorder(BorderFactory.createLineBorder(Color.orange));
            String str = "<html><center>"
                    + "Name: <font color=red>" + champ2.getName();
            l2Btn.setToolTipText(str);
        }
        else{
            l2Btn.setVisible(false);
            l2Btn.setEnabled(false);
        }


        return GameView.convertToMultiline(s);
    }


}
