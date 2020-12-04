package com.produtize.managementactions.dto;

import com.produtize.managementactions.model.Action;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.lang.NonNull;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import java.util.Date;


@Data
@AllArgsConstructor
public class ActionIn {

    @NonNull
    @DecimalMin(value = "0.01")
    private Double buyPrice;

    @NonNull
    @DecimalMin(value = "0.01")
    private Double salePrice;

    @Builder.Default
    private Action.Currency currency = Action.Currency.BRL;

    @DecimalMin(value = "1")
    private int quantity;

    private Date saleDate;

    @NonNull
    @NotBlank
    private String active;


}
