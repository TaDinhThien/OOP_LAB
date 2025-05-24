package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	private static int nbDigitalVideoDiscs = 0;
	 private int id;
	
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		 this.id = ++nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		 this.id = ++nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		 this.id = ++nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		 this.id = ++nbDigitalVideoDiscs;
	}
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	 public int getId() { return id; }
	 
	 //cac phuong thuc chinh sua thuoc tinh cua du lieu
	 // ap dung cho phan TestPassingParameter
	public void setTitle(String title) {
		this.title = title;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public DigitalVideoDisc() {
        super();
    }

    public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost, length, director);
    }
    public DigitalVideoDisc(int id, String title, String category, float cost) {
        super();
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    @Override
    public String toString() {
        if (getDirector() == null)
            return "DVD - " + getTitle() + " - " + getCategory() + " - " + getCost() + " $ ";
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - "
                + getLength() + " : " + getCost() + " $ ";
    }
    
}

