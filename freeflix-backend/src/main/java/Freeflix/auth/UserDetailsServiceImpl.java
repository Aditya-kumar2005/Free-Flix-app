package Freeflix.auth;

import Freeflix.model.User;
import Freeflix.repo.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserRepository userRepo;

	public UserDetailsServiceImpl(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User u = userRepo.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
		String[] roles = u.getRoles() == null ? new String[0] : u.getRoles().toArray(new String[0]);
		return org.springframework.security.core.userdetails.User.withUsername(u.getEmail())
			.password(u.getPasswordHash())
			.authorities(roles)
			.accountExpired(false)
			.accountLocked(false)
			.credentialsExpired(false)
			.disabled(false)
			.build();
	}
}
