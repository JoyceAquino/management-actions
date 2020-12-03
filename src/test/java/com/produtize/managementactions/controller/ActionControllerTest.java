package com.produtize.managementactions.controller;

import com.produtize.managementactions.converter.ActionInConverter;
import com.produtize.managementactions.dto.ActionIn;
import com.produtize.managementactions.repository.ActionRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.RequestContextHolder;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class ActionControllerTest {

    private @InjectMocks
    ActionController controller;

    private @Mock
    ActionInConverter converter;

    private @Mock
    ActionRepository repository;

    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @BeforeAll
    public static void createValidator() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterAll
    public static void close() {
        validatorFactory.close();
        RequestContextHolder.resetRequestAttributes();
    }

    @Test
    public void should_create_action(){
        ActionIn in = mock(ActionIn.class);
        var responseEntity = controller.save(in);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.CREATED);
    }

    @Test
    public void should_have_no_violations(){
        Set<ConstraintViolation<ActionIn>> violations = validator.validate(ControllerFixtures.getActionInWithoutValidationErros());
        assertTrue(violations.isEmpty());
    }

    @Test
    public void should_have_violations_in_salePrice(){
        Set<ConstraintViolation<ActionIn>> violations = validator.validate(ControllerFixtures.getActionInWithSalePriceValidationErros());
        assertEquals(violations.size(),1);
    }

    @Test
    public void should_have_violations_in_salePriceAndBuyPrice(){
        Set<ConstraintViolation<ActionIn>> violations = validator.validate(ControllerFixtures.getActionInWithSalePriceAndBuyPriceValidationErros());
        assertEquals(violations.size(),2);
    }
}
