package LoginRegistroJwt.security.impl;



import LoginRegistroJwt.entity.Users;
import LoginRegistroJwt.repository.UserRepository;
import LoginRegistroJwt.service.AuthUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDetailServiceImpl implements UserDetailsService {

    private  final UserRepository repository;

    public UserDetailServiceImpl(UserRepository repository) {
        this.repository = repository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> users = repository.findByName(username);
        if (users.isEmpty()) {
            throw new UsernameNotFoundException("Usuario  [" + username + "] não encontrado");
        }

        return new AuthUserDetails(users);
    }


}
