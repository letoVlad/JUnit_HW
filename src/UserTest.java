import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user;

    @BeforeEach
    public void createUser() {
        user = new User("John", "John@example.com");
    }

    @DisplayName("Установка данныйх при создании")
    @Test
    public void testCreateUser() {
        assertEquals("John", user.getName(), "Данные не установленны");
        assertEquals("John@example.com", user.getEmail(), "Данные не установленны");
    }

    @DisplayName("Установка нулевых данных при создании")
    @Test
    public void testNotCreateUser() {
        User user = new User();
        assertNull(user.getName());
        assertNull(user.getEmail());
    }

    @DisplayName("Корректный Е-майл")
    @Test
    void testCorrectEmailUser() {
        assertThrows(IllegalArgumentException.class, () -> new User("Jong", "123qasdd.ru"));
    }

    @DisplayName("Е-майл != логин ")
    @Test
    void testEmailNotEqualToName() {
        assertThrows(RuntimeException.class, () -> new User("John@example.com", "John@example.com"));
    }
}