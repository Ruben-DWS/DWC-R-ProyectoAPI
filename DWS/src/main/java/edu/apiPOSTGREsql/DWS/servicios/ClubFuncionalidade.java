package edu.apiPOSTGREsql.DWS.servicios;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
		
		//club.setPassword_club(encriptarContrasenya(club.getPassword_club()));
		
		 try {
	            MessageDigest digest = MessageDigest.getInstance("SHA-256");
	            byte[] hash = digest.digest(club.getPassword_club().getBytes());
	            StringBuilder hexString = new StringBuilder();
	            
	            for (byte b : hash) {
	                String hex = String.format("%02x", b); // Formato hexadecimal simplificado
	                hexString.append(hex);
	            }
	            
	            club.setPassword_club(hexString.toString()); 

	           // return hexString.toString();
	        } catch (NoSuchAlgorithmException e) {
	            throw new RuntimeException(e);
	        }
		
		
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
	
	/*
	public String encriptarContrasenya(String contraseña) {
		 try {
	            MessageDigest digest = MessageDigest.getInstance("SHA-256");
	            byte[] hash = digest.digest(contraseña.getBytes());
	            StringBuilder hexString = new StringBuilder();

	            for (byte b : hash) {
	                String hex = String.format("%02x", b); // Formato hexadecimal simplificado
	                hexString.append(hex);
	            }

	            return hexString.toString();
	        } catch (NoSuchAlgorithmException e) {
	            throw new RuntimeException(e);
	        }
		
	}*/
	
}
	
	

