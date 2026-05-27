public class Book {
    int id;
    String title;
    boolean available=true;

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public boolean getAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
}