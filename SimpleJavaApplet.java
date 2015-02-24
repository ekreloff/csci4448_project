import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;

public class SimpleJavaApplet extends Applet{
	public void paint(Graphics g){
		g.drawString("Hello World", 50, 50);
		g.drawRect(20,20,20,20);
		g.setColor(Color.red);
		g.fillRect(20, 20, 20, 20);
	}
}
