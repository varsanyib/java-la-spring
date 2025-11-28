package hu.gamf.javalabproject.services;

import hu.gamf.javalabproject.models.User;
import hu.gamf.javalabproject.repositories.UserInterfaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthUserService implements UserDetailsService {

    private final UserInterfaceRepo userRepo;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthUserService(UserInterfaceRepo userRepo) {
        this.userRepo = userRepo;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Nincs ilyen felhasználó"));

        List<GrantedAuthority> authorities = new ArrayList<>();
        if (user.getRole().equals("ADMIN")) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                authorities
        );
    }

    public void registerUser(String username, String fullname, String rawPassword) {
        User user = new User();
        user.setUsername(username);
        user.setFullname(fullname);
        user.setPassword(passwordEncoder.encode(rawPassword));
        user.setRole("USER");
        userRepo.save(user);
    }
}
