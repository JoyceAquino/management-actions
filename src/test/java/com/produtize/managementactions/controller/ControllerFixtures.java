package com.produtize.managementactions.controller;

import com.produtize.managementactions.dto.ActionIn;
import com.produtize.managementactions.model.Action;

import java.util.Date;

public class ControllerFixtures {
    private static final String VVAR = "VVAR";

    public static ActionIn getActionInWithoutValidationErros() {
        return new ActionIn(100.0, 200.0, Action.Currency.BRL, 10, new Date(), VVAR);
    }

    public static ActionIn getActionInWithSalePriceValidationErros() {
        return new ActionIn(100.0, 0.0, Action.Currency.BRL, 10, new Date(), VVAR);
    }

    public static ActionIn getActionInWithSalePriceAndBuyPriceValidationErros() {
        return new ActionIn(0.0, 0.0, Action.Currency.BRL, 10, new Date(), VVAR);
    }

    public static ActionIn getActionInWithQuantityValidationErros() {
        return new ActionIn(10.0, 10.0, Action.Currency.BRL, 0, new Date(), VVAR);
    }

    public static ActionIn getActionInWithActionValidationErros() {
        return new ActionIn(10.0, 10.0, Action.Currency.BRL, 10, new Date(),"");
    }

    public static Action getActionWithoutValidationErros() {
        Action action = new Action();
        action.setSaleDate(new Date());
        action.setBuyPrice(100.9);
        action.setSalePrice(100.9);
        return action;
    }
}
