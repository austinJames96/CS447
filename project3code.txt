
// Austin Sypolt CS447
// Bar Graph Project 3
import java.awt.*;
import java.awt.event.*;

public class graphProject extends Frame
{  public static void main(String[] args){new graphProject();}
   
   graphProject()
   {  super("Bar Graph Program CS447");
      addWindowListener(new WindowAdapter()
         {public void windowClosing(WindowEvent e){System.exit(0);}});
      setSize(800, 600);
      add("Center", new CvGraph());
      show();
   }
}

class CvGraph extends Canvas
{  public void paint(Graphics g)
   {    
	  String[] categoryNames = new String[]{"Cat","Dog","Frog","Horse","Mouse", "House", "Couch", "Swordfish"};
	  
	  int[] categoryValues = new int[categoryNames.length];
	  for (int i = 0; i<(categoryNames.length); i++){
			categoryValues[i] = (int)(Math.random()*500);
	  }
	  //String[] categoryNames = new String[]{"Cat","Dog","Frog","Horse","Mouse"};
	  //int[] categoryValues = new int[]{200, 40, 200, 400, 500};
	  //String[] categoryNames = new String[]{"Hats","Shoes","Shirts","Pants"};
	  //int[] categoryValues = new int[]{69, 220, 19, 309, 480};
	  
	  String[] yvalues = new String[]{"0", "100", "200", "300", "400", "500"}; // range 0-500
	  int valueMax = 500;
	  g.drawLine(50, 0, 50, 500);
	  g.drawLine(50, 500, 575, 500);
	  
	  for(int n = 0; n<=(categoryNames.length-1); n++){
		int R = (int)((Math.random()*250)+n);
		int G = (int)((Math.random()*250)+n);
		int B = (int)((Math.random()*250)+n);
		Color randomColor = new Color(R, G, B);
		g.setColor(randomColor);
		
			g.fillRect(680, 20+(20*n), 10, 10);
			g.fillRect(80+((500/(categoryNames.length))*n),valueMax-categoryValues[n], 40, categoryValues[n]);
			
			g.setColor(Color.black);
			g.drawString(categoryNames[n], 700, 30+(20*n));	
			g.drawString(categoryNames[n], (100 + (500/((categoryNames.length))*n)), 525);
			g.drawLine((100 + ((500/(categoryNames.length))*n)),500,(100 + ((500/(categoryNames.length))*n)),510);
			
			
			for(int j = 0; j<yvalues.length; j++){
				g.drawLine(40,(100*j),60,(100*j));
				g.drawString(yvalues[j], 20, 520-(100*j));
				
			}
	  }
   }
}