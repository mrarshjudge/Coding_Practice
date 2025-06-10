package com.practice.in.DesignPatterns;

import java.util.ArrayList;
import java.util.List;

//Observer Pattern for Event System
public class Observer_Pattern_Tester {
	public static void main(String[]args) {
		Subject channel = new YoutubeChannel();
		User user1 = new User("Arsh");
		User user2 = new User("Deep");
		User user3 = new User("Judge");
		User user4 = new User("Singh");
		
		channel.subscribe(user1);
		channel.subscribe(user2);
		channel.subscribe(user3);
		channel.subscribe(user4);
		
		channel.notifyObservers("HouseFul-5");
		channel.unsubscribe(user4);
		channel.unsubscribe(user1);
		channel.notifyObservers("HouseFul-3");
	}
}

interface Subject{
	void subscribe(Observer o);
	void unsubscribe(Observer o);
	void notifyObservers(String videoTitle);
}

class YoutubeChannel implements Subject{
	List<Observer> observerList = new ArrayList<>();
	
	@Override
	public void notifyObservers(String videoTitle) {
		for(Observer o :observerList){
			o.update(videoTitle);
		}
	}
	@Override
	public void subscribe(Observer o) {
		observerList.add(o);	
	}
	@Override
	public void unsubscribe(Observer o) {
		observerList.remove(o);
	}
	
}


interface Observer{
	void update(String videoTitle);
	String getName();
}
class User implements Observer{
	private String name;
	
	public User(String name) {
		this.name = name;
	}
	@Override
	public String getName() {
		return  this.name;
	}
	
	@Override
	public void update(String videoTitle) {
		System.out.println(this.getName()+" will watch new Video: "+videoTitle);
	}

}