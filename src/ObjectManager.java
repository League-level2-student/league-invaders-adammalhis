import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	
	Rocketship rocket;
	ArrayList <Projectile>projectiles = new ArrayList<Projectile>();
	ArrayList <Alien>aliens = new ArrayList<Alien>();
	Random random= new Random();
	
	ObjectManager(Rocketship rocket) {
		this.rocket = rocket;
	}
	void addProjectile(Projectile projectile1) {
		projectiles.add(projectile1);
	}
	void addAlen(Alien alien1) {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
	}
	void update() {
		for(int i=0; i<aliens.size(); i++) {
			update();
			if(aliens.get(i).y <= 800 || aliens.get(i).y >= 0) {
				aliens.get(i).isActive= false;
			}
		}	
		for(int i=0; i<projectiles.size(); i++) {
			update();
			if(projectiles.get(i).y <= 800 || projectiles.get(i).y >= 0) {
				projectiles.get(i).isActive= false;
			}
		}
	}
	void draw(Graphics g) {
		for(int i=0; i<aliens.size(); i++) {
			draw(g);
		}
		for(int i=0; i<projectiles.size(); i++) {
			draw(g);
		}
		rocket.draw(g);
	}
	void purgeObjects() {
		for(int i=0; i<aliens.size(); i++) {
			if(aliens.get(i).isActive == false) {
				aliens.remove(i);
			}
		}
		for(int i=0; i<projectiles.size(); i++) {
			if(projectiles.get(i).isActive == false) {
				projectiles.remove(i);
			}
		}
	}
	 
	
}
