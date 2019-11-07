import java.awt.Color;
public class Rotation {

    public static void main(String[] args) {

        double angle = Math.toRadians(Double.parseDouble(args[1]));
        double sin = Math.sin(angle);
        double cos = Math.cos(angle);
        double x0 = 0.5 * (width  - 1);     // point to rotate about
        double y0 = 0.5 * (height - 1);     // center of image
		
        // rotation
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                double a = x - x0;
                double b = y - y0;
                int xx = (int) (+a * cos - b * sin + x0);
                int yy = (int) (+a * sin + b * cos + y0);

                }
            }
        }
    }
 

   
}