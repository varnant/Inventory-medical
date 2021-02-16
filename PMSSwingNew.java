

//Swing Packages

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.table.*;
import javax.swing.plaf.metal.*;
import javax.swing.border.*;
import javax.swing.JOptionPane;  


//DataBase Packages

import java.io.*;
import java.sql.*;

//Main Class

class PMSSwingNew extends JFrame implements ActionListener,FocusListener
{
  private Statement st;
  private Connection con;

  //List of Labels

  private JLabel lblOldMedicineID;
  private JLabel lblMedicineID;
  private JLabel lblMediTitle;
  private JLabel lblQty;
  private JLabel lblPrice;
  private JLabel lblCompanyname;
  private JLabel lblcomp;

  //List of TextFields

  private JTextField txtOldMedicineID;
  private JTextField txtMedicineID;
  private JTextField txtMedicineIDFoucs;
  private JTextField txtMediTitle;
  private JTextField txtQty;
  private JTextField txtPrice;
  private JTextField txtCompanyname;

  //List of Buttons

  private JButton btnSaveAdd,btnSaveUpdate;
  private JButton btnSaveEdit;
  private JButton btnSaveDelete;
  private JButton btnAdd;
  private JButton btnEdit;
  private JButton btnDelete;
  private JButton btnExit;
  private JButton btnRefresh;
  private JButton btnCancel;
  private JButton btnSearch;// modi..
  private JButton btnFind;//modi..

  //List of Panel

  private JPanel btnpanel;
  private JPanel panel;
  

  //Table
  
  private JTable table;
  private DefaultTableModel tmodel;

  //Container

  private Container cpane;
  

  PMSSwingNew()
  {
System.out.println("varnan @cometsoftwares");
  }
		
	
  PMSSwingNew(int choice)
  {
    switch(choice)
    {
      case 1:
        //Initial Window

        setTitle("PHARMACY MANAGEMENT SYSTEM-varnan @comet");      //set the title
        setBounds(275, 250, 550, 210);               // set the size of frame..
        setResizable(true);                          //can be maximized..earlier it was false...
        setIconImage (getToolkit().getImage ("health.jpg"));
        addWindowListener(new MyWindowAdapter());
       // loadSplashScreen();// how it is run directly??
		//dispMainFrame();

        //s.dispose();


          //cotainer

        cpane = getContentPane();

        //components

        tmodel = new DefaultTableModel();//??
        table = new JTable(tmodel);
        SetColHeader();

        btnpanel = new JPanel(new GridLayout(1, 6, 5,0));
        btnAdd = new JButton ("Add");
        btnEdit = new JButton ("Edit");
        btnDelete = new JButton ("Delete");
        btnRefresh = new JButton ("Refresh");
        btnExit = new JButton ("Issue");
		btnSearch = new JButton("Search");

        btnAdd.addActionListener(this);
        btnEdit.addActionListener(this);
        btnDelete.addActionListener(this);
        btnRefresh.addActionListener(this);
        btnExit.addActionListener(this);
		btnSearch.addActionListener(this);

        btnpanel.add(btnAdd);
		btnpanel.add(btnExit);
        btnpanel.add(btnEdit);
        btnpanel.add(btnDelete);
		btnpanel.add(btnSearch);
		btnpanel.add(btnRefresh);
	    
        
		
		int v= ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int m= ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		JScrollPane jsp = new JScrollPane(table,v,m);
        
		cpane.add(jsp);
        cpane.add(btnpanel, BorderLayout.SOUTH);// why dont we initialize setlayout(new borderlayout())???

        break;
//..............................................................................................................
      case 2:
        //Appending Window
        setIconImage (getToolkit().getImage ("health.jpg"));
        setTitle("Addition of data...");
        setBounds(500, 400, 600, 200);
        setResizable(false);

        //cotainer

        cpane = getContentPane();
        cpane.setLayout(new FlowLayout());

        //Components

        panel = new JPanel(new GridLayout(8, 1, 5, 6));

        lblMedicineID = new JLabel(" MediID ");
        lblMediTitle = new JLabel(" MediTitle ");
        lblQty = new JLabel(" Qty ");
        lblPrice = new JLabel(" Price ");
		lblCompanyname = new JLabel("Company");

        txtMedicineID = new JTextField(15);
        txtMediTitle = new JTextField(15);
        txtQty = new JTextField(15);
        txtPrice = new JTextField(15);
		txtCompanyname = new JTextField(15);

        panel.add(lblMedicineID);
        panel.add(txtMedicineID);
        panel.add(lblMediTitle);
        panel.add(txtMediTitle);
        panel.add(lblQty);
        panel.add(txtQty);
        panel.add(lblPrice);
        panel.add(txtPrice);
		panel.add(lblCompanyname);
		panel.add(txtCompanyname);

        btnpanel = new JPanel(new GridLayout(2, 1, 10, 5));
        btnSaveAdd = new JButton ("Save");
        btnCancel = new JButton ("Cancel");

        btnSaveAdd.addActionListener(this);
        btnCancel.addActionListener(this);

        btnpanel.add(btnSaveAdd);
        btnpanel.add(btnCancel);

        cpane.add(panel);
        cpane.add(btnpanel, BorderLayout.EAST);
        break;
//.....................................................................................		
      case 3:
        //Editing window
        
		setIconImage (getToolkit().getImage ("health.jpg"));
        setTitle("Updation of data...");
        setBounds(350, 350, 600, 230);
        setResizable(false);

        //cotainer

        cpane = getContentPane();
        cpane.setLayout(new FlowLayout());

        //Components

        panel = new JPanel(new GridLayout(10, 1, 5, 6));
        lblOldMedicineID = new JLabel(" OldMedicineID ");
        lblMedicineID = new JLabel(" NewMediID ");
        lblMediTitle = new JLabel(" MediTitle ");
        lblQty = new JLabel(" Qty ");
        lblPrice = new JLabel(" Price ");
		lblCompanyname = new JLabel("Company");

		txtOldMedicineID = new JTextField(15);
        txtMedicineID = new JTextField(15);
        txtMediTitle = new JTextField(15);
        txtQty = new JTextField(15);
        txtPrice = new JTextField(15);
		txtCompanyname = new JTextField(15);


        panel.add(lblOldMedicineID);
        panel.add(txtOldMedicineID);
        panel.add(lblMedicineID);
        panel.add(txtMedicineID);
        panel.add(lblMediTitle);
        panel.add(txtMediTitle);
        panel.add(lblQty);
        panel.add(txtQty);
        panel.add(lblPrice);
        panel.add(txtPrice);
		panel.add(lblCompanyname);
		panel.add(txtCompanyname);

        btnpanel = new JPanel(new GridLayout(2, 1, 10, 5));
        btnSaveEdit = new JButton ("Save");
        btnCancel = new JButton ("Cancel");

        btnSaveEdit.addActionListener(this);
        btnCancel.addActionListener(this);

        btnpanel.add(btnSaveEdit);
        btnpanel.add(btnCancel);

        cpane.add(panel);
        cpane.add(btnpanel, BorderLayout.EAST);
        break;
//.........................................................................................................		
      case 4:
        //Deleting window
        
		setIconImage (getToolkit().getImage ("health.jpg"));
        setTitle("Removal of data...");
        setBounds(300, 300, 300, 125);
        setResizable(false);

        //cotainer

        cpane = getContentPane();
        cpane.setLayout(new FlowLayout());

        //Components

        panel = new JPanel(new GridLayout(2, 1, 5, 0));
        lblMedicineID = new JLabel("MedicineID to be deleted: ");
        txtMedicineID = new JTextField(15);

        panel.add(lblMedicineID);
        panel.add(txtMedicineID);

        btnpanel = new JPanel(new GridLayout(2, 1, 10, 5));
        btnSaveDelete = new JButton ("Delete");
        btnCancel = new JButton ("Cancel");

        btnSaveDelete.addActionListener(this);
        btnCancel.addActionListener(this);

        btnpanel.add(btnSaveDelete);
        btnpanel.add(btnCancel);

        cpane.add(panel);
        cpane.add(btnpanel, BorderLayout.EAST);
        break;
//...................................................................................	
	 case 5:
	    
       //searching a window....		
		setIconImage (getToolkit().getImage ("health.jpg"));
        setTitle("Searching of data...");
        setBounds(350, 350, 600, 230);
        setResizable(false);

        //cotainer

        cpane = getContentPane();
        cpane.setLayout(new FlowLayout());

        //Components

        panel = new JPanel(new GridLayout(8, 1, 5, 6));
        lblMedicineID = new JLabel(" MediID ");
        lblMediTitle = new JLabel(" MediTitle ");
        lblQty = new JLabel(" Qty ");
        lblPrice = new JLabel(" Price ");
		lblCompanyname = new JLabel("Company");

        txtMedicineID = new JTextField(15);
        txtMediTitle = new JTextField(15);
        txtQty = new JTextField(15);
        txtPrice = new JTextField(15);
		txtCompanyname = new JTextField(15);

        panel.add(lblMedicineID);
        panel.add(txtMedicineID);
        panel.add(lblMediTitle);
        panel.add(txtMediTitle);
        panel.add(lblQty);
        panel.add(txtQty);
        panel.add(lblPrice);
        panel.add(txtPrice);
		panel.add(lblCompanyname);
		panel.add(txtCompanyname);

        btnpanel = new JPanel(new GridLayout(2, 1, 10, 5));
        btnFind = new JButton ("Find");
        btnCancel = new JButton ("Cancel");

        btnFind.addActionListener(this);
        btnCancel.addActionListener(this);

        btnpanel.add(btnFind);
        btnpanel.add(btnCancel);

        cpane.add(panel);
        cpane.add(btnpanel, BorderLayout.EAST);
        break;
		case 6:
        //Appending Window
        setIconImage (getToolkit().getImage ("health.jpg"));
        setTitle("Issuing Medicine...");
        setBounds(500, 400, 600, 200);
        setResizable(false);

        //cotainer

        cpane = getContentPane();
        cpane.setLayout(new FlowLayout());

        //Components

        panel = new JPanel(new GridLayout(8, 1, 5, 6));

        lblMedicineID = new JLabel(" MediID ");
        lblMediTitle = new JLabel(" MediTitle ");
        lblQty = new JLabel(" Total Qty ");
        lblPrice = new JLabel("Issue Qty");
		lblCompanyname = new JLabel("Company");

		txtMedicineIDFoucs= new JTextField(15);
        txtMediTitle = new JTextField(15);
        txtQty = new JTextField(15);
        txtPrice = new JTextField(15);
		txtCompanyname = new JTextField(15);

        panel.add(lblMedicineID);
        panel.add(txtMedicineIDFoucs);
        panel.add(lblMediTitle);
        panel.add(txtMediTitle);
        panel.add(lblQty);
        panel.add(txtQty);
        panel.add(lblPrice);
        panel.add(txtPrice);
		panel.add(lblCompanyname);
		panel.add(txtCompanyname);

        btnpanel = new JPanel(new GridLayout(2, 1, 10, 5));
        btnSaveUpdate = new JButton ("Save");
        btnCancel = new JButton ("Cancel");

        btnSaveUpdate.addActionListener(this);
        btnCancel.addActionListener(this);
		txtMedicineIDFoucs.addFocusListener(this);
        btnpanel.add(btnSaveUpdate);
        btnpanel.add(btnCancel);

        cpane.add(panel);
        cpane.add(btnpanel, BorderLayout.EAST);
        break;
	}
		
    
    //Window Properties

    setDefaultCloseOperation(HIDE_ON_CLOSE);
    setVisible(true);
	
	
    //conection to DataBase

    ConnectToDatabase();
  }
  
  class MyWindowAdapter extends WindowAdapter 
	{
      public void windowClosing(WindowEvent we) 
	  {
       System.exit(0);
      }
	}

  public void focusLost (FocusEvent ae)
  {
    if (ae.getSource() == txtMedicineIDFoucs)
    {
		try{
       FindDataForIssue( txtMedicineIDFoucs.getText());
	   
      txtMediTitle.setEnabled(false);
      txtQty.setEnabled(false);
	  txtCompanyname.setEnabled(false);
		}    catch(Exception e) 
	{
	 System.out.println(e);  
	 e.printStackTrace();
	}

    }
  }
  public void focusGained (FocusEvent ae)
  {

  }
  
	
  public void actionPerformed (ActionEvent ae)
  {
    if (ae.getSource() == btnAdd)
    {
      new PMSSwingNew(2);
    }
    else if (ae.getSource() == btnEdit)
    {
      new PMSSwingNew(3);
    }
    else if (ae.getSource() == btnDelete)
    {
      new PMSSwingNew(4);
    }
	else if (ae.getSource() == btnSearch)// modi
	{
	  new PMSSwingNew(5);
	}
    else if (ae.getSource() == btnExit)
    {
     new PMSSwingNew(6);
    }
    else if (ae.getSource() == btnCancel)
    {
      setVisible(false);
    }
    else if(ae.getSource() == btnSaveAdd)
    {
      AddData(txtMedicineID.getText(), txtMediTitle.getText(), txtQty.getText(), txtPrice.getText(), txtCompanyname.getText());// how this method run without object??
	  txtMediTitle.setEnabled(true);
      txtQty.setEnabled(true);
	  txtCompanyname.setEnabled(true);
	  
      txtMedicineID.setText("");
      txtMediTitle.setText("");
      txtQty.setText("");
      txtPrice.setText("");
	  txtCompanyname.setText("");
    }
	else if(ae.getSource() == btnSaveUpdate)
    {
	  System.out.println(txtQty.getText()+ " "+txtPrice.getText());
	  int total=0;
	  int orig=Integer.parseInt(txtQty.getText());
	  int issu=Integer.parseInt(txtPrice.getText());
	  System.out.println(orig+"  "+issu);
	  try{
	   total=orig-issu;
	  }catch(Exception exp){
		  exp.printStackTrace();
		  return;
	  }
      EditData(txtMedicineIDFoucs.getText(),""+total,txtMediTitle.getText(),""+issu);
      txtMedicineIDFoucs.setText("");
      txtMediTitle.setText("");
      txtQty.setText("");
      txtPrice.setText("");
	  txtCompanyname.setText("");
    }
    else if(ae.getSource() == btnSaveEdit)
    {
      EditData( txtMedicineID.getText(), txtMediTitle.getText(), txtQty.getText(), txtPrice.getText(), txtCompanyname.getText(),txtOldMedicineID.getText());
      txtOldMedicineID.setText("");
      txtMedicineID.setText("");
      txtMediTitle.setText("");
      txtQty.setText("");
      txtPrice.setText("");
	  txtCompanyname.setText("");
    }
    else if(ae.getSource() == btnSaveDelete)
    {
      DeleteData(txtMedicineID.getText());
      txtMedicineID.setText("");
	  
    }
	else if(ae.getSource() == btnFind)
	{
	  FindData( txtMedicineID.getText());
	  txtMedicineID.setText("");
	}
    else if(ae.getSource() == btnRefresh)
    {
      RetrieveData();
    }
  }
  
  /*Splash s = new Splash();
  
  //thread
  Thread ThFormSplash = new Thread(s);


  protected void loadSplashScreen()// used in case 1 of PMSSwing()..
  {
    //Start the thread
    ThFormSplash.start();
    while(!s.isShowing())
    {
      try
      {
        //Display the FormSplash for 2 seconds
        Thread.sleep(2000);
      }
      catch(InterruptedException e)
      {
      }
    }
  }*/
  
 /* protected void dispMainFrame()
  {
   MainFrame mf = new MainFrame();
  }*/
  
  private void SetColHeader()
  {
    tmodel.addColumn("MedicineID");
    tmodel.addColumn("MediTitle");
    tmodel.addColumn("Qty");
    tmodel.addColumn("Price");
	tmodel.addColumn("Company");

  }

  private void ConnectToDatabase ()
  {
    try
    {
      con = Connect.getConnection();

      //create statement
      st = con.createStatement();
    }
    catch (Exception e) 
	{
	 System.out.println(e);
	}
  }

  private void AddData (String code, String title, String hour, String price, String Compname)
  {
    try
    {
      //prepare statement
      String qry = "Insert into MediInfo values (?, ?, ?, ?, ?)";//sql quiery
      System.out.println(code + "\t"+title+ "\t"+hour+ "\t"+price+"\t" +Compname+ "\t");
      
      PreparedStatement ps = con.prepareStatement(qry);

      ps.setString(1, code);
      ps.setString(2, title);
      ps.setString(3, hour);
      ps.setString(4,price);
	  ps.setString(5, Compname);

      ps.executeUpdate();
    }
    catch(Exception e) 
	{
	 System.out.println(e + "\t" + e.getMessage());  
	}
	 
  }
         
  private void EditData (String code, String title, String quantity, String price, String cname, String cond)
  {

    try
    {
      //prepare statement
      String qry = "Update MediInfo set MedicineID = ?, MediTitle = ?, Qty = ?, Price = ?,Company = ? where MedicineID = ?";
      PreparedStatement ps = con.prepareStatement(qry);
      ps.setString(1, code);
      ps.setString(2, title);
      ps.setString(3, quantity);
      ps.setString(4, price);
      ps.setString(5, cname);  
      ps.setString(6, cond);
	  
      ps.executeUpdate();
    }
    catch(Exception e) 
	{
	 System.out.println(e);  
	}
  }
private void EditData (String code, String quantity,String pname,String issue)
  {

    try
    {
      //prepare statement
      String qry = "Update MediInfo set Qty = ? where MedicineID = ?";
      PreparedStatement ps = con.prepareStatement(qry);
      ps.setString(1, quantity);
      ps.setString(2, code);
      ps.executeUpdate();
	  MYSQLjdbcInsertDemo.callMasterDB(pname,issue,"dealer1");
    }
    catch(Exception e) 
	{
	 System.out.println(e);  
	}
  }

  private void DeleteData (String cond)
  {
    try
    {
      //prepare statement
      String qry = "Delete from MediInfo where MedicineID = ?";
      PreparedStatement ps = con.prepareStatement(qry);

      ps.setString(1, cond);

      ps.executeUpdate();
    }
    catch(Exception e) 
	{
	 System.out.println(e);  
	}
  }
  private void FindData ( String id)
  {
   try
    {
	 ResultSet rs = st.executeQuery("Select * from MediInfo where MedicineId= '"+id+"'");
	 
	 if(rs.next())
	 {
	  txtMedicineID.setText(rs.getString(1));
	  txtMediTitle.setText(rs.getString(2));
	  txtQty.setText(rs.getString(3));
	  txtPrice.setText(rs.getString(4));
	  txtCompanyname.setText(rs.getString(5));
	 }
	 else
	 {
	  String msg = "incorrect";
	  JOptionPane.showMessageDialog(null,"your Choice is "+msg,"Caution",JOptionPane.ERROR_MESSAGE);
	 }
    }
    catch(Exception e) 
	{
	 System.out.println(e);  
	}
  }
  
    private void FindDataForIssue ( String id)
  {
   try
    {
	 ResultSet rs = st.executeQuery("Select * from MediInfo where MedicineId= '"+id+"'");
	 
	 if(rs.next())
	 {
	  txtMedicineIDFoucs.setText(rs.getString(1));
	  txtMediTitle.setText(rs.getString(2));
	  txtQty.setText(rs.getString(3));
	  //txtPrice.setText(rs.getString(4));
	  txtCompanyname.setText(rs.getString(5));
	 }
	 else
	 {
	  String msg = "incorrect";
	  JOptionPane.showMessageDialog(null,"your Choice is "+msg,"Caution",JOptionPane.ERROR_MESSAGE);
	  txtMediTitle.setEnabled(true);
      txtQty.setEnabled(true);
	  txtCompanyname.setEnabled(true);
	  
	 }
    }
    catch(Exception e) 
	{
	 System.out.println(e);  
	 e.printStackTrace();
	}
  }
	 
//........................................................................................
  private void RetrieveData ()// c.RetrieveData..
  {
    try
    {
      int row = tmodel.getRowCount();
      while(row > 0)
      {
        row--;
        tmodel.removeRow(row);
      }

      //execute query
      ResultSet rs = st.executeQuery("Select * from MediInfo");

      //get metadata
      ResultSetMetaData md = rs.getMetaData();
      int colcount = md.getColumnCount();

      Object[] data = new Object[colcount];
      //extracting data

      while (rs.next())
      {
        for (int i=1; i<=colcount; i++)
        {
          data[i-1] = rs.getString(i);
        }
        tmodel.addRow(data);
      }
    }
    catch(Exception e) 
	{
	 System.out.println(e);  
	}
  }
  
//.........................................................................................  
  public static void main(String arg[])
  {
    try
    {
    //  javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
   javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
    }
    catch (Exception e)
    {
      System.out.println("Error Loading Theme:" + e.toString());
      
	  //If Failed to load the liquid theme then load my own XPStyleTheme
      
	  /*MetalTheme myXPStyleTheme = new XPStyleTheme();
      MetalLookAndFeel.setCurrentTheme(myXPStyleTheme);
      try
      {
          UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
      }
      catch (Exception err)
      {
           System.out.println("Error loading myXPStyleTheme:" + err.toString());
       }*/
       }
    new Splash();
	PMSSwingNew c;
	try{
	Thread.sleep(2000);
	c = new PMSSwingNew(1);
	}
	catch(Exception e){
		
		e.printStackTrace();
	}
	Progressbar b = new Progressbar();
		PMSSwingNew d = new PMSSwingNew();
	d.RetrieveData();
  }


}
