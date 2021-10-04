import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBException;

import model.User;
import utils.JAXBManager;

public class Ejecutable {
	public static void main(String[] args) {
		User u = new User ("Pepe");
		try {
			JAXBManager.marshal(u, new File("prueba.xml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
