package com.marcelo.finance_tracker.modules.expenses.controllers;

import com.marcelo.finance_tracker.modules.expenses.entities.ExpenseTypeEntity;
import com.marcelo.finance_tracker.modules.expenses.services.ExpenseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expenses/expense-type")
public class ExpenseTypeController {

    @Autowired
    private ExpenseTypeService createNewExpenseType;

    @PostMapping("/new")
    public ResponseEntity<Object> newExpenseType(@RequestBody ExpenseTypeEntity expenseType) {
        return ResponseEntity.ok().body(createNewExpenseType.execute(expenseType));
    }

}
