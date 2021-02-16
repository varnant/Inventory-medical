import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class MainFrame extends JFrame //implements ActionListener
{
 private JLabel lblusername;
 private JLabel lblpassword;
 
 private JTextField txtusername;
 private JTextField txtpassword;
 
 private JButton btn_login;
 private JButton btn_cancel;
 
 private Container c;
 private JPanel btnpanel;
 private JPanel panel;
 
 MainFrame()
 {
  setTitle("PHARMACY MANAGEMENT SYSTEM");      //set the title
  setBounds(275, 250, 550, 210);               // set the size of frame..
  setResizable(false);
  c = getContentPane();
  
  panel = new JPanel(new GridLayout(2, 1, 5, 6));
  lblusername = new JLabel(" username");
  lblpassword = new JLabel(" password ");
  
  txtusername = new JTextField(10);
  txtpassword = new JTextField(10);
  
  panel.add(lblusername);
  panel.add(txtusername);
  panel.add(lblpassword);
  panel.add(txtpassword);
        
       
        
  btnpanel = new JPanel(new GridLayout(1, 2, 5,0));
  btn_login = new JButton ("Login");
  btn_cancel = new JButton ("Cancel");
  
  //btn_login.addActionListener(this);
  //btn_cancel.addActionListener(this);
  
  btnpanel.add(btn_login);
  btnpanel.add(btn_cancel);
        
  c.add(panel);
  c.add(btnpanel, BorderLayout.SOUTH);
 }
} 
        
  
  
  