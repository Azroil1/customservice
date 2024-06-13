package ru.mtsbank.customservice.userdetail;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.mtsbank.customservice.dto.UserDTO;

import java.util.Collection;
import java.util.List;

public class CustomerUserDetail implements UserDetails {

    private final UserDTO user;

    public CustomerUserDetail(UserDTO user) {
        this.user = user;
    }

    public int getCustomerId(){
        return user.getId();
    }

    public String getBankAccountId() {
        return user.getBankAccountId();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getPhoneNumber();
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
