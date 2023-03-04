package NGS.DataStructure.code.scheduler;

import java.util.Scanner;

public class Scheduler {
	
	private int capacity = 10;
	private Event[] events = new Event[100];
	private int n = 0;
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
		for (int i = 0; i < n; i++) {
			System.out.println(" " + events[i].toString());
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
		if (n >= capacity) {
			reallocate();
		} else {
			events[n++] = ev;
		}
	}
	
	public void reallocate() {
		Event[] tmp = new Event[capacity * 2];
		for (int i = 0; i < n; i++) {
			tmp[i] = events[i];
		}
		events = tmp;
		capacity *= 2;
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
