import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;

public class ObjectManager implements ActionListener {

	Rocketship rocket;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	Random random = new Random();
	Timer alienTimer;

	ObjectManager(Rocketship rocket) {
		this.rocket = rocket;
		alienTimer = new Timer(1000, this);
		alienTimer.start();
	}

	void addProjectile(Projectile projectile1) {
		projectiles.add(projectile1);
	}

	void addAlien() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
	}

	void update() {
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
			if (aliens.get(i).y >= 800 || aliens.get(i).y <= 0) {
				aliens.get(i).isActive = false;
			}
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
			if (projectiles.get(i).y <= 800 || projectiles.get(i).y >= 0) {
				projectiles.get(i).isActive = false;
			}
		}
		rocket.update();
		checkCollision();
		purgeObjects();
	}

	void draw(Graphics g) {
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}
		rocket.draw(g);
	}

	void purgeObjects() {
		for (int i = 0; i < aliens.size(); i++) {
			if (aliens.get(i).isActive == false) {
				aliens.remove(i);
			}
		}
		for (int i = 0; i < projectiles.size(); i++) {
			if (projectiles.get(i).isActive == false) {
				projectiles.remove(i);
			}
		}
	}

	void checkCollision() {
		for (int i = 0; i < aliens.size(); i++) {
			Alien currentAlien = aliens.get(i);
			for (int j = 0; j < projectiles.size(); j++) {
				Projectile currentProjectile = projectiles.get(j);
				if (currentAlien.collisionBox.intersects(currentProjectile.collisionBox)) {
					currentAlien.isActive = false;
					currentProjectile.isActive = false;
				}
			}
			if (rocket.collisionBox.intersects(currentAlien.collisionBox)) {
				currentAlien.isActive = false;
				rocket.isActive = false;
			}
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();
	}

}
