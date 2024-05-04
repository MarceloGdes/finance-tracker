package com.marcelo.finance_tracker.modules.expenses.usecases;

import com.marcelo.finance_tracker.modules.expenses.entities.ExpenseTypeEntity;
import com.marcelo.finance_tracker.modules.expenses.repositories.ExpenseTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateNewExpenseType {

    @Autowired
    private ExpenseTypeRepository expenseTypeRepository;

    public ExpenseTypeEntity execute(ExpenseTypeEntity expenseType) {

        ExpenseTypeEntity createdExpenseTypeEntity = expenseTypeRepository.save(expenseType);
        return  createdExpenseTypeEntity;
    }

}
