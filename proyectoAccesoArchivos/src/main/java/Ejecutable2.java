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
		System.out.println("Inserte nickname: ");
		nickname = Utilities.getString();
		User u = new User(nickname);
		rl = JAXBManager.unmarshal(f);
		Set<Room> roomlist = rl.getRooms();
		for (final Room r : roomlist) {
			if (r.getName().equals("Sala 1")) {
				Set<User> users = r.getUsers();

				r.addUser(u);
				System.out.println(r.getUsers());
				System.out.println(r.getMessages());
				LocalDateTime date = LocalDateTime.now();
				m = writeMessage(u, date);
				r.addMessage(m);
				try {
					JAXBManager.marshal(rl, f);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (JAXBException e2) {
					e2.printStackTrace();
				}
				Timer t = new Timer();
				t.schedule(new TimerTask() {
					@Override
					public void run() {
						rl = JAXBManager.unmarshal(f);
						System.out.println(rl);
					}
				}, 0, 8000);
				int opcion1 = -1;
				do {
					System.out.println("Quieres escribir otro mensaje? Pulsa 1");
					System.out.println("Pulsa 0 para salir...");
					opcion1 = Utilities.getInt();
					switch (opcion1) {
					case 0:
						System.out.println("Hasta luego!");
						users.remove(u);
						r.setUsers(users);
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
		try {
			JAXBManager.marshal(rl, f);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.exit(0);

	}

	public static Message writeMessage(User u, LocalDateTime date) {
		Message m = new Message();
		String text = "";
		System.out.println("Escribe aqui tu mensaje: ");
		text = Utilities.getString();
		m = new Message(date, u, text);
		return m;
	}
}