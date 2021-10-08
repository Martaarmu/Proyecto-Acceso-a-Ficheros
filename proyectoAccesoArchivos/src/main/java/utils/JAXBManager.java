package utils;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import model.Room;
import model.RoomList;
import model.User;



public class JAXBManager {
	
		public static void marshal(RoomList rl, File f) throws IOException, JAXBException{ 
			BufferedWriter writer = new BufferedWriter(new FileWriter(f));
			JAXBContext context = JAXBContext.newInstance(RoomList.class);
			Marshaller m= context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
			m.setProperty(Marshaller.JAXB_ENCODING,"utf8");
			m.marshal(rl, writer);
			writer.close();
		}
		
		
		
		public static RoomList unmarshal(File f) {
			JAXBContext jaxbContext;
			RoomList rl = new RoomList ();
			try {
				jaxbContext = JAXBContext.newInstance(RoomList.class);
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				rl = (RoomList) jaxbUnmarshaller.unmarshal(f);
				//r= newR.r;
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return rl;
		
		}
	
}
