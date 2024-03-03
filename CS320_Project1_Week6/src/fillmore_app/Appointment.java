package fillmore_app;

import java.util.Date;

public class Appointment {
    private final String appointmentID;
    private Date appointmentDate;
    private String appointmentDesc;
    
    // Constructor with parameters
    public Appointment(String appointmentID, Date appointmentDate, String appointmentDesc) {
        if (appointmentID == null || appointmentID.length() > 10) {
            throw new IllegalArgumentException("Appointment ID cannot be null and must be 10 characters or less.");
        }
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Appointment date cannot be null and must not be in the past.");
        }
        if (appointmentDesc == null || appointmentDesc.length() > 50) {
            throw new IllegalArgumentException("Appointment description cannot be null and must be 50 characters or less.");
        }
        
        this.appointmentID = appointmentID;
        this.appointmentDate = appointmentDate;
        this.appointmentDesc = appointmentDesc;
    }
    
    // Getters
    public String getAppointmentID() {
        return appointmentID;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }
    
    public String getAppointmentDesc() {
        return appointmentDesc;
    }
    
    // Setters
    public void setAppointmentDate(Date appointmentDate) {
        if (appointmentDate != null && !appointmentDate.before(new Date())) {
            this.appointmentDate = appointmentDate;
        } else {
            throw new IllegalArgumentException("Invalid appointment date.");
        }
    }

    public void setAppointmentDesc(String appointmentDesc) {
        if (appointmentDesc != null && appointmentDesc.length() <= 50) {
            this.appointmentDesc = appointmentDesc;
        } else {
            throw new IllegalArgumentException("Invalid appointment description.");
        }
    }
}
