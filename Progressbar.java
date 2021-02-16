// for progress bar...

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class Progressbar extends JFrame implements Runnable
{
	JProgressBar pb;
	Thread t;
	Container c;
	Progressbar()
	 {
        setTitle("LOADING");
		c=getContentPane();
		c.setLayout(new BorderLayout());
		setIconImage (getToolkit().getImage ("health.jpg"));
		
		t = new Thread(this);
		
		pb = new JProgressBar(0,100);
		pb.setValue(0);	
		pb.setIndeterminate(false);	
		pb.setStringPainted(true);
		pb.setForeground(Color.BLUE);
	//	pb.setForeground(new Color(204, 238, 241));				
		c.add(pb,BorderLayout.CENTER);
		t.start();
		setSize(600,50);
		setLocation(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 }
	public void run()
	{
		for (int i = 0; i<=100; i++)
		{
			try 
			{
    			Thread.sleep(10);
			}
			catch (Exception ex) 
			{
			 System.out.println(ex);
			}
			pb.setValue(i);
		}
			dispose();	
	}
}
