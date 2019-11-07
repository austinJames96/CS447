// RedRect.java: The largest possible rectangle in red.

// Copied from Section 1.1 of
//    Ammeraal, L. (1998) Computer Graphics for Java Programmers,
//       Chichester: John Wiley.
// Run under Windows 95
// Austin Sypolt Project 3
import java.awt.*;
import java.awt.event.*;

public class BarGraph extends Frame
{  public static void main(String[] args){new BarGraph();}
   
   BarGraph()
   {  super("Bar Graph Program CS447");
      addWindowListener(new WindowAdapter()
         {public void windowClosing(WindowEvent e){System.exit(0);}});
      setSize(800, 600);
      add("Center", new CvBarGraph());
      show();
   }
}

class CvBarGraph extends Canvas
{  public void paint(Graphics g)
   {  Dimension d = getSize();
      int maxX = d.width - 1, maxY = d.height - 1;
	  int categories = 5; //Number of different bar graphs
	  String[] categoryNames = new String[categories];
	  categoryNames[0] = "Cat";
	  categoryNames[1] = "Dog";
	  categoryNames[2] = "Frog";
	  categoryNames[0] = "Horse";
	  categoryNames[0] = "Mouse";
	  int[] categoryValues = new int[]{100, 200, 300, 400, 500};
	  
	  
	  
	  
      //g.drawString("d.width  = " + d.width,  10, 30);
      //g.drawString("d.height = " + d.height, 10, 60);
      //g.setColor(Color.green);
      //g.drawRect(10, 10, maxX-20, maxY-20);
      
     //  g.fillOval(50,50, 90,120);
   }
}