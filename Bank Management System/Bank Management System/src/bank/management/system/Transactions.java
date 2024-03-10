
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    
    JButton deposite,withdrawl,fastcash,  ministatement,pinchange,balance,exit;
    String pinnumber;
    
     Transactions(String pinnumber) {
        this.pinnumber=pinnumber;
         
         setLayout(null);
         
         ImageIcon i1 =  new ImageIcon(ClassLoader.getSystemResource("icons/aatm.jpg"));
         Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(0,0,900,900);
         add(image);
         
         JLabel text = new JLabel("Please select your Transaction");
         text.setBounds(200,350,700,35);
         text.setForeground(Color.black);
         text.setFont(new Font("System",Font.BOLD,16));
         image.add(text);
         
         deposite = new JButton("Deposite");
         deposite.setBounds(150,415,150,30);
         deposite.addActionListener(this);
         image.add(deposite);
         
         withdrawl = new JButton("Cash Withdrawl");
         withdrawl.setBounds(335,415,150,30);
         withdrawl.addActionListener(this);         
         image.add(withdrawl);
         
         fastcash = new JButton("Fast Cash");
         fastcash.setBounds(150,450,150,30);
         fastcash.addActionListener(this);
         image.add(fastcash);
         
         ministatement= new JButton("Mini Statement");
         ministatement.setBounds(335,450,150,30);
         ministatement.addActionListener(this);
         image.add(ministatement);
         
         pinchange= new JButton("PIN Change");
         pinchange.setBounds(150,485,150,30);
         pinchange.addActionListener(this);
         image.add(pinchange);
         
         balance= new JButton("Balance Enquiry");
         balance.setBounds(335,485,150,30);
         balance.addActionListener(this);
         image.add(balance);
         
         exit= new JButton("Exit");
         exit.setBounds(250,520,150,30);
         exit.addActionListener(this);
         image.add(exit);
         
         setSize(900,900);
         setLocation(550,50);
         setUndecorated(true);
         setVisible(true);
         
        
    }
     
     @Override
     public void actionPerformed(ActionEvent a){
         
         if(a.getSource() == exit){
         System.exit(0);
         }else if(a.getSource() == deposite){
             setVisible(false);
             new Deposite(pinnumber).setVisible(true);
         }else if(a.getSource() == withdrawl){
             setVisible(false);
             new Withdrawl(pinnumber).setVisible(true);
         }else if(a.getSource() == fastcash){
             setVisible(false);
             new FastCash(pinnumber).setVisible(true);
         }else if(a.getSource() == pinchange){
              setVisible(false);
              new PinChange(pinnumber).setVisible(true);
         }else if(a.getSource() ==  balance){
             setVisible(false);
             new BalanceEnquiry(pinnumber).setVisible(true);
         }else if(a.getSource() == ministatement){
//             setVisible(false);
             new MiniStatement(pinnumber).setVisible(true);
         }
         
     }
    
    public static void main(String[] args) {
        
        new Transactions("");
        
    }
    
    
}