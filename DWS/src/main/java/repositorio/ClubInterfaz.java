package repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dtos.ClubDtos;

@Repository

public interface ClubInterfaz extends JpaRepository<ClubDtos, Long>{
	
	
	
	
}
