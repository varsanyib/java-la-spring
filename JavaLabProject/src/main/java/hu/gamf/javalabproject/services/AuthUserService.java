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
        if (user.isAdmin()) {
            authorities.add(new SimpleGrantedAuthority("admin"));
        } else {
            authorities.add(new SimpleGrantedAuthority("user"));
        }

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                authorities
        );
    }

    public void register(String username, String fullname, String rawPassword) {
        User user = new User();
        user.setUsername(username);
        user.setFullname(fullname);
        user.setPassword(passwordEncoder.encode(rawPassword));
        user.setRole("user");
        userRepo.save(user);
    }
}
