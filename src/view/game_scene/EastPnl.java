package view.game_scene;

import model.abilities.Ability;
import model.abilities.CrowdControlAbility;
import model.abilities.DamagingAbility;
import model.abilities.HealingAbility;
import model.effects.Effect;
import model.effects.EffectType;
import model.world.AntiHero;
import model.world.Champion;
import model.world.Hero;
import view.GameView;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class EastPnl extends JPanel{

    private JPanel main;
    static final int W = (int) (0.2*Toolkit.getDefaultToolkit().getScreenSize().getWidth());
    static final int H = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight());

    JLabel image = new JLabel();
    JLabel name = new JLabel();
    JLabel currentHp = new JLabel();
    JLabel mana = new JLabel();
    JLabel speed = new JLabel();
    JLabel maxActions = new JLabel();
    JLabel attackDmg = new JLabel();
    JLabel attackRange = new JLabel();
    JLabel type = new JLabel();
    JLabel leader = new JLabel();

    JLabel label;
    JPanel abilityBtns;
    JPanel appliedEff;

    JButton ability1 = new JButton();
    JButton ability2 = new JButton();
    JButton ability3 = new JButton();

    private Dimension btnDim;

    private MouseListener listener;

    public EastPnl(){


        setLayout(new BorderLayout());
        setOpaque(false);
        setPreferredSize(new Dimension(400,0));
        setBorder(new LineBorder(Color.DARK_GRAY,2));
        setOpaque(false);

        ImageIcon background =  new ImageIcon("src/pics/I1.png");
        background.getImage().getScaledInstance(400,768,Image.SCALE_SMOOTH);

        main = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background.getImage(), 0, 0, null);
            }
        };

        main.setLayout(null);
        main.setBounds(0,0, 350 ,768);
        main.setOpaque(false);

        add(main,BorderLayout.CENTER);

        {
            name.setText("Name : ");
            name.setFont(new Font("FiraCode", Font.BOLD, 20));
            name.setForeground(Color.WHITE);
            name.setBounds(50, 70, 170, 30);

            currentHp.setText("Current HP : ");
            currentHp.setFont(new Font("FiraCode", Font.BOLD, 20));
            currentHp.setForeground(Color.WHITE);
            currentHp.setBounds(50, 100, 170, 30);

            mana.setText("Mana : ");
            mana.setFont(new Font("FiraCode", Font.BOLD, 20));
            mana.setForeground(Color.WHITE);
            mana.setBounds(50, 130, 170, 30);

            speed.setText("Speed : ");
            speed.setFont(new Font("FiraCode", Font.BOLD, 20));
            speed.setForeground(Color.WHITE);
            speed.setBounds(50, 160, 170, 30);

            maxActions.setText("Max Action Points : ");
            maxActions.setFont(new Font("FiraCode", Font.BOLD, 20));
            maxActions.setForeground(Color.WHITE);
            maxActions.setBounds(50, 190, 200, 30);

            attackDmg.setText("Attack Damage : ");
            attackDmg.setFont(new Font("FiraCode", Font.BOLD, 20));
            attackDmg.setForeground(Color.WHITE);
            attackDmg.setBounds(50, 220, 170, 30);

            attackRange.setText("Attack Range : ");
            attackRange.setFont(new Font("FiraCode", Font.BOLD, 20));
            attackRange.setForeground(Color.WHITE);
            attackRange.setBounds(50, 250, 170, 30);

            type.setText("Type : ");
            type.setFont(new Font("FiraCode", Font.BOLD, 20));
            type.setForeground(Color.WHITE);
            type.setBounds(50, 280, 170, 30);

            leader.setText("Leader Ability used : ");
            leader.setFont(new Font("FiraCode", Font.BOLD, 20));
            leader.setForeground(Color.WHITE);
            leader.setBounds(50, 310, 200, 30);

            btnDim = new Dimension((int) (0.15 * getPreferredSize().width), (int) (0.15 * getPreferredSize().width));

            ability1.setPreferredSize(btnDim);
            ability1.setMaximumSize(btnDim);
            ability1.setBorder(new LineBorder(Color.YELLOW, 3));
            ability1.setBounds(50, 400, (int) btnDim.getWidth(), (int) btnDim.getHeight());
            ability1.setToolTipText("TEST");

            ability2.setPreferredSize(btnDim);
            ability2.setMaximumSize(btnDim);
            ability2.setBorder(new LineBorder(Color.YELLOW, 3));
            ability2.setBounds(150, 400, (int) btnDim.getWidth(), (int) btnDim.getHeight());

            ability3.setPreferredSize(btnDim);
            ability3.setMaximumSize(btnDim);
            ability3.setBorder(new LineBorder(Color.YELLOW, 3));
            ability3.setBounds(250, 400, (int) btnDim.getWidth(), (int) btnDim.getHeight());
        }

        label = new JLabel();
        label.setFont(GameView.gameFont2.deriveFont(30f));
        label.setForeground(Color.white);
        label.setVerticalAlignment(SwingConstants.TOP);
        label.setBounds(20,20,getPreferredSize().width,700);

         abilityBtns = new JPanel();
         abilityBtns.setLayout(new FlowLayout(FlowLayout.CENTER,20,0));
         abilityBtns.setBounds(0,380,getPreferredSize().width,100);
         abilityBtns.setOpaque(false);

         appliedEff = new JPanel();
         appliedEff.setLayout(new FlowLayout(FlowLayout.CENTER,20,0));
         appliedEff.setBounds(100,270,getPreferredSize().width,100);
         appliedEff.setOpaque(false);


        main.add(label);
        main.add(abilityBtns);
        main.add(appliedEff);
    }

    public void updateEastPnl(Champion c){
        String type = (c instanceof Hero)?"Hero":(c instanceof AntiHero)?"AntiHero":"Villain";
        label.setText("<html><head>" +
                "<style>" +
                "p {" +
                "  line-height: 1.4;" +
                "}" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<p>" +
                "Name: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "+champNameColored(c.getName())+" <br/>" +
                "Type : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "+type+"<br/>" +
                "Action Points : &nbsp; "+c.getCurrentActionPoints()+"<br/>" +
                "Mana : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "+c.getMana()+"<br/>" +
                "Attack Damage : "+c.getAttackDamage()+"<br/>" +
                "Attack Range : &nbsp; "+c.getAttackRange()+"<br/>" +
                "Applied Effects : <br/><br/>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Abilities<br/>" +
                "</p></body>"
        );
        //Update Abilities
        abilityBtns.removeAll();
        for(Ability a : c.getAbilities()) {
            JButton btn = new JButton();
            String path = "src/pics/icons/abilities/";
            if (a.getName().equals("Punch"))
                path += "Punch.png";
            else
                path += c.getName() + "/" + a.getName() + ".png";
            btn.setIcon(new ImageIcon(path));
            btn.setContentAreaFilled(false);
            btn.setHorizontalTextPosition(SwingConstants.CENTER);
            btn.setVerticalTextPosition(SwingConstants.BOTTOM);
            btn.setFont(GameView.gameFont2.deriveFont(20f));
            btn.setForeground(Color.WHITE);
            btn.setBorder(new LineBorder(Color.orange,2));
            String col;
            if(a instanceof DamagingAbility)
                col = "red";
            else if(a instanceof HealingAbility)
                col = "green";
            else
                col = "orange";
            String str = "<html><center>"
                    + "Name: <font color=yellow>" + a.getName()
                    + "</font> <br/> Type: <font color="+col+">" + a.getClass().getSimpleName()
                    + "</font> <br/> AOE: <font color=yellow>" + a.getCastArea()
                    + "</font><br/>                     Range: <font color=yellow>" + a.getCastRange()
                    + "</font><br/>  Mana Cost: <font color=yellow>" + a.getManaCost() + "&nbsp;&nbsp;&nbsp;&nbsp;"
                    + "</font>AP Cost: <font color=yellow>" + a.getRequiredActionPoints()
                    + "</font><br/>  Cooldown: " + a.getCurrentCooldown() + "/" + a.getBaseCooldown() +"<br/>"+
                    ((a instanceof HealingAbility)?"Heal Amount: <font color=green>"+((HealingAbility)a).getHealAmount():
                            (a instanceof DamagingAbility)?"Damage Amount: <font color=red>"+((DamagingAbility)a).getDamageAmount():
                                    (a instanceof CrowdControlAbility)?"<font color=orange>"+((CrowdControlAbility) a).getEffect():"");
            btn.setToolTipText(str);
            abilityBtns.add(btn);
        }
        //Update Applied Effects
        appliedEff.removeAll();
        for(Effect eff : c.getAppliedEffects()){
            JButton btn = new JButton();
            btn.setPreferredSize(new Dimension(40,40));
            String path = "src/pics/icons/effects/";
            path += eff.getName() + ".png";
            ImageIcon icon = new ImageIcon(path);
            Image img = icon.getImage() ;
            Image newimg = img.getScaledInstance( 40, 40,  java.awt.Image.SCALE_SMOOTH ) ;
            icon = new ImageIcon( newimg );
            btn.setIcon(icon);

            btn.setContentAreaFilled(false);
            btn.setHorizontalTextPosition(SwingConstants.CENTER);
            btn.setVerticalTextPosition(SwingConstants.BOTTOM);
            btn.setFont(GameView.gameFont2.deriveFont(20f));
            btn.setForeground(Color.WHITE);
            btn.setBorder(new LineBorder(Color.orange,2));
            String col;
            if(eff.getType() .equals(EffectType.BUFF))
                col = "green";
            else
                col = "red";
            String str = "<html><center>"
                    + "Name: <font color=yellow>" + eff.getName()
                    + "</font> <br/> Type: <font color="+col+">" + eff.getType()
                    + "</font><br/>                     Duration: <font color=yellow>" + eff.getDuration();

            btn.setToolTipText(str);
            appliedEff.add(btn);
        }
    }

    public String champNameColored(String name){
        String str = "";
        switch (name){
            case "Captain America" -> str = "<font color=blue>Captain</font><font color=red> America</font>";
            case "Deadpool" -> str = "<font color=#5e0d0d>Deadpool</font>";

            case "Dr Strange" -> str = "<font color=#5e0d0d>Dr Strange</font>";
            case "Electro" -> str = "<font color=#5e0d0d>Electro</font>";

            case "Ghost Rider" -> str = "<font color=#ffb300>Ghost</font><font color=#ff6a00> Rider</font>";

            case "Hela" -> str = "<font color=#185713>Hela</font>";

            case "Hulk" -> str = "<font color=#185713>Hulk</font>";

            case "Iceman" -> str = "<font color=blue>Iron</font><font color=#ffb300>man</font>";

            case "Ironman" -> str = "<font color=#f52a0f>Iron</font><font color=#ffb300>man</font>";

            case "Loki" -> str = "<font color=yellow>Loki</font>";
            case "Quicksilver" -> str = "<font color=grey>Quicksilver</font>";

            case "Spiderman" -> str = "<font color=red>Spider</font><font color=blue>man</font>";
            case "Thor" -> str = "<font color=orange>Thor</font>";
            case "Venom" -> str = "<font color=grey>Venom</font>";
            case "Yellow Jacket" -> str = "<font color=white>Yellow Jacket</font>";
        }
        return str;
    }




}
