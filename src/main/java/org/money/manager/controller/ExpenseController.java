package org.money.manager.controller;

import org.money.manager.model.Expense;
import org.money.manager.model.ExpenseRequest;
import org.money.manager.service.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private ExpenseService expenseService;

    @PostMapping("/add")
    public ResponseEntity<?> addExpense(@RequestBody ExpenseRequest expenseRequest, @RequestHeader("Authorization") String token) {
        expenseService.addExpense(expenseRequest, token);
        return ResponseEntity.ok("Expense added successfully.");
    }

    @GetMapping
    public List<Expense> getAllExpenses(@RequestHeader("Authorization") String token) {
        return expenseService.getAllExpenses(token);
    }
}

