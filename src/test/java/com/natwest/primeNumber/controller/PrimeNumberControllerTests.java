package com.natwest.primeNumber.controller;

import com.natwest.primeNumber.controller.PrimeNumberController;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class PrimeNumberControllerTests {

    @InjectMocks
    PrimeNumberController primeNumberController;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testprimeList_withIntegerParam(){
        String input = "5";
        List<Integer> output = new ArrayList<>();
        output.add(2);
        output.add(3);
        output.add(5);
        ResponseEntity<List<Integer>> response = primeNumberController.primeList(input);
        List<Integer> primeList = response.getBody();
        Assert.assertEquals(200, response.getStatusCodeValue());
        Assert.assertEquals(output,primeList);
    }

    @Test
    public void testprimeList_withStringParam(){
        String input = "test";
        String errorMessage = "Input type of limit was not an Integer value";
        exception.expect(NumberFormatException.class);
        exception.expectMessage(errorMessage);
        primeNumberController.primeList(input);
    }
}
