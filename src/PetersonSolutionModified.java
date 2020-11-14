
public class PetersonSolutionModified implements Runnable{
	private boolean waiting[];
	private volatile int turn;
	private int count;
	private boolean exit;
	public PetersonSolutionModified(int count) {
		waiting = new boolean[2];
		this.count = count;
		this.exit = false;
	}
	
	public boolean exit() {
		return this.exit;
	}
	
	public void setExit(boolean exit) {
		this.exit = exit;
	}
	
	public int getCount() {
		return count;
	}
	
	@Override
	public void run() {
		int threadId = Integer.parseInt(Thread.currentThread().getName());
		while(!exit) {
			waiting[threadId] = true;
			turn = 1 - threadId;
			while(waiting[turn] && turn == 1-threadId) 
				System.out.println(threadId + " is busy waiting");
			
			if(threadId == 0)
				count++;
			else
				count--;
			
			System.out.println("T"+threadId+" count:" + count);
			
			waiting[threadId] = false;
		}
	}
	
	
}
