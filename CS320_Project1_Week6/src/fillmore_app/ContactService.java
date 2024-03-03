package fillmore_app;
import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
    	// if contact is null or the contacts HashMap already contains the contact ID we error
        if (contact == null || contacts.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("Contact already exists or is invalid");
        }
        contacts.put(contact.getContactID(), contact);
    }
    // method to delete a Map object from the HashMap via contactID
    public void deleteContact(String contactID) {
        contacts.remove(contactID);
    }
    // update HashMap via the contactID
    public void updateContact(String contactID, String firstName, String lastName, String phone, String address) {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }
        
        // Validate all inputs before making any changes
        if ((firstName != null && firstName.length() > 10) ||
            (lastName != null && lastName.length() > 10) ||
            (phone != null && (phone.length() != 10 || !phone.matches("\\d+"))) ||
            (address != null && address.length() > 30)) {
            throw new IllegalArgumentException("Invalid input");
        }
        
        // Now that all inputs have been validated, proceed with the updates
        if (firstName != null) contact.setFirstName(firstName);
        if (lastName != null) contact.setLastName(lastName);
        if (phone != null) contact.setPhone(phone);
        if (address != null) contact.setAddress(address);
    }
    
    // Gettors
    public Contact getContact(String contactID) {
        return contacts.get(contactID);
    }

}
