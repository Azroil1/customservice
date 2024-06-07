package ru.mtsbank.customservice.mapperentitytodto;

import ru.mtsbank.customservice.dto.UserDTO;
import ru.mtsbank.customservice.entity.User;

public class UserMapper {
    public static UserDTO userToUserDTO(User user) {
        return new UserDTO(user.getId(), user.getBankAccountId(), user.getPhoneNumber(), user.getPassword());
    }
}
