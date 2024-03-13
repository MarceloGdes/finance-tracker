package com.marcelo.finance_tracker.modules.expenses.usecases;

import com.marcelo.finance_tracker.modules.expenses.entities.ExpenseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.finance_tracker.modules.expenses.repositories.ExpenseRepository;

@Service
public class NewExpenseUseCase {
    
    @Autowired
    private ExpenseRepository expenseRepository;

    public ExpenseEntity execute(ExpenseEntity expense) {
        expense.setExpenseNumber(getNextExpenseNumber());
        ExpenseEntity createdExpenseEntity = expenseRepository.save(expense);
        return createdExpenseEntity;
    }

    private Integer getNextExpenseNumber() {
        Integer newExpenseNumber = expenseRepository.findMaxExpenseNumber() + 1;
        return newExpenseNumber;
    }
}
