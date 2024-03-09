package com.marcelo.finance_tracker.modules.expenses.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.marcelo.finance_tracker.modules.expenses.entities.ExpenseEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/expenses")
public class ExpensesController {
    
    @PostMapping("/new")
    public ResponseEntity<Object> newExpense(@RequestBody @Autowired ExpenseEntity expense) {
        
        return ResponseEntity.ok().body(expense);
    }
    

}
