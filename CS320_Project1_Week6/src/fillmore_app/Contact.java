package fillmore_app;

public class Contact {
	// final so contactID is not able to be updated (we don't provide a method to do this anyway)
    private final String contactID;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    
    // contact class created with required parameters
    public Contact(String contactID, String firstName, String lastName, String phone, String address) {
    	// if null or greater than 10 characters we error
    	if (contactID == null || contactID.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID");
        }
        // if null or greater than 10 characters we error
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        // if null or greater than 10 characters we error
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        // Can't be null, has to be length of 10 and has to be digits
        if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        // if null or address length greater than 30 we error
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }
        // Set class attributes to defined values
        this.contactID = contactID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }
    
    // gettors
    public String getContactID() {
        return contactID;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
    
    // setters - contact service will use this to update values
    public void setFirstName(String firstName) {
        if (firstName != null && firstName.length() <= 10) {
            this.firstName = firstName;
        } else {
            throw new IllegalArgumentException("Invalid first name");
        }
    }

    public void setLastName(String lastName) {
        if (lastName != null && lastName.length() <= 10) {
            this.lastName = lastName;
        } else {
            throw new IllegalArgumentException("Invalid last name");
        }
    }

    public void setPhone(String phone) {
        if (phone != null && phone.length() == 10 && phone.matches("\\d+")) {
            this.phone = phone;
        } else {
            throw new IllegalArgumentException("Invalid phone number");
        }
    }

    public void setAddress(String address) {
        if (address != null && address.length() <= 30) {
            this.address = address;
        } else {
            throw new IllegalArgumentException("Invalid address");
        }
    }
}
