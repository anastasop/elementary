package com.github.anastasop.elementary.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.anastasop.elementary.entities.Country;

@Component
public class CountriesService {
	private EntityManager entityManager;
	
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	@SuppressWarnings("unchecked")
	public List<Country> getAllCountries() {
		Query q = getEntityManager().createNamedQuery("getAllCountries");
		return q.getResultList();
	}
	
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public void addCountry(Country country) {
		country.setId(System.currentTimeMillis());
		getEntityManager().persist(country);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Autowired
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
