package MultithreadingPrograms;



class First extends Thread
{
	public void run()
	{
		try {
			for(int i=1;i<6;i++)
			{
				System.out.println("First Thread is:  "+i);
				Thread.sleep(1000);
			}
		}catch(Exception ex)
		{
			System.out.println();
		}
	}
}
class Second extends Thread
{
	public void run() {
		try {
			for(int i=1;i<6;i++)
			{
				System.out.println("Second Thread is:  "+i);
				Thread.sleep(5000);
			}
		}catch(Exception ex)
		{
			System.out.println();
		}
	}
}

public class ThreadExample {

	public static void main(String[] args) {
		First f=new First();
		f.start();
		Second sd=new Second();
		sd.start();
	}

}
