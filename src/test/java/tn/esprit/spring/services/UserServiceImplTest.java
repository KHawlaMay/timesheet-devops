package tn.esprit.spring.services;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Role;
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
@Test
void testAddUser() throws ParseException {
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
   Date d = dateFormat.parse("25-03-23");
	User u = new User ("khawla", "khawla" , d,Role.INGENIEUR);
	User userAdded = us.addUser(u);
	Assertions.assertEquals(u.getLastName(),userAdded.getLastName());
}

public void testModifyUser() throws ParseException {
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date d = dateFormat.parse("2015-03-23");
	User u = new User(5L, "khawlaaaa", "khawla" , d, Role.INGENIEUR);
	User userUpdated = us.updateUser(u);
	Assertions.assertEquals(u.getLastName(), userUpdated.getLastName());
	
}
public void testRetreiveUser() {
	User userRetreived = us.retrieveUser("1");
	Assertions.assertEquals(1L,userRetreived.getId());
}


@Test
public void testDeleteUser(){

us.deleteUser("2");
Assertions.assertNull(us.retrieveUser("2"));

}
}
