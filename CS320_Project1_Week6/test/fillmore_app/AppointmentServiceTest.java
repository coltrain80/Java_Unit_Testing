package fillmore_app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import org.junit.jupiter.api.DisplayName;

class AppointmentServiceTest {

    private AppointmentService service;

    @BeforeEach
    void setUp() {
        service = new AppointmentService();
    }

    @Test
    @DisplayName("Test that adds an appointment successfully")
    void testAddAppointment() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appointment = new Appointment("01234", futureDate, "Appointment1");
        
        assertDoesNotThrow(() -> service.addAppointment(appointment));
    }

    @Test
    @DisplayName("Test that adding a duplicate appointment throws an exception")
    void testAddDuplicateAppointment() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appointment1 = new Appointment("01234", futureDate, "Appointment1");
        service.addAppointment(appointment1);
        Appointment appointment2 = new Appointment("01234", futureDate, "Appointment2");
        
        assertThrows(IllegalArgumentException.class, () -> service.addAppointment(appointment2));
    }
    
    @Test
    @DisplayName("Test that adding a null appointment throws an exception")
    void testAddNullAppointment() {
        assertThrows(IllegalArgumentException.class, () -> service.addAppointment(null));
    }

    @Test
    @DisplayName("Test that deleting an appointment is successful")
    void testDeleteAppointment() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appointment = new Appointment("01234", futureDate, "Appointment1");
        service.addAppointment(appointment);
        
        assertDoesNotThrow(() -> service.deleteAppointment("01234"));
    }

    @Test
    @DisplayName("Test that deleting a non-existent appointment throws an exception")
    void testDeleteNonExistentAppointment() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteAppointment("No_Appointment"));
        
        assertThrows(IllegalArgumentException.class, () -> service.deleteAppointment(null));
    }
}
