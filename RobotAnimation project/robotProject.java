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


public class robotProject extends Frame
{  public static void main(String[] args){new robotProject();}
   
   robotProject()
   {  super("robotProject");
      addWindowListener(new WindowAdapter()
         {public void windowClosing(WindowEvent e){System.exit(0);}});
      setSize(1200, 800);
      add("Center", new CvrobotProject());
      show();
   }
}

class CvrobotProject extends Canvas
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
	/*
	g.drawRect(250, 325, 300, 40); //first arm yPos[0] xPos[2]
	g.drawRect(525, 325, 25, 200); //second arm yPos[1] xPos[3]
	g.drawRect(500, 525, 75, 20); //Hand base yPos[2] xPos[4]
	g.drawRect(500, 545, 15, 50); //Hand arm left yPos[3] xPos[5]
	g.drawRect(560, 545, 15, 50); //Hand arm right yPos[4] xPos[6]
	*/
	g.drawOval(150,300,200,200); //Haul top
	g.fillOval(230, 325, 40, 42);//Rotation circle
	g.fillRect(150, 400, 200, 300); //Main haul
	
	g.drawString("Use A and D to move left and right", 800, 100);
	g.drawString("Use J and K to operate the first and second arm", 800, 125);
	g.drawString("Use L to operate the robot hand", 800, 150);
	
	g.drawRect(1000, 600, 200, 200);
	g.drawString("Object", 1100, 700);
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
		double theta = Math.PI/8 * icount;
		double theta1 = Math.PI/8 * acount;
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
				double length3 = Math.pow(Math.pow(armMove, 2)+Math.pow(armMove,2),0.5); 
				
				xsinPos[2] = length3*sinValue2;
				ycosPos[2] = length3*cosValue2;
		}
		if(s.equals("l")){
			g.setColor(Color.white);
			g.fillRect(0, 0, 1200, 800);
			armMove--;
				double length3 = Math.pow(Math.pow(armMove, 2)+Math.pow(armMove,2),0.5); 
				
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
		
		//g.drawRect(xPosInt[2], 325, 300, 40); //first arm
		
		g.drawLine(xPosInt[2], 325, xPosInt[2]+xsinInt[0], 325+ycosInt[0]);
		g.drawLine(xPosInt[2], 365, xPosInt[2]+xsinInt[0], 325+ycosInt[0]);
		/*for(int k = -10; k < 10; k++){
			g.drawLine(xPosInt[2]+xsinInt[0]+k, 325+ycosInt[0], xPosInt[2]+xsinInt[0]+xsinInt[1]+k, 325+ycosInt[0]+ycosInt[1]);	//Second Arm
			for(int j = 0; j < 10; j++){
				g.drawLine(xPosInt[2]+xsinInt[0]+xsinInt[1], 325+ycosInt[0]+ycosInt[1], xPosInt[2]+xsinInt[0]+xsinInt[1]+5*k+5*armMove, 325+ycosInt[0]+ycosInt[1]+j);
			}
		}*/
		
		//g.drawLine(xPosInt[2]+xsinInt[0], 365+ycosInt[0], xPosInt[2]+xsinInt[0]+xsinInt[1], 325+ycosInt[0]+ycosInt[1]);
		//g.drawRect(xPosInt[3], 325, 25, 200); //second arm
		//g.drawLine(xPosInt[2]+xsinInt[0]+xsinInt[1], 325+ycosInt[0]+ycosInt[1], xPosInt[2]+xsinInt[0]+xsinInt[1] + 10*sinValue, 325+ycosInt[0]+ycosInt[1] + 10*cosValue);
		/*
		g.drawRect(xPosInt[4], 525, 75, 20); //Hand base
		g.drawRect(xPosInt[5], 545, 15, 50); //Hand arm left
		g.drawRect(xPosInt[6], 545, 15, 50); //Hand arm right
		*/
		
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
		}
		//g.drawLine(xPosInt[2], 365, xPosInt[2]+xsinInt[0], 325+ycosInt[0]); //First arm
		
		g.setColor(Color.black);
		g.fillOval(xPosInt[8], 325, 40, 42);//Rotation circle
		g.drawString("Use A and D to move left and right", 800, 100);
		g.drawString("Use J and K to operate the first and second arm", 800, 125);
		g.drawString("Use L and ; to operate the robot hand", 800, 150);
		
		g.drawRect(1000, 600, 200, 200);
		g.drawString("Object", 1100, 700);
		icount++;
		acount++;
	}
   }
}
