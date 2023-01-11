package com.example.intern.pfm.expenses;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class ExpenseConfig {

    @Bean
    CommandLineRunner commandLineRunner(ExpenseRepository expenseRepository) {
        return args -> {
//            Expense expense1 = new Expense(
//                    "Lunch",
//                    35.90,
//                    "Food",
//                    LocalDate.of(2023, Month.JANUARY, 1)
//            );
//
//            Expense expense2 = new Expense(
//                    "Movies",
//                    20.90,
//                    "Entertainment",
//                    LocalDate.of(2023, Month.JANUARY, 2)
//            );
//
//            expenseRepository.saveAll(
//                    List.of(expense1, expense2)
//            );
        };
    }
}
