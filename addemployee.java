import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class addemployee extends JFrame implements ActionListener{
     JLabel l1,l2;
     JTextField t1,t2;
     JButton b1,b2,b3;
    public addemployee(){
        setLayout(new FlowLayout());
      l1=new JLabel("Enter new employee id");
      l2=new JLabel("Enter Employee's Password");
      t1=new JTextField(15);
      t2=new JTextField(15);
      b1=new JButton("Add");
      b2=new JButton("back");
      b3=new JButton("Edit Employee's info.");
      add(b2);
      add(b3);
      add(l1);
      add(t1);
      add(l2);
      add(t2);
      add(b1);
      b1.addActionListener(this);
      b2.addActionListener(this);
      b3.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b3){
		editemployee eemployee=new editemployee();
		eemployee.setSize(500,500);
		eemployee.setVisible(true);
        dispose();
        }
        else if(e.getSource()==b2){
            server ser3=new server();
            ser3.setVisible(true);
            ser3.setSize(500,500);
            dispose();
        }
        else if(e.getSource()==b1){

        }
    }
} 