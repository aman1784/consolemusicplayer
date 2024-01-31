import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    // Declare private fields to store the name, artist, and a list of songs in the album
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    // Default constructor with no parameters
    public Album(){
        // Empty constructor
    }

    // Parameterized constructor with name and artist parameters
    public Album(String name, String artist) {

        this.name = name;
        this.artist = artist;
        // Initialize the list of songs as an ArrayList
        this.songs = new ArrayList<Song>();
    }

    // Method to find a song in the album by its title
    public Song findSong(String title) {
        // Iterate through the list of songs
        for (Song checkedSongs : songs) {
            // If a song with the specified title is found, return the song
            if (checkedSongs.getTitle().equals(title))
                return checkedSongs;
        }
        // If no song with the specified title is found, return null
        return null;
    }

    // Method to add a new song to the album
    public boolean addSong(String title, double duration) {
        // Check if the song already exists in the album
        if (findSong(title) == null) {
            // If the song does not exist, create a new Song object and add it to the list of songs
            songs.add(new Song(title, duration));
            // Return true to indicate successful addition
            return true;
        } else {
            // If the song already exists, return false to indicate that the addition was not successful
            return false;
        }
    }

    // Method to add a song from the album to a playlist by track number
    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        // Calculate the index of the song based on the provided track number
        int index = trackNumber - 1;
        // Check if the calculated index is within the valid range of song indices
        if (index >= 0 && index < this.songs.size()) {
            // Add the song to the playlist and return true to indicate success
            playList.add(this.songs.get(index));
            return true;
        }
        // Return false to indicate that the addition was not successful
        return false;
    }

    // Method to add a song from the album to a playlist by title
    public boolean addToPlaylist(String title, LinkedList<Song> playList) {
        // Iterate through the list of songs in the album
        for (Song checkedSong : this.songs) {
            // If a song with the specified title is found, add it to the playlist and return true
            if (checkedSong.getTitle().equals(title)) {
                playList.add(checkedSong);
                return true;
            }
        }
        // If no song with the specified title is found, return false
        return false;
    }
}
