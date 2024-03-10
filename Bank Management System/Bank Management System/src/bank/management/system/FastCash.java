
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    
    JButton deposite,withdrawl,fastcash,  ministatement,pinchange,balance,exit;
    String pinnumber;
    
     FastCash(String pinnumber) {
        this.pinnumber=pinnumber;
         
         setLayout(null);
         
         ImageIcon i1 =  new ImageIcon(ClassLoader.getSystemResource("icons/aatm.jpg"));
         Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(0,0,900,900);
         add(image);
         
         JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
         text.setBounds(200,350,700,35);
         text.setForeground(Color.black);
         text.setFont(new Font("System",Font.BOLD,16));
         image.add(text);
         
         deposite = new JButton("RS 100");
         deposite.setBounds(150,415,150,30);
         deposite.addActionListener(this);
         image.add(deposite);
         
         withdrawl = new JButton("RS 500");
         withdrawl.setBounds(335,415,150,30);
         withdrawl.addActionListener(this);         
         image.add(withdrawl);
         
         fastcash = new JButton("RS 1000");
         fastcash.setBounds(150,450,150,30);
         fastcash.addActionListener(this);
         image.add(fastcash);
         
         ministatement= new JButton("RS 2000");
         ministatement.setBounds(335,450,150,30);
         ministatement.addActionListener(this);
         image.add(ministatement);
         
         pinchange= new JButton("RS 5000");
         pinchange.setBounds(150,485,150,30);
         pinchange.addActionListener(this);
         image.add(pinchange);
         
         balance= new JButton("RS 10000");
         balance.setBounds(335,485,150,30);
         balance.addActionListener(this);
         image.add(balance);
         
         exit= new JButton("BACK");
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
             
             setVisible(false);
             new Transactions(pinnumber).setVisible(true);

         }else {
             String amount = ((JButton)a.getSource()).getText().substring(3);
             conn c = new conn();
             
             try{
                 ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                 int balance = 0;
                 while(rs.next()){
                     if(rs.getString("type").equals("Deposite")){
                         balance +=Integer.parseInt(rs.getString("amount"));
                     }else{
                         balance -= Integer.parseInt(rs.getString("amount"));
                     }
                 }
                 
                 if(a.getSource() != exit && balance < Integer.parseInt(amount)){
                     JOptionPane.showMessageDialog(null,"Insufficient Balance");
                     return;
                 }
                 Date date = new Date();
                 String query = "insert into bank values('"+pinnumber+"','"+date+"','withdrawl','"+amount+"')";
                 c.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null, "Rs "+ amount + " Debited Sucessfully");
                 
                 setVisible(false);
                 new Transactions(pinnumber).setVisible(true);
                 
             }catch(Exception e){
                 System.out.println(e);
             }
         }
         }
     
     
     
      public static void main(String[] args) {
        
        new FastCash("");
        
    }
     
     
         
     }