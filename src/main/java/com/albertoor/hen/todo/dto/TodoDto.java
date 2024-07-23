package com.albertoor.hen.todo.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDto {
    @NotNull(message = "Title cannot be null")
    @Size(max = 50, message = "Title should not exceed {max} chars.")
    private String title;

    @NotNull(message = "Description cannot be null")
    @Size(max = 150, message = "Description should not exceed {max} chars.")
    private String description;
}
