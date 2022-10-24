package m.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Izvodjenje;
import model.Predstava;

public interface IzvodjenjeRepository extends JpaRepository<Izvodjenje, Integer>{
	
		List<Izvodjenje> findByPredstava(Predstava p);

}
