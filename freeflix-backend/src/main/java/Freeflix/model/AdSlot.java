package Freeflix.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("ad_slots")
public class AdSlot {
  @Id
  private String id;
  private String name; // preroll, midroll, postroll
  private String adVideoHlsUrl; // HLS ad asset
  private int durationSeconds;
  private boolean active;
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAdVideoHlsUrl() {
    return adVideoHlsUrl;
  }

  public void setAdVideoHlsUrl(String adVideoHlsUrl) {
    this.adVideoHlsUrl = adVideoHlsUrl;
  }

  public int getDurationSeconds() {
    return durationSeconds;
  }

  public void setDurationSeconds(int durationSeconds) {
    this.durationSeconds = durationSeconds;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }
}