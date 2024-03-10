
package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener{
    
    
    JTextField panTextField,aadharTextField;
    JButton next;
    JRadioButton sYes,sNo,eYes,eNo;
    JComboBox religion,category,occupation,education,income;
    String formno;
            
    public SignupTwo(String formno) {
        
        this.formno = formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        
        
        JLabel additionalDetails=new JLabel("Page 2: Additional Details");
        additionalDetails.setForeground(Color.black);
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
        JLabel name=new JLabel("Religion:");
        name.setForeground(Color.black);
        name.setFont(new Font("Raleway",Font.BOLD,22));
        name.setBounds(100,140,100,30);
        add( name);
        
        String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"}; 
        religion = new JComboBox(valReligion);
        religion.setFont(new Font ("Raleway",Font.BOLD,14));
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
                      
        
        JLabel Fathername=new JLabel("Category:");
        Fathername.setForeground(Color.black);
        Fathername.setFont(new Font("Raleway",Font.BOLD,22));
        Fathername.setBounds(100,190,200,30);
        add( Fathername);
        
        
        String valCategory[] = {"General","OBC","SC","ST","Other"}; 
        category = new JComboBox(valCategory);
        category.setFont(new Font ("Raleway",Font.BOLD,14));
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);
      
        
        
        JLabel dob=new JLabel("Income:");
        dob.setForeground(Color.black);
        dob.setFont(new Font("Raleway",Font.BOLD,22));
        dob.setBounds(100,240,200,30);
        add( dob);
        
        String valIncome[] = {"Null","<1,50,000","<2,50,000","<5,50,000","Upto 10,00,000"}; 
        income = new JComboBox(valIncome);
        income.setFont(new Font ("Raleway",Font.BOLD,14));
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);
      
        
        
        
        
        JLabel gender=new JLabel("Educational");
        gender.setForeground(Color.black);
        gender.setFont(new Font("Raleway",Font.BOLD,22));
        gender.setBounds(100,290,200,30);
        add( gender);
        
        
        JLabel email=new JLabel("Qalification:");
        email.setForeground(Color.black);
        email.setFont(new Font("Raleway",Font.BOLD,22));
        email.setBounds(100,315,200,30);
        add( email);
        
        
        String valEducation[] = {"Non-Graduation","Graduate","Post Graduate","Doctrate","other"}; 
        education = new JComboBox(valEducation);
        education.setFont(new Font ("Raleway",Font.BOLD,14));
        education.setBounds(300, 300, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);
        
        
        
        
        JLabel martial=new JLabel("Occupation:");
        martial.setForeground(Color.black);
        martial.setFont(new Font("Raleway",Font.BOLD,22));
        martial.setBounds(100,390,200,30);
        add( martial);
        
        String valOccupation[] = {"Salaried","Self-Employed","Bussiness","Student","REtired","OthersSS"}; 
        occupation = new JComboBox(valOccupation);
        occupation.setFont(new Font ("Raleway",Font.BOLD,14));
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        
        
        JLabel address=new JLabel("PAN Number:");
        address.setForeground(Color.black);
        address.setFont(new Font("Raleway",Font.BOLD,22));
        address.setBounds(100,440,200,30);
        add( address);
        
        panTextField = new JTextField();
        panTextField.setFont(new Font ("Raleway",Font.BOLD,14));
        panTextField.setBounds(300, 440, 400, 30);
        add(panTextField);
        
        JLabel city=new JLabel("Aadhar Number:");
        city.setForeground(Color.black);
        city.setFont(new Font("Raleway",Font.BOLD,22));
        city.setBounds(100,490,200,30);
        add( city);
        
        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font ("Raleway",Font.BOLD,14));
        aadharTextField.setBounds(300, 490, 400, 30);
        add(aadharTextField);
        
        JLabel state=new JLabel("Senior Citizen:");
        state.setForeground(Color.black);
        state.setFont(new Font("Raleway",Font.BOLD,22));
        state.setBounds(100,540,200,30);
        add(state);
        
        sYes = new JRadioButton("YES");
        sYes.setBackground(Color.WHITE);
        sYes.setBounds(300, 540, 100, 30);
        add(sYes);     
        
        sNo = new JRadioButton("NO");
        sNo.setBackground(Color.WHITE);
        sNo.setBounds(450, 540, 100, 30);
        add(sNo);

        ButtonGroup group =  new ButtonGroup();
        group.add(sYes);
        group.add(sNo);
     
        
        
        
        JLabel pincode=new JLabel("Existing Account:");
        pincode.setForeground(Color.black);
        pincode.setFont(new Font("Raleway",Font.BOLD,22));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        eYes = new JRadioButton("YES");
        eYes.setBackground(Color.WHITE);
        eYes.setBounds(300, 590, 100, 30);
        add(eYes);     
        
        eNo = new JRadioButton("NO");
        eNo.setBackground(Color.WHITE);
        eNo.setBounds(450, 590, 100, 30);
        add(eNo);
        
        ButtonGroup egroup =  new ButtonGroup();
        egroup.add(eYes);
        egroup.add(eNo);
        
        
        
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
        
        String sreligion = (String)religion.getSelectedItem();
        String scategory = (String)category.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String seducation = (String)education.getSelectedItem();
        String soccupation = (String)occupation.getSelectedItem();
        String seniorCitizen = null;
        if(sYes.isSelected()){
            seniorCitizen = "Yes";
        }else if(sNo.isSelected()){
            seniorCitizen = "No";
        }
    
       
        String existingAccount =null;
        if(eYes.isSelected()){
            existingAccount = "Yes";
        } else if (eNo.isSelected()){
            existingAccount = "No";
        }
        
        String span = panTextField.getText();
        String saadhar = aadharTextField.getText();
        
        try{
            
                conn c = new conn();
                String query = "insert into signuptwo values ('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorCitizen+"','"+existingAccount+"')";
                c.s.executeUpdate(query);
                
                
                setVisible(false);
                new SignupThree(formno).setVisible(true);
                
                
                
            
            
        }catch (Exception e){
            System.out.println(e);
        }
        
        
    }
    
        
    
    public static void main(String[] args) {
        
        new SignupTwo("");
        
    }
}