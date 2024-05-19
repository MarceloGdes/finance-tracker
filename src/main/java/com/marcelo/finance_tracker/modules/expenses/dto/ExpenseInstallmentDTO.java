package com.marcelo.finance_tracker.modules.expenses.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseInstallmentDTO {

    private Double value;
    private LocalDate dueDate;
    private boolean paid;

}
