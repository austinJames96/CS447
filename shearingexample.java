import java.awt.Component;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.RoundRectangle2D;
 
public class TransformShapes {
 
    public static void main(String[] args) {
 
  // Create a frame
 
  Frame frame = new Frame();
 
  // Add a component with a custom paint method
 
  frame.add(new CustomPaintComponent());
 
  // Display the frame
 
  int frameWidth = 300;
 
  int frameHeight = 300;
 
  frame.setSize(frameWidth, frameHeight);
 
  frame.setVisible(true);
 
    }
 
    /**
     * To draw on the screen, it is first necessary to subclass a Component 
     * and override its paint() method. The paint() method is automatically called 
     * by the windowing system whenever component's area needs to be repainted.
     */
    static class CustomPaintComponent extends Component {
 
  public void paint(Graphics g) {
 
    // Retrieve the graphics context; this object is used to paint shapes
 
    Graphics2D g2d = (Graphics2D)g;
 
    /**
 
     * The coordinate system of a graphics context is such that the origin is at the 
 
     * northwest corner and x-axis increases toward the right while the y-axis increases 
 
     * toward the bottom.
 
     */
 
    int x = 0;
 
    int y = 0;
 
    int w = getSize().width-1;
 
    int h = getSize().height-1;
 
    Shape roundRectangle = new RoundRectangle2D.Float(x, y, w, h, w/2, h/2);
 
    AffineTransform affineTransform = new AffineTransform();
 
    affineTransform.scale(0.6, 0.4);
 
    affineTransform.shear(0.3, 0.7);
 
    affineTransform.translate(w/4, h/4);
 
    affineTransform.rotate(0.12);
 
    Shape newRoundRectangle = affineTransform.createTransformedShape(roundRectangle);
 
    g2d.draw(roundRectangle);
 
    g2d.draw(newRoundRectangle);
 
  }
 
    }
 
}