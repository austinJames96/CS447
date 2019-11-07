import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.*;

class MyCanvas extends JComponent {

  public void paint(Graphics g) {
	Dimension d = getSize();
	int maxX = d.width -1;
	int maxY = d.height -1;
	int n = 3;
	
	//background blue sky
	g.setColor(Color.blue);
    g.fillRect(0, 0, maxX, maxY);
	
	//backgroud green grass
	g.setColor(Color.green);
	g.fillRect(0, 500, 1000, 400);
	
	//house base
	g.setColor(Color.darkGray);
	g.fillRect(150, 250, 400, 400);
	
	//chimney
	g.setColor(Color.lightGray);
	g.fillRect(200, 100, 30, 125);
	
	//house roof
	g.setColor(Color.red);
	int x[] = {100, 350, 600};
	int y[] = {300, 50, 300};
	Polygon p = new Polygon(x, y, n);
	g.fillPolygon(p);   
	
	//house door
	g.setColor(Color.white);
	g.fillRect(325, 550, 70, 100);
	
	//house windows
	g.setColor(Color.yellow);
	g.fillRect(215, 400, 50, 65);
	g.fillRect(450, 400, 50, 65);
	
	//house window lines
	g.setColor(Color.black);
	g.drawLine(240, 400, 240, 465);
	g.drawLine(215, 433, 265, 433);
	g.drawLine(475, 400, 475, 465);
	g.drawLine(450, 433, 500, 433);
	
	//doorknob
	g.fillOval(375, 585, 10, 10);
	
	//sun
	g.setColor(Color.yellow);
	g.fillOval(825, -125, 250, 250);
	
	//chimney smoke
	g.setColor(Color.black);
	g.fillOval(194, 55, 45, 45);
	g.fillOval(196, 25, 45, 45);
	g.fillOval(198, 0, 45, 45);
	
	//Garage
	g.setColor(Color.lightGray);
	g.fillRect(550, 450, 250, 200);
	
	//Garage door
	g.setColor(Color.red);
	g.fillRect(585, 500, 175, 150);
	
	//Garage door lines
	g.setColor(Color.black);
	g.drawLine(585, 525, 759, 525);
	g.drawLine(585, 550, 759, 550);
	g.drawLine(585, 575, 759, 575);
	g.drawLine(585, 600, 759, 600);
	g.drawLine(585, 625, 759, 625);
	
	//Person
	g.setColor(Color.black);
	g.drawLine(815, 560, 815, 615);
	g.drawLine(815, 615, 800, 640);
	g.drawLine(815, 615, 830, 640);
	g.drawLine(800, 600, 815, 590);
	g.drawLine(815, 590, 830, 600);
	g.setColor(Color.yellow);
	g.fillOval(800, 540, 30, 40);
	g.setColor(Color.black);
	g.fillOval(805, 550, 7, 7);
	g.fillOval(815, 550, 7, 7);
	g.fillOval(807, 560, 15, 15);
	g.setColor(Color.yellow);
	g.fillOval(807, 557, 15, 15);
	
	//Person 2
	g.setColor(Color.black);
	g.drawLine(830, 600, 850, 620);
	g.drawLine(850, 600, 850, 630);
	g.drawLine(850, 630, 840, 640);
	g.drawLine(850, 630, 860, 640);
	g.drawLine(850, 620, 863, 627);
	g.setColor(Color.yellow);
	g.fillOval(840, 580, 20, 28);
	g.setColor(Color.black);
	g.fillOval(844, 585, 5, 5);
	g.fillOval(852, 585, 5, 5);
	g.fillOval(846, 592, 10, 10);
	g.setColor(Color.yellow);
	g.fillOval(846, 589, 10, 10);
	
	//tree
	Color newBrown = new Color(102, 51, 0);
	g.setColor(newBrown);
	g.fillRect(900, 350, 75, 300);
	Color newGreen = new Color(0, 153, 51);
	g.setColor(newGreen);
	g.fillOval(910, 300, 150, 150);
	g.fillOval(810, 300, 150, 150);
	g.fillOval(860, 250, 150, 150);
	
	
	//Sidewalk
	g.setColor(Color.lightGray);
	g.fillRect(325, 650, 70, 200);
	
	//Sidewalk lines
	g.setColor(Color.black);
	g.drawLine(325, 675, 395, 675);
	g.drawLine(325, 700, 395, 700);
	g.drawLine(325, 725, 395, 725);
	g.drawLine(325, 750, 395, 750);
	g.drawLine(325, 775, 395, 775);
	
	//Clouds
	g.setColor(Color.white);
	g.fillOval(50, 42, 50, 40);
	g.fillOval(80, 20, 55, 60);
	g.fillOval(110, 42, 50, 40);
	
	g.fillOval(450, 62, 50, 40);
	g.fillOval(480, 40, 55, 60);
	g.fillOval(510, 62, 50, 40);
	
	g.fillOval(650, 22, 50, 40);
	g.fillOval(680, 0, 55, 60);
	g.fillOval(710, 22, 50, 40);
	
	g.fillOval(850, 182, 50, 40);
	g.fillOval(880, 160, 55, 60);
	g.fillOval(910, 182, 50, 40);
  }
}

public class FillRect {
  public static void main(String[] a) {
    JFrame window = new JFrame();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setBounds(50, 50, 1000, 800);
    window.getContentPane().add(new MyCanvas());
    window.setVisible(true);
  }
}