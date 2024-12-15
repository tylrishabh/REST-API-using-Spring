/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RTayal.dev.springPract.run;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tylri
 */
@RestController
@RequestMapping("/api/runs")
public class RunController {

    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @GetMapping("")
    List<Run> getAllRun() {
        return runRepository.findAll();
    }

    @GetMapping("/{id}")
    Run findByID(@PathVariable Integer id) {
        Optional<Run> run = runRepository.findByID(id);
        if (run.isEmpty()) {
            throw new RunNotFoundException();
        }
        return run.get();
    }
    // @ResponseStatus(HttpStatus.CREATED)
    // @PostMapping("")
    // void addRun(@Valid @RequestBody Run runObj) {
    //     runRepository.addRunData(runObj);
    // }
    // @ResponseStatus(HttpStatus.NO_CONTENT)
    // @PutMapping("/{id}")
    // void updateRun(@Valid @PathVariable Integer id, @RequestBody Run runObj) {
    //     runRepository.updateRunData(id, runObj);
    // }
    // @ResponseStatus(HttpStatus.NO_CONTENT)
    // @DeleteMapping("/{id}")
    // void deleteRun(@PathVariable Integer id) {
    //     runRepository.deleteRunObj(id);
    // }
}
