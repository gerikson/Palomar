import javax.swing.JApplet;
import java.awt.Graphics;

public class HappyFace extends JApplet {


		public void paint(Graphics canvas)
		{
			canvas.drawOval(100, 50, 200, 200);
			canvas.fillOval(155, 100, 20, 20);
			canvas.fillOval(230, 100, 20, 20);
			canvas.drawArc(150, 160, 100, 50, 0, 180);
		}


}
