import java.util.Random;

public class RandGen extends Thread{
	public static int no;
	Random r;
	
	@Override
	public void run() {
		int i = 0;
		while(i < 10) {
			r = new Random();
			no = r.nextInt(10);
			i++;
			System.out.println("\nNumber generated"  + " is " + no );
			
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String [] args) throws InterruptedException {
		RandGen r = new RandGen();
		r.start();
		int i = 0;
		
		Square s;
		Cube c;
		while(i < 10) {
			
			s = new Square();
			s.start();
			Thread.sleep(500);
			
			
			c = new Cube();
			c.start();
			Thread.sleep(500);
			i++;
	
		}
	}
}

class Square extends Thread {
	@Override
	public void run() {
		System.out.println("Square is " + RandGen.no*RandGen.no);
	//	System.out.println("Output from " + Thread.currentThread());
	}
}

class Cube extends Thread {
	@Override
	public void run() {
		System.out.println("Cube is " + RandGen.no*RandGen.no*RandGen.no);
	//	System.out.println("Output from " + Thread.currentThread());
	}
}
