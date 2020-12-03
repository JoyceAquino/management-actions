package com.produtize.managementactions.dto;

import com.produtize.managementactions.model.Action;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.lang.NonNull;


import javax.validation.constraints.DecimalMin;
import java.util.Date;


@Data
@AllArgsConstructor
public class ActionIn {

    @NonNull
    @DecimalMin(value = "0.01")
    private Double BuyPrice;

    @NonNull
    @DecimalMin(value = "0.01")
    private Double SalePrice;

    @Builder.Default
    private Action.Currency currency = Action.Currency.BRL;

    @DecimalMin(value = "1")
    private int Quantity;

    @NonNull
    private Date SaleDate;

    @NonNull
    private String Active;


}
