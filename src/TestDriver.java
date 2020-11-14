/*
20180442
كيرلس هاني مكرم فهمي
*/
public class TestDriver implements Runnable {
	static int count = 5;
	static PetersonSolutionModified modifiedSol = new PetersonSolutionModified(count);

	public static void main(String[] args) {

		try {

			Thread t0 = new Thread(modifiedSol, "0");
			Thread t1 = new Thread(modifiedSol, "1");

			t0.start();
			t1.start();
			Thread terminator = new Thread(new TestDriver());
			terminator.start();

			t0.join();
			t1.join();

			System.out.println("final count: " + modifiedSol.getCount());
			System.out.println("###################");

			System.out.println("final count: " + modifiedSol.getCount());
		} catch (InterruptedException exc) {
			System.out.println(exc.getMessage());
		}
	}

	@Override
	public void run() {
		try {
			Thread.sleep(5000);
			modifiedSol.setExit(true);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
