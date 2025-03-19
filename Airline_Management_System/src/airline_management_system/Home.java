package airline_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Home  extends JFrame implements ActionListener{
    
  
    public Home(){
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airline_management_system/icons/plane.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1920,1080);
        add(image);
        
        JLabel heading = new JLabel("WELCOME TO AIRLINE MANAGEMENT");
        heading.setBounds(550 , 30 , 800 , 100);
        heading.setForeground(Color.white);
        heading.setFont(new Font("Tahoma",Font.BOLD, 40));
        image.add(heading);
        
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        
        JMenu details = new JMenu("Details");
        menubar.add(details);
        
        JMenuItem flightDetails = new JMenuItem(" Flight Details ");
        flightDetails.addActionListener(this);
        details.add(flightDetails);
        
        JMenuItem CustomerDetails = new JMenuItem(" Add Customer Details ");
        CustomerDetails.addActionListener(this);
        details.add(CustomerDetails);
        
        JMenuItem bookFlight = new JMenuItem(" Book Flight ");
        bookFlight.addActionListener(this);
        details.add(bookFlight); 
        
        JMenuItem journeyDetails = new JMenuItem(" Journey Details ");
        journeyDetails.addActionListener(this);
        details.add(journeyDetails);
        
        JMenuItem TicketCancellation = new JMenuItem(" Cancel Ticket ");
        TicketCancellation.addActionListener(this);
        details.add(TicketCancellation);
        
        JMenu ticket = new JMenu("ticket");
        menubar.add(ticket);
        
        JMenuItem BoardingPass = new JMenuItem(" Boarding Pass ");
         BoardingPass.addActionListener(this);
        ticket.add(BoardingPass);
        
        
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
       
        setVisible(true);
        
    }@Override
 public void actionPerformed(ActionEvent e) {
        String text = e.getActionCommand();
        
        if(text.equals(" Add Customer Details ")){
            new AddCustomer();
        }else if(text.equals(" Flight Details ")){
            new FlightInfo();
        }else if(text.equals(" Book Flight ")) {
            new BookFlight();
        }else if(text.equals(" Journey Details ")){
            new JourneyDetails();
        }else if (text.equals(" Cancel Ticket ")){
            new Cancel();
        }else if (text.equals(" Boarding Pass ")){
            new BoardingPass();
        }
    }
  
    public static void main(String[] args){
        new Home();
    }
}
   
   

   

   
