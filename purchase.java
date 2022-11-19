import java.awt.event.*;
import java.awt.*;
import java.lang.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.table.DefaultTableModel;
public class purchase extends JFrame implements ActionListener,MouseListener,KeyListener,ItemListener{
    //variables
     int tno,rt,mno;
String medname="",r="",tabno="";
int orate,ocquantity,ocrate,tntablets;

    JLabel search,medicinename,rate,total,currentdate;
    JTextField searcht,medicinenamet,tabletsno,ratet,totalt,currentdatet;
    JButton add,back,clear,print,gotoprint;
    JTextArea bill;
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
       total=new JLabel("total rate");
       currentdate=new JLabel("Current Date");
       //textfields
       searcht=new JTextField(15);
       medicinenamet=new JTextField(15);
       tabletsno=new JTextField(3);
       ratet=new JTextField(5);
       totalt=new JTextField(6);
       currentdatet=new JTextField(10);
       //textarea
       bill=new JTextArea(10,25);
       bill.setFont(new Font("monospaced",Font.PLAIN,10));
       JScrollPane bsp=new JScrollPane(bill);
       //JTextArea.setTabSize(...);
       //bill.setEnabled(false);
       //choice
       c=new Choice();
       c.addItem("tablets");
       c.addItem("card");
       //buttons
       add=new JButton("Add");
       back=new JButton("back");
       clear=new JButton("clear");
       print=new JButton("print");
       gotoprint=new JButton("go to print");
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
        currentdate.setBounds(500,50,100,25);
        currentdatet.setBounds(700,50,100,25);
        back.setBounds(50,50,100,50);
        search.setBounds(50,125,100,25);
        searcht.setBounds(200,125,100,25);
        jsp1.setBounds(50,175,400,200);
        bsp.setBounds(50,450,300,200);
        gotoprint.setBounds(50,675,100,25);
        medicinename.setBounds(500,175,100,25);
        medicinenamet.setBounds(700,175,100,25);
        c.setBounds(500,225,100,25);
        tabletsno.setBounds(700,225,100,25);
        rate.setBounds(500,275,100,25);
        ratet.setBounds(700,275,100,25);
        add.setBounds(500,325,100,25);
        print.setBounds(500,375,100,25);
        clear.setBounds(700,325,100,25);
        jsp2.setBounds(450,450,350,200);
        total.setBounds(450,675,100,25);
        totalt.setBounds(700,675,100,25);
        //add
        add(back);
        add(currentdate);
        add(currentdatet);
        add(search);
        add(searcht);
        add(jsp1);
        add(bsp);
        add(gotoprint);
        add(medicinename);
        add(medicinenamet);
        add(c);
        add(tabletsno);
        add(rate);
        add(ratet);
        add(add);
        add(print);
        add(clear);
        add(jsp2);
        add(total);
        add(totalt);
        //listener
        searcht.addKeyListener(this);
        add.addActionListener(this);
        back.addActionListener(this);
        clear.addActionListener(this);
        print.addActionListener(this);
        gotoprint.addActionListener(this);
        searchtable.addMouseListener(this);
        addedtable.addMouseListener(this);
        tabletsno.addKeyListener(this);
        c.addItemListener(this);
        currentdatem();
   }
   public void currentdatem(){
    LocalDate date=LocalDate.now();
    currentdatet.setText(date.toString());
    currentdatet.setEnabled(false);
   }
   public void totalamount(){
       int tot=0;
       try{
       for(int c=0;c<model2.getRowCount();c++){
        tot+=Integer.valueOf(model2.getValueAt(c,2).toString());
       }
       totalt.setText(String.valueOf(tot));
   }
   catch(Exception j){
       System.out.println(j);
   }
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
            String chct="";
             if(c.getSelectedItem()=="card"){
                 chct="card "+tabletsno.getText();
                 model2.addRow(new Object[]{medicinenamet.getText(),chct,ratet.getText()});
			totalamount();
             }
             else if(c.getSelectedItem()=="tablets"){
                 chct="tablets "+tabletsno.getText();
                 model2.addRow(new Object[]{medicinenamet.getText(),chct,ratet.getText()});
		totalamount();
             }
             medicinenamet.setText("");
             tabletsno.setText("");
             ratet.setText("");
             
         }
         else if(e.getSource()==clear){
             medicinenamet.setText("");
             tabletsno.setText("");
             ratet.setText("");
         }
         else if(e.getSource()==print){
            DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy/mm/dd HH:mm:ss");
            LocalDateTime now=LocalDateTime.now();
            bill.setText(bill.getText()+"***************************************************************************"+"\n");
            bill.setText(bill.getText()+"         Medical bill     "+""+dtf.format(now)+"\n");
            bill.setText(bill.getText()+"---------------------------------------------------------------------------"+"\n");
            bill.setText(bill.getText()+"    Medicine name       "+"Quality            "+"Rate"+"\n");
            for(int c=0;c<model2.getRowCount();c++){
               //1st column  for()
              int len1=model2.getValueAt(c,0).toString().length();  
               for(int j=len1;j<20;j++){
                   if(j==len1){
                    bill.setText(bill.getText()+"   "+model2.getValueAt(c,0));
                   }
                   else{
                       bill.setText(bill.getText()+" ");
                   }
               }
              //2nd column   for()
              len1=model2.getValueAt(c,1).toString().length();
              for(int j=len1;j<20;j++){
                  if(j==len1){
                      bill.setText(bill.getText()+""+model2.getValueAt(c,1));
                  }
                  else{
                    bill.setText(bill.getText()+" ");
                  }
              }
              //3rd column for()
              len1=model2.getValueAt(c,2).toString().length();
              for(int j=len1;j<20;j++){
                  if(j==len1){
                      bill.setText(bill.getText()+""+model2.getValueAt(c,2));
                  }
                  else{
                      bill.setText(bill.getText()+"");
                  }
              }
              try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical","root","");
                Statement stmt=con.createStatement();
                String torc[]=model2.getValueAt(c,1).toString().split(" ");
                int torcn=Integer.valueOf(torc[1].toString());
                int n=0;
                if(torc[0].equals("tablets")){
                    stmt.executeUpdate("update medicine set totnumoftablets=totnumoftablets-"+torcn+" where medicinename='"+model2.getValueAt(c,0).toString()+"'");
                }
                else if(torc[0].equals("card")){
                    ResultSet ry=stmt.executeQuery("select onecardquantity from medicine where medicinename='"+model2.getValueAt(c,0).toString()+"'");
                    while(ry.next()){
                   n=ry.getInt(1)*torcn;
                }
                stmt.executeUpdate("update medicine set totnumoftablets=totnumoftablets-"+n+" where medicinename='"+model2.getValueAt(c,0).toString()+"'");
            }
            //LocalTime time=LocalTime.now();
           // String t=time.toString();
           // t=t.substring(0,8);
            stmt.executeUpdate("insert into solditem values('"+java.time.LocalDate.now()+"','"+java.time.LocalTime.now().toString().substring(0,8)+"','"+model2.getValueAt(c,0).toString()+"','"+model2.getValueAt(c,1).toString()+"',"+Integer.valueOf(model2.getValueAt(c,2).toString())+")");
            }
            catch(Exception m){
                System.out.println(m);
            }
              bill.setText(bill.getText()+"\n");
            }
            bill.setText(bill.getText()+"\n");
            bill.setText(bill.getText()+"\n");
            bill.setText(bill.getText()+"                       Total Rate = "+totalt.getText());
           model2.setRowCount(0);
            
         }
         else if(e.getSource()==gotoprint){
            try{
               bill.print();
            }
            catch(Exception y){
                System.out.println(y);
            }
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
                                        ocquantity=rx.getInt(4);
                                        ocrate=rx.getInt(5);
                                        tntablets=rx.getInt(6);
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
            if(tabletsno.getText().toString().equals("")||tabletsno.getText().toString().contains(" ")){
                ratet.setText("");
            }
            else{
            tno=Integer.valueOf(tabletsno.getText().toString());
            rt=tno*orate;
            r=String.valueOf(rt);
            ratet.setText(r);
            }
            }
            else if(c.getSelectedItem()=="card"){
            if(tabletsno.getText().toString().equals("")||tabletsno.getText().toString().contains(" ")){
                ratet.setText("");
            }
            else{
            tno=Integer.valueOf(tabletsno.getText().toString());
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
        int selected;
         if(e.getSource()==searchtable){
            selected=searchtable.getSelectedRow();
            medicinenamet.setText(model1.getValueAt(selected,1).toString());
            ratet.setText(model1.getValueAt(selected,2).toString());
            c.select("tablets");
            String i="1";
            tabletsno.setText(i);
            searcht.setText("");
            model1.setRowCount(0);

         }
         else if(e.getSource()==addedtable){
            selected=addedtable.getSelectedRow();
            medicinenamet.setText(model2.getValueAt(selected,0).toString());
            String spitem=model2.getValueAt(selected,1).toString();
            String spitemarr[]=spitem.split(" ");
            c.select(spitemarr[0]);
            tabletsno.setText(spitemarr[1]);
            ratet.setText(model2.getValueAt(selected,2).toString());
            model2.removeRow(addedtable.getSelectedRow());
            totalamount();
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
    if(!medicinenamet.getText().toString().equals("")&&!tabletsno.getText().toString().equals("")&&!ratet.getText().toString().equals("")){
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
    else {

    }
}
}

}
