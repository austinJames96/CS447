//Austin Sypolt
//Range Map Project

import java.awt.*;
import java.awt.event.*;


public class rangemapdefpoly extends Frame
{  public static void main(String[] args){new rangemapdefpoly();}
 
   rangemapdefpoly()
   {  super("Robot Range Map");
      addWindowListener(new WindowAdapter()
      {public void windowClosing(WindowEvent e){System.exit(0);}});
      setSize(900, 600);
      add("Center", new rangemapcvdefpoly());
      //setCursor(Cursor.getPredefinedCursor(CROSSHAIR_CURSOR));
      show();
   }
}