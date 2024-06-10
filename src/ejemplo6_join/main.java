package ejemplo6_join;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		proceso hilo1=new proceso("Hilo 1");
		proceso hilo2=new proceso("Hilo 2");
		proceso hilo3=new proceso("Hilo 3");
		
		
		try {
			hilo1.start();
			hilo1.join();
//			hilo2.start();
//			hilo2.join();
//			hilo3.start();
//			hilo3.join();
			System.out.println("Fin de programa");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
