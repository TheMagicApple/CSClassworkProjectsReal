
public class Song {
	private String name;
	private String artist;
	private String album;
	public Song(String name,String artist,String album) {
		this.name=name;
		this.artist=artist;
		this.album=album;
	}
	public String getName() {
		return name;
	}
	public String getArtist() {
		return artist;
	}
	public String getAlbum() {
		return album;
	}
}
