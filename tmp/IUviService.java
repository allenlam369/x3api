package allen.met.service;

import java.util.List;
import java.util.Optional;

import allen.met.model.Uvi;

public interface IUviService {
	Optional<Uvi> findById(long id);
	List<Uvi> findBetween(String d1, String d2);
	List<Uvi> findOnDate(String d1);
	List<Uvi> twoDays();
	List<Uvi> oneWeek();
	Uvi save(Uvi u);
	Uvi saveOrUpdate(Uvi u);

}
