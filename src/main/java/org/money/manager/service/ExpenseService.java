package org.money.manager.service;

import org.money.manager.model.Expense;
import org.money.manager.model.ExpenseRequest;
import org.money.manager.model.AppUser; // Update from User to AppUser
import org.money.manager.repository.ExpenseRepository;
import org.money.manager.repository.UserRepository;
import org.money.manager.security.JWTUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;
    private final JWTUtil jwtUtil;

    // Constructor Injection
    public ExpenseService(ExpenseRepository expenseRepository, UserRepository userRepository, JWTUtil jwtUtil) {
        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    public void addExpense(ExpenseRequest request, String token) {
        if (jwtUtil.validateToken(token)) {
            AppUser user = userRepository.findByUsername(jwtUtil.extractUsername(token)).orElseThrow();
            Expense expense = new Expense();
            expense.setAmount(request.getAmount());
            expense.setDescription(request.getDescription());
            expense.setOccurrence(request.getOccurrence());
            expense.setUser(user);
            expenseRepository.save(expense);
        }
    }

    public List<Expense> getAllExpenses(String token) {
        AppUser user = userRepository.findByUsername(jwtUtil.extractUsername(token)).orElseThrow();
        return expenseRepository.findByUser(user);
    }
}
