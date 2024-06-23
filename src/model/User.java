package model;

public class User {
    private int userId;
    private String username;
    private String email;
    private String password;
    private NotificationPreferences notificationPreferences;

    public User(int userId, String username, String email, String password, NotificationPreferences notificationPreferences) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.notificationPreferences = notificationPreferences;
    }

    // Getter ve setter metodları
    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public NotificationPreferences getNotificationPreferences() {
        return notificationPreferences;
    }

    public void setNotificationPreferences(NotificationPreferences notificationPreferences) {
        this.notificationPreferences = notificationPreferences;
    }
}

