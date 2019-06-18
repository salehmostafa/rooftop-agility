package nodes;

public class ReturnHandler extends StaticNode {

	@Override
	public boolean validate() {
		return m.myPlayer().getZ() == 0 && !u.getCity().getStartArea().contains(m.myPlayer());
	}

	@Override
	public int execute() throws InterruptedException {
		u.setStatus("Walking to start area");
		m.getWalking().webWalk(u.getCity().getStartArea());
		return 0;
	}

}
