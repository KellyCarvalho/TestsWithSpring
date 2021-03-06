package com.devsuperior.dscatalog.repositories;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import com.devsuperior.dscatalog.entities.Product;

@DataJpaTest
public class ProductRepositoryTests {
	@Autowired
	private ProductRepository repository;
	@Test
	public void deleteShouldDeleteObjectWhenIdExists() {
		
		long existingId=1L;
		repository.deleteById(existingId);
		
		Optional<Product> result = repository.findById(1L);
		
		Assertions.assertFalse(result.isPresent());
	}
	
@Test
public void deleteShouldThrowEmptyResultDataAccessExceptionIdDoesNotExist() {
	long nonExistingId=63L;
	Assertions.assertThrows(EmptyResultDataAccessException.class, ()->{
		
		repository.deleteById(nonExistingId);
		
		
		
		
	});
	
	
	
	
	
}
}
