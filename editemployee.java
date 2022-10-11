import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
class editemployee extends JFrame implements ActionListener,MouseListener{
JButton b1,b2,b3,b4;
JTextField t1,t2,t3;
JLabel l1,l2,l3;
DefaultTableModel model=new DefaultTableModel();
JTable table1=new JTable(model);
public editemployee(){
setLayout(new FlowLayout());
l1=new JLabel("EID");
l2=new JLabel("Username");
l3=new JLabel("Password");
t1=new JTextField(5);
t2=new JTextField(10);
t3=new JTextField(10);
b1=new JButton("back");
b2=new JButton("save");
b3=new JButton("delete");
b4=new JButton("Cancel");
model.addColumn("ID");
model.addColumn("Username");
model.addColumn("Password");
int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
JScrollPane jsp=new JScrollPane(table1,v,h);
//jsp.setBounds(50,100,300,300);
add(l1);
add(t1);
add(l2);
add(t2);
add(l3);
add(t3);
add(b1);
add(b2);
add(b3);
add(b4);
add(jsp);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
table1.addMouseListener(this);
display();
}
public void display(){
try{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical","root","");
            Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("select * from tname");
while(rs.next()){
                model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3)});           

}
}
catch(Exception x){
System.out.println(x);
}
}


public void actionPerformed(ActionEvent e){
if(e.getSource()==b1){
      addemployee addemp2=new addemployee();
      addemp2.setSize(500,500);
      addemp2.setVisible(true);
      dispose();  
/*
String ID="",Username="",Password="";
ID=t1.getText();
Username=t2.getText();
Password=t3.getText();
//database connection..
try{
Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical","root","");
            Statement stmt=con.createStatement();
stmt.executeUpdate("insert into tname values('"+ID+"','"+Username+"','"+Password+"')");
model.addRow(new Object[]{ID,Username,Password});
t1.setText("");
t2.setText("");
t3.setText("");
t1.requestFocus();
}
catch(Exception z){
System.out.println(z);
}
*/
}
else if(e.getSource()==b2){


}
else if(e.getSource()==b3){


}
else if(e.getSource()==b4){


}


}

//Mouse event
public void mouseClicked(MouseEvent e){
    
        model=(DefaultTableModel)table1.getModel();
        int selected=table1.getSelectedRow();
        String id=(model.getValueAt(selected,0).toString());
        String username=(model.getValueAt(selected,1).toString());
        String password=(model.getValueAt(selected,2).toString());
        t1.setText(id);
        t2.setText(username);
        t3.setText(password);
}
 public void mousePressed(MouseEvent e) 
{
}
 public void mouseReleased(MouseEvent e)
 {
}
 public void mouseEntered(MouseEvent e)
 {
}
public void mouseExited(MouseEvent e) 
{
}

public static void main(String []args){
editemployee ob=new editemployee();
ob.setSize(500,500);
ob.setVisible(true);
}
}