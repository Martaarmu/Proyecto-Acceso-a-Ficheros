import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import javax.xml.bind.JAXBException;

import model.Message;
import model.Room;
import model.RoomList;
import model.User;
import utils.JAXBManager;
import utils.Utilities;

public class Ejecutable2 {
	public static File f = new File("prueba1.xml");
	public static RoomList rl = JAXBManager.unmarshal(f);

	public static void main(final String[] args) {
		Message m = new Message();
		String nickname = "";
		System.out.println("** Bienvenido al Chat Vintage:                 **");
		System.out.println("** Inserte su nickname para entrar en la sala: **");
		nickname = Utilities.getString();
		rl = JAXBManager.unmarshal(f);
		Set<Room> roomlist = rl.getRooms();
		
		for ( Room r : roomlist) {
			if (r.getName().equals("Sala 1")) {
				User u = new User(nickname);
				
				Set<User> users = r.getUsers();
				users.add(u);
				r.addUser(u);
				System.out.println("Los usuarios conectados son:");
				System.out.println(r.getUsers());
			
				
				save();
				refresh();
				
				LocalDateTime date = LocalDateTime.now();
				m = writeMessage(u, date);
				r.addMessage(m);
				int opcion1 = -1;
				do {
					System.out.println("Para escribir un nuevo mensaje pulse: 1");
	                System.out.println("Para salir del chat pulse: 0");
					opcion1 = Utilities.getInt();
					switch (opcion1) {
					case 0:
						System.out.println("Has salido del chat.");

					for(User j:users) {
							if(j.getNickname().equals(u.getNickname())) {
								r.getUsers().remove(j);
								break;
							}
						}
					rl.setRooms(roomlist);
						
						break;
					default:
						m = writeMessage(u, date);
						r.addMessage(m);
						break;

					}
				} while (opcion1 != 0);

			}
		}
		
		
		
		save();
		

		System.exit(0);

	}
	
	/**
	* Método que carga el XML cada 8s
	*/
	public static void refresh() {
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			@Override
			public void run() {
				rl = JAXBManager.unmarshal(f);
				System.out.println(rl);
			}
		}, 0, 8000);
	}
	/**
	* Método que guarda en XML
	*/
	public static void save() {
		try {
			JAXBManager.marshal(rl, f);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	* Método que permite escribir un mensaje
	* @param u, date
	* @return Menssage
	*/
	public static Message writeMessage(User u, LocalDateTime date) {
		Message m = new Message();
		String text = "";
		System.out.println("Escribe aqui tu mensaje: ");
		text = Utilities.getString();
		m = new Message(date, u, text);
		return m;
	}
}
