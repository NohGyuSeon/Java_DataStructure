package NGS.DataStructure.code.scheduler2;

public class DeadlinedEvent extends Event {
	public String title;
	public MyDate deadline;
	
	public DeadlinedEvent(String title, MyDate deadline) {
		super(title);
		this.deadline = deadline;
	}
	
	@Override
	public String toString() {
		return title + ", " + deadline.toString();
	}
	
}
