package fillmore_app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
    private ContactService service;
    
    // setup the contact service before the tests execute
    @BeforeEach
    void setUp() {
        service = new ContactService();
    }

    @Test
    @DisplayName("Add contact successfully")
    void testAddContactSuccess() {
        Contact contact = new Contact("ID12345678", "Kylian", "Mbappe", "1234567890", "123 Raven St");
        service.addContact(contact);
        assertNotNull(service.getContact("ID12345678"));
    }

    @Test
    @DisplayName("Adding null contact should error")
    void testAddNullContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(null);
        });
    }

    @Test
    @DisplayName("Adding a contact with a duplicate ID should error")
    void testAddContactWithDuplicateID() {
        Contact contact = new Contact("ID12345678", "Kylian", "Mbappe", "1234567890", "123 Raven St");
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(new Contact("ID12345678", "Kylian", "Mbappe", "0987654321", "456 Raven St"));
        });
    }

    @Test
    @DisplayName("Delete contact success")
    void testDeleteContact() {
        Contact contact = new Contact("ID12345678", "Kylian", "Mbappe", "1234567890", "123 Raven St");
        service.addContact(contact);
        service.deleteContact("ID12345678");
        assertNull(service.getContact("ID12345678"));
    }

    @Test
    @DisplayName("Update contact first name success")
    void testUpdateContactFirstName() {
        Contact contact = new Contact("ID12345678", "Kylian", "Mbappe", "1234567890", "123 Raven St");
        service.addContact(contact);
        service.updateContact("ID12345678", "Kevin", null, null, null);
        contact = service.getContact("ID12345678");
        assertNotNull(contact);
        assertEquals("Kevin", contact.getFirstName());
    }

    @Test
    @DisplayName("Update contact last name success")
    void testUpdateContactLastName() {
        Contact contact = new Contact("ID12345678", "Kylian", "Mbappe", "1234567890", "123 Raven St");
        service.addContact(contact);
        service.updateContact("ID12345678", null, "DeBruyne", null, null);
        contact = service.getContact("ID12345678");
        assertNotNull(contact);
        assertEquals("DeBruyne", contact.getLastName());
    }

    @Test
    @DisplayName("Update contact phone success")
    void testUpdateContactPhone() {
        Contact contact = new Contact("ID12345678", "Kylian", "Mbappe", "1234567890", "123 Raven St");
        service.addContact(contact);
        service.updateContact("ID12345678", null, null, "1112223334", null);
        contact = service.getContact("ID12345678");
        assertNotNull(contact);
        assertEquals("1112223334", contact.getPhone());
    }

    @Test
    @DisplayName("Update contact address success")
    void testUpdateContactAddress() {
        Contact contact = new Contact("ID12345678", "Kylian", "Mbappe", "1234567890", "123 Raven St");
        service.addContact(contact);
        service.updateContact("ID12345678", null, null, null, "456 Raven St");
        contact = service.getContact("ID12345678");
        assertNotNull(contact);
        assertEquals("456 Raven St", contact.getAddress());
    }

    @Test
    @DisplayName("Updating contact with invalid first name should throw exception")
    void testUpdateContactWithInvalidFirstName() {
        Contact contact = new Contact("ID12345678", "Kylian", "Mbappe", "1234567890", "123 Raven St");
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateContact("ID12345678", "KevinIsTooLongNameHere", "DeBruyne", "1112223334", "456 Raven St");
        });

        assertEquals("Kylian", service.getContact("ID12345678").getFirstName());
    }
    
    @Test
    @DisplayName("Updating contact with invalid last name should throw exception")
    void testUpdateContactWithInvalidLastName() {
        Contact contact = new Contact("ID12345678", "Kylian", "Mbappe", "1234567890", "123 Raven St");
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateContact("ID12345678", "Kevin", "DeBruyneTooLongLastName", "1112223334", "456 Raven St");
        });
 
        assertEquals("Mbappe", service.getContact("ID12345678").getLastName());
    }
    
    @Test
    @DisplayName("Updating contact with invalid phone should throw exception")
    void testUpdateContactWithInvalidPhone() {
        Contact contact = new Contact("ID12345678", "Kylian", "Mbappe", "1234567890", "123 Raven St");
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateContact("ID12345678", "Kevin", "DeBruyne", "NotAPhoneNumber", "456 Raven St");
        });

        assertEquals("1234567890", service.getContact("ID12345678").getPhone());
    }
    
    @Test
    @DisplayName("Updating contact with invalid address should throw exception")
    void testUpdateContactWithInvalidAddress() {
        Contact contact = new Contact("ID12345678", "Kylian", "Mbappe", "1234567890", "123 Raven St");
        service.addContact(contact);
        String longAddress = "This Address Is Certainly Way Too Long To Be Considered Valid";
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateContact("ID12345678", "Kevin", "DeBruyne", "1112223334", longAddress);
        });

        assertEquals("123 Raven St", service.getContact("ID12345678").getAddress());
    }
    
    @Test
    @DisplayName("Updating contact that doesn't exist should error")
    void testUpdateNonExistingContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateContact("ID1111111", "Harry", "Maguire", "1112223334", "456 Raven St");
        });
    }
}

