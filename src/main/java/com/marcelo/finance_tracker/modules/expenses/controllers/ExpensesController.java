package com.marcelo.finance_tracker.modules.expenses.controllers;

import com.marcelo.finance_tracker.modules.expenses.dto.ExpenseRequestDTO;
import com.marcelo.finance_tracker.modules.expenses.services.ExpenseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/expenses")
public class ExpensesController {


    @Autowired private ExpenseService createNewExpenseUseCase;


    @PostMapping("/new") //TODO: criar validação de comparação de descrições do tipo da conta
    public ResponseEntity<Object> newExpense(@RequestBody ExpenseRequestDTO expense) {
        return ResponseEntity.ok().body(createNewExpenseUseCase.execute(expense));
    }
    

}
