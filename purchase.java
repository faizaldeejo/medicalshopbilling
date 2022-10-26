import java.awt.event.*;
import java.awt.*;
import java.lang.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
public class purchase extends JFrame implements ActionListener,MouseListener,KeyListener,ItemListener{
    //variables
     int tno,rt,mno;
String medname="",r="",tabno="";
int orate,ocquantity,ocrate,tntablets;

    JLabel search,medicinename,rate;
    JTextField searcht,medicinenamet,tabletsno,ratet;
    JButton add,back,clear;
    Choice c;
     DefaultTableModel model1=new DefaultTableModel();
    DefaultTableModel model2=new DefaultTableModel();
   JTable searchtable=new JTable(model1);
   JTable addedtable=new JTable(model2);
   public purchase(){
       //labels
       setLayout(null);
       search=new JLabel("search");
       medicinename=new JLabel("medicine name");
       rate=new JLabel("rate");
       //textfields
       searcht=new JTextField(15);
       medicinenamet=new JTextField(15);
       tabletsno=new JTextField(3);
       ratet=new JTextField(5);
       //choice
       c=new Choice();
       c.addItem("tablets");
       c.addItem("card");
       //buttons
       add=new JButton("Add");
       back=new JButton("back");
       clear=new JButton("clear");
       //table
        int searchtablev=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int searchtableh=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        JScrollPane jsp1=new JScrollPane(searchtable,searchtablev,searchtableh);
        int addedtablev=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int addedtableh=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        JScrollPane jsp2=new JScrollPane(addedtable,addedtablev,addedtableh);
        model2.addColumn("medicine name");
        model2.addColumn("quantity");
        model2.addColumn("rate");
        model1.addColumn("mno");
        model1.addColumn("medicine name");
        model1.addColumn("once rate");
        model1.addColumn("one card quantity");
        model1.addColumn("one card rate");
        model1.addColumn("tot numof tablets");
        //set Bounds
        back.setBounds(50,50,100,50);
        search.setBounds(50,125,100,25);
        searcht.setBounds(200,125,100,25);
        jsp1.setBounds(50,175,400,200);
        medicinename.setBounds(500,175,100,25);
        medicinenamet.setBounds(700,175,100,25);
        c.setBounds(500,225,100,25);
        tabletsno.setBounds(700,225,100,25);
        rate.setBounds(500,275,100,25);
        ratet.setBounds(700,275,100,25);
        add.setBounds(500,325,100,25);
        clear.setBounds(700,325,100,25);
        jsp2.setBounds(450,475,350,350);
        //add
        add(back);
        add(search);
        add(searcht);
        add(jsp1);
        add(medicinename);
        add(medicinenamet);
        add(c);
        add(tabletsno);
        add(rate);
        add(ratet);
        add(add);
        add(clear);
        add(jsp2);
        //listener
        searcht.addKeyListener(this);
        add.addActionListener(this);
        back.addActionListener(this);
        clear.addActionListener(this);
        searchtable.addMouseListener(this);
        tabletsno.addKeyListener(this);
        c.addItemListener(this);
   }
     //action methos
     public void actionPerformed(ActionEvent e){
         if(e.getSource()==back){
             employee employee1=new employee();
             employee1.setSize(600,500);
              employee1.setVisible(true);
              dispose();
         }
         else if(e.getSource()==add){

         }
         else if(e.getSource()==clear){
             medicinenamet.setText("");
             tabletsno.setText("");
             ratet.setText("");
         }
     }
     //keylistener
      public void keyTyped(KeyEvent e) {   
          if(e.getSource()==searcht)
                {
                     model1.setRowCount(0);
                } 
                

    }
    public void keyReleased(KeyEvent e){
        if(e.getSource()==searcht){
            try{
            String mname=searcht.getText();
            if(mname.equals("")||mname.contains(" ")){

            }
            else{
                 Class.forName("com.mysql.jdbc.Driver");
                                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical","root","");
                                Statement stmt=con.createStatement();
                                ResultSet rx=stmt.executeQuery("select * from  medicine where medicinename like '"+mname+"%' ");
                                while(rx.next()){
                                        mno=rx.getInt(1);
                                        medname=rx.getString(2);
                                        orate=rx.getInt(3);
                                        ocquantity=rx.getInt(3);
                                        ocrate=rx.getInt(5);
                                        tntablets=rx.getInt(5);
                                        model1.addRow(new Object[]{mno,medname,orate,ocquantity,ocrate,tntablets});
                                }
            }
        }
        catch(Exception j){
            System.out.println(j);
        }
        }
        
        else if(e.getSource()==tabletsno){
            if(c.getSelectedItem()=="tablets"){
                 tabno=tabletsno.getText();
            if(tabno.equals("")||tabno.contains(" ")){
                ratet.setText("");
            }
            else{
            tno=Integer.valueOf(tabno);
            rt=tno*orate;
            r=String.valueOf(rt);
            ratet.setText(r);
            }
            }
            else if(c.getSelectedItem()=="card"){
                 tabno=tabletsno.getText();
            if(tabno.equals("")||tabno.contains(" ")){
                ratet.setText("");
            }
            else{
            tno=Integer.valueOf(tabno);
            rt=tno*ocrate;
            r=String.valueOf(rt);
            ratet.setText(r);
            }
            }
                
        }
       }
    public void keyPressed(KeyEvent e) {
    }
    //mouselistener
     public void mouseClicked(MouseEvent e){
         if(e.getSource()==searchtable){
            int selected=searchtable.getSelectedRow();
            medicinenamet.setText(model1.getValueAt(selected,1).toString());
            ratet.setText(model1.getValueAt(selected,2).toString());
            String i="1";
            tabletsno.setText(i);
            searcht.setText("");
            model1.setRowCount(0);

         }
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

    //itemlistener
    public void itemStateChanged(ItemEvent e)
{ 
    if(e.getSource()==c){
    if(c.getSelectedItem()=="card"){
        int tc=Integer.valueOf(tabletsno.getText().toString());

            //tno=Integer.valueOf(tabno);
          String mr=String.valueOf(tc*ocrate);
           // r=String.valueOf(rt);
            ratet.setText(mr);
        }
        else if(c.getSelectedItem()=="tablets"){
                int t=Integer.valueOf(tabletsno.getText().toString());
                String rm=String.valueOf(t*orate);
                ratet.setText(rm);
        }
}
}


    //main function
    /*
    public static void main(String []args){
        purchase ob=new purchase();
        ob.setSize(700,700);
        ob.setVisible(true);
    }*/
}
