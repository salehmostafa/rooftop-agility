package utils;

import org.osbot.rs07.api.model.RS2Object;
import org.osbot.rs07.script.Script;

import data.City;
import data.Obstacle;

public class Utils {
	private final Script si;
	private final Timer timer;
	
	private String status = "Booting up";
	
	private final City city;
	
	private Obstacle lastObstacle;
	private Timer lastObstacleTimer = new Timer(12000);
	
	public Utils(Script si, City city) {
		this.si = si;
		this.city = city;
		timer = new Timer();
	}
	
	public Timer getLastObstacleTimer() {
		return lastObstacleTimer;
	}
	
	public City getCity() {
		return city;
	}
	
	public Timer getTimer() {
		return timer;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Script getScript() {
		return si;
	}
	
	public void goLogOut(String... messages) throws InterruptedException {
		for(String s: messages) {
			if(s != null) {
				getScript().log(s);
			}
		}
		getScript().getWidgets().closeOpenInterface();
		
		getScript().getLogoutTab().logOut();
		getScript().stop();
	}
	
	public Obstacle getCourseObstacle() {
		for(Obstacle obstacle : getCity().getObstacles()) {
			if(obstacle.getArea().contains(getScript().myPlayer())) {
				if(lastObstacle != obstacle) {
					lastObstacleTimer.restart();
				}
				return lastObstacle = obstacle;
			}
		}
		return null;
	}
	
	public String getAction(RS2Object object) {
		for(String action : object.getActions()) {
			if(action != null)
				return action;
		}
		return null;
	}
}
