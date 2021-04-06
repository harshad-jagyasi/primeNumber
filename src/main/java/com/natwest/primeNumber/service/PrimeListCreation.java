package com.natwest.primeNumber.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class PrimeListCreation {

    private static final Logger logger = LoggerFactory.getLogger(PrimeListCreation.class);

    public static List<Integer> primeListGenerator(int limit) {
        logger.info("Generating primeList");
        return IntStream.rangeClosed(2, limit)
                .filter(x -> isPrime(x)).boxed()
                .collect(Collectors.toList());
    }
    private static boolean isPrime(int number) {
        logger.info("Validating if {} is prime", number);
        return IntStream.rangeClosed(2, (int) (Math.sqrt(number)))
                .allMatch(n -> number % n != 0);
    }

}
