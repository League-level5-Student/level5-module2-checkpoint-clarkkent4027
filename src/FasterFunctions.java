public class FasterFunctions {
	public static void main(String[] args) {
		float totalTime = 0;
		long startTime = System.currentTimeMillis();
		//Your Code Here
//		SlowFunctions sf = new SlowFunctions();
		
		Thread t1 = new Thread(() -> SlowFunctions.slowSortLargeArray());
		Thread t2 = new Thread(() -> SlowFunctions.ackermann(3, 14));
		Thread t3 = new Thread(() -> SlowFunctions.millionsOfSqrts());
		

		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			System.out.println("Could not join threads");
		}
		
		t1.start();
		t2.start();
		t3.start();
		
		float endTime = (float)((double)System.currentTimeMillis() - (double)startTime) / 1000.0f;
		totalTime += endTime;
		System.out.println("Total Time: " + totalTime);
	}
}
