package Freeflix.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;

@Document("watch_history")
public class WatchHistory {
  @Id
  private String id;
  private String userId;
  private String movieId;
  private Instant startedAt;
  private Instant finishedAt;
  private long secondsWatched;
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getMovieId() {
    return movieId;
  }

  public void setMovieId(String movieId) {
    this.movieId = movieId;
  }

  public Instant getStartedAt() {
    return startedAt;
  }

  public void setStartedAt(Instant startedAt) {
    this.startedAt = startedAt;
  }

  public Instant getFinishedAt() {
    return finishedAt;
  }

  public void setFinishedAt(Instant finishedAt) {
    this.finishedAt = finishedAt;
  }

  public long getSecondsWatched() {
    return secondsWatched;
  }

  public void setSecondsWatched(long secondsWatched) {
    this.secondsWatched = secondsWatched;
  }
}