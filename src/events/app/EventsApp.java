package events.app;
import events.domain.*;

public class EventsApp {

	public static void main(String[] args) {
		
		IDataStore dataList = new DataList();
		
		Controller controller = new Controller();

		controller.setList(dataList);
		
		ConsoleUI userInterface = new ConsoleUI();

		userInterface.setController(controller);

		userInterface.start();

	}
}
