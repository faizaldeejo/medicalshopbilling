import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
class databaseserver extends JFrame implements ActionListener,MouseListener,KeyListener{
    JLabel search,medicinename,oncerate,onecardquantity,onecardrate,totnumoftablets;
    JTextField searcht,medicinenamet,onceratet,onecardquantityt,onecardratet,totnumoftabletst;
    JButton save,delete,back;
    DefaultTableModel model1=new DefaultTableModel();
    DefaultTableModel model2=new DefaultTableModel();
   JTable dbdetails=new JTable(model1);
   JTable searchdetails=new JTable(model2);
    public databaseserver(){
        setLayout(new FlowLayout());
        //JLabels
        search=new JLabel("search");
        medicinename=new JLabel("medicine name");
        oncerate=new JLabel("once rate");
        onecardquantity=new JLabel("one card quantity");
        onecardrate=new JLabel("one card rate");
        totnumoftablets=new JLabel("tot numof tablets");
        //JTextFields
        medicinenamet=new JTextField(15);
        onceratet=new JTextField(3);
        onecardquantityt=new JTextField(2);
        onecardratet=new JTextField(4);
        totnumoftabletst=new JTextField(5);
        searcht=new JTextField(15);
        //JButton
        save=new JButton("Save");
        delete=new JButton("Delete");
        back=new JButton("back");
        //JTable
        int searchdetailsv=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int searchdetailsh=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        JScrollPane jsp1=new JScrollPane(searchdetails,searchdetailsv,searchdetailsh);
        int dbdetailsv=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int dbdetailsh=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        JScrollPane jsp2=new JScrollPane(dbdetails,dbdetailsv,dbdetailsh);
        model1.addColumn("medicine name");
        model1.addColumn("once rate");
        model1.addColumn("one card quantity");
        model1.addColumn("one card rate");
        model1.addColumn("tot numof tablets");
        model2.addColumn("medicine name");
        model2.addColumn("once rate");
        model2.addColumn("one card quantity");
        model2.addColumn("one card rate");
        model2.addColumn("tot numof tablets");
        //add
        add(back);
        add(medicinename);
        add(medicinenamet);
        add(oncerate);
        add(onceratet);
        add(onecardquantity);
        add(onecardquantityt);
        add(onecardrate);
        add(onecardratet);
        add(totnumoftablets);
        add(totnumoftabletst);
        add(save);
        add(delete);
        add(search);
        add(searcht);
        add(jsp1);
        add(jsp2);
        //listeners
        back.addActionListener(this);
        save.addActionListener(this);
        delete.addActionListener(this);
        searcht.addKeyListener(this);
        dbdetails.addMouseListener(this);
        searchdetails.addMouseListener(this);
    }
    //actionmethod
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==back){
            server server2=new server();
            server2.setSize(500,500);
            server2.setVisible(true);
            dispose();
        }
    }
    //keymethods
    public void keyTyped(KeyEvent e) {        
    }
    public void keyReleased(KeyEvent e){
       }
    public void keyPressed(KeyEvent e) {
    }
    //mousemethods
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
    //mainfunction
    
}