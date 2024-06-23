package model;

public class NotificationPreferences {
    private int frequency; // frequency in seconds
    private String communicationChannel;

    public NotificationPreferences(int frequency, String communicationChannel) {
        this.frequency = frequency;
        this.communicationChannel = communicationChannel;
    }

    // Getter ve setter metodları
    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String getCommunicationChannel() {
        return communicationChannel;
    }

    public void setCommunicationChannel(String communicationChannel) {
        this.communicationChannel = communicationChannel;
    }

    @Override
    public String toString() {
        return "Frequency: " + frequency + " seconds, Communication Channel: " + communicationChannel;
    }
}
