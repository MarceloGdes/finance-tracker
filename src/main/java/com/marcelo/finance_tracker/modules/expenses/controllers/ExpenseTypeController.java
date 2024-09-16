package com.marcelo.finance_tracker.modules.expenses.controllers;
import com.marcelo.finance_tracker.modules.expenses.dto.expensetype.*;
import com.marcelo.finance_tracker.modules.expenses.services.ExpenseTypeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@RequestMapping("/expenses/expense-type")
public class ExpenseTypeController {

    @Autowired
    private ExpenseTypeService service;

    @PostMapping()
    public ResponseEntity<Object> newExpenseType(@RequestBody CreateExpenseTypeDto dto) {
        return ResponseEntity.ok().body(service.create(dto));
    }

    @GetMapping()
    public ResponseEntity<Object> getExpensesType(){
        return ResponseEntity.ok().body(service.getExpenseTypes());
    }

    @PutMapping
    public ResponseEntity<Object> updateExpenseType(@RequestBody UpdateExpenseTypeDto dto) {

        try {
            return ResponseEntity.ok().body(service.updateExpenseType(dto));
        }catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteExpenseType(@PathVariable UUID id) {

        try {
            service.deleteExpenseType(id);
            return ResponseEntity.ok().body("Removido");

        }catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());

        }catch (DataIntegrityViolationException e) {
            return ResponseEntity.internalServerError().body("Esse tipo de despesa está relacionado a despesas já lançadas no sistema e não pode ser removido. " + e.getMessage());
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getExpensesTypeById(@PathVariable UUID id){

        try {
            return ResponseEntity.ok().body(service.getExpenseTypesById(id));
        }catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
        }

    }

}
