package ro.ase.cts.proxy;

public class YoutubeVideo {
int id;
private String title;
private float duration;
public YoutubeVideo(int id, String title, float duration) {
	super();
	this.id = id;
	this.title = title;
	this.duration = duration;
}
public int getId() {
	return id;
}
public String getTitle() {
	return title;
}
public float getDuration() {
	return duration;
}

}
