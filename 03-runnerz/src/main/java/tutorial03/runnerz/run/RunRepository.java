package tutorial03.runnerz.run;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class RunRepository {
	
	private List<Run> runs = new ArrayList<>();
	
	List<Run> findAll() {
		return runs;
	}
	
	@PostConstruct
	private void init() {
		runs.add(new Run(
				1,
				"Monday Morning Run",
				LocalDateTime.now(),
				LocalDateTime.now().plus(38, ChronoUnit.MINUTES),
				4,
				Location.INDOOR)
				);
		
		runs.add(new Run(
				2,
				"Tuesday Evening Run",
				LocalDateTime.now(),
				LocalDateTime.now().plus(70, ChronoUnit.MINUTES),
				8,
				Location.OUTDOOR)
				);
	}
}
