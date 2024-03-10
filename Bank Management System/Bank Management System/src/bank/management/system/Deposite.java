
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposite extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton deposite,back;
    String pinnumber;
    public Deposite(String pinnumber) {
        
        
        this.pinnumber=pinnumber;
        setLayout(null);
        
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/aatm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        
        
        JLabel text = new JLabel("Enter the amount you want to Deposite");
        text.setForeground(Color.black);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(160,330,400,20);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,16));
        amount.setBounds(150,370,320,25);
        image.add(amount);
        
        
        deposite = new JButton("Deposite");
        deposite.setBounds(355,485,150,30);
        deposite.addActionListener(this);
        image.add(deposite);
        
        
        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
         
        setSize(900,900);
         setLocation(550,50);
        setVisible(true);
                
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == deposite){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposite");
            }else {
                
                try{
                conn c = new conn();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Deposite','"+number+"') ";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+number+" Deposited Successfully");
                setVisible(true);
                new Transactions(pinnumber).setVisible(true);
                
                }catch (Exception ae){
                    System.out.println(ae);
                }
                
            }
        }else if(e.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    
    }

    
    
    public static void main(String[] args) {
        
        new Deposite("");
    }
}