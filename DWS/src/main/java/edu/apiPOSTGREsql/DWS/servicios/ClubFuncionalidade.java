package edu.apiPOSTGREsql.DWS.servicios;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.apiPOSTGREsql.DWS.dtos.ClubDtos;
import edu.apiPOSTGREsql.DWS.repositorio.ClubInterfaz;

@Service
public class ClubFuncionalidade {

	//Sirver para inyeccion de dependencias
	@Autowired 
	ClubInterfaz clubinterfaz;
	
	public ArrayList<ClubDtos> getClub(){
		
		return (ArrayList<ClubDtos>) clubinterfaz.findAll(); 
		
	}
	
	
	public ClubDtos guardaclub(ClubDtos club) {
		
		return clubinterfaz.save(club);
		
	}
	
	
	public Optional<ClubDtos> getById(Long id){
		
		return clubinterfaz.findById(id);
	}
	
	
	public ClubDtos updateById(ClubDtos request, Long id ){
		
		ClubDtos club = clubinterfaz.findById(id).get();
	
		club.setNombre_club(request.getNombre_club());
		club.setNick_club(request.getNick_club());
		club.setEmail_club(request.getEmail_club());
		club.setPassword_club(request.getPassword_club());
		
		
		return club;
				
	}
	
	
	public Boolean DeleteClub(Long id) {
		
		try {
			
			clubinterfaz.deleteById(id);
			return true;
			
			
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
		
	}
	
	
}
