import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerProblem{
	static int count = 0;
	static Lock lock = new ReentrantLock();
	static Condition full = lock.newCondition();
	static Condition empty = lock.newCondition();

	static LinkedList<Integer> list = new LinkedList<>();
	static int capacity = 2 ; 

	public static void main(String[] args)  {
		//	System.out.println("here");
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				for(int i= 0 ; i < 1000 ; i++){
					lock.lock();
					//				System.out.println("hello");
					if(isFull()){

						try {
							full.await();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					count++;
					list.addFirst(i);
					System.out.println("added : "+ i);
					empty.signalAll();

					lock.unlock();
				}

			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i= 0 ; i < 10 ; i++){
					lock.lock();
					if(isEmpty()){
						try {
							empty.await();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					int value = list.removeLast();
					System.out.println("removed : "+ value);
					full.signalAll();

					lock.unlock();
				}

			}
		});

		t1.start();
		t2.start();
	
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("p "+ count);
	}

	static boolean isFull(){
		if(list.size() == capacity)
			return true;
		return false;
	}

	static boolean isEmpty(){
		if(list.size() == 0 ){
			return true;
		}
		return false;
	}

}
