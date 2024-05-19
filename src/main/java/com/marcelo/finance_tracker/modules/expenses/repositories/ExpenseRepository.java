package com.marcelo.finance_tracker.modules.expenses.repositories;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.marcelo.finance_tracker.modules.expenses.entities.ExpenseEntity;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseEntity, UUID> {


    @Query("SELECT max(expenseNumber) FROM expense")
    Integer findMaxExpenseNumber();
}
