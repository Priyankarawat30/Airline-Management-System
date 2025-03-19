
package airline_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BoardingPass extends JFrame implements ActionListener{
    
    JTextField   tfpnr ;
    JLabel tfname ,  tfnationality , lblsrc , lbldest , labelfname , labelfcode , labeldate;
    JButton  fetchButton ;
    
   
   
    
    public BoardingPass(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading = new JLabel("BOARDING PASS");
        heading.setBounds(300, 20, 500, 35);
        heading.setFont(new Font("Tahoma" , Font.BOLD , 45));
        heading.setForeground(Color.WHITE);
        add(heading);
        
        JLabel lblaadhar = new JLabel("PNR NO.");
        lblaadhar.setBounds(50, 100, 150, 30);
        lblaadhar.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(lblaadhar);
        
        tfpnr = new JTextField();
        tfpnr.setBounds(230, 100 , 150, 30);
        add(tfpnr);
        
        fetchButton = new JButton("ENTER");
        fetchButton.setBackground(Color.black);
        fetchButton.setForeground(Color.white);
        fetchButton.setBounds(450, 100, 150, 30);
        fetchButton.addActionListener(this);
        add(fetchButton);

        
        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(50, 160, 150, 30);
        lblname.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(lblname);
        
        tfname = new JLabel();
        tfname.setBounds(230, 150, 150, 50);
        tfname.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(tfname);
        
        JLabel lblnationality = new JLabel("COUNTRY");
        lblnationality.setBounds(50, 220, 150, 30);
        lblnationality.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(lblnationality);
        
        tfnationality = new JLabel();
        tfnationality.setBounds(230, 220, 150, 30);
        tfnationality.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(tfnationality);
        
        
        
        JLabel lbladdress = new JLabel("SRC");
        lbladdress.setBounds(50, 280, 150, 30);
        lbladdress.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(lbladdress);
        
        lblsrc = new JLabel();
        lblsrc.setBounds(230, 280, 150, 30);
        lblsrc.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(lblsrc);
        
        JLabel lblgender = new JLabel("DEST");
        lblgender.setBounds(400, 280, 150, 30);
        lblgender.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(lblgender);
        
        lbldest = new JLabel();
        lbldest.setBounds(600, 272, 150, 40);
        lbldest.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(lbldest);
       
        
        
        JLabel lblfname = new JLabel("FL.NAME");
        lblfname.setBounds(50, 340, 150, 30);
        lblfname.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(lblfname);
        
        labelfname = new JLabel();
        labelfname.setBounds(230, 340, 150, 30);
        labelfname.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(labelfname);
        
        JLabel lblfcode = new JLabel("FL.CODE");
        lblfcode.setBounds(400, 340, 150, 30);
        lblfcode.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(lblfcode);
        
        labelfcode = new JLabel();
        labelfcode.setBounds(600, 340, 150, 30);
        labelfcode.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(labelfcode);
        
        JLabel lbldate = new JLabel("DATE");
        lbldate.setBounds(50, 400, 150, 30);
        lbldate.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(lbldate);
        
        labeldate = new JLabel();
        labeldate.setBounds(230, 400, 150, 30);
        labeldate.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(labeldate);
        
        
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("airline_management_system/icons/SKY.jpg"));
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds( 0, 0 ,1100, 800 );
        add(lblimage);
        
        setSize(1000 ,500);
        setLocation(480 , 150);
        setVisible(true);
    
}
    
    public static void main(String[]args){
        new BoardingPass();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       
           
            String pnr = tfpnr.getText();
            
            try {
                Conn conn = new Conn();

                String query = "select *from  reservations where PNR =  '"+pnr+"'";

                ResultSet rs = conn.s.executeQuery(query);
                
                if (rs.next()){
                    tfname.setText(rs.getString("name"));
                    tfnationality.setText(rs.getString("nationality"));
                    lblsrc.setText(rs.getString("src"));
                    lbldest.setText(rs.getString("dest"));
                    labelfname.setText(rs.getString("flightname"));
                    labelfcode.setText(rs.getString("flightcode"));
                    labeldate.setText(rs.getString("ddate"));

                    
                }else{
                    JOptionPane.showMessageDialog(null, "PNR DOES NOT EXIST");
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
    }
    
}


