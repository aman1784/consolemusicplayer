public class Song {
    // Declare private fields to store the title and duration of the song
    private String title;
    private double duration;

    // Default constructor with no parameters
    public Song() {
        // Empty constructor
    }

    // Parameterized constructor with title and duration parameters
    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    // Getter method to retrieve the title of the song
    public String getTitle() {
        return title;
    }

    // Setter method to set the title of the song
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter method to retrieve the duration of the song
    public double getDuration() {
        return duration;
    }

    // Setter method to set the duration of the song
    public void setDuration(double duration) {
        this.duration = duration;
    }

    // Override the toString method to provide a custom string representation of the object
    @Override
    public String toString() {
        // Return a formatted string containing the title and duration of the song
        return "Song[ title= " + title + " | duration= " + duration;
    }
}
