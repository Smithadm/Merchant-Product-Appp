import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class test {
public static void main(String[] args) {
	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	System.out.println(manager);
}
}
