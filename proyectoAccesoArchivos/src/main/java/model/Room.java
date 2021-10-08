package model;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="room")
public class Room  implements Serializable{
	private static final long serialVersionUID = 1L;

	private String name;
	private Set<User> users;
	private ArrayList<Message> messages;

	public Room() {}
	public Room(String name) {
		this.name = name;
	}
	
	public Room(String name, Set<User>users) {
		this.name = name;
		this.users=users;
	}

	public Room(String name, Set<User> users, ArrayList<Message> messages) {
		this.name = name;
		this.users = users;
		this.messages = messages;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public ArrayList<Message> getMessages() {
		return messages;
	}

	public void setMessages(ArrayList<Message> messages) {
		this.messages = messages;
	}
	public void addUser(User newUser) {
		this.users.add(newUser);
	}
	public boolean existUser(User nickname) {

		boolean result = false;
		for (User u : users) {
			if (u != null && u.getNickname().equals(nickname)) {
				result = true;
			}
		}
		return result;
	}


	@Override
	public String toString() {
		return "\n" + name + "\nUsuarios:" + users + "\nMensajes:" + messages+"\n";
	}
}
