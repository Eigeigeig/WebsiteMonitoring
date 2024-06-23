package model;

public class Subscription {
    private User user;
    private Website website;

    public Subscription(User user, Website website) {
        this.user = user;
        this.website = website;
    }

    // Getter ve setter metodları
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Website getWebsite() {
        return website;
    }

    public void setWebsite(Website website) {
        this.website = website;
    }
}

