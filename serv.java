import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
class serv extends JFrame implements ActionListener,KeyListener,MouseListener
{
                           //variable
String emid="";
int mno;
String medname="";
int orate,ocquantity,ocrate,tntablets;
//ser buttons
JButton addemployeeandedit,medicinedetails,back;
                   //Lables
//addempandedit
JLabel aesearch,aeempname,aeemppass,editempname,editemppass;
JTextField aesearcht,aeempnamet,aeemppasst,editempnamet,editemppasst;
JButton aeadd,aesave,aecancel,aedelete;
DefaultTableModel aemodel1=new DefaultTableModel();
DefaultTableModel aemodel2=new DefaultTableModel();
JTable aesearchtable=new JTable(aemodel1);
JTable aedetailstable=new JTable(aemodel2);
//medicinedetails
JLabel ssearch,smedicinename,soncerate,sonecardquantity,sonecardrate,stotnumoftablets,seditmedicinename,seditoncerate,seditonecardquantity,seditonecardrate,sedittotnumoftablets;
JTextField ssearcht,smedicinenamet,sonceratet,sonecardquantityt,sonecardratet,stotnumoftabletst,seditmedicinenamet,seditonceratet,seditonecardquantityt,seditonecardratet,sedittotnumoftabletst;
JButton ssave,sdelete,scancel,sadd;
DefaultTableModel smodel1=new DefaultTableModel();
DefaultTableModel smodel2=new DefaultTableModel();
JTable ssearchtable=new JTable(smodel1);
JTable sdetailstable=new JTable(smodel2);
                       //scrolpan to tabl
//addandedit scrolpan
        int aesearchtablev=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int aesearchtableh=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        JScrollPane jsp1=new JScrollPane(aesearchtable,aesearchtablev,aesearchtableh);
        int aedetailstablev=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int aedetailstableh=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        JScrollPane jsp2=new JScrollPane(aedetailstable,aedetailstablev,aedetailstableh);
//medicine scrolpan
        int ssearchtablev=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int ssearchtableh=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        JScrollPane jsp3=new JScrollPane(ssearchtable,ssearchtablev,ssearchtableh);
        int sdetailstablev=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int sdetailstableh=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        JScrollPane jsp4=new JScrollPane(sdetailstable,sdetailstablev,sdetailstableh);
public serv(){
    setLayout(null);
                //lable                
 //addandeditlables               
        aesearch=new JLabel("search");
        aeempname=new JLabel("empname");
        aeemppass=new JLabel("emppass");
        editempname=new JLabel("editempname");
        editemppass=new JLabel("editpass");
//medicine lables
        ssearch=new JLabel("search");
        smedicinename=new JLabel("medicine name");
        soncerate=new JLabel("once rate");
        sonecardquantity=new JLabel("one card quantity");
        sonecardrate=new JLabel("one card rate");
        stotnumoftablets=new JLabel("tot num of tablets");
        seditmedicinename=new JLabel("medicine name");
        seditoncerate=new JLabel("once rate");
        seditonecardquantity=new JLabel("one card quantity");
        seditonecardrate=new JLabel("one card rate");
        sedittotnumoftablets=new JLabel("tot num of tablets");
               //textfield
//addandedit textfields
        aesearcht=new JTextField(15);
        aesearcht.requestFocusInWindow();
        aeempnamet=new JTextField(10);
        aeemppasst=new JTextField(8);
        editempnamet=new JTextField(10);
        editempnamet.setEnabled(false);
        editemppasst=new JTextField(8);
        editemppasst.setEnabled(false);
//medicine textfields
        ssearcht=new JTextField(15);
        smedicinenamet=new JTextField(15);
        sonceratet=new JTextField(3);
        sonecardquantityt=new JTextField(3);
        sonecardratet=new JTextField(4);
        stotnumoftabletst=new JTextField(5);
        seditmedicinenamet=new JTextField(15);
        seditmedicinenamet.setEnabled(false);
        seditonceratet=new JTextField(3);
        seditonceratet.setEnabled(false);
        seditonecardquantityt=new JTextField(3);
        seditonecardquantityt.setEnabled(false);
        seditonecardratet=new JTextField(4);
        seditonecardratet.setEnabled(false);
        sedittotnumoftabletst=new JTextField(5);
        sedittotnumoftabletst.setEnabled(false);
                 //button
//serbutton
        back=new JButton("back");
        addemployeeandedit=new JButton("add employee and edit");
        medicinedetails=new JButton("medicine details");
//addandeditbutton                 
        aeadd=new JButton("add");
        aesave=new JButton("save");
        aesave.setEnabled(false);
        aedelete=new JButton("delete");
        aedelete.setEnabled(false);
        aecancel=new JButton("cancel");
        aecancel.setEnabled(false);
//medicine button
        ssave=new JButton("save");
        ssave.setEnabled(false);
        sdelete=new JButton("delete");
        sdelete.setEnabled(false);
        scancel=new JButton("cancel");
        scancel.setEnabled(false);
        sadd=new JButton("add");
                  //modles to table
//addandedit modles
        aemodel1.addColumn("Eid");
        aemodel1.addColumn("empname");
        aemodel1.addColumn("emppass");
        aemodel2.addColumn("Eid");
        aemodel2.addColumn("empname");
        aemodel2.addColumn("emppass");
//medicine modles
        smodel1.addColumn("mno");
        smodel1.addColumn("medicine name");
        smodel1.addColumn("once rate");
        smodel1.addColumn("one card quantity");
        smodel1.addColumn("one card rate");
        smodel1.addColumn("tot num of tablets");
        smodel2.addColumn("mno");
        smodel2.addColumn("medicine name");
        smodel2.addColumn("once rate");
        smodel2.addColumn("one card quantity");
        smodel2.addColumn("one card rate");
        smodel2.addColumn("tot num of tablets");         
                            //visibles
//addandedit visibles
        aesearch.setVisible(true);
        aeempname.setVisible(true);
        aeemppass.setVisible(true);
        editempname.setVisible(true);
        editemppass.setVisible(true);
        aesearcht.setVisible(true);
        aeempnamet.setVisible(true);
        aeemppasst.setVisible(true);
        editempnamet.setVisible(true);
        editemppasst.setVisible(true);
        aeadd.setVisible(true);
        aesave.setVisible(true);
        aecancel.setVisible(true);
        aedelete.setVisible(true);
        jsp1.setVisible(true);
        jsp2.setVisible(true);
//medicine visibles
        ssearch.setVisible(false);
        smedicinename.setVisible(false);
        soncerate.setVisible(false);
        sonecardquantity.setVisible(false);
        sonecardrate.setVisible(false);
        stotnumoftablets.setVisible(false);
        seditmedicinename.setVisible(false);
        seditoncerate.setVisible(false);
        seditonecardquantity.setVisible(false);
        seditonecardrate.setVisible(false);
        sedittotnumoftablets.setVisible(false);
        ssearcht.setVisible(false);
        smedicinenamet.setVisible(false);
        sonceratet.setVisible(false);
        sonecardquantityt.setVisible(false);
        sonecardratet.setVisible(false);
        stotnumoftabletst.setVisible(false);
        seditmedicinenamet.setVisible(false);
        seditonceratet.setVisible(false);
        seditonecardquantityt.setVisible(false);
        seditonecardratet.setVisible(false);
        sedittotnumoftabletst.setVisible(false);
        ssave.setVisible(false);
        sdelete.setVisible(false);
        scancel.setVisible(false);
        sadd.setVisible(false);
        jsp3.setVisible(false);
        jsp4.setVisible(false);
                    //setBounds
//ser setbounds
        back.setBounds(50,50,100,25);
        addemployeeandedit.setBounds(250,50,200,25);
        medicinedetails.setBounds(550,50,200,25);
//addandedit setbound
        aesearch.setBounds(50,125,100,25);
        aesearcht.setBounds(200,125,100,25);
        jsp1.setBounds(50,200,250,200);
        editempname.setBounds(50,475,100,25);
        editempnamet.setBounds(200,475,100,25);
        editemppass.setBounds(50,550,100,25);
        editemppasst.setBounds(200,550,100,25);
        aesave.setBounds(50,650,100,25);
        aedelete.setBounds(200,650,100,25);
        aecancel.setBounds(50,700,100,25);
        aeempname.setBounds(500,200,100,25);
        aeempnamet.setBounds(650,200,100,25);
        aeemppass.setBounds(500,275,100,25);
        aeemppasst.setBounds(650,275,100,25);
        aeadd.setBounds(500,350,100,25);
        jsp2.setBounds(500,450,250,150);
//medicine setbounds
        ssearch.setBounds(50,125,100,25);
        ssearcht.setBounds(200,125,100,25);
        jsp3.setBounds(50,200,250,200);
        seditmedicinename.setBounds(50,425,100,25);
        seditmedicinenamet.setBounds(200,425,100,25);
        seditoncerate.setBounds(50,475,100,25);
        seditonceratet.setBounds(200,475,100,25);
        seditonecardquantity.setBounds(50,525,100,25);
        seditonecardquantityt.setBounds(200,525,100,25);
        seditonecardrate.setBounds(50,575,100,25);
        seditonecardratet.setBounds(200,575,100,25);
        sedittotnumoftablets.setBounds(50,625,100,25);
        sedittotnumoftabletst.setBounds(200,625,100,25);
        ssave.setBounds(50,675,100,25);
        sdelete.setBounds(200,675,100,25);
        scancel.setBounds(50,725,100,25);
        smedicinename.setBounds(450,125,100,25);
        smedicinenamet.setBounds(600,125,100,25);
        soncerate.setBounds(450,175,100,25);
        sonceratet.setBounds(600,175,100,25);
        sonecardquantity.setBounds(450,225,100,25);
        sonecardquantityt.setBounds(600,225,100,25);
        sonecardrate.setBounds(450,275,100,25);
        sonecardratet.setBounds(600,275,100,25);
        stotnumoftablets.setBounds(450,325,100,25);
        stotnumoftabletst.setBounds(600,325,100,25);
        sadd.setBounds(450,375,100,25);
        jsp4.setBounds(450,425,250,300);
                     //add
//ser add
        add(back);
        add(addemployeeandedit);
        add(medicinedetails);
//addandedit add
        add(aesearch);
        add(aesearcht);
        add(jsp1);
        add(editempname);
        add(editempnamet);
        add(editemppass);
        add(editemppasst);
        add(aesave);
        add(aedelete);
        add(aecancel);
        add(aeempname);
        add(aeempnamet);
        add(aeemppass);
        add(aeemppasst);
        add(aeadd);
        add(jsp2);
//medicine add
        add(ssearch);
        add(ssearcht);
        add(jsp3);
        add(seditmedicinename);
        add(seditmedicinenamet);
        add(seditoncerate);
        add(seditonceratet);
        add(seditonecardquantity);
        add(seditonecardquantityt);
        add(seditonecardrate);
        add(seditonecardratet);
        add(sedittotnumoftablets);
        add(sedittotnumoftabletst);
        add(ssave);
        add(sdelete);
        add(scancel);       
        add(smedicinename);
        add(smedicinenamet);
        add(soncerate);
        add(sonceratet);
        add(sonecardquantity);
        add(sonecardquantityt);
        add(sonecardrate);
        add(sonecardratet);
        add(stotnumoftablets);
        add(stotnumoftabletst);
        add(sadd);
        add(jsp4);
                        //listener
//ser listener
        addemployeeandedit.addActionListener(this);
        medicinedetails.addActionListener(this);
        back.addActionListener(this);
//addandedit
        aeadd.addActionListener(this);
        aesave.addActionListener(this);
        aecancel.addActionListener(this);
        aedelete.addActionListener(this);
//medicine
        ssave.addActionListener(this);
        sdelete.addActionListener(this);
        scancel.addActionListener(this);
        sadd.addActionListener(this);
                         //keylistener
//addandedit key
        aesearcht.addKeyListener(this);
//medicine key
        ssearcht.addKeyListener(this);
                         //mouselistner
 //addandeidt mouse
        aesearchtable.addMouseListener(this);
        //aedetailstable.addMouseListener(this);
//medicine mouse
        ssearchtable.addMouseListener(this);
        //sdetailstable.addMouseListener(this);
         ssearcht.requestFocusInWindow();
                    //employee db function
        empdisplay();
        medicaldisplay();
}                                                         
                        //display method to aesearchtable
public void empdisplay()
{
        try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical","root","");
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("select * from employee");
                while(rs.next()){
                        aemodel2.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3)});           
                }
                aedetailstable.setEnabled(false);
        }
        catch(Exception x){
                System.out.println(x);
        }
}
                        //display method to ssearchtable
public void medicaldisplay()
{
        try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical","root","");
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("select * from medicine");
                while(rs.next()){
                        smodel2.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6)});           
                }
                sdetailstable.setEnabled(false);
        }
        catch(Exception j){
                System.out.println(j);
        }

}
                          //actionmethods
        //addandedit action methos
public void actionPerformed(ActionEvent e){
        if(e.getSource()==back){
                employee employee2=new employee();
                employee2.setSize(600,500);
                employee2.setVisible(true);
                dispose();
        }
        else if(e.getSource()==addemployeeandedit)
        {
        //addandedit visibles
                aesearch.setVisible(true);aeempname.setVisible(true);aeemppass.setVisible(true);editempname.setVisible(true);editemppass.setVisible(true);
                aesearcht.setVisible(true);
                aeempnamet.setVisible(true);
                aeemppasst.setVisible(true);
                editempnamet.setVisible(true);
                editemppasst.setVisible(true);
                aeadd.setVisible(true);
                aesave.setVisible(true);
                aecancel.setVisible(true);
                aedelete.setVisible(true);
                jsp1.setVisible(true);
                jsp2.setVisible(true);
        //medicine visibles
                ssearch.setVisible(false);
                smedicinename.setVisible(false);
                soncerate.setVisible(false);
                sonecardquantity.setVisible(false);
                sonecardrate.setVisible(false);
                stotnumoftablets.setVisible(false);
                seditmedicinename.setVisible(false);
                seditoncerate.setVisible(false);
                seditonecardquantity.setVisible(false);
                seditonecardrate.setVisible(false);
                sedittotnumoftablets.setVisible(false);
                ssearcht.setVisible(false);
                smedicinenamet.setVisible(false);
                sonceratet.setVisible(false);
                sonecardquantityt.setVisible(false);
                sonecardratet.setVisible(false);
                stotnumoftabletst.setVisible(false);
                seditmedicinenamet.setVisible(false);
                seditonceratet.setVisible(false);
                seditonecardquantityt.setVisible(false);
                seditonecardratet.setVisible(false);
                sedittotnumoftabletst.setVisible(false);
                ssave.setVisible(false);
                sdelete.setVisible(false);
                scancel.setVisible(false);
                sadd.setVisible(false);
                jsp3.setVisible(false);
                jsp4.setVisible(false);    
        }
        else if(e.getSource()==medicinedetails)
        {
        //addandedit visibles
                aesearch.setVisible(false);
                aeempname.setVisible(false);
                aeemppass.setVisible(false);
                editempname.setVisible(false);
                editemppass.setVisible(false);
                aesearcht.setVisible(false);
                aeempnamet.setVisible(false);
                aeemppasst.setVisible(false);
                editempnamet.setVisible(false);
                editemppasst.setVisible(false);
                aeadd.setVisible(false);
                aesave.setVisible(false);
                aecancel.setVisible(false);
                aedelete.setVisible(false);
                jsp1.setVisible(false);
	        jsp2.setVisible(false);
        //medicine visibles
                ssearch.setVisible(true);
                smedicinename.setVisible(true);
                soncerate.setVisible(true);
                sonecardquantity.setVisible(true);
                sonecardrate.setVisible(true);
                stotnumoftablets.setVisible(true);
                seditmedicinename.setVisible(true);
                seditoncerate.setVisible(true);
                seditonecardquantity.setVisible(true);
                seditonecardrate.setVisible(true);
                sedittotnumoftablets.setVisible(true);
                ssearcht.setVisible(true);
                smedicinenamet.setVisible(true);
                sonceratet.setVisible(true);
                sonecardquantityt.setVisible(true);
                sonecardratet.setVisible(true);
                stotnumoftabletst.setVisible(true);
                seditmedicinenamet.setVisible(true);
                seditonceratet.setVisible(true);
                seditonecardquantityt.setVisible(true);
                seditonecardratet.setVisible(true);
                sedittotnumoftabletst.setVisible(true);
                ssave.setVisible(true);
                sdelete.setVisible(true);
                scancel.setVisible(true);
                sadd.setVisible(true);
                jsp3.setVisible(true);
                jsp4.setVisible(true);     
        }
        else if(e.getSource()==aeadd)
        {
                int o=0;
                String aeaddempname=aeempnamet.getText(),aeaddemppass=aeemppasst.getText(),eid="em";
                if(aeaddempname.equals("")||aeaddemppass.equals(""))
                {
                        JOptionPane.showMessageDialog(this,"The employeename and Password are invalid..");
                }
                else if(aeaddempname.contains(" ")||aeaddemppass.contains(" "))
                {
                        JOptionPane.showMessageDialog(this,"don't make space..");
                }
                else if(!aeaddempname.equals("")&&!aeaddemppass.equals("")&&!aeaddempname.contains(" ")&&!aeaddemppass.contains(" "))
                {
                        try
                        {
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical","root","");
                                Statement stmt=con.createStatement();
                                ResultSet rs=stmt.executeQuery("select * from employee");
                                while(rs.next())
                                {
                                        String adempname=rs.getString(2);
                                        String ademppass=rs.getString(3);               
                                        if(aeaddempname.equals(adempname)&&aeaddemppass.equals(ademppass))
                                        {
                                                o++;
                                                 break;
                                         }
                    
                                }
                                if(o>0)
                                {
                                        JOptionPane.showMessageDialog(this,"its exists.. con't create acc..");
                                 }
                                else
                                {       
                                        ResultSet ry=stmt.executeQuery("select count(Eid) from employee");
                                        while(ry.next())
                                        {
                                                int count=ry.getInt(1);
                                                count++;
                                                 eid=eid+count;
                                        }
                                        stmt.executeUpdate("insert into employee values('"+eid+"','"+aeaddempname+"','"+aeaddemppass+"')");
                                        aemodel2.addRow(new Object[]{eid,aeaddempname,aeaddemppass});
                                        aeempnamet.setText("");
                                        aeemppasst.setText("");
                                }
                        }
                        catch(Exception z)
                        {
                                System.out.println(z);
                        }



                }
                else
                {                
                }
                aeempnamet.setText("");
                aeemppasst.setText("");
       
        }
        else if(e.getSource()==aesave)
        {
                try
                {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical","root","");
                        Statement stmt=con.createStatement();
                        String edempname=editempnamet.getText();
                        String edemppass=editemppasst.getText();
                        stmt.executeUpdate("update employee set username='"+edempname+"',password='"+edemppass+"' where Eid='"+emid+"'");
                        aesave.setEnabled(false);
                        aedelete.setEnabled(false);
                        aecancel.setEnabled(false);
                        editempnamet.setText("");
                        editemppasst.setText("");
                        editempnamet.setEnabled(false);
                        editemppasst.setEnabled(false);
                        aemodel2.setRowCount(0);
                        empdisplay();
                }
                catch(Exception t)
                {
                        System.out.println(t);
                }
        }
        else if(e.getSource()==aedelete)
        {
                try
                {
                         Class.forName("com.mysql.jdbc.Driver");
                        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical","root","");
                        Statement stmt=con.createStatement();
                        stmt.executeUpdate("delete from employee where Eid='"+emid+"'");
                        aesave.setEnabled(false);
                        aedelete.setEnabled(false);
                        aecancel.setEnabled(false);
                        editempnamet.setText("");
                        editemppasst.setText("");
                        editempnamet.setEnabled(false);
                        editemppasst.setEnabled(false);
                        aemodel2.setRowCount(0);
                        empdisplay();

                }
                catch(Exception y)
                {
                        System.out.println(y);
                }

        }
        else if(e.getSource()==aecancel)
        {
                editempnamet.setText("");
                editemppasst.setText("");
                editempnamet.setEnabled(false);
                editemppasst.setEnabled(false);
                aesave.setEnabled(false);
                aedelete.setEnabled(false);
                aecancel.setEnabled(false);
                
        }
        else if(e.getSource()==sadd){
                String addmedicinename=smedicinenamet.getText(),addoncerate=sonceratet.getText(),addonecardquantity=sonecardquantityt.getText(),addonecardrate=sonecardratet.getText(),addtotnumoftablets=stotnumoftabletst.getText();
                if((!addmedicinename.equals("")&&!addoncerate.equals("")&&!addonecardquantity.equals("")&&!addonecardrate.equals("")&&!addtotnumoftablets.equals(""))&&(!addmedicinename.contains(" ")&&!addoncerate.contains(" ")&&!addonecardquantity.contains(" ")&&!addonecardrate.contains(" ")&&!addtotnumoftablets.contains(" ")))
                {
                        int n=0,addmno=0;
                        try{
                                 Class.forName("com.mysql.jdbc.Driver");
                        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical","root","");
                        Statement stmt=con.createStatement();
                        ResultSet sr=stmt.executeQuery("select * from medicine");
                        while(sr.next()){
                                if(addmedicinename==sr.getString(2)){
                                        n++;
                                        break;
                                }
                        }
                        if(n>0){
                                JOptionPane.showMessageDialog(this,"its exists.. con't add newly..");
                        }
                        else{
                                ResultSet rc=stmt.executeQuery("select count(mno) from medicine");
                                while(rc.next()){
                                addmno=rc.getInt(1);
                                addmno++;
                        }
                                int addonceratei=Integer.valueOf(addoncerate),addonecardquantityi=Integer.valueOf(addonecardquantity),addonecardratei=Integer.valueOf(addonecardrate),addtotnumoftabletsi=Integer.valueOf(addtotnumoftablets);
                                stmt.executeUpdate("insert into medicine values("+addmno+",'"+addmedicinename+"',"+addonceratei+","+addonecardquantityi+","+addonecardratei+","+addtotnumoftabletsi+")");
                                smodel2.addRow(new Object[]{addmno,addmedicinename,addonceratei,addonecardquantityi,addonecardratei,addtotnumoftabletsi});
                                smedicinenamet.setText("");
                                sonceratet.setText("");
                                sonecardquantityt.setText("");
                                sonecardratet.setText("");
                                stotnumoftabletst.setText("");
                        }

                        }
                        catch(Exception j){
                                System.out.println(j);
                        }
                }
                else{
                       JOptionPane.showMessageDialog(this,"fill the fields.."); 
                }
        }
        else if(e.getSource()==ssave){
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical","root","");
                    Statement stmt=con.createStatement();
                     medname=seditmedicinenamet.getText();
                     orate=Integer.valueOf(seditonceratet.getText());
                     ocquantity=Integer.valueOf(seditonecardquantityt.getText());
                     ocrate=Integer.valueOf(seditonecardratet.getText());
                     tntablets=Integer.valueOf(sedittotnumoftabletst.getText());
                    stmt.executeUpdate("update medicine set medicinename='"+medname+"',oncerate= "+orate+",onecardquantity="+ocquantity+",onecardrate="+ocrate+",totnumoftablets="+tntablets+" where mno="+mno+""); 
                    mno=0;
                    seditmedicinenamet.setText("");
                    seditmedicinenamet.setEnabled(false);
                    seditonceratet.setText("");
                    seditonceratet.setEnabled(false);
                    seditonecardquantityt.setText("");
                    seditonecardquantityt.setEnabled(false);
                    seditonecardratet.setText(""); 
                    seditonecardratet.setEnabled(false);
                    sedittotnumoftabletst.setText("");
                    sedittotnumoftabletst.setEnabled(false);
                    ssave.setEnabled(false);
                    sdelete.setEnabled(false);
                    scancel.setEnabled(false);   
                }
                catch(Exception c){
                        System.out.println(c);
                }
        }
        else if(e.getSource()==sdelete){
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical","root","");
                    Statement stmt=con.createStatement();
                    stmt.executeUpdate("delete from medicine where mno="+mno+"");
                     mno=0;
                    seditmedicinenamet.setText("");
                    seditmedicinenamet.setEnabled(false);
                    seditonceratet.setText("");
                    seditonceratet.setEnabled(false);
                    seditonecardquantityt.setText("");
                    seditonecardquantityt.setEnabled(false);
                    seditonecardratet.setText(""); 
                    seditonecardratet.setEnabled(false);
                    sedittotnumoftabletst.setText("");
                    sedittotnumoftabletst.setEnabled(false);
                    ssave.setEnabled(false);
                    sdelete.setEnabled(false);
                    scancel.setEnabled(false);   
                }
                catch(Exception j){
                        System.out.println(j);
                }

        }
        else if(e.getSource()==scancel){
                    mno=0;
                    seditmedicinenamet.setText("");
                    seditmedicinenamet.setEnabled(false);
                    seditonceratet.setText("");
                    seditonceratet.setEnabled(false);
                    seditonecardquantityt.setText("");
                    seditonecardquantityt.setEnabled(false);
                    seditonecardratet.setText(""); 
                    seditonecardratet.setEnabled(false);
                    sedittotnumoftabletst.setText("");
                    sedittotnumoftabletst.setEnabled(false);
                    ssave.setEnabled(false);
                    sdelete.setEnabled(false);
                    scancel.setEnabled(false);

        }
        

}
                         //keymethos
//addandedit key methos
    public void keyTyped(KeyEvent e)
        {       
                if(e.getSource()==aesearcht)
                {
                     aemodel1.setRowCount(0);
                }
                else if(e.getSource()==ssearcht){
                        smodel1.setRowCount(0);
                } 
        }
    public void keyReleased(KeyEvent e)
        {
                if(e.getSource()==aesearcht)
                {
                        String ae=aesearcht.getText(),dbid="",dbusername="",dbpassword="";
                        try
                        {
                                if(ae.equals("")||ae.contains(" "))
                                {
                                }else{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical","root","");
                        Statement stmt=con.createStatement();
                        ResultSet rm=stmt.executeQuery("select * from employee where Eid like '"+ae+"%' ");
                        while(rm.next())
                        {
                                dbid=rm.getString(1);
                                dbusername=rm.getString(2);
                                dbpassword=rm.getString(3);
                                aemodel1.addRow(new Object[]{dbid,dbusername,dbpassword});
                        }
                                }
                        }
                        catch(Exception m)
                        {
                        System.out.println(m);
                        }
                }
                else if(e.getSource()==ssearcht)
                {
                        String mname=ssearcht.getText();
                        try{
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
                                        smodel1.addRow(new Object[]{mno,medname,orate,ocquantity,ocrate,tntablets});
                                }
                                }
                        }
                        catch(Exception p){
                                System.out.println(p);
                        }
                }
        }
    public void keyPressed(KeyEvent e)
        {
        }
                    //mousemethos
//addandeidt mouse methos
    public void mouseClicked(MouseEvent e)
        {
                int selected;
                if(e.getSource()==aesearchtable)
                {
                        selected=aesearchtable.getSelectedRow();
                        emid=(aemodel1.getValueAt(selected,0).toString());
                        editempnamet.setEnabled(true);
                        editempnamet.setText(aemodel1.getValueAt(selected,1).toString());
                        editemppasst.setEnabled(true);
                        editemppasst.setText(aemodel1.getValueAt(selected,2).toString());
                        aesave.setEnabled(true);
                        aedelete.setEnabled(true);
                        aecancel.setEnabled(true);
                        aesearcht.setText("");
                        aemodel1.setRowCount(0);
                }
                else if(e.getSource()==ssearchtable){
                        selected=ssearchtable.getSelectedRow();
                        mno=Integer.valueOf((smodel1.getValueAt(selected,0).toString()));
                        seditmedicinenamet.setEnabled(true);
                        seditmedicinenamet.setText(smodel1.getValueAt(selected,1).toString());
                        seditonceratet.setEnabled(true);
                        seditonceratet.setText(smodel1.getValueAt(selected,2).toString());
                        seditonecardquantityt.setEnabled(true);
                        seditonecardquantityt.setText(smodel1.getValueAt(selected,3).toString());
                        seditonecardratet.setEnabled(true);
                        seditonecardratet.setText(smodel1.getValueAt(selected,4).toString());
                        sedittotnumoftabletst.setEnabled(true);
                        sedittotnumoftabletst.setText(smodel1.getValueAt(selected,5).toString());
                        ssave.setEnabled(true);
                        sdelete.setEnabled(true);
                        scancel.setEnabled(true);
                        ssearcht.setText("");
                        smodel1.setRowCount(0);
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
}


