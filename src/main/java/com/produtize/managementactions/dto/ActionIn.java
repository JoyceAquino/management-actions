package com.produtize.managementactions.dto;

import com.produtize.managementactions.model.Action;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Data
@AllArgsConstructor
public class ActionIn {

    @DecimalMin(value = "0.01")
    private Double buyPrice;

    @DecimalMin(value = "0.01")
    private Double salePrice;

    @Builder.Default
    private Action.Currency currency = Action.Currency.BRL;

    @DecimalMin(value = "1")
    private int quantity;

    @NotNull
    private LocalDate saleDate;

    @NotNull
    private String active;

}
