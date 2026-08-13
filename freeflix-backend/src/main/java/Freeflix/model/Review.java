package Freeflix.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;

@Document("reviews")
public class Review {
  @Id
  private String id;
  private String movieId;
  private String userId;
  private int rating; // 1-5
  private String comment;
  private Instant createdAt;
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getMovieId() {
    return movieId;
  }

  public void setMovieId(String movieId) {
    this.movieId = movieId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }
}