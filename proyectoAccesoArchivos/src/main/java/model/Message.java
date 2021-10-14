package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import utils.LocalDateAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="message")
public class Message implements Serializable{
	@XmlJavaTypeAdapter (value=LocalDateAdapter.class)
	private LocalDateTime date =LocalDateTime.now();
	private User u;
	private String text ="";
	
	public Message() {}

	public Message(LocalDateTime date, User u, String text) {
		this.date = date;
		this.u = u;
		this.text = text;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Fecha: " + date + " Usuario: " + u + " Texto: " + text +"\n";
	}
	
	
	
}
