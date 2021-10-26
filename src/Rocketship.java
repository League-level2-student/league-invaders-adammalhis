import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	
	
	Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed= 10;
		
	}
	
	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		 g.fillRect(x, y, width, height);
	}
	
	void up() {
		if (y-10 != -10) {
		y-= speed; 
		}
	}
	
	void down() {
		if (y+10 != 310) {
		y+= speed;
		}
	}
	
	void left() {
		if (x-10 != -10) {
		x-= speed;
		}
	}
	
	void right() {
		if (x+10 != )
		x+= speed;
	}
}
