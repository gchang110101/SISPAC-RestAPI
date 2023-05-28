package com.uam.SISPAC.dto.humanresources;

import com.uam.SISPAC.model.humanresources.UserType;
import lombok.Data;


@Data
public class SystemUserDto {
    private String id;
    private String cif;
    private String cardNumber;
    private String password;

    private Boolean status;

    private String names;
    private String lastNames;
    private String phoneNumber;
    private UserType userType;
}
