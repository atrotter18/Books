import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.BookItems;





public class Helper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("books");
	
	public void insertItem(BookItems ai) {
		EntityManager lion = emfactory.createEntityManager();
		lion.getTransaction().begin();
		lion.persist(ai);
		lion.getTransaction().commit();
		lion.close();
	}
	
	public List<BookItems>showAllBooks(){
		EntityManager lion = emfactory.createEntityManager();
		List<BookItems>allBooks = lion.createQuery("SELECT i FROM BookItems i").getResultList();
		return allBooks;
	}
	
	public void deleteItem(BookItems toDelete) {
		EntityManager lion = emfactory.createEntityManager();
		lion.getTransaction().begin();
		TypedQuery<BookItems> typedQuery = lion.createQuery("select li from BookItems li where li.BookName=:selectedBookName and li.genre=:selectedGenre", BookItems.class);
		typedQuery.setParameter("selectedBookName", toDelete.getBookName());
		typedQuery.setParameter("selectedGenre", toDelete.getGenre());
		
		typedQuery.setMaxResults(1);
		
		BookItems result = typedQuery.getSingleResult();
		lion.remove(result);;
		lion.getTransaction().commit();
		lion.close();
	}
	
	public void updateItem(BookItems edit) {
		// TODO Auto-generated method stub
		EntityManager lion =emfactory.createEntityManager();
		lion.getTransaction().begin();
		lion.merge(edit);
		lion.getTransaction().commit();
		lion.close();
		
	}
	
	public void clean() {
		emfactory.close();
	}
}
