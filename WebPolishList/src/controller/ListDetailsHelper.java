package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListDetails;
import model.ListItems;

public class ListDetailsHelper {
	static EntityManagerFactory emfactory = 
			Persistence.createEntityManagerFactory("ConsolePolishItemsList");

	public void insertNewListDetails(ListDetails s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ListDetails> getLists(){
		EntityManager em = emfactory.createEntityManager();
		List<ListDetails> allDetails = em.createQuery("SELECT d FROM ListDetails d").getResultList();
		return allDetails;
	}
	
	public ListDetails searchForListById(Integer tempId) {
		EntityManager em= emfactory.createEntityManager();
		em.getTransaction().begin();
		ListDetails found = em.find(ListDetails.class, tempId);
		em.close();
		return found;
	}
	public void deleteItem(ListDetails listToDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListDetails>TypedQuery = em.createQuery("select b from ListDetails b where b.id=:selectedid",ListDetails.class);

		//Substitute	parameter	with	actual	data	from	the	toDelete	item
		TypedQuery.setParameter("selectedid",listToDelete.getId());
		
		//we	only	want	one	result
		TypedQuery.getMaxResults();
		
		//get	the	result	and	save	it	into	a	new	list	item
		ListDetails	result	=	TypedQuery.getSingleResult();
		
		//remove	it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		}

	}
