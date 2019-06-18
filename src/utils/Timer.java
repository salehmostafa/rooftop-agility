package utils;


import org.osbot.rs07.script.MethodProvider;

public class Timer {
	private long timeStarted, timeOut;
	private final int lowerBoundsTimeOut, upperBoundsTimeOut;
	
	/**
	 * 
	 * @param minutes Whether the lower and upper bounds are given in minutes or milliseconds
	 * @param lowerBoundsTimeOut The lowest possible time out value
	 * @param upperBoundsTimeOut The highest possible time out value
	 * @param instantTimeOut If the timer should start already timed out
	 */
	public Timer(boolean minutes, int lowerBoundsTimeOut, int upperBoundsTimeOut, boolean instantTimeOut) {
		if(lowerBoundsTimeOut < upperBoundsTimeOut) {
			if(minutes) {
				this.lowerBoundsTimeOut = 60000*lowerBoundsTimeOut;
				this.upperBoundsTimeOut = 60000*upperBoundsTimeOut;
			} else {
				this.lowerBoundsTimeOut = lowerBoundsTimeOut;
				this.upperBoundsTimeOut = upperBoundsTimeOut;
			}
		} else {
			if(minutes) {
				this.lowerBoundsTimeOut = 60000*lowerBoundsTimeOut;
				this.upperBoundsTimeOut = 60000*upperBoundsTimeOut;
			} else {
				this.lowerBoundsTimeOut = lowerBoundsTimeOut;
				this.upperBoundsTimeOut = upperBoundsTimeOut;
			}
		}
		setStart(instantTimeOut ? 0 : System.currentTimeMillis());
		this.timeOut = MethodProvider.random(this.lowerBoundsTimeOut, this.upperBoundsTimeOut);
	}
	
	public Timer(boolean minutes, int lowerBoundsTimeOut, int upperBoundsTimeOut) {
		this(minutes, lowerBoundsTimeOut, upperBoundsTimeOut, false);
	}
	
	public Timer(boolean minutes, int timeOut, boolean instantTimeOut) {
		this(minutes, timeOut, timeOut + 1, instantTimeOut);
	}
	
	public Timer(int lowerBoundsTimeOut, int upperBoundsTimeOut) {
		this(false, lowerBoundsTimeOut, upperBoundsTimeOut);
	}
	
	public Timer(boolean minutes, int timeOut) {
		this(minutes, timeOut, timeOut + 1);
	}
	
	public Timer(int timeOut) {
		this(false, timeOut + 1);
	}
	
	/**
	 * Creates a new timer incapable of timing out.
	 */
	public Timer() {
		this(-1);
	}
	
	/**
	 * Sets the starting time of the timer 
	 */
	public void setStart(long start) {
		this.timeStarted = start;
	}
	
	/**
	 * Returns the time elapsed required to time out.
	 */
	public long getTimeOut() {
		return timeOut;
	}
	
	/**
	 * Returns if the timer is capable of timing out.
	 */
	public boolean canTimeOut() {
		return lowerBoundsTimeOut >= 0;
	}
	
	/**
	 * Returns the time elapsed since the timer was started
	 */
	public long timeElapsed() {
		return System.currentTimeMillis() - timeStarted;
	}
	
	/**
	 * Returns if the timer has passed the given amount of time elapsed.
	 * 
	 * @param minutes Whether timePassed is given in minutes or milliseconds
	 * @param timePassed The amount of time to check if the timer has passed.
	 * @return
	 */
	public boolean hasPassed(boolean minutes, long timePassed) {
		return timeElapsed() >= (minutes ? timePassed*60000 : timePassed);
	}
	
	/**
	 * @param timePassed The amount of time to check if the timer has passed in ms.
	 */
	public boolean hasPassed(long timePassed) {
		return hasPassed(false, timePassed);
	}
	
	/**
	 * Returns if the timer has timed out
	 */
	public boolean timedOut() {
		return canTimeOut() && hasPassed(getTimeOut());
	}
	
	/**
	 * Restarts the timer
	 */
	public void restart() {
		setStart(System.currentTimeMillis());
	}
	
	/**
	 * Randomizes time until time out
	 */
	public void randomizeTimeOut() {
		timeOut = MethodProvider.random(lowerBoundsTimeOut, upperBoundsTimeOut);
	}
	
	/**
	 * Restarts and randomizes the time out.
	 */
	public void restartAndRandomize() {
		restart();
		randomizeTimeOut();
	}
	
	/**
	 * If the timer is capable of timing out, this returns the time until the timer will out, or
	 * 0 if the timer has already timed out.
	 */
	public long timeUntilTimeOut() {
		if(canTimeOut()) {
			long timeUntilTimeOut = getTimeOut() - timeElapsed();
			return timeUntilTimeOut < 0 ? 0 : timeUntilTimeOut;
		}
		return -1;
	}
	
	/**
	 * Returns the number of units per hour have been gained according to time elapsed.
	 */
	public int perHour(int units) {
		return (int)Math.round((units / (timeElapsed() / 3600000.0D)));
	}
	
	/**
	 * Returns the formatted count down until time out.
	 */
	public String asCountDown() {
		return format(timeUntilTimeOut());
	}
	
	/**
	 * Returns the formatted time elapsed.
	 */
	@Override
	public String toString() {
		return format(timeElapsed());
	}
	
	public static String format(long timeElapsed) {
		if(timeElapsed < 0)
			return ("00:00");
		
		long s = timeElapsed / 1000, m = s / 60, h = m / 60, d = h / 24;
	     s %= 60; m %= 60; h %= 24;

	     return d > 0 ? String.format("%02d:%02d:%02d:%02d", d, h, m, s) :
	    	 h > 0 ? String.format("%02d:%02d:%02d", h, m, s) :
	    	 String.format("%02d:%02d", m, s);
	}
}