import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
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
      adminidt.requestFocus();
      add(password);
      add(passwordt);
      add(login);
      back.addActionListener(this);
      login.addActionListener(this);
    }
 public void actionPerformed(ActionEvent e){
     if(e.getSource()==login){
         String aid=adminidt.getText(),apass=passwordt.getText();
       if(aid.equals("")&&apass.equals("")||aid.contains(" ")&&apass.contains(" ")){
           JOptionPane.showMessageDialog(this,"The adminid and adninpass are invalid..");
         }
         else if(aid.equals("")||aid.contains(" ")){
           JOptionPane.showMessageDialog(this,"The adminid is invalid..");
         }
         else if(apass.equals("")||apass.contains(" ")){
           JOptionPane.showMessageDialog(this,"The adminpass is invalid..");
         }
         else{  
                try{
           Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical","root","");
          Statement stmt=con.createStatement();
          int j=0;
ResultSet rs=stmt.executeQuery("select * from serverlogin");
          while(rs.next()){
            String dbid=rs.getString(1);
            String dbpass=rs.getString(2);
              if(dbid.equals(aid)&&dbpass.equals(apass)){
                j++;
         serv ser=new serv();
         ser.setSize(800,800);
         ser.setVisible(true);
         dispose();
         }
     }
     if(j==0){
         JOptionPane.showMessageDialog(this,"The adminid,adminpass are invalid..");
     }
                }
       catch(Exception y){
             System.out.println(y);
           } 
         }
     }
     else if(e.getSource()==back){
          employee employee3=new employee();
          employee3.setSize(600,500);
          employee3.setVisible(true);
          dispose();
     }
}
}