import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class Screen extends Canvas implements KeyListener {

	int x;
	int y;
	
	private BufferedImage image;
	private static final long serialVersionUID = 1L;
	Car car1 = new Car(0,0);
	Car car2 = new Car(0,50);
	List<Car> CarList = new ArrayList<Car>();

	
	public Screen() {
		try {
			CarList.add(car1);
			CarList.add(car2);
			image = ImageIO.read(new File("car.png"));
			
			addKeyListener(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
			for(Car car : CarList) {
				g.drawImage(image, car.x, car.y, this);
			}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		for(Car car : CarList) {
			int gap = 10;
			switch(e.getKeyCode())
			{
			case KeyEvent.VK_UP:
				car.y -= gap;
				break;
			case KeyEvent.VK_DOWN:
				car.y += gap;
				break;
			case KeyEvent.VK_LEFT:
				car.x -= gap;
				break;
			case KeyEvent.VK_RIGHT:
				car.x += gap;
				break;
			}
			System.out.println(car.x+", "+car.y);
			repaint();
		}
	}

}
