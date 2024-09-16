package com.marcelo.finance_tracker.modules.expenses.controllers;

import com.marcelo.finance_tracker.modules.expenses.dto.ExpenseRequestDTO;
import com.marcelo.finance_tracker.modules.expenses.services.ExpenseService;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/expenses")
public class ExpensesController {


    @Autowired private ExpenseService expenseService;


    @PostMapping("/new") //TODO: criar validação de comparação de descrições do tipo da conta
    public ResponseEntity<Object> newExpense(@RequestBody ExpenseRequestDTO expense) {
        return ResponseEntity.ok().body(expenseService.create(expense));
    }

//    @PutMapping("/update")
//    public ResponseEntity<Object> updateExpense(@RequestBody ExpenseRequestDTO expense) {
//        return ResponseEntity.ok().body(expenseService.update(expense));
//    }
    

}
