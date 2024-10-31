package edu.apiPOSTGREsql.DWS.controller;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.apiPOSTGREsql.DWS.dtos.ClubDtos;
import edu.apiPOSTGREsql.DWS.servicios.ClubFuncionalidade;


@RestController
@RequestMapping("/club")

public class ClubController {

	@Autowired
	private ClubFuncionalidade clubFuncionalidade;
	
	@GetMapping
	public ArrayList<ClubDtos> getClub(){
		return this.clubFuncionalidade.getClub();
		
	}
	@PostMapping
	public ClubDtos guardaClub(@RequestBody ClubDtos club) {
		return this.clubFuncionalidade.guardaclub(club);
	}
	
	
	@GetMapping(path = "/{id}")
	public Optional<ClubDtos> getClubbyId(@PathVariable("id") Long id){
		
		return this.clubFuncionalidade.getById(id);
		
	}
	
	@PutMapping(path = "/{id}")
	public ClubDtos updateClubById(@RequestBody ClubDtos request, @PathVariable Long id) {
	    return this.clubFuncionalidade.updateById(request, id);
	}
	
	@DeleteMapping(path = "/{id}")
	public String deleteClubById(@PathVariable("id") Long id) {
		
		
		boolean ok = this.clubFuncionalidade.DeleteClub(id);
		
		if(ok) {
			return "Club" + id + "Eliminao";
		}else {
			return "No sa Eliminao";
		}
		
	}
	
}
