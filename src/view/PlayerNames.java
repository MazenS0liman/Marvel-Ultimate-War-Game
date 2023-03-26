package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class PlayerNames extends JPanel implements ActionListener{
    private JButton confirmBtn = new JButton("Done");
    private JLabel label1 = new JLabel();
    private JLabel label2 = new JLabel();
    private JTextField txtField1 = new JTextField("Player 1");
    private JTextField txtField2 = new JTextField("Player 2");

    private PlayerNamesListener listener;

    public PlayerNames(){
        setLayout(null);

        txtField1.setBounds(640,200,200,50);
        txtField2.setBounds(640,280,200,50);

        label1.setText("First Player Name  ");
        label1.setFont(new Font("Serif", Font.BOLD, 20));
        label1.setBounds(440,200,200,50);

        label2.setText("Second Player Name  ");
        label2.setFont(new Font("Serif", Font.BOLD, 20));
        label2.setBounds(440,280,200,50);

        confirmBtn.setSize(100,50);
        confirmBtn.setBounds(640- confirmBtn.getWidth()/2,400, confirmBtn.getWidth(), confirmBtn.getHeight());
        confirmBtn.setActionCommand("NEXT");
        confirmBtn.addActionListener(this);
        confirmBtn.setFocusable(false);

        add(txtField1);
        add(txtField2);
        add(label1);
        add(label2);
        add(confirmBtn);

    }

    public void addBtnListener(ActionListener al){
        confirmBtn.addActionListener(al);
    }

    public JButton getConfirmBtn() {
        return confirmBtn;
    }

    public String getP1Name() {
        return txtField1.getText();
    }

    public String getP2Name() {
        return txtField2.getText();
    }

    public void setPNsListener(PlayerNamesListener l){
        listener = l;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(listener != null){
            try {
                listener.onPlayerNamesConfirmed(txtField1.getText(),txtField2.getText());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
