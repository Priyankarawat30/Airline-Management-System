
package airline_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AddCustomer extends JFrame implements ActionListener{
    
    JTextField tfname , tfmobile , tfnationality , tfaadhar , tfaddress;
    JRadioButton rbmale , rbfemale;
    
    public AddCustomer(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading = new JLabel("ADD CUSTOMER DETAILS...");
        heading.setBounds(180, 20, 500, 35);
        heading.setFont(new Font("Tahoma" , Font.BOLD , 35));
        heading.setForeground(Color.WHITE);
        add(heading);
        
        
        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(50, 80, 150, 30);
        lblname.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 80, 150, 30);
        add(tfname);
        
        JLabel lblnationality = new JLabel("COUNTRY");
        lblnationality.setBounds(50, 120, 150, 30);
        lblnationality.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(lblnationality);
        
        tfnationality = new JTextField();
        tfnationality.setBounds(200, 120, 150, 30);
        add(tfnationality);
        
        JLabel lblaadhar = new JLabel("AADHAR NO.");
        lblaadhar.setBounds(50, 160, 150, 30);
        lblaadhar.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(200, 160, 150, 30);
        add(tfaadhar);
        
        JLabel lbladdress = new JLabel("ADDRESS");
        lbladdress.setBounds(50, 200, 150, 30);
        lbladdress.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 200, 150, 30);
        add(tfaddress);
        
        JLabel lblgender = new JLabel("GENDER");
        lblgender.setBounds(50, 240, 150, 30);
        lblgender.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(lblgender);
        
        ButtonGroup gendergroup = new ButtonGroup();
        
        rbmale = new JRadioButton("MALE");
        rbmale.setBounds(200, 240, 70, 30);
        rbmale.setBackground(Color.white);
        add(rbmale);
        
        rbfemale = new JRadioButton("FEMALE");
        rbfemale.setBounds(280, 240, 70, 30);
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        gendergroup.add(rbmale);
        gendergroup.add(rbfemale);
        
        JLabel lblmobile = new JLabel("MOBILE NO.");
        lblmobile.setBounds(50, 280, 150, 30);
        lblmobile.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(lblmobile);
        
        tfmobile = new JTextField();
        tfmobile.setBounds(200, 280, 150, 30);
        add(tfmobile);
        
        JButton save = new JButton("SAVE");
        save.setBackground(Color.black);
        save.setForeground(Color.WHITE);
        save.setBounds(310, 360, 150, 40);
        save.addActionListener(this);
        add(save);
        
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("airline_management_system/icons/grey.png"));
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds( 0, 0 ,955, 500 );
        add(lblimage);
        
        setSize(800,500);
        setLocation(400 , 150);
        setVisible(true);
    
}
    
    public static void main(String[]args){
        new AddCustomer();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = tfname.getText();
        String nationality = tfnationality.getText();
        String address = tfaddress.getText();
        String mobile = tfmobile.getText();
        String aadhar = tfaadhar.getText();
        String gender = null;
        if(rbmale.isSelected()){
            gender = "MALE";
        }else{
            gender = "FEMALE";
        }
        try {
            Conn conn = new Conn();
            
            String query = "insert into passenger values ('"+name+"' , '"+nationality+"' , '"+aadhar+"' , '"+address+"' , '"+mobile+"' , '"+gender+"' )";
            
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "CUSTOMER DETAILS  ADDED SUCCESSFULLY");
            
            setVisible(false);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    

    
    
}
