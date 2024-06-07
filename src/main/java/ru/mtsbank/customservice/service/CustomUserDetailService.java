package ru.mtsbank.customservice.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.mtsbank.customservice.dto.UserDTO;
import ru.mtsbank.customservice.entity.User;
import ru.mtsbank.customservice.mapperentitytodto.UserMapper;
import ru.mtsbank.customservice.repository.UserRepository;
import ru.mtsbank.customservice.userdetail.CustomerUserDetail;

@Service
public class CustomUserDetailService implements UserDetailsService {
    UserRepository repository;
    public CustomUserDetailService(UserRepository userRepository) {
        repository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        User user = repository.findByPhoneNumber(phone);
        if(user == null) {
            throw new UsernameNotFoundException(phone);
        }
        UserDTO userDto = UserMapper.userToUserDTO(user);

        return new CustomerUserDetail(userDto);
    }
}
