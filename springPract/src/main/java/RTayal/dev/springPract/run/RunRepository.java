/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RTayal.dev.springPract.run;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tylri
 */
@Repository
public class RunRepository {

    private static final Logger log = LoggerFactory.getLogger(RunRepository.class);
    private final JdbcClient JdbcClient;

    public RunRepository(JdbcClient JdbcClient) {
        this.JdbcClient = JdbcClient;
    }

    public List<Run> findAll() {
        return JdbcClient.sql("select * from run")
                .query(Run.class)
                .list();
    }

    private final List<Run> runs = new ArrayList<>();

    // List<Run> findAll() {
    //     return runs;
    // }
    Optional<Run> findByID(Integer id) {
        return JdbcClient.sql("SELECT id,title,started_on,completed_on,miles,location FROM run WHERE id= :id")
                .param("id", id)
                .query(Run.class)
                .optional();
        // return runs.stream()
        //         .filter(run -> Objects.equals(run.id(), id))
        //         .findFirst();
    }

    // Used to do some initialisation
    // @PostConstruct
    // private void init() {
    //     runs.add(new Run(1,
    //             "First Run",
    //             LocalDateTime.now(),
    //             LocalDateTime.now().plus(1, ChronoUnit.HOURS),
    //             3, Location.INDOOR)
    //     );
    //     runs.add(new Run(2,
    //             "Second Run",
    //             LocalDateTime.now(),
    //             LocalDateTime.now().plus(1, ChronoUnit.HOURS),
    //             4, Location.OUTDOOR)
    //     );
    // }
    // void addRunData(Run runObj) {
    //     runs.add(runObj);
    // }
    // void updateRunData(Integer id, Run runObj) {
    //     Optional<Run> run = findByID(id);
    //     if (run.isPresent()) {
    //         runs.set(runs.indexOf(run.get()), runObj);
    //     }
    // }
    // void deleteRunObj(Integer id) {
    //     runs.removeIf(run -> run.id().equals(id));
    // }
}
