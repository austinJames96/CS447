// RedRect.java: The largest possible rectangle in red.

// Copied from Section 1.1 of
//    Ammeraal, L. (1998) Computer Graphics for Java Programmers,
//       Chichester: John Wiley.
// Run under Windows 95

import java.awt.*;
import java.awt.event.*;

public class primeGraph extends Frame
{  public static void main(String[] args){new primeGraph();}
   
   primeGraph()
   {  super("primeGraph");
      addWindowListener(new WindowAdapter()
         {public void windowClosing(WindowEvent e){System.exit(0);}});
      setSize(1500, 1500);
      add("Center", new graph());
      show();
   }
}

class graph extends Canvas
{  public void paint(Graphics g)
   {  Dimension d = getSize();
      int maxX = d.width - 1, maxY = d.height - 1;

    
    int maxSize = 1500;
    g.drawLine(2, 2, 2, 2);
    

    for(int i = 2; i<maxSize; i++){
        for(int j = 3; j<maxSize; j++){
            if ((j%i)==0){//not prime

            }
            else{
                g.drawLine(i, j, i, j);
            }
        }
    }
      /*
      g.drawString("d.width  = " + d.width,  10, 30);
      g.drawString("d.height = " + d.height, 10, 60);
      g.setColor(Color.green);
      g.drawRect(10, 10, maxX-20, maxY-20);
      
     //  g.fillOval(50,50, 90,120);*/
   }
}