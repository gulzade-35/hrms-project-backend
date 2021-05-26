package javaproject.hrms.business.abstracts;

import java.util.List;

import javaproject.hrms.entities.concretes.Position;

public interface PositionService {
	List<Position> getAll();
}
