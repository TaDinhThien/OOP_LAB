package hust.soict.hedspi.aims.media;


public class Track implements Playable{
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;  // Cùng tham chiếu => bằng nhau
        if (o == null || getClass() != o.getClass()) return false;  // khác lớp => không bằng

        Track other = (Track) o;
        return this.length == other.length &&
               (this.title != null && this.title.equals(other.title));
    }

    @Override
    public void play() {
        System.out.println("Playing Track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }
}
