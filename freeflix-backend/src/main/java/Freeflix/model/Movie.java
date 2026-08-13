package Freeflix.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
import java.util.List;

@Document("movies")
public class Movie {
  @Id
  private String id;
  private String title;
  private String description;
  private List<String> genres;
  private String posterUrl;
  private String hlsPlaylistUrl; // e.g., /hls/movie123/master.m3u8
  private LocalDate releaseDate;
  private boolean publicDomain;
  private String licenseId; // for indie/public domain tracking
  private double averageRating;
  private long views;
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<String> getGenres() {
    return genres;
  }

  public void setGenres(List<String> genres) {
    this.genres = genres;
  }

  public String getPosterUrl() {
    return posterUrl;
  }

  public void setPosterUrl(String posterUrl) {
    this.posterUrl = posterUrl;
  }

  public String getHlsPlaylistUrl() {
    return hlsPlaylistUrl;
  }

  public void setHlsPlaylistUrl(String hlsPlaylistUrl) {
    this.hlsPlaylistUrl = hlsPlaylistUrl;
  }

  public LocalDate getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(LocalDate releaseDate) {
    this.releaseDate = releaseDate;
  }

  public boolean isPublicDomain() {
    return publicDomain;
  }

  public void setPublicDomain(boolean publicDomain) {
    this.publicDomain = publicDomain;
  }

  public String getLicenseId() {
    return licenseId;
  }

  public void setLicenseId(String licenseId) {
    this.licenseId = licenseId;
  }

  public double getAverageRating() {
    return averageRating;
  }

  public void setAverageRating(double averageRating) {
    this.averageRating = averageRating;
  }

  public long getViews() {
    return views;
  }

  public void setViews(long views) {
    this.views = views;
  }
}