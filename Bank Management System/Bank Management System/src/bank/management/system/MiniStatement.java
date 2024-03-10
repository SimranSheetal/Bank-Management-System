package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class MiniStatement extends JFrame implements ActionListener{
    
    JButton exit;
    String pinnumber;
    
    public MiniStatement(String pinnumber) {
        
        this.pinnumber = pinnumber;
        
        setTitle("Mini Statement");
        setLayout(null);
        
        JLabel mini = new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);
        
        JLabel bank = new JLabel("SBI");
        bank.setBounds(150,20,100,20);
        bank.setFont(new Font("System",Font.BOLD,24));
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
       
        JLabel balance = new JLabel();
        balance.setBounds(20,400,320,20);
        add(balance);
        
        try {
            conn c = new conn();
            ResultSet rs =c.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number: "+rs.getString("cardnumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardnumber").substring(12));
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        try {
            
            conn c = new conn();
            int bal = 0;
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while (rs.next()){
                mini.setText(mini.getText() + "<html>"+rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br></html>");
                 if(rs.getString("type").equals("Deposite")){
                         bal +=Integer.parseInt(rs.getString("amount"));
                     }else{
                         bal -= Integer.parseInt(rs.getString("amount"));
                     }
                
            }
            
            balance.setText("Your current amount balance is Rs "+bal);
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
        exit = new JButton("Exit");
        exit.addActionListener(this);
        exit.setBounds(20, 500, 100, 25);
        add(exit);
        
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
        
    }
     public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }
    
    
    public static void main(String[] args) {
        
        new MiniStatement("");
    }
}