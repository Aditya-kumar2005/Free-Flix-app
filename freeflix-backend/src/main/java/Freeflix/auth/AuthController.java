package Freeflix.auth;

import Freeflix.model.User;
import Freeflix.repo.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

  private final UserRepository userRepo;
  private final JwtUtil jwtUtil;
  private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

  public AuthController(UserRepository userRepo, JwtUtil jwtUtil) {
    this.userRepo = userRepo;
    this.jwtUtil = jwtUtil;
  }

  @PostMapping("/register")
  public String register(@RequestBody AuthRequest req) {
    User user = new User();
    user.setEmail(req.getEmail());
    user.setPasswordHash(encoder.encode(req.getPassword()));
    userRepo.save(user);
    return "OK";
  }

  @PostMapping("/login")
  public String login(@RequestBody AuthRequest req) {
    var existing = userRepo.findByEmail(req.getEmail()).orElseThrow();
    if (encoder.matches(req.getPassword(), existing.getPasswordHash())) {
      return jwtUtil.generateToken(existing.getEmail());
    }
    throw new RuntimeException("Invalid credentials");
  }
}