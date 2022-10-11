import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class serverlogin extends JFrame implements ActionListener{
     JLabel l1,l2;
     JTextField t1,t2;
     JButton b1,b2;
    public serverlogin(){
        setLayout(null);
      l1=new JLabel("Admin id");
      l2=new JLabel("Password");
      t1=new JTextField(15);
      t2=new JTextField(15);
      b1=new JButton("Login");
      b2=new JButton("back");

      b2.setBounds(50,50,100,50);
      l1.setBounds(50,150,100,50);
      t1.setBounds(200,150,100,50);
      l2.setBounds(50,250,100,50);
      t2.setBounds(200,250,100,50);
      b1.setBounds(150,350,100,50);
      add(b2);	 	
      add(l1);
      add(t1);
      add(l2);
      add(t2);
      add(b1);
      b1.addActionListener(this);
      b2.addActionListener(this);
    }
 public void actionPerformed(ActionEvent e){
     if(e.getSource()==b1){
         server ser=new server();
         ser.setSize(500,500);
         ser.setVisible(true);
         dispose();
     }
     else if(e.getSource()==b2){
          employee employee3=new employee();
          employee3.setSize(500,500);
          employee3.setVisible(true);
          dispose();
     }
 }
}