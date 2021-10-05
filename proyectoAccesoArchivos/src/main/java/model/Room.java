package model;

import java.io.Serializable;
import java.util.ArrayList;

import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlAccessType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="room")
public class Room implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private ArrayList<User> users;
	private ArrayList<Message> messages;
	
	public Room() {}
	
	public Room(String name, ArrayList<User> users, ArrayList<Message> messages) {
		super();
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

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public ArrayList<Message> getMessages() {
		return messages;
	}

	public void setMessages(ArrayList<Message> messages) {
		this.messages = messages;
	}

	@Override
	public String toString() {
		return "Room [name=" + name + ", users=" + users + ", messages=" + messages + "]";
	}
	
}
