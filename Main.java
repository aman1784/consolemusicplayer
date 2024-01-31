import java.util.*;

public class Main {
    // Declare a static ArrayList to store albums
    private static ArrayList<Album> albums = new ArrayList<>();

    // Main method
    public static void main(String[] args) {

        // Create an instance of Album and add songs to it
        Album album = new Album("Album1", "AC/DC");
        album.addSong("Hello", 4.5);
        album.addSong("Hi", 5.0);
        album.addSong("Go to hell", 4.7);
        album.addSong("Bye", 4.6);

        // Add the album to the list of albums
        albums.add(album);

        // Create another instance of Album and add songs to it
        album = new Album("Album2", "eminem");
        album.addSong("emi1", 4.5);
        album.addSong("emi2", 5.0);
        album.addSong("emi3", 4.7);
        album.addSong("emi4", 4.6);

        // Add the second album to the list of albums
        albums.add(album);

        // Create a LinkedList to represent a playlist
        LinkedList<Song> playlist1 = new LinkedList<>();

        // Add songs from different albums to the playlist
        albums.get(0).addToPlaylist("Hello", playlist1);
        albums.get(0).addToPlaylist("Hi", playlist1);
        albums.get(1).addToPlaylist("emi3", playlist1);
        albums.get(1).addToPlaylist("emi4", playlist1);

        // Call the play method to simulate playing the playlist
        play(playlist1);
    }

    // Method to simulate playing a playlist
    private static void play(LinkedList<Song> playlist){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playlist.listIterator();

        // Check if the playlist is empty
        if (playlist.size() == 0){
            System.out.println("PlayList is empty");
        }else {
            // Print the currently playing song if the playlist is not empty
            System.out.println("Now Playing - " + listIterator.next().toString());
            // Print the menu options
            printMenu();
        }

        // Main loop for user interaction
        while (!quit){
            int action = sc.nextInt();
            sc.nextLine();

            switch (action){
                case 0:
                    System.out.println("Play list over...");
                    quit = true;
                    break;
                case 1:
                // Play the next song in the playlist
                    if (!forward){
                        if (listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()){
                        System.out.println("Now playing : " + listIterator.next().toString());
                    }else {
                        System.out.println("No Song Available, Reached to the end of the list...");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()){
                        System.out.println("Now Playing : " + listIterator.previous().toString());
                    } else {
                        System.out.println("We are at the first song...");
                        forward = false;
                    }
                    break;
                case 3:
                    if (forward){
                        if (listIterator.hasPrevious()){
                            System.out.println("Now Playing : " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the list...");
                        }
                    } else {
                        if (listIterator.hasNext()){
                            System.out.println("Now playing : " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached to the end of the list...");
                        }
                    }
                    break;
                case 4:
                    printLst(playlist);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playlist.size() > 0){
                        listIterator.remove();
                        if (listIterator.hasNext()){
                            System.out.println("Now playing : " + listIterator.next().toString());
                            continue;
                        } else if (listIterator.hasPrevious()){
                            System.out.println("Now Playing : " + listIterator.previous().toString());
                            continue;
                        }
                        System.out.println("Playlist is empty");
                        printMenu();
                    }
            }
        }
    }

    // Method to print the available menu options
    private static void printMenu(){
        System.out.println("Available options \npress: ");
        System.out.println("0 -> To Quit" +
                "\n1 -> To play next song" +
                "\n2 -> To play previous song" +
                "\n3 -> To replay current song" +
                "\n4 -> List of all songs" +
                "\n5 -> Print all available options" +
                "\n6 -> Delete current song");
    }

    // Method to print the list of songs in a playlist
    private static void printLst(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("====================================");

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("====================================");
    }
}