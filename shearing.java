//HW 2 Problem 2
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;

public class shearing extends Frame
{  public static void main(String[] args){new shearing();}
   
   shearing()
   {  super("Homework 2 Problem 2: Shearing");
      addWindowListener(new WindowAdapter()
         {public void windowClosing(WindowEvent e){System.exit(0);}});
      setSize(300, 300);
      add("Center", new CvShearing());
      show();
   }
}

class CvShearing extends Canvas
{  public void paint(Graphics g)
   {  	Dimension d = getSize();
		int maxX = d.width - 1, maxY = d.height - 1; //define maxX and maxY values
		double a = 0.5; //shearing constant
		
		Shape preshearRect = new Rectangle(10, 10, maxX-20, maxY-20); //define initial rectangle
		Shape preshearCircle = new Oval(10, 10, maxX-20, maxY-20); //define initial circle
		//g.drawRect(10, 10, maxX-20, maxY-20);
		//g.drawOval(10,10, maxX-20, maxY-20);
	  
		AffineTransform shearingTransform = new AffineTransform();
		shearingTransform.shear(a, a); //Shear by given constant a = 0.5 in both x and y directions
		
		Shape shearRect = shearingTransform.createTransformedShape(preshearRect); //using affinetransform for shearing
		//Shape shearCircle = shearingTransform.createTransformedShape(preshearCircle);
		
		
		g.draw(preshearRect); //Draw original rectangle
		g.draw(preshearCircle); //Draw original circle
		
		g.draw(shearRect); //new transformed rectangle
		g.draw(shearCircle); //new transformed circle
   }
}