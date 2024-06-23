package system;

import model.User;
import model.Subscription;
import model.Notification;

import java.util.*;

public class WebsiteMonitorSystem {
    private static List<User> users = new ArrayList<>();
    private static List<Subscription> subscriptions = new ArrayList<>();

    private static List<Timer> timers = new ArrayList<>();
    private static Map<Timer, Subscription> timerMap = new HashMap<>();

    public static List<User> getUsers() {
        return users;
    }

    public static List<Subscription> getSubscriptions() {
        return subscriptions;
    }





    private static void checkUpdateForUser(User user) {
        for (Subscription sub : subscriptions) {
            if (sub.getUser().getUserId() == user.getUserId()) {
                generateNotification(user, "Update found for " + sub.getWebsite().getUrl());
            }
        }
    }

    public static void startMonitoringForUser(int userId) {
        User user = findUserById(userId);
        if (user != null) {
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    checkUpdateForUser(user);
                }
            }, 0, user.getNotificationPreferences().getFrequency() * 1000);

            // Timer ve ilgili Subscription'ı timers ve timerMap'e ekleyelim
            timers.add(timer);
            timerMap.put(timer, findSubscriptionByUserId(userId));
        }
    }

    public static void stopMonitoringForUser(int userId) {
        User user = findUserById(userId);
        if (user != null) {
            // Find the corresponding timer and cancel it
            for (Timer timer : timers) {
                Subscription sub = timerMap.get(timer);
                if (sub.getUser().getUserId() == userId) {
                    timer.cancel();
                    timers.remove(timer);
                    timerMap.remove(timer);
                    break;
                }
            }
        }
    }




    private static void generateNotification(User user, String message) {
        Notification notification = new Notification(users.size() + 1, message);
        deliverNotification(user, notification);
    }

    private static void deliverNotification(User user, Notification notification) {
        // Simulate delivering notification
        System.out.println("Notification to " + user.getUsername() + ": " + notification.getMessage() +
                " via " + user.getNotificationPreferences().getCommunicationChannel());
    }

    public static User findUserById(int userId) {
        for (User user : users) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null; // Eğer kullanıcı bulunamazsa null döner.
    }


    private static Subscription findSubscriptionByUserId(int userId) {
        for (Subscription sub : subscriptions) {
            if (sub.getUser().getUserId() == userId) {
                return sub;
            }
        }
        return null;
    }

}


