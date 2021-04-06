package com.natwest.primeNumber.service;

import com.natwest.primeNumber.service.PrimeListCreation;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class PrimeListCreationTests {

    @InjectMocks
    PrimeListCreation primeListCreation;

    @Test
    public void testprimeListGenerator_CreatesAPrimeList(){
        int input = 5;
        List<Integer> output = new ArrayList<>();
        output.add(2);
        output.add(3);
        output.add(5);

        Assert.assertEquals(output,primeListCreation.primeListGenerator(input));
    }

    @Test
    public void testprimeListGenerator_CreatesOnlyPrimeList(){
        int input = 5;
        List<Integer> output = new ArrayList<>();
        output.add(1);
        output.add(2);
        output.add(3);
        output.add(4);
        output.add(5);

        Assert.assertNotSame(output,primeListCreation.primeListGenerator(input));
    }
}
