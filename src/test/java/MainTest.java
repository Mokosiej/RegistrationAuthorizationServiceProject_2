import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.UserRepository;
import repository.UserRepositoryImpl;
import service.Cryptographer;
import service.CryptographerImpl;
import service.UserService;
import service.UserServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private UserService userService;

    @BeforeEach
    public void setUp() {
        UserRepository userRepository = new UserRepositoryImpl();
        Cryptographer cryptographer = new CryptographerImpl();
        userService = new UserServiceImpl(userRepository, cryptographer);
    }

    @Test
    public void testRegisterSuccess() {
        assertTrue(userService.usernameAndPaswordCheck("user1", "Password1!"));
    }

    @Test
    public void testRegisterFailWeakPassword() {
        assertFalse(userService.usernameAndPaswordCheck("user1", "pass"));
    }

    @Test
    public void testLoginSuccess() {
        userService.usernameAndPaswordCheck("user1", "Password1!");
        assertTrue(userService.login("user1", "Password1!"));
    }

    @Test
    public void testLoginFailInvalidPassword() {
        userService.usernameAndPaswordCheck("user1", "Password1!");
        assertFalse(userService.login("user1", "wrongpassword"));
    }

}