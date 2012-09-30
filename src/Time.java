public class Time {
	private int hours, minutes, seconds, milliseconds;
	
	public Time(long ms) {
		milliseconds = (int)(ms % 1000);
		seconds = (int)(ms / 1000);
		minutes = seconds / 60;
		hours = minutes / 60;
		
		minutes = minutes % 60;
		seconds = seconds % 60;
	}
	
	public Time(int hours, int minutes, int seconds, int milliseconds) {
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
		this.milliseconds = milliseconds;
	}
	
	public int getHours() {
		return hours;
	}
	
	public int getMinutes() {
		return minutes;
	}
	
	public int getSeconds() {
		return seconds;
	}
	
	public int getMilliseconds() {
		return milliseconds;
	}
	
	/**
	 * timeElapsed() calculates the time that has elapsed between a later secondTime and an earlier 
	 * firstTime.
	 * @param firstTime is the earlier time being compared.
	 * @param secondTime is the later time being compared. 
	 * @return Difference in time.  This time will be NEGATIVE if secondTime occurs earlier than firstTime.
	 */
	public static Time timeElapsed(Time secondTime, Time firstTime) throws Exception {
		long firstMs = toMilliseconds(firstTime), secondMs = toMilliseconds(secondTime);
		if (secondMs < firstMs) {
			throw new Exception("Second time is less than first time.");
		}
		return new Time(secondMs - firstMs);
	}
	
	public static long toMilliseconds(Time time) {
		return (((time.hours * 60) + time.minutes) * 60 + time.seconds) * 1000 + time.milliseconds; 
	}
	
	public String toString() {
		int roundedSeconds = (milliseconds >= 500) ? seconds + 1 : seconds;
		StringBuilder sb = new StringBuilder();
		if (hours < 10) {
			sb.append("0");
		} 
		sb.append(hours + ":");
		if (minutes < 10) {
			sb.append("0");
		}
		sb.append(minutes + ":");
		if (roundedSeconds < 10) {
			sb.append("0");
		}
		sb.append(roundedSeconds);
		return sb.toString();
	}
	
	
	private static void tester(String value, String expected) {
		if (value.equals(expected)) {
			System.out.println("Test passed.");
		} else {
			System.out.println("*** Test failed: value is " + value + " and expected is " + expected);
		}
	}
	
	public static void main (String[] args) {
		Time firstTime, secondTime;
		System.out.println("== Testing conversions. == (Total Tests: 7) ");
		firstTime = new Time(1000);
		tester(firstTime.toString(), "00:00:01");
		
		firstTime = new Time(1001);
		tester(firstTime.toString(), "00:00:01");
		
		firstTime = new Time(1500);
		tester(firstTime.toString(), "00:00:02");
		
		firstTime = new Time(10000);	// 10 seconds.
		tester(firstTime.toString(), "00:00:10");
		
		firstTime = new Time(66499);	// 66.499 seconds.  Should round down.
		tester(firstTime.toString(), "00:01:06");
		
		firstTime = new Time(685000);
		tester(firstTime.toString(), "00:11:25");
		
		firstTime = new Time(7185000);
		tester(firstTime.toString(), "01:59:45");
		
		System.out.println("\n== Testing timeElapsed(). == (Total Tests: 4)");
		firstTime = new Time(1, 12, 50, 25);
		secondTime = new Time(2, 13, 51, 35);
		try {
			tester(timeElapsed(secondTime, firstTime).toString(), "01:01:01");
		} catch (Exception e) {
			System.err.print(e);
		}
		
		try {
			tester(timeElapsed(firstTime, secondTime).toString(), "Should error.");
		} catch (Exception e) {
			System.out.println("Test passed.");
		}
		
		firstTime = new Time(1, 0, 45, 499);
		secondTime = new Time(1, 1, 16, 0);	
		try {
			tester(timeElapsed(secondTime, firstTime).toString(), "00:00:31");
		} catch (Exception e) {
			System.err.print(e);
		}
		
		firstTime = new Time(1, 0, 45, 501);
		secondTime = new Time(1, 1, 16, 0);	
		try {
			tester(timeElapsed(secondTime, firstTime).toString(), "00:00:30");
		} catch (Exception e) {
			System.err.print(e);
		}
	}
}
