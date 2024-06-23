package controller;

import system.WebsiteMonitorSystem;
import model.User;
import model.Website;
import model.Subscription;

public class RegistrationController {
    private WebsiteMonitorSystem system;

    public RegistrationController(WebsiteMonitorSystem system) {
        this.system = system;
    }

    public void registerUser(User user, Website website) {
        system.getUsers().add(user);
        system.getSubscriptions().add(new Subscription(user, website));
    }

    public void modifySubscription(User user, Website newWebsite) {
        for (Subscription sub : system.getSubscriptions()) {
            if (sub.getUser().getUserId() == user.getUserId()) {
                sub.setWebsite(newWebsite);
            }
        }
    }

    public void cancelSubscription(User user) {
        system.getSubscriptions().removeIf(sub -> sub.getUser().getUserId() == user.getUserId());
    }

    public WebsiteMonitorSystem getSystem() {
        return system;
    }

}




