package view;
import java.util.concurrent.Semaphore;
import controller.PortaController;

public class Principal {
	  public static void main(String[] args) {
		      int permissoes = 1;
		      Semaphore semaphore = new Semaphore(permissoes);
		      for (int pessoa = 1; pessoa <= 4; pessoa++) {
		        Thread tPessoa = new PortaController(pessoa, semaphore);
		        tPessoa.start();
		      }
	  }

}
