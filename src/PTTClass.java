import java.util.Date;

public class PTTClass {
	
	private int ID;
	private String location;
	private int size;
	private Date time;
	private String semester;
	
	public PTTClass(int ID, String location, int size, Date time, String semester) {
		this.ID = ID;
		this.location = location;
		this.size = size;
		this.time = time;
		this.semester = semester;
	}
}
