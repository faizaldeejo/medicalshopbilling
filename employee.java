import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class employee extends JFrame implements ActionListener{
  JLabel employeeid,employeepass;
  JTextField employeeidt,employeepasst;
  JButton admin,login;
    public employee(){
      setLayout(null);
      //labels
      employeeid=new JLabel("username");
      employeepass=new JLabel("Password");
      //textfields
      employeeidt=new JTextField(8);
      employeepasst=new JTextField(8);
      //buttons
      admin=new JButton("Admin Page");
      login=new JButton("login");
      //set bounds
      admin.setBounds(50,150,200,200);
      employeeid.setBounds(300,150,100,25);
      employeeidt.setBounds(450,150,100,25);
      employeepass.setBounds(300,225,100,25);
      employeepasst.setBounds(450,225,100,25);
      login.setBounds(375,325,100,50);
      //adding
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
           try{
           Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical","root","");
          Statement stmt=con.createStatement();
          int j=0;
ResultSet rs=stmt.executeQuery("select * from employee");
          while(rs.next()){
            String dbusn=rs.getString(2);
            String dbpass=rs.getString(3);
              if(dbusn.equals(username)&&dbpass.equals(password)){
                j++;
                 purchase pur=new purchase();
                 pur.setSize(900,900);
                 pur.setVisible(true);
                 dispose();

              }
          }
          if(j==0){
            JOptionPane.showMessageDialog(this,"The username,password are invalid..");
          }
           }
           catch(Exception y){
             System.out.println(y);
           }
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
     ob.setSize(600,500);
     ob.setVisible(true);
   }
}