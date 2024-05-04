package com.marcelo.finance_tracker.modules.expenses.usecases;

import com.marcelo.finance_tracker.modules.expenses.dto.ExpenseDTO;
import com.marcelo.finance_tracker.modules.expenses.entities.ExpenseClassificationEntity;
import com.marcelo.finance_tracker.modules.expenses.entities.ExpenseClassificationMappingEntity;
import com.marcelo.finance_tracker.modules.expenses.entities.ExpenseEntity;
import com.marcelo.finance_tracker.modules.expenses.entities.ExpenseTypeEntity;
import com.marcelo.finance_tracker.modules.expenses.repositories.ExpenseClassificationMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.finance_tracker.modules.expenses.repositories.ExpenseRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreateNewExpenseUseCase {
    
    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private ExpenseClassificationMappingRepository expenseClassificationMappingRepository;

    public ExpenseEntity execute(ExpenseDTO dto) {

        //TODO: Fazer validações para verificar se o id passado no DTo existe no banco e completar as informações no builder, separa em use case diferente
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

        //Mapeando as classificações e adicionando na tabela de realcionamento,
        // TODO: realizar validações se as classificações existem no banco

        ArrayList classifications = new ArrayList<>();

        dto.getExpenseClassificationIDs().stream().forEach(id -> {
            ExpenseClassificationEntity classification = ExpenseClassificationEntity.builder()
                    .id(id)
                    .build();

            ExpenseClassificationMappingEntity mapping = ExpenseClassificationMappingEntity.builder()
                    .expense(createdExpenseEntity)
                    .expenseClassification(classification)
                    .build();

            classifications.add(classification);
            expenseClassificationMappingRepository.save(mapping);

        });

        createdExpenseEntity.setClassifications(classifications);
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
