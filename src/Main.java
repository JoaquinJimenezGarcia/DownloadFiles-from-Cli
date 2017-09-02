
import java.io.IOException;

import controller.DescargaArchivo;

public class Main {

	public static void main(String[] args) {
		DescargaArchivo app = new DescargaArchivo();
		try {
			app.start();
		} catch (IOException e) {
			System.out.println("An error has occurred and the download has not been carried out successfully.");
		}
	}

}
