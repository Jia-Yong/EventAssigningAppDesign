package events.domain;

import java.util.List;

public interface IDataStore {

	public int getNumberOfEvent();

	public List<Event> getAllEvents();

	public void addEvent(Event eventObj);

	public Event searchEvent(String searchTitle);
	
	
}
