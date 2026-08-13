package Freeflix.auth;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

  private final Key key;
  private final long expirationMillis;

  public JwtUtil(@Value("${freeflix.jwt.secret}") String secret,
                 @Value("${freeflix.jwt.expirationMinutes}") long expirationMinutes) {
    this.key = Keys.hmacShaKeyFor(secret.getBytes());
    this.expirationMillis = expirationMinutes * 60_000;
  }

  public String generateToken(String username) {
    return Jwts.builder()
      .setSubject(username)
      .setIssuedAt(new Date())
      .setExpiration(new Date(System.currentTimeMillis() + expirationMillis))
      .signWith(key, SignatureAlgorithm.HS256)
      .compact();
  }

  public String extractUsername(String token) {
    return Jwts.parserBuilder().setSigningKey(key).build()
      .parseClaimsJws(token).getBody().getSubject();
  }

  public boolean validateToken(String token, UserDetails userDetails) {
    try {
      String username = extractUsername(token);
      return username.equals(userDetails.getUsername()) &&
             !isTokenExpired(token);
    } catch (JwtException e) {
      return false;
    }
  }

  private boolean isTokenExpired(String token) {
    Date expiration = Jwts.parserBuilder().setSigningKey(key).build()
      .parseClaimsJws(token).getBody().getExpiration();
    return expiration.before(new Date());
  }
}