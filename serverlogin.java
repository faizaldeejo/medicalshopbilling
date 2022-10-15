import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class serverlogin extends JFrame implements ActionListener{
     JLabel adminid,password;
     JTextField adminidt,passwordt;
     JButton login,back;
    public serverlogin(){
        setLayout(null);
      adminid=new JLabel("Admin id");
      password=new JLabel("Password");
      adminidt=new JTextField(8);
      passwordt=new JTextField(8);
      login=new JButton("Login");
      back=new JButton("back");

      back.setBounds(50,50,100,25);
      adminid.setBounds(50,150,100,25);
      adminidt.setBounds(200,150,100,25);
      password.setBounds(50,250,100,25);
      passwordt.setBounds(200,250,100,25);
      login.setBounds(150,350,100,25);
      add(back);	 	
      add(adminid);
      add(adminidt);
      add(password);
      add(passwordt);
      add(login);
      back.addActionListener(this);
      login.addActionListener(this);
    }
 public void actionPerformed(ActionEvent e){
     if(e.getSource()==login){
         String adid,paword;
         adit=adminidt.getText();
         paword=passwordt.getText();
         if(adit.equals("")



         serv ser=new serv();
         ser.setSize(800,800);
         ser.setVisible(true);
         dispose();
     }
     else if(e.getSource()==back){
          employee employee3=new employee();
          employee3.setSize(500,500);
          employee3.setVisible(true);
          dispose();
     }
 }
}