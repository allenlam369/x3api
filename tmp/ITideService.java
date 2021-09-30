package allen.met.service;

import java.util.List;

import allen.met.model.Tide;

public interface ITideService {
	Tide saveOrUpdate(Tide t);
	List<Tide> findBetweenDates(String d1, String d2, int stationId);
	List<Tide> twoDays(int stationId);
	List<Tide> oneWeek(int stationId);
}
