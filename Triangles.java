// Triangles.java: This program draws 50 triangles inside each other.


import java.awt.*;
import java.awt.event.*;

public class Triangles extends Frame
{  public static void main(String[] args){new Triangles();}
   
   Triangles()
   {  super("Squares everywhere!");
      addWindowListener(new WindowAdapter()
         {public void windowClosing(WindowEvent e){System.exit(0);}});
      setSize(575,680);
      add(new newSquares());
      show();
   }
}

class newSquares extends Canvas
{  int maxX, maxY, minMaxXY, xCenter, yCenter;

   public void paint(Graphics g)
   {  
	for(int a = 0; a < 8; a++){
		for(int b = 0; b < 8; b++){
      //b is for the horizontal axis and a for vertical
				
			if((a+b)%2 == 0){
				g.setColor(Color.BLACK);
				g.fillRect(b * 80,a * 80, 80, 80);
				}
			}
		}	
		for(int p=0; p<32; p++){
			for(int l=0; l<32; l++){
				if ((p%2) == 1){
					g.setColor(Color.red);
					g.fillRect(p*40, l*40, 20, 20);
					g.fillRect(l*40, p*40, 20, 20);
					g.fillRect(p*40 +20, l*40 + 20, 20, 20);
					g.fillRect(l*40 + 20, p*40 + 20, 20, 20);
					g.fillRect(p*40 -20, l*40 - 20, 20, 20);
					g.fillRect(l*40 - 20, p*40 - 20, 20, 20);
							
					g.setColor(Color.lightGray);
					g.fillRect(p*40, l*40, 15, 15);
					g.fillRect(l*40, p*40, 15, 15);
							
					g.setColor(Color.green);
					g.fillRect(p*40, l*40, 10, 10);
					g.fillRect(l*40, p*40, 10, 10);
					g.setColor(Color.blue);
					g.fillRect(p*40, l*40, 5, 5);
					g.fillRect(l*40, p*40, 5, 5);
					}
				if ((p%2) == 0){
					g.setColor(Color.blue);
					g.fillRect(p*40, l*40, 20, 20);
					g.fillRect(l*40, p*40, 20, 20);
					g.fillRect(p*40 +20, l*40 + 20, 20, 20);
					g.fillRect(l*40 + 20, p*40 + 20, 20, 20);
					g.fillRect(p*40 -20, l*40 - 20, 20, 20);
					g.fillRect(l*40 - 20, p*40 - 20, 20, 20);
							
					g.setColor(Color.red);
					g.fillRect(p*40, l*40, 15, 15);
					g.fillRect(l*40, p*40, 15, 15);
							
					g.setColor(Color.lightGray);
					g.fillRect(p*40, l*40, 10, 10);
					g.fillRect(l*40, p*40, 10, 10);
					g.setColor(Color.green);
					g.fillRect(p*40, l*40, 5, 5);
					g.fillRect(l*40, p*40, 5, 5);
					}						
			}
		}
	}
}
	
