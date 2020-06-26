package events.domain;

import java.util.List;

public class Controller {
	private IDataStore dataList;
	
	public Controller() {
		dataList = null;
	}
	
	public void setList(IDataStore dataLists) {
		this.dataList = dataLists;
	}
	
	public void addEvent(String title,String date,String venue,String theme) {
		dataList.addEvent(new Event(title,date,venue,theme));
	}

	
	public int getNumberOfEvent() {
		return dataList.getNumberOfEvent();
	}
	
	public List<Event> getAllEvents(){
		return dataList.getAllEvents();
	}
	
	public Event searchEvent(String searchTitle) {
		return dataList.searchEvent(searchTitle);
	}
	
	public void assignTalk(Event theEvent,Talk theTalk) {
		theEvent.assignTalk(theTalk);
	}
	public void assignGuest(Event theEvent,Guest theGuest) {
		theEvent.assignGuest(theGuest);
	}

	public Guest searchGuest(Event theEvent, String searchName) {
		for(int i = 0; i < theEvent.getNumberOfGuestAssigned(); i++)
		{
			if(theEvent.getAllGuestsAssigned().get(i).getName().equals(searchName))
				return theEvent.getAllGuestsAssigned().get(i);
		}
		return null;
	}
}

