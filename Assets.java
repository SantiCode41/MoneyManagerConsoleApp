import java.util.Random;

public class Assets {
	
	public Assets() {
		
	}
	
	public void loadingBar(int length, String outputMessage, String redirectMessage) {
		int percentIncrement = 100 / length;
		int maxDelay = 10;
		Random randomNum = new Random();
		int sleepDelay;
		try {
			for (int i = 0; i <= length; i++) {
				System.out.print("\r[");
				System.out.print(String.valueOf('#').repeat(i));
				System.out.print(String.valueOf(' ').repeat(length - i));
				System.out.print(String.format("] %d%%", (i * percentIncrement)));
				System.out.flush();
				sleepDelay = randomNum.nextInt(maxDelay);
				Thread.sleep(sleepDelay);
			}
			
			System.out.println("\n" + outputMessage);
			System.out.println(redirectMessage);
			Thread.sleep(2000);
		}
		catch (InterruptedException e) {
			System.out.println("Loading interrupted: " + e.getMessage());
		}
	}
}