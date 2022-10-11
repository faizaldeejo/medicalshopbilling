import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class employee extends JFrame implements ActionListener{
  JLabel employeeid,employeepass;
  JTextField employeeidt,employeepasst;
  JButton admin,login;
    public employee(){
      setLayout(new FlowLayout());
      //labels
      employeeid=new JLabel("employee id");
      employeepass=new JLabel("Password");
      //textfields
      employeeidt=new JTextField(8);
      employeepasst=new JTextField(8);
      //buttons
      admin=new JButton("Admin Page");
      login=new JButton("login");
/*
      b2.setBounds(50,50,100,50);
      l1.setBounds(50,150,100,50);
      t1.setBounds(200,150,100,50);
      l2.setBounds(50,250,100,50);
      t2.setBounds(200,250,100,50);
      b1.setBounds(150,350,100,50);
      */
      add(admin);
      add(employeeid);
      add(employeeidt);
      add(employeepass);
      add(employeepasst);
      add(login);
      admin.addActionListener(this);
      login.addActionListener(this);
    }
   public void actionPerformed(ActionEvent e){
       if(e.getSource()==login){
         String  username= employeeidt.getText();
         String  password=employeepasst.getText();
         if(username.equals("")&&password.equals("")||username.contains(" ")&&password.contains(" ")){
           JOptionPane.showMessageDialog(this,"The Username and Password are invalid..");
         }
         else if(username.equals("")||username.contains(" ")){
           JOptionPane.showMessageDialog(this,"The Username is invalid..");
         }
         else if(password.equals("")||password.contains(" ")){
           JOptionPane.showMessageDialog(this,"The password is invalid..");
         }
         else{
           purchase pur=new purchase();
           pur.setSize(700,700);
           pur.setVisible(true);
           dispose();
         }    
       }
       else if(e.getSource()==admin){
                serverlogin serlogin=new serverlogin();
                serlogin.setSize(500,500);
                serlogin.setVisible(true);
                dispose();
       }

   }
   public static void main(String []args){
     employee ob=new employee();
     ob.setSize(500,500);
     ob.setVisible(true);
   }
}