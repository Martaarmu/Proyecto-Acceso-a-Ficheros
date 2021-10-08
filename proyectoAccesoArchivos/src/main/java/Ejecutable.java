import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import model.Message;
import model.Room;
import model.RoomList;
import model.User;
import utils.JAXBManager;
import utils.LocalDateAdapter;
import utils.Utilities;

public class Ejecutable {
	public static RoomList rl = JAXBManager.unmarshal(new File("prueba.xml") );
	public static void main(String[] args) {
		
		/*
		try {
			//JAXBManager.marshal(new RoomList(), new File("prueba.xml"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		*/
		
		ArrayList<Message> mensajes1 = new ArrayList<Message>();
		ArrayList<Message> mensajes2 = new ArrayList<Message>();
		
		User u1 = new User ("Pepe");
		User u2 = new User ("Nicolas");
		User u3 = new User ("Maria");
		
		
		Set<User> users1 = new HashSet<User>();
		Set<User> users2 = new HashSet<User>();
		users1.add(u1);
		users1.add(u2);
		users2.add(u3);
		
		Room r1 = new Room ();
		//Room r2 = new Room ("Sala 2",users2,mensajes2);
		
		
		Set<Room> roomlist = rl.getRooms();
		
		//roomlist.add(r1);
		//roomlist.add(r2);
		//rl = new RoomList(roomlist);
		
		Timer t = new Timer();
		t.schedule(new TimerTask() {

			@Override
			public void run() {
				try {
					
					JAXBManager.marshal(rl, new File("prueba.xml"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JAXBException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
			}
			
		},0, 3000);
		
		

		String nickname="";
		String text="";
		System.out.println("Inserte su nick: ");
		nickname=Utilities.getString();
		User u = new User (nickname);
		
		Message m = new Message();
		
		int opcion=-1;
		do {
			
			System.out.println("**BIENVENIDO**");
			System.out.println("Elige un chat: ");
			System.out.println("1- Sala 1");
			System.out.println("2- Sala 2");
			System.out.println("0- SALIR");
			opcion=Utilities.getInt();
			
			switch (opcion) {
			case 1:
				//r1.addUser(u);
				for(Room r: roomlist) {
					if(r.getName().equals("Sala 1")) {
						r1 = r;
						r1.addUser(u);
						mensajes1= r1.getMessages();
					}
				}
				System.out.println(r1);
				
				LocalDateTime date= LocalDateTime.now();
				m = writeMessage(u,date);
				mensajes1.add(m);
				r1.setMessages(mensajes1);
				System.out.println(mensajes1);
				
				int opcion1 = -1;
				do {
					System.out.println("Quieres escribir otro mensaje? Pulsa 1");
					System.out.println("Pulsa 0 para salir...");
					opcion1=Utilities.getInt();
					switch (opcion1) {
					case 0:
						System.out.println("Hasta luego!");
						break;

					default:
						m = writeMessage(u,date);
						mensajes1.add(m);
						r1.setMessages(mensajes1);
						break;
					}
				} while (opcion1!=0);
				
				break;
				
			case 2:
				//r2.addUser(u);
				//System.out.println(r2);
				break;
			case 0:
				System.out.println("Hasta luego. Gracias");
				users1.remove(u);
				break;

			default:
				System.out.println("");
				break;
			}
		}while(opcion!=0);
		

		
		////////CARGA Y GUARDA DEL XML
		/*try {
			JAXBManager.marshal(rl, new File("prueba.xml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
	
		
		
		
		////////////////////////////////////////////////////////////////////
		System.exit(0);
	}

	public static Message writeMessage(User u, LocalDateTime date) {
		String text ="";
		System.out.println("Escribe aquí tu mensaje: ");
		text=Utilities.getString();	
		Message m = new Message(date,u,text);
		return m;
		
	}
}
