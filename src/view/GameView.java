package view;

import view.game_scene.GameScene;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GameView extends JFrame {
    public final static int W = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    public final static int H = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    public static Font gameFont = new Font("Elephant",10,10);
    public static Font gameFont2 = new Font("Elephant",10,10);
    public static Font gameFontBold = new Font("Elephant",10,10);

    private JLayeredPane layers;
    private JPanel drawPnl;
    private JPanel cards = new JPanel();
    private CardLayout cardL;
    private StartScreen ss;
    private PlayerNames pn;
    private Display cs;
    private GameScene gs;

    public GameView(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Marvel: Ultimate War");
        setBounds(0,0,W,H);
        setMinimumSize(new Dimension(1280,720));
//        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setIconImage((new ImageIcon("src/pics/marvel.png")).getImage());
//        setUndecorated(true);

        System.out.println(getWidth() + "x" + getHeight());

        //Font
        try {
            //create the font to use. Specify the size!
            gameFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/HeroesAssemble3DRegular-gz3p.otf")).deriveFont(40f);
            gameFont2 = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/HeroesAssembleRegular-Kmvl.otf")).deriveFont(40f);
            gameFontBold = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/HeroesAssembleBold-ez3n.otf")).deriveFont(40f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //register the font
            ge.registerFont(gameFont);
            ge.registerFont(gameFont2);
            ge.registerFont(gameFontBold);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        layers = new JLayeredPane();
        layers.setBounds(0,0,W,H);
        drawPnl = new JPanel(null);
        drawPnl.setBounds(0,0,getWidth(),getHeight());
//        drawPnl.setBackground(new Color(70,150,200,50));
        drawPnl.setOpaque(false);

        cardL = new CardLayout();
        cards.setLayout(cardL);
        cards.setBounds(0,0,getWidth(),getHeight());
//        layers.setLayout(new BorderLayout());
        layers.add(drawPnl,BorderLayout.PAGE_START);
        layers.add(cards,BorderLayout.CENTER);

//        add(cards);
        add(layers);

        System.out.println("Frame insets: "+ getInsets());


        ss = new StartScreen("Marvel: Ultimate War");

        pn = new PlayerNames();
//
//        cs = new ChampSelect();

        cs = new Display();
//
        gs = new GameScene();

        cards.add(ss);
        cards.add(pn);
        cards.add(cs);
        cards.add(gs);

        setVisible(true);

        cards.setBounds(0,0,getWidth()-getInsets().left-getInsets().right,getHeight()-getInsets().bottom-getInsets().top);

    }

    public static String convertToMultiline(String orig) {
        return "<html>" + orig.replaceAll("\n", "<br>");
    }

    public JPanel getCards() {
        return cards;
    }

    public CardLayout getCardL() {
        return cardL;
    }

    public StartScreen getSs() {
        return ss;
    }

    public PlayerNames getPn() {
        return pn;
    }

    public Display getCs() {
        return cs;
    }

    public GameScene getGs() {
        return gs;
    }

    public void setPn(PlayerNames pn) {
        this.pn = pn;
    }

    public void setCs(Display cs) {
        this.cs = cs;
    }

    public void setGs(GameScene gs) {
        this.gs = gs;
    }

    public JPanel getDrawPnl() {
        return drawPnl;
    }

    public JRootPane getViewRootPane(){
        return getRootPane();
    }
}
