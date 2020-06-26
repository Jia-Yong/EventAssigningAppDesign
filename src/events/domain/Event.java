package events.domain;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
public class Event {

	private String title;
	private String date;
	private String venue;
	private String theme;
	private List<Guest> guestsAssigned;
	private List<Talk> talksAssigned;

	public Event(String title, String date,String venue,String theme)
	{
		this.title=title;
		this.date=date;
		this.venue=venue;
		this.theme=theme;	
		guestsAssigned = new ArrayList();
		talksAssigned = new ArrayList();
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public String getDate()
	{
		return date;
	}
	
	public String getVenue()
	{
		return venue;
	}
	
	public String getTheme()
	{
		return theme;
	}
	
	public void assignGuest(Guest theGuest){
		guestsAssigned.add(theGuest);
	}
	
	public void assignTalk(Talk theTalk){
		talksAssigned.add(theTalk);
	}
	
	public List<Talk> getAllTalksAssigned(){
		return talksAssigned;
	}
	
	public List<Guest> getAllGuestsAssigned(){
		return guestsAssigned;
	}
	
	public int getNumberOfGuestAssigned() {
		return guestsAssigned.size();
	}
	
}
