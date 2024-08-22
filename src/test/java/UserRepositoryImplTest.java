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
        // добавление пользователя в репозиторий и предотвращение дублирования пользователей
        assertTrue(userRepository.addUser(user));
        assertFalse(userRepository.addUser(user));
    }

    @Test
    public void testGetUser() {
        User user = new User("testUser", "Test@1234");
        userRepository.addUser(user);
        //проверяет извлечение пользователя из репозитория по имени и отсутствие пользователя
        User fetchedUser = userRepository.getUser("testUser");
        assertNotNull(fetchedUser);
        assertEquals("testUser", fetchedUser.getUsername());
        assertEquals("Test@1234", fetchedUser.getPassword());

        assertNull(userRepository.getUser("nonExistentUser"));

    }
}
