package fillmore_app;

import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
    private final Map<String, Appointment> appointments;

    public AppointmentService() {
        this.appointments = new HashMap<>();
    }

    // Adds appointment to the service
    public void addAppointment(Appointment appointment) throws IllegalArgumentException {
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment cannot be null.");
        }
        if (appointments.containsKey(appointment.getAppointmentID())) {
            throw new IllegalArgumentException("Appointment with this ID already exists.");
        }
        appointments.put(appointment.getAppointmentID(), appointment);
    }

    // Deletes appointment by ID
    public void deleteAppointment(String appointmentID) throws IllegalArgumentException {
        if (appointmentID == null || !appointments.containsKey(appointmentID)) {
            throw new IllegalArgumentException("No appointment found with the given ID.");
        }
        appointments.remove(appointmentID);
    }
}

