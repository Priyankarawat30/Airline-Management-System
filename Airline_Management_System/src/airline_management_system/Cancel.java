
package airline_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
public class Cancel extends JFrame implements ActionListener{
    
    JTextField   tfpnr ;
    JLabel tfname ,  cancellationno , lblfcode , lbldateoftravel ;
    JButton   fetchButton , flight ;
   
    
    
    public Cancel(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        Random random = new Random();
        
        JLabel heading = new JLabel("CANCELLATION");
        heading.setBounds(300, 20, 250, 30);
        heading.setFont(new Font("Tahoma" , Font.BOLD , 31));
        heading.setForeground(Color.black);
        add(heading);
        
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airline_management_system/icons/cancel.jpg"));
         Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(600, 100, 250,250);
         add(image);
         

        
        JLabel lblaadhar = new JLabel("PNR NO.");
        lblaadhar.setBounds(50, 220, 150, 30);
        lblaadhar.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(lblaadhar);
        
        tfpnr = new JTextField();
        tfpnr.setBounds(220, 220, 150, 30);
        add(tfpnr);
        
        fetchButton = new JButton("SHOW DETAILS..");
        fetchButton.setBackground(Color.black);
        fetchButton.setForeground(Color.white);
        fetchButton.setBounds(400, 220, 150, 30);
        fetchButton.addActionListener(this);
        add(fetchButton);

        
        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(50, 100, 150, 30);
        lblname.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(lblname);
        
        tfname = new JLabel();
        tfname.setBounds(230, 90, 150, 50);
        tfname.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(tfname);
        
        JLabel lblnationality = new JLabel("CANCELLATION NO.");
        lblnationality.setBounds(50, 160, 150, 30);
        lblnationality.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(lblnationality);
        
        cancellationno = new JLabel("" +random.nextInt(1000000));
        cancellationno.setBounds(230, 160, 150, 30);
        cancellationno.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(cancellationno);
        
        
        
        JLabel lbladdress = new JLabel("FL.CODE");
        lbladdress.setBounds(50, 280, 150, 30);
        lbladdress.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(lbladdress);
        
        lblfcode = new JLabel();
        lblfcode.setBounds(230, 280, 150, 30);
        lblfcode.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(lblfcode);
        
        JLabel lblgender = new JLabel("DATE");
        lblgender.setBounds(50, 340, 150, 30);
        lblgender.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(lblgender);
        
        lbldateoftravel = new JLabel();
        lbldateoftravel.setBounds(230, 335, 150, 40);
        lbldateoftravel.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(lbldateoftravel);
        
        
        
        
        flight = new JButton("CANCEL FLIGHT");
        flight.setBackground(Color.black);
        flight.setForeground(Color.WHITE);
        flight.setBounds(350, 400, 150, 40);
        flight.addActionListener(this);
        add(flight);
        
                
       
        setSize(900 ,500);
        setLocation(480 , 300);
        setVisible(true);
    
}
    
    public static void main(String[]args){
        new Cancel();
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == fetchButton){
           
            String pnr = tfpnr.getText();
            
            try {
                Conn conn = new Conn();

                String query = "select *from  reservations where PNR = '"+pnr+"'";

                ResultSet rs = conn.s.executeQuery(query);
                
                if (rs.next()){
                    tfname.setText(rs.getString("name"));
                    lblfcode.setText(rs.getString("flightcode"));
                    lbldateoftravel.setText(rs.getString("ddate"));
                }else{
                    JOptionPane.showMessageDialog(null, "PNR DOES NOT EXIST");
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        } else if (ae.getSource() == flight){
           
            String name = tfname.getText();
            String pnr = tfpnr.getText();
            String cancelno = cancellationno.getText();
            String fcode = lblfcode.getText();
            String date = lbldateoftravel.getText();
            
            try {
                Conn conn = new Conn();

                String query = "insert into   cancel values('"+pnr+"' , '"+name+"' , '"+cancelno+"', '"+fcode+"', '"+date+"') ";

                conn.s.executeUpdate(query);
                conn.s.executeUpdate("delete from reservations where PNR = '"+pnr+"'");
                JOptionPane.showMessageDialog(null, "TICKET CANCELLED");
                setVisible(false);
                
               
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
            
    }

   
    
}

