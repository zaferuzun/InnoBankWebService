package com.zuzun.business.dto;

import com.zuzun.utils.pojo.LoansModel;
import com.zuzun.utils.pojo.LoansParameterModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoansDto {
    private int id;
    private int accountId;
    private String type;
    private LoansParameterModel loansParameterModel;
}
