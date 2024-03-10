
package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;


public class PinChange  extends JFrame implements ActionListener{

    JPasswordField pin,repin;
    JButton change,back;
    String pinnumber;
    
    public PinChange(String pinnumber) {
          this.pinnumber = pinnumber;
          setLayout(null);
        
         ImageIcon i1 =  new ImageIcon(ClassLoader.getSystemResource("icons/aatm.jpg"));
         Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(0,0,900,900);
         add(image);
         
         
         JLabel text = new JLabel("CHANGE YOUR PIN");
         text.setForeground(Color.black);
         text.setFont(new Font("System",Font.BOLD,20));
         text.setBounds(200,350,700,35);
         image.add(text);
         
         JLabel pintext = new JLabel("New PIN");
         pintext.setForeground(Color.black);
         pintext.setFont(new Font("System",Font.BOLD,16));
         pintext.setBounds(150,400,180,25);
         image.add(pintext);
         
         
         pin = new JPasswordField();
         pin.setFont(new Font("Raleway",Font.BOLD,25));
         pin.setBounds(300,400,180,25);
         image.add(pin);
      
         
         JLabel repintext = new JLabel("Re-Enter New PIN");
         repintext.setForeground(Color.black);
         repintext.setFont(new Font("System",Font.BOLD,16));
         repintext.setBounds(150,430,180,25);
         image.add(repintext);
         
         repin = new JPasswordField();
         repin.setFont(new Font("Raleway",Font.BOLD,25));
         repin.setBounds(300,430,180,25);
         image.add(repin);
         
         change = new JButton("CHANGE");
         change.setBounds(355,485,150,30);
         change.addActionListener(this);
         image.add(change);
         
         back = new JButton("BACK");
         back.setBounds(355,520,150,30);
         back.addActionListener(this);
         image.add(back);
         
         
         
         setSize(900,900);
         setLocation(550,50);
         setUndecorated(true);
         setVisible(true);
        
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == change){
        try{
            
            String npin = pin.getText();
            String rpin = repin.getText();
            
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
            
            if(npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter New PIN");
                    return;
            }
            if(rpin.equals("")){
              
                    JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                    return;
            }
            
            conn c = new conn();
            String q1 = "update bank set pin = '"+rpin+"' where pin='"+pinnumber+"'";
            String q2 = "update login set pin = '"+rpin+"' where pin='"+pinnumber+"'";
            String q3 = "update signupthree set pin = '"+rpin+"' where pin='"+pinnumber+"'";
            
            c.s.executeUpdate(q1);
            c.s.executeUpdate(q2);
            c.s.executeUpdate(q3);
            JOptionPane.showMessageDialog(null, "PIN changed Successfully ");
            setVisible(false);
            new Transactions(rpin).setVisible(true);
            
        }catch(Exception e){
            System.out.println(e);
            
        }
        }else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        
    }
    
    
    
    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}