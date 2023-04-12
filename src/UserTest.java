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
        User user1 = new User("Test1", "John@examplecom");
        User user2 = new User("Test2", "John@example.com");
        assertFalse(user1.isValidEmail(user1.getEmail()), "Е-майл не имеет '@' или '.' ");
        assertTrue(user2.isValidEmail(user2.getEmail()), "Е-майл не имеет '@' или '.' ");
    }


    @DisplayName("Е-майл != логин ")
    @Test
    public void testIsEqualsEmailAndName() {
        user = new User("johwn@example.com", "John@example.com");
        assertTrue(user.isEqualsEmailAndName("John@example.com", user.getName()), "Имейл и логин одинаковые");
        assertTrue(user.isEqualsEmailAndName("johndoe@example.com", user.getName()), "Имейл и логин одинаковые");
    }
}