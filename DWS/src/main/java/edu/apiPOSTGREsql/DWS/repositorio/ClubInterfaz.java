package edu.apiPOSTGREsql.DWS.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.apiPOSTGREsql.DWS.dtos.ClubDtos;

@Repository

public interface ClubInterfaz extends JpaRepository<ClubDtos, Long>{
	
	
	
	
}
