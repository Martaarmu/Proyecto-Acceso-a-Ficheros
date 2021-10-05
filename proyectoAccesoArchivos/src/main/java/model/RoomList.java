package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="roomlist")
public class RoomList  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="room", type=Room.class)
	private List<Room> rooms = new ArrayList<Room>();
	
	public RoomList() {}
	
	public List<Room> getRooms(){
		return rooms;		
	}
	
	public void setRooms (List<Room> rooms) {
		this.rooms = rooms;
	}
	
	public void addRoom(Room newRoom) {
		this.rooms.add(newRoom);
	}
	
}
