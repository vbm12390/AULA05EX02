package controller;
import java.util.concurrent.Semaphore;

public class PortaController extends Thread{
	private int pessoa;
	private Semaphore semaphore;

	public PortaController(int pessoa, Semaphore semaphore) {
		this.semaphore = semaphore;
		this.pessoa= pessoa;
		int soma = pessoa + pessoa;
		System.out.println(pessoa + "Chegou= "+ soma );
	}
	
	@Override
	public void run() {
		
		PessoaAndando(pessoa);
		try {
			semaphore.acquire();
	        PassandoPorta();
		} catch (Exception error) {
	          error.printStackTrace();
	    } 
	    finally {
	        semaphore.release();
	    }
	}

	private void PessoaAndando(int pessoa) {
		int distanciaPercorrida=0;
		while(distanciaPercorrida<=200) {
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int PessoaAnda = (int)((Math.random() * 3) + 4);
			distanciaPercorrida+= PessoaAnda;
			System.out.println("Pessoa "+ pessoa+" Andou "+ PessoaAnda + "m/s" + "# Total ==> "+ distanciaPercorrida);
			if (distanciaPercorrida>=200) {
				System.err.println(pessoa+ " Chegou na Porta");
				break;
			}
		}
	}

	private void PassandoPorta() {
		int abrindoporta = (int)((Math.random() * 2) + 1);
		try {
			System.err.println(pessoa + " Está abrindo a porta");		
			sleep(abrindoporta * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.err.println(pessoa + " Atravesou" + " ==> Demorou "+ abrindoporta + " Segundos Para Abrir a porta");		
	}
	
	

}
