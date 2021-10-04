package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import model.User;


public class JAXBManager {
	
		
		public static void marshal(User u, File f) throws IOException, JAXBException{ 
			BufferedWriter writer = new BufferedWriter(new FileWriter(f));
			JAXBContext context = JAXBContext.newInstance(User.class);
			Marshaller m= context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
			m.setProperty(Marshaller.JAXB_ENCODING,"utf8");
			m.marshal(u, writer);
		}
		public static User unmarshal(File f) {
			return null;
		}
	
}
