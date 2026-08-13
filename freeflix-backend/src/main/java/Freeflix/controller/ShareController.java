// src/main/java/com/freeflix/controller/ShareController.java
package Freeflix.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/share")
public class ShareController {

  @GetMapping("/movie/{movieId}")
  public Map<String, String> shareLink(@PathVariable String movieId) {
    // In production, generate short links
    return Map.of("url", "https://freeflix.example/m/" + movieId);
  }
}
