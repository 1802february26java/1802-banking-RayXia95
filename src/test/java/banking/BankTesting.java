package banking;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.revature.model.User;
import com.revature.repository.UserDAO;
import com.revature.repository.UserDAOImpl;
import com.revature.service.BankService;

public class BankTesting {

    private UserDAO userDAO;
    private User userTest = new User();
    private BankService bankService = new BankService();

    @Before
    public void setup() {
	userDAO = UserDAOImpl.getUserDAO();
	userTest.setUsername("Admin");
	userTest.setPassword("admin");
	userTest.setName("ray");
	userTest.setBalance(0);

    }

    @Test
    public void testGetUserFromDB() {
	assertEquals(userTest, bankService.getUserFromDB("Admin", "admin"));
    }

    @Test
    public void testBalance() {
	assertEquals(null, bankService.logout(userTest));
    }
}
