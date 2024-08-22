import entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.UserRepository;
import repository.UserRepositoryImpl;
import service.Cryptographer;
import service.CryptographerImpl;
import service.UserService;
import service.UserServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class  UserServiceTest {
    private UserService userService;

    @BeforeEach
    public void setUp() {
        UserRepository userRepository = new UserRepositoryImpl();
        Cryptographer cryptographer = new CryptographerImpl();
        userService = new UserServiceImpl(userRepository, cryptographer);
    }

    @Test
    public void testRegisterSuccess() {
        // Проверка успешной регистрации пользователя с валидными данными
        assertTrue(userService.usernameAndPaswordCheck("user1", "Password1!"));
    }

    @Test
    public void testRegisterFail_UsernameTooShort() {
        // Проверка неудачной регистрации с коротким именем пользователя
        assertFalse(userService.usernameAndPaswordCheck("us", "Password1!"));
    }

    @Test
    public void testRegisterFail_PasswordTooShort() {
        // Проверка неудачной регистрации с коротким паролем
        assertFalse(userService.usernameAndPaswordCheck("user1", "Pass1!"));
    }

    @Test
    public void testRegisterFail_PasswordMissingNumber() {
        // Проверка неудачной регистрации с паролем без цифр
        assertFalse(userService.usernameAndPaswordCheck("user1", "Password!"));
    }

    @Test
    public void testRegisterFail_PasswordMissingSpecialCharacter() {
        // Проверка неудачной регистрации с паролем без специального символа
        assertFalse(userService.usernameAndPaswordCheck("user1", "Password1"));
    }

    @Test
    public void testLoginSuccess() {
        // Проверка успешного входа
        userService.usernameAndPaswordCheck("user1", "Password1!");
        assertTrue(userService.login("user1", "Password1!"));
    }

    @Test
    public void testLoginFail_InvalidPassword() {
        // Проверка неудачного входа с неверным паролем
        userService.usernameAndPaswordCheck("user1", "Password1!");
        assertFalse(userService.login("user1", "WrongPassword!"));
    }

    @Test
    public void testLoginFail_UserNotRegistered() {
        // Проверка неудачного входа для незарегистрированного пользователя
        assertFalse(userService.login("nonExistentUser", "Password1!"));
    }

    @Test
    public void testLoginFail_AccountLockedAfterTooManyAttempts() {
        // Проверка блокировки учетной записи после нескольких неудачных попыток входа
        userService.usernameAndPaswordCheck("user1", "Password1!");

        // 3 неудачные попытки входа
        assertFalse(userService.login("user1", "WrongPassword!"));
        assertFalse(userService.login("user1", "WrongPassword!"));
        assertFalse(userService.login("user1", "WrongPassword!"));

        // 4-я попытка должна быть заблокирована
        assertFalse(userService.login("user1", "Password1!"));
    }
}
