package com.produtize.managementactions.converter;


import com.produtize.managementactions.dto.ActionOut;
import com.produtize.managementactions.model.Action;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Component
@AllArgsConstructor

public class ActionsOutConverter implements Function<List<Action>, ArrayList<ActionOut>> {
    @Override
    public ArrayList<ActionOut> apply(List<Action> actions) {
        ArrayList<ActionOut> actionInList = new ArrayList<>();
        actions.parallelStream().forEach(action -> actionInList.add(
                new ActionOut(
                        action.getActive(),
                        action.getQuantity(),
                        action.getBuyPrice(),
                        action.getSalePrice(),
                        action.getVariation(),
                        action.getSaleDate(), action.getCurrency())));
        return actionInList;
    }
}
