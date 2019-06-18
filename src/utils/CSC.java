package utils;

import java.util.function.BooleanSupplier;

import org.osbot.rs07.utility.Condition;
import org.osbot.rs07.utility.ConditionalSleep;

/**
 * CSC - Conditional Sleep, Condition. Used to 'replace' the ConditionalSleep and Condition format
 * with functional interfaces that can be easily and cleanly written using lambda. 
 * Sleeps conditionally and converts from functional interface to Condition.
 * 
 * @author Saleh
 * @since 4/22/17
 *
 */
public class CSC {
	
	private CSC() {
	}
	
	/**
	 * Sleeps until the given condition is met
	 * 
	 * @param time The maximum amount of time to sleep for
	 * @param checkTime How often the condition should be checked
	 * @param b Functional interface in the form of a BooleanSupplier
	 * @return Whether the given condition was met
	 */
	public static boolean sleepUntil(int time, int checkTime, BooleanSupplier b) {
		return new ConditionalSleep(time, checkTime) {
			@Override
			public boolean condition() throws InterruptedException {
				return b.getAsBoolean();
			}
		}.sleep();
	}
	
	/**
	 * Sleeps until the given condition is met
	 * 
	 * @param time The maximum amount of time to sleep for
	 * @param b Functional interface in the form of a BooleanSupplier
	 * @return Whether the given condition was met
	 */
	public static boolean sleepUntil(int time, BooleanSupplier b) {
		return sleepUntil(time, 20, b);
	}
	
	/**
	 * Sleeps while the given condition is met
	 * 
	 * @param timeOut The maximum amount of time to sleep for
	 * @param checkTime How often the condition should be checked
	 * @param b Functional interface in the form of a BooleanSupplier
	 * @return Whether the given condition was met
	 */
	public static boolean sleepWhile(int timeOut, int checkTime, BooleanSupplier b) {
		return sleepUntil(timeOut, checkTime, () -> !b.getAsBoolean());
	}
	
	/**
	 * Sleeps while the given condition is met
	 * 
	 * @param timeOut The maximum amount of time to sleep for
	 * @param b Functional interface in the form of a BooleanSupplier
	 * @return Whether the given condition was met
	 */
	public static boolean sleepWhile(int timeOut, BooleanSupplier b) {
		return sleepWhile(timeOut, 20, b);
	}
	
	/**
	 * Converts from BooleanSupplier to Condition
	 * 
	 * @param b Functional interface in the form of a BooleanSupplier
	 * @return The condition form of the given BoolenSupplier
	 */
	public static Condition toC(BooleanSupplier b) {
		return new Condition() {
			@Override
			public boolean evaluate() {
				return b.getAsBoolean();
			}
		};
	}
}
