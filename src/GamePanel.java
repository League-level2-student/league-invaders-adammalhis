import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener { 
	
	final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState= MENU;
    Font titleFont= new Font("Arial", Font.PLAIN, 48);
    Font enterFont= new Font("Arial", Font.PLAIN, 24);
    Timer frameDraw;
    Rocketship ship= new Rocketship(250, 700, 50, 50);
    ObjectManager OM= new ObjectManager(ship);
    public static BufferedImage image;
    public static boolean needImage = true;
    public static boolean gotImage = false;	

	GamePanel() {
		frameDraw= new Timer(1000/60, this);
		frameDraw.start();
		if (needImage) {
		    loadImage ("space.png");
		}

		
	}
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } 
	        catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}
		else if(currentState == GAME){
		    drawGameState(g);
		}
		else if(currentState == END){
		    drawEndState(g);
		}
	}
	void updateMenuState() {

		
		
	}
	void updateGameState() {
		OM.update();
		
		
	}
	void updateEndState() {
		
		
		
	}
	
	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 15, 250);
		g.setFont(enterFont);
		g.drawString("Press ENTER to start", 115, 500);
		g.drawString("Press SPACE for instructions", 80, 750);
	}
	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		if (gotImage) {
			g.drawImage(image, 0, 0, 500, 800, null);
		} 
		else {
			g.setColor(Color.BLUE);
			g.fillRect(0, 0, 500, 800);
		}
		OM.draw(g);
	}
	
	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("Game Over", 110, 250);
		g.setFont(enterFont);
		g.drawString("You killed enemies", 130, 500);
		g.drawString("Press ENTER to restart", 115, 750);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}
		else if(currentState == GAME){
		    updateGameState();
		}
		else if(currentState == END){
		    updateEndState();
		}
		//System.out.println("action");
		repaint();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    } else {
		        currentState++;
		    }
		 } 
		if (e.getKeyCode()==KeyEvent.VK_UP) {
		    System.out.println("UP");
		    ship.up();
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
		    System.out.println("DOWN");
		    ship.down();
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
		    System.out.println("RIGHT");
		    ship.right();
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
		    System.out.println("LEFT");
		    ship.left();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
	
	
}


