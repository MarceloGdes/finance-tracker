package com.marcelo.finance_tracker.modules.expenses.repositories;

import com.marcelo.finance_tracker.modules.expenses.entities.ExpenseClassificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExpenseClassificationRepository extends JpaRepository<ExpenseClassificationEntity, UUID> {
}
