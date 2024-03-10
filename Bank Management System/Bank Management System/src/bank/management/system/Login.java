
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.sql.*;




public class Login extends JFrame implements ActionListener {
        JButton login,signup,clear;
        JTextField cardTextField;
        JPasswordField pinTextField;
    
        Login(){
            
           
           
           ImageIcon icon1=new ImageIcon(ClassLoader.getSystemResource("icons/logo1.jpg"));
           Image i2=icon1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
           ImageIcon i3=new ImageIcon(i2);
           
           JLabel label=new JLabel();
           label.setIcon(i3);
           label.setBounds(90, 10, 100, 100);
           add(label);
           
           JLabel text = new JLabel("Welcome to ATM");
           text.setForeground(Color.black);
           text.setBounds(220,40,450,40);
           text.setFont(new Font("Osward",Font.BOLD,38));
           add(text);
            
           JLabel cardno = new JLabel("Card Number:");
           cardno.setForeground(Color.black);
           cardno.setBounds(125,150,375,30);
           cardno.setFont(new Font("Raleway",Font.BOLD,28));
           add(cardno);
           
           cardTextField=new JTextField();
           cardTextField.setBounds(320,150,230,30);
           cardTextField.setFont(new Font("Arial",Font.BOLD,16));
           add(cardTextField);
           
           JLabel pin = new JLabel("Enter PIN:");
           pin.setForeground(Color.black);
           pin.setBounds(125,220,375,30);
           pin.setFont(new Font("Raleway",Font.BOLD,28));
           add(pin);
           
           pinTextField=new JPasswordField();
           pinTextField.setBounds(320,220,230,30);
           pinTextField.setFont(new Font("Arial",Font.BOLD,16));
           add(pinTextField);
           
           login = new JButton("SIGN IN");
           login.setBounds(320, 300, 100, 30);
           login.setBackground(Color.black);
           login.setForeground(Color.white);
           login.addActionListener(this);
           add(login);
         
           
           clear = new JButton("CLEAR");
           clear.setBounds(450, 300, 100, 30);
           clear.setBackground(Color.black);
           clear.setForeground(Color.white);
           clear.addActionListener(this);
           add(clear);
           
           signup = new JButton("SIGN UP");
           signup.setBounds(320, 350, 230, 30);
           signup.setBackground(Color.black);
           signup.setForeground(Color.white);
           signup.addActionListener(this);
           add(signup);
         
    
       
         
           
           setLayout(null);
           setTitle("AUTOMATED TELLER MACHINE");
           setSize(800,480);
           setLocation(550,220);
           setVisible(true);
           getContentPane().setBackground(Color.WHITE);
           
           
          
        }
        
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == clear){
                cardTextField.setText("");
                pinTextField.setText("");
            }else if(e.getSource() == login){
                
                conn c = new conn();
                String cardnumber = cardTextField.getText();
                String pinnumber = pinTextField.getText();
                String query1 = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
                try{
                    ResultSet rs = c.s.executeQuery(query1);
                    if(rs.next()){
                        setVisible(false);
                        new Transactions(pinnumber).setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null,"Incorrect Card Number or PIN");
                    }
                    
                }catch (Exception ae){
                    System.out.println(ae);
                }
                
                
            }else if(e.getSource() == signup){
                setVisible(false);
                new SignupOne().setVisible(true);
            
            }
            
        }
        
            
                
        public static void main(String[] args) {
           
            new Login();
            
            
            
            
    }
}


