package com.marcelo.finance_tracker.modules.expenses.services;

import com.marcelo.finance_tracker.modules.expenses.dto.ExpenseRequestDTO;
import com.marcelo.finance_tracker.modules.expenses.entities.ExpenseClassificationEntity;
import com.marcelo.finance_tracker.modules.expenses.entities.ExpenseClassificationMappingEntity;
import com.marcelo.finance_tracker.modules.expenses.entities.ExpenseEntity;
import com.marcelo.finance_tracker.modules.expenses.repositories.ExpenseClassificationMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseClassificationMappingService {

    @Autowired
    private ExpenseClassificationMappingRepository expenseClassificationMappingRepository;
    public List<ExpenseClassificationMappingEntity> execute(ExpenseRequestDTO dto, ExpenseEntity createdExpenseEntity){

        //Mapeando as classificações e adicionando na tabela de realcionamento,
        // TODO: realizar validações se as classificações existem no banco

        List<ExpenseClassificationMappingEntity> classifications = new ArrayList<>();

        dto.getExpenseClassificationIDs().forEach(id -> {
            ExpenseClassificationEntity classification = ExpenseClassificationEntity.builder()
                    .id(id)
                    .build();

            ExpenseClassificationMappingEntity mapping = ExpenseClassificationMappingEntity.builder()
                    .expense(createdExpenseEntity)
                    .expenseClassification(classification)
                    .build();

            classifications.add(expenseClassificationMappingRepository.save(mapping));


        });

        return classifications;
    }
}
