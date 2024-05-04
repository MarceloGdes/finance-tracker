package com.marcelo.finance_tracker.modules.expenses.controllers;

import com.marcelo.finance_tracker.modules.expenses.dto.ExpenseDTO;
import com.marcelo.finance_tracker.modules.expenses.usecases.CreateNewExpenseUseCase;
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


    @Autowired private CreateNewExpenseUseCase createNewExpenseUseCase;


    @PostMapping("/new") //TODO: criar validação de comparação de descrições do tipo da conta
    public ResponseEntity<Object> newExpense(@RequestBody ExpenseDTO expense) {
        return ResponseEntity.ok().body(createNewExpenseUseCase.execute(expense));
    }
    

}
