// Matteo Zanette 5Bia 01/10/2003


package Semafori;
import java.util.concurrent.Semaphore;
import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		Semaphore[] mutex=new Semaphore[3];
		String[] parole=new String[3];
		final int Num_Campane=3;
		
		Scanner scanner=new Scanner(System.in);
		
		for(int i=1;i<Num_Campane;i++)
		{
			mutex[i]= new Semaphore(0);
		}
		mutex[0]=new Semaphore(1);
		
		
		for(int i=0;i<Num_Campane;i++)
		{
			System.out.println("\nInserire parola da stampare della campana " + (i+1) + ": ");
			parole[i]=scanner.next();
			
		}
		
		for(int i=0;i<Num_Campane;i++)
		{
			new Thread(new Task(parole[i], mutex[i], mutex[(i+1) % Num_Campane])).start();
		}
		
		scanner.close(); //sennò da problemi
		
	}
}
