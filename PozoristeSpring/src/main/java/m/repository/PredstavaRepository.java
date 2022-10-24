package m.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Predstava;
import model.Reziser;

public interface PredstavaRepository extends JpaRepository<Predstava, Integer> {
	
		Predstava findByNaziv(String naziv);
		List<Predstava> findByReziser(Reziser r);

}
