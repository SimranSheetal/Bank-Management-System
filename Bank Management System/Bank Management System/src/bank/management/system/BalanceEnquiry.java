
package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class BalanceEnquiry extends JFrame implements ActionListener {
    
    
    JButton back;
    String pinnumber;

    public BalanceEnquiry(String pinnumber) {
        
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 =  new ImageIcon(ClassLoader.getSystemResource("icons/aatm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
         
        
        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
          conn c = new conn();
          int balance = 0;   
             try{
                 ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                 
                 while(rs.next()){
                     if(rs.getString("type").equals("Deposite")){
                         balance +=Integer.parseInt(rs.getString("amount"));
                     }else{
                         balance -= Integer.parseInt(rs.getString("amount"));
                     }
                 }
                }catch(Exception e){
                         
                         System.out.println(e);
                   }
           
        JLabel text = new JLabel("Your current Acoount balance is Rs "+balance);
        text.setForeground(Color.black);
        text.setFont(new Font("System",Font.BOLD,20));
        text.setBounds(120,340,400,30);
        image.add(text);
        
        setSize(900,900);
        setLocation(550,50);
        setUndecorated(true);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
    
    
    
    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}