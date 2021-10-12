import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import javax.xml.bind.JAXBException;

import model.Message;
import model.Room;
import model.RoomList;
import model.User;
import utils.JAXBManager;

public class Ejecutable2 {
	public static File f = new File("prueba1.xml");
	public static RoomList rl=JAXBManager.unmarshal(f);
	public static void main(String[] args) {

		String nickname="";
		System.out.println("nuevo user: ");
		nickname=utils.Utilities.getString();
		User u = new User (nickname);
		rl = JAXBManager.unmarshal(f);
		Set<Room> roomlist = rl.getRooms();
			
			for(Room r: roomlist) {
				if(r.getName().equals("Sala 1")) {
					
					r.addUser(u);
				
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
	
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			@Override
			public void run() {
				rl=JAXBManager.unmarshal(f);
				System.out.println(rl);
			}
		}, 0, 8000);
		
		
		//System.exit(0);
	
	}

}
