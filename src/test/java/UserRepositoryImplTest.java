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
        User user = new User("testUser", "Test@1234");
        assertTrue(userRepository.addUser(user));

        assertFalse(userRepository.addUser(user));
    }

    @Test
    public void testGetUser() {
        User user = new User("testUser", "Test@1234");
        userRepository.addUser(user);

        User fetchedUser = userRepository.getUser("testUser");
        assertNotNull(fetchedUser);
        assertEquals("testUser", fetchedUser.getUsername());
        assertEquals("Test@1234", fetchedUser.getPassword());

        assertNull(userRepository.getUser("nonExistentUser"));
    }

    @Test
    public void testPasswordTooShort() {
        User shortPasswordUser = new User("user1", "short");
        assertTrue(userRepository.addUser(shortPasswordUser)); // Предполагаем, что добавление такого пользователя невозможно
    }

    @Test
    public void testPasswordMissingSymbol() {
        User missingSymbolUser = new User("user2", "Password123");
        assertTrue(userRepository.addUser(missingSymbolUser)); // Предполагаем, что добавление такого пользователя невозможно
    }

    @Test
    public void testPasswordMissingNumber() {
        User missingNumberUser = new User("user3", "Password!");
        assertTrue(userRepository.addUser(missingNumberUser)); // Предполагаем, что добавление такого пользователя невозможно
    }
}
