package fillmore_app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

import java.util.Collections;
import java.util.Date;

class AppointmentTest {

    @Test
    @DisplayName("Test that adding an appointment with valid data is successful")
    void testAppointmentConstructorValidData() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000); // A future date
        String appointmentID = "01234";
        String appointmentDesc = "Appointment1";
        
        Appointment appointment = new Appointment(appointmentID, futureDate, appointmentDesc);
        
        assertEquals(appointmentID, appointment.getAppointmentID());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals(appointmentDesc, appointment.getAppointmentDesc());
    }

    @Test
    @DisplayName("Test that adding an appointment with an invalid ID throws an exception")
    void testAppointmentConstructorInvalidID() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        
        assertThrows(IllegalArgumentException.class, () -> new Appointment(null, futureDate, "Appointment1"));
        
        assertThrows(IllegalArgumentException.class, () -> new Appointment("012345678901", futureDate, "Appointment1"));
    }

    @Test
    @DisplayName("Test that adding an appointment with an invalid date throws an exception")
    void testAppointmentConstructorInvalidDate() {
        String appointmentID = "01234";
        String appointmentDesc = "Appointment1";
        
        assertThrows(IllegalArgumentException.class, () -> new Appointment(appointmentID, null, appointmentDesc));
        
        assertThrows(IllegalArgumentException.class, () -> new Appointment(appointmentID, new Date(System.currentTimeMillis() - 100000), appointmentDesc));
    }

    @Test
    @DisplayName("Test that adding an appointment with an invalid description throws an exception")
    void testAppointmentConstructorInvalidDescription() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        String appointmentID = "01234";
        
        assertThrows(IllegalArgumentException.class, () -> new Appointment(appointmentID, futureDate, null));
        
        String longDescription = String.join("", Collections.nCopies(51, "a"));
        assertThrows(IllegalArgumentException.class, () -> new Appointment(appointmentID, futureDate, longDescription));
    }

    @Test
    @DisplayName("Test setting an appointment with a valid date")
    void testSetAppointmentDateValid() {
        Appointment appointment = new Appointment("01234", new Date(System.currentTimeMillis() + 100000), "Valid Description");
        Date newValidDate = new Date(System.currentTimeMillis() + 10000);

        appointment.setAppointmentDate(newValidDate);
        
        assertEquals(newValidDate, appointment.getAppointmentDate());
    }

    @Test
    @DisplayName("Test setting an appointment with an invalid date throws an exception")
    void testSetAppointmentDateInvalid() {
        Appointment appointment = new Appointment("01234", new Date(System.currentTimeMillis() + 100000), "Valid Description");
        Date pastDate = new Date(System.currentTimeMillis() - 100000);
        Date nullDate = null;
        
        assertThrows(IllegalArgumentException.class, () -> appointment.setAppointmentDate(pastDate));
        
        assertThrows(IllegalArgumentException.class, () -> appointment.setAppointmentDate(nullDate));
    }

    @Test
    @DisplayName("Test setting an appointment with a valid description")
    void testSetAppointmentDescValid() {
        Appointment appointment = new Appointment("01234", new Date(System.currentTimeMillis() + 100000), "Description");
        String newDescription = "New description";
        
        appointment.setAppointmentDesc(newDescription);
        
        assertEquals(newDescription, appointment.getAppointmentDesc());
    }

    @Test
    @DisplayName("Test setting an appointment with an invalid description throws an exception")
    void testSetAppointmentDescInvalid() {
        Appointment appointment = new Appointment("01234", new Date(System.currentTimeMillis() + 100000), "Valid Description");
        
        assertThrows(IllegalArgumentException.class, () -> appointment.setAppointmentDesc(null));
        
        String longDescription = String.join("", Collections.nCopies(51, "a"));
        assertThrows(IllegalArgumentException.class, () -> appointment.setAppointmentDesc(longDescription));
    }
}
