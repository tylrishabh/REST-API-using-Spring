/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package RTayal.dev.springPract.run;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

/**
 *
 * @author tylri
 */
public record Run(Integer id, @NotEmpty
        String title, LocalDateTime startedOn, LocalDateTime completedOn, @Positive
        Integer miles, Location location) {

}
