package help;

public class ThreadLocalTest {
	private static int num = 1;
        //创建一个Index类型的本地变量 
	private static ThreadLocal<Integer> local = new ThreadLocal<Integer>() {
		@Override
		protected synchronized Integer initialValue() {
			return num ++;
		}
	};
	
	private static ThreadLocal<Integer> getX() {
		return local;
	}

	public static void main(String[] args) throws InterruptedException {
		Thread[] threads = new Thread[5];
		for (int j = 0; j < 5; j++) {
			threads[j] = new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName() + " : "+ local.get());
					
					local = getX();
					

					System.out.println(Thread.currentThread().getName() + " : "+ local.get());
				}
			}, "Thread-" + j);
		}
		for (Thread thread : threads) {
			thread.start();
		}
	}
}