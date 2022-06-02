package tn.esprit.spring.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.User;
//import tn.esprit.spring.services.IUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
@SpringBootTest
class UserServiceImplTest {
	
@Autowired
IUserService us;
@Test
public void testRetrieveAllUsers() {
List<User> listUsers = us.retrieveAllUsers();
Assertions.assertEquals(2, listUsers.size());
}
}
