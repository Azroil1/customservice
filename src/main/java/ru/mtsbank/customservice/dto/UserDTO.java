package ru.mtsbank.customservice.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class UserDTO {
    private int id;
    private String bankAccountId;
    private String phoneNumber;
    private String password;

    @JsonCreator
    public UserDTO(@JsonProperty("phone") String phoneNumber,@JsonProperty("password") String password) {
        this.phoneNumber = phoneNumber;
        this.password = password;
    }
}
