package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="roomlist")

public class RoomList implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@XmlElement(name="room",type=Room.class)
	private Set<Room> rooms=new HashSet<Room>();
	
	public RoomList() {}
	
	
	
	public RoomList(Set<Room> rooms) {
		this.rooms = rooms;
	}



	public Set<Room> getRooms(){
		return rooms;
	}
	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}
	
	public void addRoom(Room newRoom) {
		rooms.add(newRoom);
	}

	@Override
	public String toString() {
		return "\n"+rooms;
	}

	
	
}