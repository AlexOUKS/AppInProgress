package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.responses;

import java.util.List;

import org.hibernate.AnnotationException;
import org.hibernate.CallbackException;
import org.hibernate.DuplicateMappingException;
import org.hibernate.HibernateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javassist.NotFoundException;

public class ResponseEntityUtil {
	static public ResponseEntity<String> modifiedElement()
	{
		return new ResponseEntity<String>("Elément modifié !", HttpStatus.OK);
	}
	static public ResponseEntity<String> createdElement()
	{
		return new ResponseEntity<String>("Elément créé !", HttpStatus.OK);
	}
	static public ResponseEntity<String> deletedElement()
	{
		return new ResponseEntity<String>("Elément supprimé !", HttpStatus.OK);
	}
	static public ResponseEntity<String> voidList(){
		return new ResponseEntity<String>("Liste vide", HttpStatus.OK);
	}
	static public ResponseEntity<List<Object>> objectList(List<Object> objs){
		return new ResponseEntity<List<Object>>(objs, HttpStatus.OK);
	}
	static public ResponseEntity<Object> viewObject(Object obj){
		return new ResponseEntity<Object>(obj, HttpStatus.OK);
	}
	static public ResponseEntity<String> responseForException(Exception e)
	{
		if(e.getClass() == HibernateException.class)
			return new ResponseEntity<String>("Erreur interne !", HttpStatus.INTERNAL_SERVER_ERROR);
		if(e.getClass() == NotFoundException.class)
			return new ResponseEntity<String>("Contenu inconnu !", HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<String>("Erreur inconnue", HttpStatus.UNPROCESSABLE_ENTITY);

	}
	static public ResponseEntity<String> badValues(){
		return new ResponseEntity<String>("Toutes les valeurs n'ont pas été correctement définies !", HttpStatus.BAD_REQUEST);
	}

}
