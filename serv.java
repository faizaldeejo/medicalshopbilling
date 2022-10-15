import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
class serv extends JFrame implements ActionListener,KeyListener,MouseListener{
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
JLabel ssearch,smedicinename,soncerate,sonecardquantity,sonecardrate,stotnumoftablets,seditmedicinename,seditoncerate,seditonecardquantity,seditonecardrate,sedittonumoftablets;
JTextField ssearcht,smedicinenamet,sonceratet,sonecardquantityt,sonecardratet,stotnumoftabletst,seditmedicinenamet,seditonceratet,seditonecardquantityt,seditonecardratet,sedittonumoftabletst;
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
sedittonumoftablets=new JLabel("tot num of tablets");
               //textfield
//addandedit textfields
aesearcht=new JTextField(15);
aeempnamet=new JTextField(10);
aeemppasst=new JTextField(10);
editempnamet=new JTextField(10);
editemppasst=new JTextField(10);
//medicine textfields
ssearcht=new JTextField(15);
smedicinenamet=new JTextField(15);
sonceratet=new JTextField(3);
sonecardquantityt=new JTextField(3);
sonecardratet=new JTextField(4);
stotnumoftabletst=new JTextField(5);
seditmedicinenamet=new JTextField(15);
seditonceratet=new JTextField(3);
seditonecardquantityt=new JTextField(3);
seditonecardratet=new JTextField(4);
sedittonumoftabletst=new JTextField(5);
                 //button
//serbutton
back=new JButton("back");
addemployeeandedit=new JButton("add employee and edit");
medicinedetails=new JButton("medicine details");
//addandeditbutton                 
aeadd=new JButton("add");
aesave=new JButton("save");
aedelete=new JButton("delete");
aecancel=new JButton("cancel");
//medicine button
ssave=new JButton("save");
sdelete=new JButton("delete");
scancel=new JButton("cancel");
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
smodel1.addColumn("medicine name");
smodel1.addColumn("once rate");
smodel1.addColumn("one card quantity");
smodel1.addColumn("one card rate");
smodel1.addColumn("tot num of tablets");
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
        sedittonumoftablets.setVisible(false);
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
        sedittonumoftabletst.setVisible(false);
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
        jsp2.setBounds(500,450,250,250);
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
        sedittonumoftablets.setBounds(50,625,100,25);
        sedittonumoftabletst.setBounds(200,625,100,25);
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
        add(sedittonumoftablets);
        add(sedittonumoftabletst);
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
        aedetailstable.addMouseListener(this);
        //medicine mouse
        ssearchtable.addMouseListener(this);
        sdetailstable.addMouseListener(this);
}
         //actionmethods
    //addandedit action methos
    public void actionPerformed(ActionEvent e){
            if(e.getSource()==back){
                    employee employee2=new employee();
                    employee2.setSize(500,500);
                    employee2.setVisible(true);
                    dispose();
            }
           else if(e.getSource()==addemployeeandedit){

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
        sedittonumoftablets.setVisible(false);
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
        sedittonumoftabletst.setVisible(false);
        ssave.setVisible(false);
        sdelete.setVisible(false);
        scancel.setVisible(false);
        sadd.setVisible(false);
        jsp3.setVisible(false);
        jsp4.setVisible(false);    
           

}
           else if(e.getSource()==medicinedetails){
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
        sedittonumoftablets.setVisible(true);
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
        sedittonumoftabletst.setVisible(true);
        ssave.setVisible(true);
        sdelete.setVisible(true);
        scancel.setVisible(true);
        sadd.setVisible(true);
        jsp3.setVisible(true);
        jsp4.setVisible(true);
          
 }
    }
            //keymethos
    //addandedit key methos
     public void keyTyped(KeyEvent e) {        
    }
    public void keyReleased(KeyEvent e){
       }
    public void keyPressed(KeyEvent e) {
    }
               //mousemethos
    //addandeidt mouse methos
     public void mouseClicked(MouseEvent e){
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


