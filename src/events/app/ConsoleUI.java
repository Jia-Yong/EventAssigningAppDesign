package events.app;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import events.domain.*;


public class ConsoleUI {

		private Scanner scanner;

		private Controller controller;

		public ConsoleUI() {
			scanner = new Scanner(System.in);
			controller = null;
		}

		public void setController(Controller controller) {
			this.controller = controller;
		}

		 public void start()
		 {	 
			 int choice;
			 int option;
			 String skip;
			 do
			 {
				 
			 System.out.print("Menu\n-----------------------\n"
			 		+ "1.Create a new event record\n"
			 		+ "2.Add a talk for an event\n"
			 		+ "3.Add a guest to invite for an event\n"
			 		+ "4.Update the status of the invited guest\n"
			 		+ "5.Display all events\n"
			 		+ "6.Display the list of talks for an event\n"
			 		+ "7.Display the list of guests for an event\n");
			 choice = scanner.nextInt();
			 skip = scanner.nextLine();
			 	switch(choice)
			 	{
			 	case 1: createEvent(); break;
			 	case 2:	addTalk(); break;
			 	case 3:	addGuest(); break;
			 	case 4: updateGuest(); break;
			 	case 5: displayEvents(); break;
			 	case 6:	displayTalks(); break;
			 	case 7: displayGuests(); break;
			 	default:break;
			 	}
			 
			 System.out.print("Do you want to return to menu? 1.Yes 2.No\n");
			 option = scanner.nextInt();
			 skip = scanner.nextLine();
			 }while (option == 1);
			 
		 }
		 
		 public void createEvent()
		 {
			 System.out.println("Enter event title:");
			 String eventTitle = scanner.next();
			 System.out.println("Enter date of event:");
			 String eventDate = scanner.next();
			 System.out.println("Enter event venue:");
			 String eventVenue = scanner.next();
			 System.out.println("Enter event theme:");
			 String eventTheme = scanner.next();
			 controller.addEvent(eventTitle,eventDate,eventVenue,eventTheme);
			 System.out.println("New event created.");
		 }

		 public void addTalk()
		 {	 
			 Event theEvent = searchEvent();
			 if(theEvent != null) {
			 System.out.println("Enter talk title:");
			 String talkTitle = scanner.next();
			 System.out.println("Enter speaker name:");
			 String speaker = scanner.next();
			 System.out.println("Enter talk duration:");
			 String duration = scanner.next();
			 System.out.println("New talk added.");
			 Talk theTalk = new Talk(talkTitle,speaker,duration);
			 assignTalk(theEvent,theTalk);
			 }
			 else
				 System.out.println("Event not found.");
		 }
			
		 public void addGuest()
		 {
			 Event theEvent = searchEvent();
			 if(theEvent != null) {
			 System.out.println("Enter guest name:");
			 String guestName = scanner.next();
			 System.out.println("Enter guest contact number:");
			 String contactNo = scanner.next();
			 System.out.println("Status: 1.Accepted 2.Rejected");
			 int selectStatus = scanner.nextInt();
			 do {
				 if(selectStatus == 1) {
				 	Guest theGuest = new Guest(guestName,contactNo,"accepted");
			 	 	assignGuest(theEvent,theGuest);
			 	 	System.out.println("New guest added.");
			 		}
			 	else if(selectStatus == 2) {
				 	Guest theGuest2 = new Guest(guestName,contactNo,"declined");
				 	assignGuest(theEvent,theGuest2);
				 	System.out.println("New guest added.");
			 		}
			 	}while(selectStatus != 1 && selectStatus != 2);
			 }
			 else
				 System.out.println("Event not found.");
		 }
			
		 
		 public void updateGuest()
		 {
			 Event theEvent = searchEvent();
			 if(theEvent != null) {
				 Guest theGuest = searchGuest(theEvent);
				 if(theGuest != null)
				 {
					 System.out.println("Current guest name: "+ theGuest.getName());
					 System.out.println("Current contact number: "+ theGuest.getContact());
					 System.out.println("Current status: "+ theGuest.getStatus());
					 System.out.println("Update status: 1.Accepted 2.Rejected");
					 int updateStatus = scanner.nextInt();
					 if(updateStatus == 1)
						 theGuest.setStatus("accepted");
					 else if(updateStatus == 2)
						 theGuest.setStatus("declined");
					 System.out.println("Guest status updated.");
				 }
				 else
					 System.out.println("Guest not found.");
			 }
			 else
				 System.out.println("Event not found.");
			 
		 }

		 public void displayEvents()
		 {
			 List<Event> theEvents = controller.getAllEvents();
			 for(int i = 0; i < controller.getNumberOfEvent(); i++)
			 {
				System.out.println(i + 1 + ".") ;
				System.out.println("Event title: "+ theEvents.get(i).getTitle());
				System.out.println("Date: "+ theEvents.get(i).getDate());
				System.out.println("Venue: "+ theEvents.get(i).getVenue());
				System.out.println("Theme: "+ theEvents.get(i).getTheme());
				System.out.println("");
			 }
		 }

		 public void displayTalks()
		 {
			 Event theEvent = searchEvent();
			 if(theEvent != null) {
			 List<Talk> assignedTalks = theEvent.getAllTalksAssigned();
			 
			 	for(int i = 0; i < assignedTalks.size(); i++)
			 	{
			 		System.out.println(i + 1 + ".") ;
			 		System.out.println("Talk title: "+ assignedTalks.get(i).getTitle());
			 		System.out.println("Speaker name: "+ assignedTalks.get(i).getSpeaker());
			 		System.out.println("Talk duration: "+ assignedTalks.get(i).getDuration());
			 		System.out.println("");
			 	}
			 	
			 }
			 else
				 System.out.println("Event not found.");
		 }

		 public void displayGuests()
		 {
			 Event theEvent = searchEvent();
			 if(theEvent != null) {
			 List<Guest> assignedGuests = theEvent.getAllGuestsAssigned();
			 	for(int i = 0; i < assignedGuests.size(); i++)
			 	{
			 		System.out.println(i + 1 + ".") ;
			 		System.out.println("Guest name: "+ assignedGuests.get(i).getName());
			 		System.out.println("Contact number: "+ assignedGuests.get(i).getContact());
			 		System.out.println("Status: "+ assignedGuests.get(i).getStatus());
			 		System.out.println("");
			 	} 
			 	
			 }
			 else
				 System.out.println("Event not found.");
		 }
		 
		 //--------------------------------------------------------------------------
		 public void assignTalk(Event theEvent, Talk theTalk) {
				if(theEvent != null){
					controller.assignTalk(theEvent, theTalk);
					System.out.println("Talk assigned successfully!");
					}
				else
					System.out.println("Failed to assign talk.");
		 }
		 
		 public void assignGuest(Event theEvent, Guest theGuest) {

				if(theEvent != null){
					controller.assignGuest(theEvent, theGuest);
					System.out.println("Guest assigned successfully!");
					}
				else
					System.out.println("Failed to assign guest.");
				
		 }
		 //--------------------------------------------------------------------------
		 public Event searchEvent() {
			 System.out.println("Enter event title: ");
			 String searchTitle = scanner.next();
			 Event aEvent = controller.searchEvent(searchTitle);
			 if(aEvent != null)
				 return aEvent;
			 else
				 return null;
		 }
		 
		 public Guest searchGuest(Event theEvent) {
			 System.out.println("Enter guest name: ");
			 String searchName = scanner.next();
			 Guest aGuest = controller.searchGuest(theEvent,searchName);
			 if(aGuest != null)
				 return aGuest;
			 else
				 return null;
		 }	
		 
		
		
}
