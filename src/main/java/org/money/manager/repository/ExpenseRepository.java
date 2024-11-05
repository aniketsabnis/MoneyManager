package org.money.manager.repository;

import org.money.manager.model.Expense;
import org.money.manager.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByUser(AppUser appUser);
}
