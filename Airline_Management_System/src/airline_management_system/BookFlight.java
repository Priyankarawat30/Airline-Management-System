
package airline_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
public class BookFlight extends JFrame implements ActionListener{
    
    JTextField   tfaadhar ;
    JLabel tfname ,  tfnationality , tfaddress , labelgender , labelfname , labelfcode;
    JButton bookflight , fetchButton , flight ;
    Choice source , destination;
    JDateChooser dcdate;
   
    
    public BookFlight(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading = new JLabel("BOOK FLIGHT...");
        heading.setBounds(370, 20, 500, 35);
        heading.setFont(new Font("Tahoma" , Font.BOLD , 45));
        heading.setForeground(Color.WHITE);
        add(heading);
        
        JLabel lblaadhar = new JLabel("AADHAR NO.");
        lblaadhar.setBounds(50, 220, 150, 30);
        lblaadhar.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(220, 220, 150, 30);
        add(tfaadhar);
        
        fetchButton = new JButton("Fetch..");
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
        
        JLabel lblnationality = new JLabel("COUNTRY");
        lblnationality.setBounds(50, 160, 150, 30);
        lblnationality.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(lblnationality);
        
        tfnationality = new JLabel();
        tfnationality.setBounds(230, 160, 150, 30);
        tfnationality.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(tfnationality);
        
        
        
        JLabel lbladdress = new JLabel("ADDRESS");
        lbladdress.setBounds(50, 280, 150, 30);
        lbladdress.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(lbladdress);
        
        tfaddress = new JLabel();
        tfaddress.setBounds(230, 280, 150, 30);
        tfaddress.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(tfaddress);
        
        JLabel lblgender = new JLabel("GENDER");
        lblgender.setBounds(50, 340, 150, 30);
        lblgender.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(lblgender);
        
        labelgender = new JLabel("GENDER");
        labelgender.setBounds(230, 335, 150, 40);
        labelgender.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(labelgender);
        
        JLabel lblsource = new JLabel("SOURCE");
        lblsource.setBounds(50, 400, 150, 30);
        lblsource.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(lblsource);
        
        source = new Choice();
        source.setBounds(220, 405, 150, 30);
        add(source);
        
        JLabel lbldest = new JLabel("TARGET");
        lbldest.setBounds(50, 460, 150, 30);
        lbldest.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(lbldest);
        
        destination = new Choice();
        destination.setBounds(220, 465, 150, 30);
        add(destination);
        
        try{
            Conn c = new Conn();
            String query = "select * from flight";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()){
                source.add(rs.getString("source"));
                destination.add(rs.getString("destination"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        flight = new JButton("FETCH FLIGHTS");
        flight.setBackground(Color.black);
        flight.setForeground(Color.WHITE);
        flight.setBounds(400, 463, 150, 25);
        flight.addActionListener(this);
        add(flight);
        
        JLabel lblfname = new JLabel("FL.NAME");
        lblfname.setBounds(50, 520, 150, 30);
        lblfname.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(lblfname);
        
        labelfname = new JLabel();
        labelfname.setBounds(230, 520, 150, 30);
        labelfname.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(labelfname);
        
        JLabel lblfcode = new JLabel("FL.CODE");
        lblfcode.setBounds(50, 580, 150, 30);
        lblfcode.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(lblfcode);
        
        labelfcode = new JLabel();
        labelfcode.setBounds(230, 580, 150, 30);
        labelfcode.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(labelfcode);
        
        JLabel lbldate = new JLabel("FL.DATE");
        lbldate.setBounds(50, 640, 150, 30);
        lbldate.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(lbldate);
        
        dcdate = new JDateChooser();
        dcdate.setBounds(220, 640, 150, 30);
        add(dcdate);
        
        bookflight = new JButton("BOOK FLIGHT");
        bookflight.setBackground(Color.black);
        bookflight.setForeground(Color.WHITE);
        bookflight.setBounds(400, 700, 150, 40);
        bookflight.addActionListener(this);
        add(bookflight);
        
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("airline_management_system/icons/SKY.jpg"));
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds( 0, 0 ,1100, 800 );
        add(lblimage);
        
        setSize(900 ,800);
        setLocation(480 , 150);
        setVisible(true);
    
}
    
    public static void main(String[]args){
        new BookFlight();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == fetchButton){
           
            String aadhar = tfaadhar.getText();
            
            try {
                Conn conn = new Conn();

                String query = "select *from  passenger where aadhar =  '"+aadhar+"'";

                ResultSet rs = conn.s.executeQuery(query);
                
                if (rs.next()){
                    tfname.setText(rs.getString("name"));
                    tfnationality.setText(rs.getString("nationality"));
                    tfaddress.setText(rs.getString("address"));
                    labelgender.setText(rs.getString("gender"));
                }else{
                    JOptionPane.showMessageDialog(null, "USER DOES NOT EXIST");
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        } else if (ae.getSource() == flight){
           
            String src = source.getSelectedItem();
            String dest = destination.getSelectedItem();
            
            try {
                Conn conn = new Conn();

                String query = "select *from  flight where source =  '"+src+"' and destination = '"+dest+"'";

                ResultSet rs = conn.s.executeQuery(query);
                
                if (rs.next()){
                    labelfname.setText(rs.getString("f_name"));
                    labelfcode.setText(rs.getString("f_code"));
                }else{
                    JOptionPane.showMessageDialog(null, "flights not found");
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }else{
            Random random = new Random();
            String aadhar = tfaadhar.getText() ;
            String name = tfname.getText();
            String nationality = tfnationality .getText();
            String flightname = labelfname.getText();
            String flightcode = labelfcode.getText();
            String src = source.getSelectedItem();
            String dest = destination.getSelectedItem();
            String ddate = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            
             try {
                Conn conn = new Conn();

                String query = "insert into reservations values ('PNR-"+random.nextInt(1000000)+"' , 'TIC-"+random.nextInt(10000)+"', '"+aadhar+"', '"+name+"', '"+nationality+"', '"+flightname+"','"+flightcode+"' , '"+src+"' , '"+dest+"' , '"+ddate+"')";

                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "TICKET BOOKED SUCCESSFULLY");
                
                setVisible(false);
               
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }    
            
    }
    
}

