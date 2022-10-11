import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class server extends JFrame implements ActionListener{
    JButton b1,b2,b3;
    public server(){
        setLayout(new FlowLayout());
        b1=new JButton("Back");
        b2=new JButton("Add Employee and Edit");
        b3=new JButton("Go to Database Server");
        add(b1);
        add(b2);
        add(b3);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1){
           employee employee4=new employee();
           employee4.setSize(500,500);
           employee4.setVisible(true);
           dispose();
        }
        else if(e.getSource()==b2){
                addemployee addemp=new addemployee();
                addemp.setSize(500,500);
                addemp.setVisible(true);
                dispose();
        }
        else if(e.getSource()==b3){
           databaseserver dbserver=new databaseserver();
           dbserver.setSize(700,700);
           dbserver.setVisible(true);
           dispose();
        }
    }
}