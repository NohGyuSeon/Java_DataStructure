package NGS.DataStructure.pratice.scheduler2;

import java.util.ArrayList;
import java.util.Scanner;

public class Scheduler {

	private ArrayList<Event> events = new ArrayList<>();
	private Scanner sc;

	public void processCommand() {
		try {
			while(true) {
				sc = new Scanner(System.in);
				System.out.printf("$ ");
				String command = sc.next();
				if (command.equals("addevent")) {
					String type = sc.next();
					if (type.equalsIgnoreCase("oneday"))
						handleAddOneDayEvent();
					else if (type.equalsIgnoreCase("duration"))
						handleAddDurationEvent();
					else if (type.equalsIgnoreCase("deadline"))
						handleAddDeadlinedEvent();
				}
				else if (command.equals("list")) {
					handleList();
				}
				else if (command.equals("show")) {
					
				}
				else if (command.equals("sort")) {
					
				}
				else if (command.equals("exit")) {
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}
	
	public void handleList() {
		for (Event event : events) {
			System.out.print(" " + event.toString());
		}
	}

	public void handleAddDeadlinedEvent() {
		// TODO Auto-generated method stub

	}

	public void handleAddDurationEvent() {
		// TODO Auto-generated method stub

	}

	public void handleAddOneDayEvent() {
		System.out.print(" when: ");
		String dateString = sc.next();
		System.out.print(" title : ");
		String title = sc.next();
		
		MyDate date = parseDateString(dateString);
		OneDayEvent ev = new OneDayEvent(title, date);
		addEvent(ev);
	}
	
	public void addEvent(OneDayEvent ev) {
		events.add(ev);
	}
	
	public MyDate parseDateString(String dateString) {
		String [] tokens = dateString.split("/");
		
		int year = Integer.parseInt(tokens[0]);
		int month = Integer.parseInt(tokens[1]);
		int day = Integer.parseInt(tokens[2]);
		
		MyDate d = new MyDate(year, month, day);
		
		return d;
	}
	
	public static void main(String[] args) {
		Scheduler app = new Scheduler();
		app.processCommand();
	}
	
}
