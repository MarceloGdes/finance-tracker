package com.marcelo.finance_tracker.modules.expenses.controllers;

import com.marcelo.finance_tracker.modules.expenses.dto.ExpenseRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expenses/classifications")
public class ExpenseClassificationController {

//    @PostMapping("/new")
//    public ResponseEntity<Object> newExpense(@RequestBody ExpenseRequestDTO expense) {
//        return ResponseEntity.ok().body(expenseService.create(expense));
//    }
}
