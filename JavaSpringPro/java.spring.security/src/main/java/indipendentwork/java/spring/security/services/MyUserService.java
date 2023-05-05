package indipendentwork.java.spring.security.services;

import indipendentwork.java.spring.security.entities.Users;
import indipendentwork.java.spring.security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByEmail(username);
        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}
