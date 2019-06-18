package nodes;

import org.osbot.rs07.script.MethodProvider;

import utils.Utils;

public abstract class StaticNode {
	protected static Utils u;
	protected static MethodProvider m;
	
	public static void setup(Utils utils) {
		StaticNode.u = utils;
		StaticNode.m = utils.getScript();
	}
	
	public abstract boolean validate();
	public abstract int execute() throws InterruptedException;
}
