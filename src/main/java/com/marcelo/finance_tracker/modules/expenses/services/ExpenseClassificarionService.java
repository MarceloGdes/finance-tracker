package com.marcelo.finance_tracker.modules.expenses.services;

import com.marcelo.finance_tracker.modules.expenses.dto.ExpenseClassificationDTO;
import com.marcelo.finance_tracker.modules.expenses.entities.ExpenseClassificationEntity;
import com.marcelo.finance_tracker.modules.expenses.repositories.ExpenseClassificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseClassificarionService {

    @Autowired
    ExpenseClassificationRepository repository;

    
    public ExpenseClassificationEntity create(ExpenseClassificationDTO dto){
        var expenseClassification = ExpenseClassificationEntity.builder()
                .description(dto.getDesc())
                .build();

        var savedClassification = repository.save(expenseClassification);
        return savedClassification;
    }
}
