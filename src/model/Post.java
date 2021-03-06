package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Post {
	
	private long postId;
	private String postName;
	private Category category;
	private String pictureURL;
	private String description;
	private User author;
	private LocalDateTime date;
	private ArrayList<Comment> comments;
	private String destination;
	private double longitude;
	private double latitude;
	private ArrayList<String> hashtags;
	private String videoURL;
	private HashSet<User> likedBy;
	
	
	public Post(String postName,Category category, String description, User author, LocalDateTime date,
			String destinationName, double longitude, double latitude, String pictureURL, String videoURl, ArrayList<String> hashTags) throws InvalidInputException {
		
		if(checkString(postName)) {
			this.postName=postName;
		}
		if(checkString(destinationName)) {
			this.destination=destinationName;
		}
		this.latitude=latitude;
		this.longitude=longitude;
		this.category=category;
		
		if(checkString(description)) {
			this.description = description;
		}
		else {
			throw new InvalidInputException("Invalid post description!");
		}
		this.pictureURL=pictureURL; // no checking for string!=null and empty string, cause picture and video can be null if the post doesn't contain one
		this.videoURL=videoURl;
		
		this.author = author;
		this.date = date;
		this.comments = new ArrayList<>();
		this.hashtags= new ArrayList<>();
		this.hashtags=hashTags;
	}
	
	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	public String getVideoURL() {
		return videoURL;
	}
	
	public void addComment(Comment c) {
		this.comments.add(c);
	}
	

	public String getPictureURL() {
		return pictureURL;
	}

	public String getDescription() {
		return description;
	}

	public User getAuthor() {
		return author;
	}

	public LocalDateTime getDate() {
		return date;
	}
	public int getLikes() {
		return likedBy.size();
	}
	
	public void like(User u){
		likedBy.add(u);
	}

	public List<Comment> getComments() {
		return Collections.unmodifiableList(comments);
	}

	public String getDestination() {
		return destination;
	}
	

	public String getPostName() {
		return postName;
	}

	public Category getCategory() {
		return category;
	}

	public double getLongitude() {
		return longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	private boolean checkString(String name) {
		if (name != null && !name.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public void addHashtags(String[] args){
		for (String string : args) {
			hashtags.add(string);
		}
	}
	
	public List<String> getHashtags() {
		return Collections.unmodifiableList(hashtags);
	}

	public void addLiker(User user) {
		likedBy.add(user);
		
	}
	
	
	
	
	
}
