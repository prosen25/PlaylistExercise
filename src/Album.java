import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    private ArrayList<Song> songs = new ArrayList<>();

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
    }

    public boolean addSong(String title, double duration) {

        Song song = findSong(title);
        if (song == null) {
            return songs.add(new Song(title, duration));
        }

        return false;
    }

    private Song findSong(String title) {

        for (Song song : songs) {

            if (song.getTitle().equalsIgnoreCase(title)) {
                return song;
            }
        }

        return null;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {

        if (trackNumber <=0 || trackNumber > songs.size()) {
            return false;
        }
        Song song = songs.get(trackNumber - 1);
        if (song != null) {
            return addToPlayList(song.getTitle(), playlist);
        }

        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playlist) {

        Song song = findSong(title);
        if (song != null) {
            for (Song songInPlaylist : playlist) {
                if (songInPlaylist.getTitle().equalsIgnoreCase(song.getTitle())) {
                    return true;
                }
            }
            return playlist.add(song);
        }
        return false;
    }
}
