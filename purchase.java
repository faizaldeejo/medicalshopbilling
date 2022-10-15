import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class purchase extends JFrame implements ActionListener,MouseListener,KeyListener{
    JLabel search,medicinename,rate;
    JTextField searcht,medicinenamet,tabletsno,ratet;
    JButton add,back;
    Choice c;
     DefaultTableModel model1=new DefaultTableModel();
    DefaultTableModel model2=new DefaultTableModel();
   JTable searchtable=new JTable(model1);
   JTable addedtable=new JTable(model2);
   public purchase(){
       //labels
       setLayout(new FlowLayout());
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

        model1.addColumn("medicine name");
        model1.addColumn("once rate");
        model1.addColumn("one card quantity");
        model1.addColumn("one card rate");
        model1.addColumn("tot numof tablets");
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
        add(jsp2);
        //listener
        searcht.addKeyListener(this);
        add.addActionListener(this);
        back.addActionListener(this);
        searchtable.addMouseListener(this);
   }
     //action methos
     public void actionPerformed(ActionEvent e){
         if(e.getSource()==back){
             employee employee1=new employee();
             employee1.setSize(500,500);
              employee1.setVisible(true);
              dispose();
         }
         else if(e.getSource()==add){

         }
     }
     //keylistener
      public void keyTyped(KeyEvent e) {        
    }
    public void keyReleased(KeyEvent e){
       }
    public void keyPressed(KeyEvent e) {
    }
    //mouselistener
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

    //main function
    /*
    public static void main(String []args){
        purchase ob=new purchase();
        ob.setSize(700,700);
        ob.setVisible(true);
    }*/
}
