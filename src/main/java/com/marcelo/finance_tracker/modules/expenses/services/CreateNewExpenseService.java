package com.marcelo.finance_tracker.modules.expenses.services;

import com.marcelo.finance_tracker.modules.expenses.dto.ExpenseRequestDTO;
import com.marcelo.finance_tracker.modules.expenses.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.finance_tracker.modules.expenses.repositories.ExpenseRepository;

@Service
public class CreateNewExpenseService {
    
    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private CreateExpenseInstallmentsService createExpenseInstallmens;

    @Autowired
    private CreateExpenseClassificationMappingService createClassificationMapping;

    public ExpenseEntity execute(ExpenseRequestDTO dto) {

        //TODO: Fazer validações para verificar se o id passado no DTO existe no banco e completar as informações no
        // builder, separa em use case diferente. O Postgres ja realiza esta verificação mas o ideal e realizar em codigo
        ExpenseTypeEntity expenseType = ExpenseTypeEntity.builder()
                .id(dto.getExpenseTypeId())
                .build();

        //TODO: Realizar validações do DTO antes de buildar a expense
        ExpenseEntity expense = ExpenseEntity.builder()
                .description(dto.getDescription())
                .totalValue(dto.getTotalValue())
                .paid(dto.isPaid())
                .expenseType(expenseType)
                .expenseNumber(getNextExpenseNumber()) //TODO: Separar esta função em outro use case
                .build();

        ExpenseEntity createdExpenseEntity = expenseRepository.save(expense);

        var classifications = createClassificationMapping.execute(dto, createdExpenseEntity);
        var createdInstallments = createExpenseInstallmens.execute(dto, createdExpenseEntity);

        createdExpenseEntity.setClassificationsMapping(classifications);
        createdExpenseEntity.setInstallments(createdInstallments);
        return createdExpenseEntity;
    }

    private Integer getNextExpenseNumber() {
        Integer newExpenseNumber = 1;
        Integer maxExpenseNumber = expenseRepository.findMaxExpenseNumber();
        if(maxExpenseNumber == null) {
            newExpenseNumber = 1;
        }else {
            newExpenseNumber += maxExpenseNumber;
        }
        return newExpenseNumber;
    }
}
