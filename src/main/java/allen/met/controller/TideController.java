package allen.met.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import allen.met.model.Tide;
//import allen.met.repository.TideRepository;
import allen.met.service.TideService;

@RestController
@RequestMapping("/tide")
public class TideController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

//	@Autowired
//	private final TideRepository repo;

	@Autowired
	private TideService tService;

	@PersistenceContext(unitName = "met")
	@Qualifier(value = "metEntityManagerFactory")
	private EntityManager em;

//	// injection
//	public TideController(TideRepository repo) {
//		this.repo = repo;
//	}

	@PostMapping(value = "/saveOrUpdate", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	Tide newTide(@RequestBody Tide newTide) {
		Tide t = tService.saveOrUpdate(newTide);
		logger.info("saveOrUpdate " + t);
		return t;
	}

	// d1 and d2 in format yyyyMMdd_HHmm, in HKT if app server is in +8 timezone
	@GetMapping("/between")
	public List<Tide> findBetween(@RequestParam String st, @RequestParam String ed, @RequestParam int stationId) {
		return tService.findBetweenDates(st, ed, stationId);
	}

	@GetMapping("/twoDays")
	public List<Tide> twoDays(@RequestParam int stationId) {
		return tService.twoDays(stationId);
	}

	@GetMapping("/oneWeek")
	public List<Tide> oneWeek(@RequestParam int stationId) {
		return tService.oneWeek(stationId);
	}
}
