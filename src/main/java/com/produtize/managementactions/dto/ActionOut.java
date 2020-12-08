package com.produtize.managementactions.dto;


import com.produtize.managementactions.model.Action;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ActionOut {

        private String active;
        private int quantity;
        private Double buyPrice;
        private Double salePrice;
        private Double variation;
        private LocalDate saleDate;
        private Action.Currency currency;
}
