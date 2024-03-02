package contactservice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    // Test for successful contact creation
    @Test
    public void testContactCreation() {
        Contact contact = new Contact("ID1234567", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("ID1234567", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    // Contact ID tests
    @Test
    public void testContactIdNull() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "John", "Doe", "1234567890", "123 Main St"));
    }
    @Test
    public void testContactIdExactLength() {
        assertDoesNotThrow(() -> new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St"));
    }
    @Test
    public void testContactIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St"));
    }
    @Test
    public void testContactIdShort() {
        assertDoesNotThrow(() -> new Contact("12345", "John", "Doe", "1234567890", "123 Main St"));
    }

    // First Name tests
    @Test
    public void testFirstNameNull() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("ID123", null, "Doe", "1234567890", "123 Main St"));
    }
    @Test
    public void testFirstNameExactLength() {
        assertDoesNotThrow(() -> new Contact("ID123", "JohnJohnJo", "Doe", "1234567890", "123 Main St"));
    }
    @Test
    public void testFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("ID123", "JohnJohnJohn", "Doe", "1234567890", "123 Main St"));
    }

    // Last Name tests
    @Test
    public void testLastNameNull() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("ID123", "John", null, "1234567890", "123 Main St"));
    }
    @Test
    public void testLastNameExactLength() {
        assertDoesNotThrow(() -> new Contact("ID123", "John", "DoeDoeDoeD", "1234567890", "123 Main St"));
    }
    @Test
    public void testLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("ID123", "John", "DoeDoeDoeDoe", "1234567890", "123 Main St"));
    }

    // Phone Number tests
    @Test
    public void testPhoneNull() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("ID123", "John", "Doe", null, "123 Main St"));
    }
    @Test
    public void testPhoneExactLength() {
        assertDoesNotThrow(() -> new Contact("ID123", "John", "Doe", "1234567890", "123 Main St"));
    }
    @Test
    public void testPhoneInvalidLength() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("ID123", "John", "Doe", "12345", "123 Main St"));
    }

    // Address tests
    @Test
    public void testAddressNull() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("ID123", "John", "Doe", "1234567890", null));
    }
    @Test
    public void testAddressExactLength() {
        assertDoesNotThrow(() -> new Contact("ID123", "John", "Doe", "1234567890", "123456789012345678901234567890"));
    }
    @Test
    public void testAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("ID123", "John", "Doe", "1234567890", "123 Main Street That Is Way Too Long Beyond Thirty Characters"));
    }

    // Update tests
    @Test
    public void testUpdateFirstName() {
        Contact contact = new Contact("ID123", "John", "Doe", "1234567890", "123 Main St");
        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());
    }
    @Test
    public void testUpdateLastName() {
        Contact contact = new Contact("ID123", "John", "Doe", "1234567890", "123 Main St");
        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());
    }
    @Test
    public void testUpdatePhone() {
        Contact contact = new Contact("ID123", "John", "Doe", "1234567890", "123 Main St");
        contact.setPhone("0987654321");
        assertEquals("0987654321", contact.getPhone());
    }
    @Test
    public void testUpdateAddress() {
        Contact contact = new Contact("ID123", "John", "Doe", "1234567890", "123 Main St");
        contact.setAddress("456 Elm St");
        assertEquals("456 Elm St", contact.getAddress());
    }
 // Test for valid Contact ID less than 10 characters
    @Test
    public void testValidContactId() {
        assertDoesNotThrow(() -> new Contact("ID1234", "John", "Doe", "1234567890", "123 Main St"));
    }

    // Test for valid FirstName less than 10 characters
    @Test
    public void testValidFirstName() {
        assertDoesNotThrow(() -> new Contact("ID123", "Jane", "Doe", "1234567890", "123 Main St"));
    }

    // Test for valid LastName less than 10 characters
    @Test
    public void testValidLastName() {
        assertDoesNotThrow(() -> new Contact("ID123", "John", "Smith", "1234567890", "123 Main St"));
    }

    // Test for valid Phone Number
    @Test
    public void testValidPhone() {
        assertDoesNotThrow(() -> new Contact("ID123", "John", "Doe", "0987654321", "123 Main St"));
    }

    // Test for valid Address less than 30 characters
    @Test
    public void testValidAddress() {
        assertDoesNotThrow(() -> new Contact("ID123", "John", "Doe", "1234567890", "456 Elm St"));
    }
 // Test for updating FirstName to more than 10 characters
    @Test
    public void testUpdateFirstNameInvalid() {
        Contact contact = new Contact("ID123", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("JaneJaneJane"));
    }

    // Test for updating LastName to more than 10 characters
    @Test
    public void testUpdateLastNameInvalid() {
        Contact contact = new Contact("ID123", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName("SmithSmithS"));
    }
 // Test for updating LastName to exactly 10 characters
    @Test
    public void testUpdateLastNameToMax() {
        Contact contact = new Contact("ID123", "John", "Doe", "1234567890", "123 Main St");
        contact.setLastName("SmithSmith");
        assertEquals("SmithSmith", contact.getLastName());
    }

    // Test for updating Address to exactly 30 characters
    @Test
    public void testUpdateAddressToMax() {
        Contact contact = new Contact("ID123", "John", "Doe", "1234567890", "123 Main St");
        contact.setAddress("123456789012345678901234567890");
        assertEquals("123456789012345678901234567890", contact.getAddress());
    }
 // Test updating firstName with valid and invalid data
    @Test
    public void testUpdateFirstNameValidInvalid() {
        Contact contact = new Contact("ID123", "John", "Doe", "1234567890", "123 Main St");
        contact.setFirstName("Jane"); // Valid update
        assertEquals("Jane", contact.getFirstName());

        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("TooLongFirstName")); // Invalid update
    }

    // Test updating lastName with valid and invalid data
    @Test
    public void testUpdateLastNameValidInvalid() {
        Contact contact = new Contact("ID123", "John", "Doe", "1234567890", "123 Main St");
        contact.setLastName("Smith"); // Valid update
        assertEquals("Smith", contact.getLastName());

        assertThrows(IllegalArgumentException.class, () -> contact.setLastName("TooLongLastName")); // Invalid update
    }
 // Test updating phone with valid and invalid data
    @Test
    public void testUpdatePhoneValidInvalid() {
        Contact contact = new Contact("ID123", "John", "Doe", "1234567890", "123 Main St");
        contact.setPhone("0987654321"); // Valid update
        assertEquals("0987654321", contact.getPhone());

        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("Not10Digits")); // Invalid update
    }

    // Test updating address with valid and invalid data
    @Test
    public void testUpdateAddressValidInvalid() {
        Contact contact = new Contact("ID123", "John", "Doe", "1234567890", "123 Main St");
        contact.setAddress("456 Elm St"); // Valid update
        assertEquals("456 Elm St", contact.getAddress());

        assertThrows(IllegalArgumentException.class, () -> contact.setAddress("ThisAddressIsDefinitelyWayTooLongForTheField")); // Invalid update
    }@Test
    public void testValidPhoneWithDifferentNumbers() {
        Contact contact = new Contact("ID123", "John", "Doe", "9876543210", "123 Main St");
        assertEquals("9876543210", contact.getPhone());
    }

}
