package com.zuzun.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDto {

    public int id;
    public String name;
    public String surname;
    public String tcNo;
    public String phone;
    public String birthday;


}

