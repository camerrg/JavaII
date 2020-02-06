package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import model.ListItems;


public class ListItemsHelper {
	//create methods and use the Start Program to interface together
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsolePolishItemsList");

public void insertItem(ListItems li) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
}

public List<ListItems>showAllItems(){
	EntityManager em = emfactory.createEntityManager();
	List<ListItems>allItems = em.createQuery("SELECT i FROM ListItems i").getResultList();
	return allItems;
	
}

public	void	deleteItem(ListItems toDelete)	{
EntityManager	em	=	emfactory.createEntityManager();
em.getTransaction().begin();
TypedQuery<ListItems>TypedQuery	=	em.createQuery("select	li	from ListItems	li	where li.brand=:selectedBrand	and	li.color=:selectedColor",	ListItems.class);

//Substitute	parameter	with	actual	data	from the	toDelete	item
TypedQuery.setParameter("selectedBrand",	toDelete.getBrand());
TypedQuery.setParameter("selectedColor",	toDelete.getColor());

//we	only	want	one	result
TypedQuery.setMaxResults(1);

//get	the	result	and	save	it	into	a	new	list	item
ListItems	result	=	TypedQuery.getSingleResult();

//remove	it
em.remove(result);
em.getTransaction().commit();
em.close();
}


public List<ListItems> searchForItemByBrand(String brandName) {
	EntityManager em = emfactory.createEntityManager();
	em.getTransaction().begin();
	TypedQuery<ListItems>TypedQuery = em.createQuery("select li from ListItems li where li.brand = :selectedBrand", ListItems.class);
	TypedQuery.setParameter("selectedBrand", brandName);
	
	List<ListItems>foundItems = TypedQuery.getResultList();
	em.close();
	return foundItems;
}


public void updateColor(ListItems toEdit) {
	EntityManager em = emfactory.createEntityManager();
	em.getTransaction().begin();
	
	em.merge(toEdit);
	em.getTransaction().commit();
	em.close();
}




public List<ListItems> searchForItemByColor(String colorName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItems>TypedQuery = em.createQuery("select li from ListItems li where li.color =:selectedColor", ListItems.class);
		TypedQuery.setParameter("selectedColor", colorName);
		
		List<ListItems>foundItems = TypedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
public void cleanUp() {
	emfactory.close();
	
}

public ListItems searchForItemById(int idToEdit) {
	EntityManager em = emfactory.createEntityManager();
	em.getTransaction().begin();
	ListItems found = em.find(ListItems.class,  idToEdit);
	em.close();
	return found;
}


}






	





