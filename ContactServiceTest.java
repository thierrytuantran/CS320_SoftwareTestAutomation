package contactservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
    private ContactService service;

    @BeforeEach
    public void setUp() {
        service = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("ID123", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        assertNotNull(service.getContact("ID123"));
    }

    @Test
    public void testDeleteContact() {
        service.addContact(new Contact("ID124", "Jane", "Doe", "1234567891", "456 Elm St"));
        service.deleteContact("ID124");
        assertNull(service.getContact("ID124"));
    }

    @Test
    public void testUpdateContact() {
        service.addContact(new Contact("ID125", "Jim", "Beam", "1234567892", "789 Oak St"));
        service.updateContact("ID125", "James", "Beam", "9876543210", "789 Oak St");
        Contact updated = service.getContact("ID125");
        assertEquals("James", updated.getFirstName());
        // Test other updated fields
    }
}
