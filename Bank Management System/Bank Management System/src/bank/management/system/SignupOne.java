
package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.util.*;
//import com.toediter.Calendar.JDateChooser;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class SignupOne extends JFrame implements ActionListener{
    
    long random;
    JTextField nameTextField,FnameTextField,dobTextField,emailTextField,addressTextField,cityTextField,stateTextField,pinTextField;
    JButton next;
    JRadioButton male,female,married,unmarried,other;
    JDateChooser datechooser;
            
    public SignupOne() {
        
        setLayout(null);
        
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L)+1000L);
        
        JLabel formNO=new JLabel("Application Form Number "+random);
        formNO.setForeground(Color.black);
        formNO.setFont(new Font("Raleway",Font.BOLD,38));
        formNO.setBounds(140,20,600,40);
        add(formNO);
        
        
        JLabel personalDetails=new JLabel("Page 1: Personal Details");
        personalDetails.setForeground(Color.black);
        personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);
        
        JLabel name=new JLabel("Name:");
        name.setForeground(Color.black);
        name.setFont(new Font("Raleway",Font.BOLD,22));
        name.setBounds(100,140,100,30);
        add( name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font ("Raleway",Font.BOLD,14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);
        
        JLabel Fathername=new JLabel("Father's Name:");
        Fathername.setForeground(Color.black);
        Fathername.setFont(new Font("Raleway",Font.BOLD,22));
        Fathername.setBounds(100,190,200,30);
        add( Fathername);
        
        FnameTextField = new JTextField();
        FnameTextField.setFont(new Font ("Raleway",Font.BOLD,14));
        FnameTextField.setBounds(300, 190, 400, 30);
        add(FnameTextField);
        
        JLabel dob=new JLabel("Date of Birth:");
        dob.setForeground(Color.black);
        dob.setFont(new Font("Raleway",Font.BOLD,22));
        dob.setBounds(100,240,200,30);
        add( dob);
        
        datechooser= new JDateChooser();
        datechooser.setBounds(300, 240, 400, 30);
        datechooser.setForeground(Color.BLACK);
        add(datechooser);
        
        JLabel gender=new JLabel("Gender:");
        gender.setForeground(Color.black);
        gender.setFont(new Font("Raleway",Font.BOLD,22));
        gender.setBounds(100,290,200,30);
        add( gender);
        
        
        male = new JRadioButton("Male");
        male.setBackground(Color.WHITE);
        male.setBounds(300,290,120,30);
        add(male);     
        
        female = new JRadioButton("Female");
        female.setBackground(Color.WHITE);
        female.setBounds(450,290,120,30);
        add(female);
        
        ButtonGroup gendergroup =  new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        JLabel email=new JLabel("Email Address:");
        email.setForeground(Color.black);
        email.setFont(new Font("Raleway",Font.BOLD,22));
        email.setBounds(100,340,200,30);
        add( email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font ("Raleway",Font.BOLD,14));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);
        
        JLabel martial=new JLabel("Marital Status:");
        martial.setForeground(Color.black);
        martial.setFont(new Font("Raleway",Font.BOLD,22));
        martial.setBounds(100,390,200,30);
        add( martial);
        
        
        married = new JRadioButton("Married");
        married.setBackground(Color.WHITE);
        married.setBounds(300,390,120,30);
        add(married);     
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBackground(Color.WHITE);
        unmarried.setBounds(450,390,120,30);
        add(unmarried);
        
        other = new JRadioButton("Other");
        other.setBackground(Color.WHITE);
        other.setBounds(630,390,120,30);
        add(other);
        
        ButtonGroup group =  new ButtonGroup();
        group.add(married);
        group.add(unmarried);
        group.add(other);

        JLabel address=new JLabel("Address:");
        address.setForeground(Color.black);
        address.setFont(new Font("Raleway",Font.BOLD,22));
        address.setBounds(100,440,200,30);
        add( address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font ("Raleway",Font.BOLD,14));
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField);
        
        JLabel city=new JLabel("City:");
        city.setForeground(Color.black);
        city.setFont(new Font("Raleway",Font.BOLD,22));
        city.setBounds(100,490,200,30);
        add( city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font ("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);
        
        JLabel state=new JLabel("State:");
        state.setForeground(Color.black);
        state.setFont(new Font("Raleway",Font.BOLD,22));
        state.setBounds(100,540,200,30);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font ("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);
        
        JLabel pincode=new JLabel("Pin Code:");
        pincode.setForeground(Color.black);
        pincode.setFont(new Font("Raleway",Font.BOLD,22));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        pinTextField = new JTextField();
        pinTextField.setFont(new Font ("Raleway",Font.BOLD,14));
        pinTextField.setBounds(300, 590, 400, 30);
        add(pinTextField);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);        
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        String formno = ""+random;
        String name = nameTextField.getText();
        String Fname = FnameTextField.getText();
        String dob = ((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }else if(female.isSelected()){
            gender = "Female";
        }
        String email = emailTextField.getText();
        String address = addressTextField.getText();
        String marital =null;
        if(married.isSelected()){
            marital = "Married";
        } else if (unmarried.isSelected()){
            marital = "Unmarried";
        }else if (other.isSelected()){
            marital = "Other";
        }
        
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
            }
            else if(dob.equals("")){
                JOptionPane.showMessageDialog(null,"DOB is Required");
            }
            
            else{
                conn c = new conn();
                String query = "insert into signup values ('"+formno+"','"+name+"','"+Fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
                
            }
            
        }catch (Exception e){
            System.out.println(e);
        }
        
        
    }
    
        
    
    public static void main(String[] args) {
        
        new SignupOne();
        
    }
}