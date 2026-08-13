package Freeflix.service;


import Freeflix.model.Movie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class StreamingService {

  @Value("${freeflix.streaming.hlsBaseUrl}")
  private String hlsBaseUrl;

  public String getPlaylist(Movie movie) {
    return movie.getHlsPlaylistUrl(); // e.g., /hls/movie123/master.m3u8
  }

  public String absolutePlaylistUrl(Movie movie) {
    String path = getPlaylist(movie);
    if (path.startsWith("http")) return path;
    return hlsBaseUrl + path.replace("/hls", "");
  }
}