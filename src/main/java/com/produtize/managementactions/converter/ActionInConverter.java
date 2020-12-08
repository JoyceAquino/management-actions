package com.produtize.managementactions.converter;

import com.produtize.managementactions.dto.ActionIn;
import com.produtize.managementactions.model.Action;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class ActionInConverter implements Function<ActionIn, Action> {

    @Override
    public Action apply(ActionIn actionIn) {
        var action = new Action();
        action.setActive(actionIn.getActive().toUpperCase(Locale.ROOT));
        action.setBuyPrice(actionIn.getBuyPrice());
        action.setSalePrice(actionIn.getSalePrice());
        action.setQuantity(actionIn.getQuantity());
        action.setUpdatedAt(LocalDateTime.now());
        action.setSaleDate(actionIn.getSaleDate());
        return action;
    }
}
