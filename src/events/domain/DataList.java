package events.domain;
import java.util.List;
import java.util.ArrayList;

public class DataList implements IDataStore {
	private List<Event> events;
	
	public DataList() {
		events = new ArrayList<Event>();
	}
	
	public void addEvent(Event eventObj) {
		events.add(eventObj);
	}
	
	public int getNumberOfEvent() {
		return events.size();
	}
	
	public List<Event> getAllEvents(){
		return events;
	}
	
	
	public Event searchEvent(String searchTitle) {
		for(int i = 0; i < events.size(); i++)
		{
			if(events.get(i).getTitle().equals(searchTitle))
				return events.get(i);
		}
		return null;
	}
	
}
