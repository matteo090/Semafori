// Matteo Zanette 5Bia 01/10/2021


package Semafori;
import java.util.concurrent.Semaphore;

public class Task implements Runnable{
	
	private Semaphore mutex;
	private Semaphore mutex2;
	private String parola="";
	
	public Task(String Parola, Semaphore mutex, Semaphore mutex2)
	{
		this.mutex=mutex;
		this.mutex2=mutex2;
		this.parola=Parola;
	}
	
	public void run()
	{
		while(true)
		{
			try {
				mutex.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println(Thread.currentThread().getName() + ": " + parola);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			mutex2.release();//fine sezione critica
		}
	}
}
