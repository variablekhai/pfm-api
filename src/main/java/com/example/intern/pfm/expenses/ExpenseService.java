package com.example.intern.pfm.expenses;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> getExpenses() {
        return expenseRepository.findAll();
    }

    public void addNewExpense(Expense expense) {
        expenseRepository.save(expense);
    }

    public void deleteExpense(Long id) {
        boolean exists = expenseRepository.existsById(id);
        if(!exists) {
            throw new IllegalArgumentException("Expense does not exists!");
        } else {
            expenseRepository.deleteById(id);
        }
    }

    @Transactional
    public void updateExpense(Long id, String name, String category, Double amount, LocalDate date) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Expense with id " + id + " does not exist!"
        ));

        if (name != null && name.length() > 0) {
            expense.setName(name);
        }

        if (category != null && category.length() > 0) {
            expense.setCategory(category);
        }

        if (amount != 0.00) {
            expense.setAmount(amount);
        }

        if (date != null) {
            expense.setDate(date);
        }
    }
}
