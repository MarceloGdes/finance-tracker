package com.marcelo.finance_tracker.modules.expenses.repositories;

import com.marcelo.finance_tracker.modules.expenses.entities.ExpenseInstallmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface ExpenseInstallmentRepository extends JpaRepository<ExpenseInstallmentEntity, UUID> {
    @Query("SELECT max(installmentNumber) FROM expense_installment ")
    Integer findMaxExpenseNumber();
}
