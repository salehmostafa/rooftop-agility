package nodes;

import org.osbot.rs07.api.model.RS2Object;
import org.osbot.rs07.script.MethodProvider;

import utils.CSC;

public class ReenterHandler extends StaticNode {

	@Override
	public boolean validate() {
		return true;
	}

	@Override
	public int execute() throws InterruptedException {
		RS2Object enterObstacle = m.getObjects().closest(u.getCity().getStartArea(), u.getCity().getStartObstacleName());
		if(enterObstacle != null) {
			if(enterObstacle.getPosition().distance(m.myPosition()) >= 5 || !m.getMap().canReach(enterObstacle)) {
				u.setStatus("Walking to start obstacle");
				m.getWalking().webWalk(enterObstacle.getPosition());
			}
			u.setStatus("Interacting with start obstacle");
			m.getCamera().toEntity(enterObstacle);
			if(enterObstacle.interact(u.getAction(enterObstacle))) {
				CSC.sleepUntil(7000, () -> m.myPlayer().getZ() != 0);
			}
		}
		u.setStatus("Waiting to re-enter");
		return MethodProvider.random(400, 800);
	}

}
