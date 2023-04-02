package LoginRegistroJwt.service;

import LoginRegistroJwt.entity.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class AuthUserDetails implements UserDetails {
    public AuthUserDetails(Optional<Users> users) {
        this.users = users;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    private final Optional<Users> users;


    @Override
    public String getPassword() {
        return users.orElse(new Users()).getPassword();
    }

    @Override
    public String getUsername() {
        return users.orElse(new Users()).getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
