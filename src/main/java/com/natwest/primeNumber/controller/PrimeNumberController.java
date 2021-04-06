package com.natwest.primeNumber.controller;

import com.natwest.primeNumber.service.PrimeListCreation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PrimeNumberController {

    private static final Logger logger = LoggerFactory.getLogger(PrimeNumberController.class);

    @Autowired
    PrimeListCreation primeListCreation;

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(value = "/primeList/{limit}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<List<Integer>> primeList(@PathVariable(value= "limit") String limit){
        int inputLimit;
        List<Integer> primeList;
        try{
            logger.info("Parsing input limit {}",limit);
             inputLimit = Integer.parseInt(limit);
            logger.info("Generating list of prime number - limit is {}",inputLimit);
            primeList = primeListCreation.primeListGenerator(inputLimit);
            logger.info("Prime List generated");
        }catch (NumberFormatException e){
            logger.error("Input type of limit was not an Integer value, input is - {}",limit);
            throw new NumberFormatException("Input type of limit was not an Integer value");
        }catch (Exception e){
            logger.error("Unknown error while execution",e);
            throw new RuntimeException("Unknown error while execution");
        }
        return new ResponseEntity<>(primeList,HttpStatus.OK);
    }
}
