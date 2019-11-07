/*
 * CS447 Graphics Robot Animation Project
 * Austin Sypolt | Spring 2019
 *
*/

import java.awt.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.Scanner; 
import java.awt.geom.Path2D;

import javax.swing.JComponent;
import javax.swing.JFrame;


public class robotProjectFinal extends Frame
{  public static void main(String[] args){new robotProjectFinal();}
   
   robotProjectFinal()
   {  super("robotProjectFinal");
      addWindowListener(new WindowAdapter()
         {public void windowClosing(WindowEvent e){System.exit(0);}});
      setSize(1200, 800);
      add("Center", new CvrobotProjectFinal());
      show();
   }
}

class CvrobotProjectFinal extends Canvas
{  public void paint(Graphics g)
   {  
	Dimension d = getSize();
    int maxX = d.width - 1, maxY = d.height - 1;

    g.setColor(Color.black);
    Graphics2D g2 = (Graphics2D)g;
     //  g.fillOval(50,50, 90,120);
	 
	 //Draw our robot
	g.drawRect(100, 700, 300, 25); //Platform
	for(int i = 0; i < 4; i++){
		g.drawOval(125 + 75*i, 725, 20, 20);//Draw wheels
	}
	
	g.drawOval(150,300,200,200); //Haul top
	g.fillOval(230, 325, 40, 42);//Rotation circle
	g.fillRect(150, 400, 200, 300); //Main haul
	
	g.drawString("Use A and D to move left and right", 800, 100);
	g.drawString("Use J and K to operate the first and second arm", 800, 125);
	g.drawString("Use L to operate the robot hand", 800, 150);
	int supercount = 0;
	//g.drawRect(1000, 600, 200, 200);
	//g.drawString("Object", 1100, 700);
	int count = 0;
	int icount = 1;
	int acount = 0;
	int mrcount = 0;
	
	double xPos[] = {100, 125, 250, 525, 500, 500, 560, 150, 230, 150};
	double yPos[] = {325, 325, 525, 545, 545};
	int xPosInt[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	//int yPosInt[] = {0, 0, 0, 0, 0};
	
	double xsinPos[] = {300,25, 75, 15, 15};
	double ycosPos[] = {40, 200, 20, 50, 50};
	
	int xsinInt[] = {0, 0, 0, 0, 0};
	int ycosInt[] = {0, 0, 0, 0, 0};
	
	int arm1xPos[] = {0, 0, 0, 0, 0};
	int arm1yPos[] = {0, 0, 0, 0, 0};
	int xsinPosInt = 0;
	int ycosPosInt = 0;
	int armMove = 0;
		
	while(count == 0){
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		if (s.equals("d")){ //Moving right
			g.setColor(Color.white);
			g.fillRect(0, 0, 1200, 800);
			
			for(int i = 0; i < 10; i++){
				xPos[i] += 50;
				//System.out.println(xPos[i] + "\n");
			}
			
		}
		double theta = Math.PI/8 * icount * -1;
		double theta1 = Math.PI/8 * acount * -1;
		double theta2 = Math.PI/8 * mrcount;
		//double radians = Math.toRadians(theta);
		double sinValue = Math.sin(theta);
		double cosValue = Math.cos(theta);
		double sinValue1 = Math.sin(theta1);
		double cosValue1 = Math.cos(theta1);
		double sinValue2 = Math.sin(theta2);
		double cosValue2 = Math.sin(theta2);
		
		if (s.equals("a")){ //Moving left
			g.setColor(Color.white);
			g.fillRect(0, 0, 1200, 800);
			
			for(int i = 0; i < 10; i++){
				xPos[i] -= 50;
				//System.out.println(xPos[i] + "\n");
			}
			
		}
		//double sinValue 
		if(s.equals("j")){ //First arm rotation
			g.setColor(Color.white);
			g.fillRect(0, 0, 1200, 800);
			
			double length = Math.pow(Math.pow(xsinPos[0], 2)+Math.pow(ycosPos[0],2),0.5);
			
			xsinPos[0] = length*sinValue;
			//g.drawRect(250, 325, 300, 40);
			ycosPos[0] = length*cosValue;
		}
		
		if(s.equals("k")){//Second arm rotation
			g.setColor(Color.white);
			g.fillRect(0, 0, 1200, 800);
			
			double length1 = Math.pow(Math.pow(xsinPos[1], 2)+Math.pow(ycosPos[1],2),0.5);
			
			xsinPos[1] = length1*sinValue1;
			//g.drawRect(250, 325, 300, 40);
			ycosPos[1] = length1*cosValue1;
		}
		
		if(s.equals(";")){//Hand open/close
			g.setColor(Color.white);
			g.fillRect(0, 0, 1200, 800);
			armMove++;
				double length3 = 20; 
				
				xsinPos[2] = length3*sinValue2;
				ycosPos[2] = length3*cosValue2;
		}
		if(s.equals("l")){
			g.setColor(Color.white);
			g.fillRect(0, 0, 1200, 800);
			armMove--;
				double length3 = 20; 
				
				xsinPos[2] = length3*sinValue2;
				ycosPos[2] = length3*cosValue2;
		}
		
		for (int i = 0; i < 10; i++){
			xPosInt[i] = (int)Math.round(xPos[i]);
		}
		for (int i = 0; i < 5; i++){
			ycosInt[i] = (int)Math.round(ycosPos[i]);
			xsinInt[i] = (int)Math.round(xsinPos[i]);
		}

		g.setColor(Color.black);
		g.drawRect(xPosInt[0], 700, 300, 25); //Platform
		for(int i = 0; i < 4; i++){
			g.drawOval(xPosInt[1] + 75*i, 725, 20, 20);//Draw wheels
		}
		
		g.drawLine(xPosInt[2], 325, xPosInt[2]+xsinInt[0], 325+ycosInt[0]);
		g.drawLine(xPosInt[2], 365, xPosInt[2]+xsinInt[0], 325+ycosInt[0]);
		
		g.drawOval(xPosInt[7], 300,200,200); //Haul top
		g.fillRect(xPosInt[9], 400, 200, 300); //Main haul	
		
		for(int k = 0; k < 20; k++){
			g.setColor(Color.blue);
			g.drawLine(xPosInt[2], 325+2*k, xPosInt[2]+xsinInt[0], 325+ycosInt[0]+2*k); //First arm
			
			g.setColor(Color.green);
			g.drawLine(xPosInt[2]+xsinInt[0], 325+ycosInt[0]+2*k, xPosInt[2]+xsinInt[0]+xsinInt[1], 325+ycosInt[0]+ycosInt[1]+k); //Second arm
			
			g.setColor(Color.magenta);
			g.drawLine(xPosInt[2]+xsinInt[0]+xsinInt[1], 325+ycosInt[0]+ycosInt[1]+k, xPosInt[2]+xsinInt[0]+xsinInt[1]-(10*armMove), 325+ycosInt[0]+ycosInt[1] + (10*armMove)+2*k);//Hand
			g.drawLine(xPosInt[2]+xsinInt[0]+xsinInt[1], 325+ycosInt[0]+ycosInt[1]+k, xPosInt[2]+xsinInt[0]+xsinInt[1]+(10*armMove), 325+ycosInt[0]+ycosInt[1] - (10*armMove)-2*k);//Hand
			if(((xPosInt[2]+xsinInt[0]+xsinInt[1] >= 1000)&&(325+ycosInt[0]+ycosInt[1])>=600)){
				g.setColor(Color.black);
				g.fillRect(xPosInt[2]+xsinInt[0]+xsinInt[1], 325+ycosInt[0]+ycosInt[1], 200, 200);
				g.setColor(Color.white);
				g.drawString("Object", xPosInt[2]+xsinInt[0]+xsinInt[1]-(10*armMove), 325+ycosInt[0]+ycosInt[1] + (10*armMove)+2*k);
				supercount++;
			}
			if(supercount == 0){
				g.setColor(Color.black);
				g.fillRect(1000, 600, 200, 200);
				g.setColor(Color.white);
				g.drawString("Object", 1100, 700);
			}
			else{
				g.setColor(Color.black);
				g.fillRect(xPosInt[2]+xsinInt[0]+xsinInt[1], 325+ycosInt[0]+ycosInt[1], 200, 200);
				g.setColor(Color.white);
				g.drawString("Object", xPosInt[2]+xsinInt[0]+xsinInt[1]-(10*armMove), 325+ycosInt[0]+ycosInt[1] + (10*armMove)+2*k);
			}
		}
		
		g.setColor(Color.black);
		g.fillOval(xPosInt[8], 325, 40, 42);//Rotation circle
		g.drawString("Use A and D to move left and right", 800, 100);
		g.drawString("Use J and K to operate the first and second arm", 800, 125);
		g.drawString("Use L and ; to operate the robot hand", 800, 150);
		
		icount++;
		acount++;
	}
   }
}
