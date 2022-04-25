import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Rocketship extends GameObject {
	
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	

	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } 
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	        needImage = false;
	    }
	}
	
	Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed= 10;
		if (needImage) {
			loadImage ("rocket.png");
		}
		
	}
	
	void draw(Graphics g) {
		 if (gotImage) {
				g.drawImage(image, x, y, width, height, null);
			} 
		 else {
				g.setColor(Color.BLUE);
				g.fillRect(x, y, width, height);
			}
	}
	
	void up() {
		if (y-10 != -10) {
		y-= speed; 
		}
	}
	
	void down() {
		if (y+10 != 730) {
		y+= speed;
		}
	}
	
	void left() {
		if (x-10 != -10) {
		x-= speed;
		}
	}
	
	void right() {
		if (x+10 != 450)
		x+= speed;
	}
	


}
