import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;

public class Splash extends JWindow implements Runnable
{
	Thread t;
	Splash(){
	t=new Thread(this,"splashscreen");
	t.start();
	}
	public void run()
	{
	    ImageIcon splash = new ImageIcon("splash.jpg");//added....
		JLabel SplashLabel = new JLabel(splash);
		Dimension screen = 	Toolkit.getDefaultToolkit().getScreenSize();// ?? for calculating size of laptop screen..??
		Color cl = new Color (0, 0, 0);
		SplashLabel.setBorder (new LineBorder (cl, 3));// cl=color.. 3= width of color
		
		Container cp = getContentPane();//added..

		cp.add(SplashLabel,BorderLayout.CENTER);

		setSize(490,300);
		setLocation((screen.width - 490)/2,((screen.height-300)/2));
		show();
	}
}