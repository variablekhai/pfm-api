package com.example.intern.pfm.expenses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/expense")
@CrossOrigin("http://localhost:4200")
public class ExpenseController {

    private final ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    public List<Expense> getExpenses() {
        return expenseService.getExpenses();
    }

    @PostMapping
    public void addExpense(@RequestBody Expense expense) {
        expenseService.addNewExpense(expense);
    }

    @DeleteMapping(path = "{expenseId}")
    public void deleteExpense(@PathVariable("expenseId") Long id) {
        expenseService.deleteExpense(id);
    }

    @PutMapping(path = "{expenseId}")
    public void updateExpense(
            @PathVariable("expenseId") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category,
            @RequestParam(required = false, defaultValue = "0.00") Double amount,
            @RequestParam(required = false) LocalDate date
    ) {
        expenseService.updateExpense(id, name, category, amount, date);
    }
}
