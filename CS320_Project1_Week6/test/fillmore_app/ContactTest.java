package fillmore_app;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    @DisplayName("Test contact constructor with valid data")
    public void testContactConstructorValidData() {
        Contact contact = new Contact("ID12345678", "Kylian", "Mbappe", "1234567890", "123 Raven St");
        assertEquals("ID12345678", contact.getContactID());
        assertEquals("Kylian", contact.getFirstName());
        assertEquals("Mbappe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Raven St", contact.getAddress());
    }

    @Test
    @DisplayName("Test contact constructor with invalid ID's")
    public void testContactConstructorInvalidID() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Kylian", "Mbappe", "1234567890", "123 Raven St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("ID12345678910111213", "Kylian", "Mbappe", "1234567890", "123 Raven St");
        });
    }

    @Test
    @DisplayName("Test contact constructor with invalid first names should error")
    public void testContactConstructorInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("ID12345678", null, "Mbappe", "1234567890", "123 Raven St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("ID12345678", "Kyliannametolong", "Mbappe", "1234567890", "123 Raven St");
        });
    }

    @Test
    @DisplayName("Test contact constructor with invalid last names should error")
    public void testContactConstructorInvalidLastName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("ID12345678", "Kylian", null, "1234567890", "123 Raven St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("ID12345678", "Kylian", "Mbappetolonglast", "1234567890", "123 Raven St");
        });
    }

    @Test
    @DisplayName("Test contact constructor with invalid phone data should error")
    public void testContactConstructorInvalidPhone() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("ID12345678", "Kylian", "Mbappe", null, "123 Raven St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("ID12345678", "Kylian", "Mbappe", "12345", "123 Raven St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("ID12345678", "Kylian", "Mbappe", "abcd", "123 Raven St");
        });
    }

    @Test
    @DisplayName("Test contact constructor with invalid address data should error")
    public void testContactConstructorInvalidAddress() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("ID12345678", "Kylian", "Mbappe", "1234567890", null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("ID12345678", "Kylian", "Mbappe", "1234567890", "123 Raven Street, Some City, too_long, 111111111");
        });
    }
    
    @Test
    @DisplayName("Test setFirstName with valid first name")
    public void testSetFirstNameValid() {
        Contact contact = new Contact("ID12345678", "Kylian", "Mbappe", "1234567890", "123 Raven St");
        contact.setFirstName("Leo");
        assertEquals("Leo", contact.getFirstName());
    }

    @Test
    @DisplayName("Test setFirstName with null should throw exception")
    public void testSetFirstNameNull() {
        Contact contact = new Contact("ID12345678", "Kylian", "Mbappe", "1234567890", "123 Raven St");
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
    }

    @Test
    @DisplayName("Test setFirstName with too long name should throw exception")
    public void testSetFirstNameTooLong() {
        Contact contact = new Contact("ID12345678", "Kylian", "Mbappe", "1234567890", "123 Raven St");
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("AlexandertheGreat"));
    }
    
    @Test
    @DisplayName("Test setLastName with valid last name")
    public void testSetLastNameValid() {
        Contact contact = new Contact("ID12345678", "Kylian", "Mbappe", "1234567890", "123 Raven St");
        contact.setLastName("Ronaldo");
        assertEquals("Ronaldo", contact.getLastName());
    }

    @Test
    @DisplayName("Test setLastName with null should throw exception")
    public void testSetLastNameNull() {
        Contact contact = new Contact("ID12345678", "Kylian", "Mbappe", "1234567890", "123 Raven St");
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
    }

    @Test
    @DisplayName("Test setLastName with too long name should throw exception")
    public void testSetLastNameTooLong() {
        Contact contact = new Contact("ID12345678", "Kylian", "Mbappe", "1234567890", "123 Raven St");
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName("De Albuquerque"));
    }

    @Test
    @DisplayName("Test setPhone with valid phone number")
    public void testSetPhoneValid() {
        Contact contact = new Contact("ID12345678", "Kylian", "Mbappe", "1234567890", "123 Raven St");
        contact.setPhone("0987654321");
        assertEquals("0987654321", contact.getPhone());
    }

    @Test
    @DisplayName("Test setPhone with null should throw exception")
    public void testSetPhoneNull() {
        Contact contact = new Contact("ID12345678", "Kylian", "Mbappe", "1234567890", "123 Raven St");
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone(null));
    }

    @Test
    @DisplayName("Test setPhone with invalid format should throw exception")
    public void testSetPhoneInvalidFormat() {
        Contact contact = new Contact("ID12345678", "Kylian", "Mbappe", "1234567890", "123 Raven St");
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("abcdefghij"));
    }

    @Test
    @DisplayName("Test setPhone with incorrect length should throw exception")
    public void testSetPhoneIncorrectLength() {
        Contact contact = new Contact("ID12345678", "Kylian", "Mbappe", "1234567890", "123 Raven St");
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("123"));
    }
    
    @Test
    @DisplayName("Test setAddress with valid address")
    public void testSetAddressValid() {
        Contact contact = new Contact("ID12345678", "Kylian", "Mbappe", "1234567890", "123 Raven St");
        contact.setAddress("456 Elm Street");
        assertEquals("456 Elm Street", contact.getAddress());
    }

    @Test
    @DisplayName("Test setAddress with null should throw exception")
    public void testSetAddressNull() {
        Contact contact = new Contact("ID12345678", "Kylian", "Mbappe", "1234567890", "123 Raven St");
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
    }

    @Test
    @DisplayName("Test setAddress with too long address should throw exception")
    public void testSetAddressTooLong() {
        Contact contact = new Contact("ID12345678", "Kylian", "Mbappe", "1234567890", "123 Raven St");
        String longAddress = "1234567890123456789012345678901 Raven Street";
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress(longAddress));
    }   
}

