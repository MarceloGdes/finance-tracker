package com.marcelo.finance_tracker.modules.expenses.dto.expensetype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateExpenseTypeDto {

    private String description;
}
