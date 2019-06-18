package nodes;

import org.osbot.rs07.api.model.GroundItem;
import org.osbot.rs07.api.model.RS2Object;
import org.osbot.rs07.script.MethodProvider;

import utils.CSC;
import data.City;
import data.Obstacle;

public class CourseHandler extends StaticNode {

	@Override
	public boolean validate() {
		return u.getCity() == City.GNOME_AGILITY || m.myPlayer().getZ() != 0;
	}

	@Override
	public int execute() throws InterruptedException {
		if(m.myPlayer().isMoving() || m.myPlayer().isAnimating()) {
			u.setStatus("Waiting for animation");
			return MethodProvider.random(800, 1300);
		}
		Obstacle nextObstacle = u.getCourseObstacle();
		if(nextObstacle != null) {
			GroundItem mog = m.getGroundItems().closest(nextObstacle.getArea(), "Mark of grace");
			if(mog != null) {
				if(mog.getPosition().distance(m.myPosition()) >= 5) {
					u.setStatus("Walking to mark of grace");
					m.getWalking().walk(mog);
				}
				u.setStatus("Taking mark of grace...");
				if(mog.interact("Take")) {
					CSC.sleepUntil(5000, () -> !mog.exists());
				}
				return MethodProvider.random(400, 800);
			}
			
			RS2Object nextObject = m.getObjects().closest(o -> o != null && o.getName().equals(nextObstacle.getName())
										&& o.getPosition().equals(nextObstacle.getPosition()));
			if(nextObject != null) {
				if(nextObject.getPosition().distance(m.myPosition()) >= 5 || u.getLastObstacleTimer().timedOut()) {
					u.setStatus("Walking to " + nextObstacle.getName());
					m.getWalking().walk(nextObject);
				}
				if(u.getLastObstacleTimer().timedOut()) {
					u.setStatus("Moving camera to " + nextObstacle.getName());
					m.getCamera().toEntity(nextObject);
					u.getLastObstacleTimer().restart();
				}
				u.setStatus("Interacting with " + nextObstacle.getName());
				if(nextObject.interact(u.getAction(nextObject))) {
					MethodProvider.sleep(MethodProvider.random(1800, 2500));
					CSC.sleepUntil(5000, () -> !m.myPlayer().isMoving() && !m.myPlayer().isAnimating());
				}
			} else {
				u.setStatus("Walking to " + nextObstacle.getName());
				m.getWalking().walk(nextObstacle.getPosition());
			}
		}
		return 0;
	}
}
