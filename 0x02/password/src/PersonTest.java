import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PersonTest {

    private static Person person;

    @BeforeAll
    static void setup() {
        person = new Person();
    }

    @ParameterizedTest
    @DisplayName("Check if user is valid")
    @ValueSource(strings = {"PaulMcCartney2", "NeilArms2"})
    void check_user_valid(String user) {
        assertTrue(person.checkUser(user));
    }

    @ParameterizedTest
    @DisplayName("Check if user is not valid")
    @ValueSource(strings = {"Paul#McCartney", "Neil@Arms"})
    void check_user_not_valid(String user) {
        assertFalse(person.checkUser(user));
    }

    @ParameterizedTest
    @DisplayName("Check if password does not have a letter")
    @ValueSource(strings = {"123456789", "#$%1234"})
    void does_not_have_letters(String password) {
        assertFalse(person.checkPassword(password));
    }

    @ParameterizedTest
    @DisplayName("Check if password does not have a number")
    @ValueSource(strings = {"Abcabcdefgh@", "#hbtn@%tc"})
    void does_not_have_numbers(String password) {
        assertFalse(person.checkPassword(password));
    }

    @ParameterizedTest
    @DisplayName("Check if password does not have eight characters")
    @ValueSource(strings = {"Abc@123", "12$@hbt"})
    void does_not_have_eight_chars(String password) {
        assertFalse(person.checkPassword(password));
    }

    @ParameterizedTest
    @DisplayName("Check if password is valid")
    @ValueSource(strings = {"abC123456$", "Hbtn@1234", "Betty@1#2", "Hbtn@123"})
    void check_password_valid(String password) {
        assertTrue(person.checkPassword(password));
    }
}