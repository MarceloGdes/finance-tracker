package com.marcelo.finance_tracker.modules.expenses.services;

import com.marcelo.finance_tracker.modules.expenses.dto.ExpenseRequestDTO;
import com.marcelo.finance_tracker.modules.expenses.entities.ExpenseEntity;
import com.marcelo.finance_tracker.modules.expenses.entities.ExpenseInstallmentEntity;
import com.marcelo.finance_tracker.modules.expenses.repositories.ExpenseInstallmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CreateExpenseInstallmentsService {

    @Autowired
    private ExpenseInstallmentRepository expenseInstallmentRepository;

    public ArrayList<ExpenseInstallmentEntity> execute(ExpenseRequestDTO dto, ExpenseEntity expense){
        var expenseInstallmentsDTO = dto.getExpenseInstallments();
        ArrayList<ExpenseInstallmentEntity> installments = new ArrayList<>();

        expenseInstallmentsDTO.forEach(i ->{
            ExpenseInstallmentEntity expenseInstallment = ExpenseInstallmentEntity.builder()
                    .expense(expense)
                    .value(i.getValue())
                    .dueDate(i.getDueDate())
                    .paid(i.isPaid())
                    .installmentNumber(getNextExpenseInstallmentNumber())
                    .build();

            installments.add(expenseInstallmentRepository.save(expenseInstallment));
        });

        return installments;
    }
    private Integer getNextExpenseInstallmentNumber() {
        Integer newExpenseInstallmentNumber = 1;
        Integer maxExpenseInstallmentNumber = expenseInstallmentRepository.findMaxExpenseNumber();
        if(maxExpenseInstallmentNumber == null) {
            newExpenseInstallmentNumber = 1;
        }else {
            newExpenseInstallmentNumber += maxExpenseInstallmentNumber;
        }
        return newExpenseInstallmentNumber;
    }


}
