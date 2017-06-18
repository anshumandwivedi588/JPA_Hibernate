package com.factories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.domain.Buyer;

public class PersistenceManager {

	private EntityManager manager;

	public PersistenceManager() {
		if (null == manager) {
			manager = Persistence.createEntityManagerFactory("persistenceUnit")
					.createEntityManager();
		}
	}

	public <T> void persistObject(T t) {
		manager.getTransaction().begin();
		manager.merge(t);
		manager.getTransaction().commit();
	}

	public List<Buyer> getAllBuyers() {
		List<Buyer> buyers = null;
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<Buyer> cq = cb.createQuery(Buyer.class);
		Root<Buyer> root = cq.from(Buyer.class);
		TypedQuery<Buyer> tq = manager.createQuery(cq);
		buyers = tq.getResultList();
		return buyers;
	}
}
