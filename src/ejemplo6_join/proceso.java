package ejemplo6_join;

import java.io.IOException;

import libreriaVersion2.files;
import libreriaVersion2.generic;

public class proceso extends Thread{
	
	private generic<String,Integer>data;
	
	public proceso(String nameProcess) {
		super(nameProcess);
		data=new generic<>();
		data.loadElements("Joseph","Sebastian","Juan","Jhon","Antony","Mateo"
				,"Jose","Cristian","Ariel","Fabian","Victor","Andy","David",
				"Erick","Josue","Karla","Mayerli","Alex","Dilan","Andre","Luis","Alison","Steven");
	}
	private int getIndex(int value) {
		return (int)(Math.random()*value);
	}
	private void listElements() {
		String [] list=new String[data.getAttribute5().length];
		for(int i=0;i<list.length;i++) {
			list[i]="";
		}
		boolean flag=false;
		for(int i=0;i<list.length;i++) {
			do {
				flag=false;
				data.setAttribute1(data.getAttribute5()[getIndex(data.getAttribute5().length)]);
				for(String name:list) {
					if(name.equals(data.getAttribute1())) {
						flag=true;
					}
				}
			}while(flag);
			list[i]=data.getAttribute1();
		}
		data.setAttribute5(list);
	}
	
	private void saveNames(String name) throws IOException {
		files archivo=new files("src/doc/afortunados.txt");
		archivo.writerFile(name, false);
	}
	public void run() {
		listElements();
		String [] actividad= {"BAILAR","NO HACE NADA","CONTAR UN CHISTE","10 FLEXIONES DE PECHO","UNA POESIA"
				,"CHOCOLATES"};
		for(String name:data.getAttribute5()) {
			data.setAttribute1(name + "\t ACTIVIDAD:"+actividad[getIndex(actividad.length)]);
			System.out.println(data.getAttribute1());
			
			try {
				saveNames(data.getAttribute1());
				sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("******************************");
	}

}
