import entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.UserRepository;
import repository.UserRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryImplTest {

    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        userRepository = new UserRepositoryImpl();
    }

    @Test
    public void testAddUser() {
        User user = new User("testUser", "testPassword");
        assertTrue(userRepository.addUser(user));

        assertFalse(userRepository.addUser(user));
    }

    @Test
    public void testGetUser() {
        User user = new User("testUser", "testPassword");
        userRepository.addUser(user);

        User fetchedUser = userRepository.getUser("testUser");
        assertNotNull(fetchedUser);
        assertEquals("testUser", fetchedUser.getUsername());
        assertEquals("testPassword", fetchedUser.getPassword());

        assertNull(userRepository.getUser("nonExistentUser"));
    }
}
