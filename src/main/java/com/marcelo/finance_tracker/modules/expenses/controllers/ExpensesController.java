package com.marcelo.finance_tracker.modules.expenses.controllers;

import com.marcelo.finance_tracker.modules.expenses.usecases.NewExpenseUseCase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcelo.finance_tracker.modules.expenses.entities.ExpenseEntity;
import com.marcelo.finance_tracker.modules.expenses.repositories.ExpenseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/expenses")
public class ExpensesController {

    @Autowired private ExpenseRepository expenseRepository;
    @Autowired private NewExpenseUseCase newExpenseUseCase;
    
    @PostMapping("/new")
    public ResponseEntity<Object> newExpense(@RequestBody ExpenseEntity expense) {
        return ResponseEntity.ok().body(newExpenseUseCase.execute(expense));
    }
    

}
