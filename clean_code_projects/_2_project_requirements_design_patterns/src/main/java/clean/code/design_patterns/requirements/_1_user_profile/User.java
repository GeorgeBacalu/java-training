package clean.code.design_patterns.requirements._1_user_profile;

import java.util.ArrayList;
import java.util.Arrays;

public class User {
    private int userId;
    private String name;
    private String email;
    private final String city;
    private final String job;
    private final String phoneNumber;
    private final String profileImageUrl;
    private final String coverImageUrl;
    private final boolean hasDrivingLicense;
    private final String[] hobbies;
    private ArrayList<Message> messages;

    public User(Builder builder) {
        this.userId = builder.userId;
        this.name = builder.name;
        this.email = builder.email;
        this.city = builder.city;
        this.job = builder.job;
        this.phoneNumber = builder.phoneNumber;
        this.profileImageUrl = builder.profileImageUrl;
        this.coverImageUrl = builder.coverImageUrl;
        this.hasDrivingLicense = builder.hasDrivingLicense;
        this.hobbies = builder.hobbies;
        this.messages = builder.messages;
    }

    static class Builder {
        private final int userId;
        private final String name;
        private final String email;
        private String city;
        private String job;
        private String phoneNumber;
        private String profileImageUrl;
        private String coverImageUrl;
        private boolean hasDrivingLicense;
        private String[] hobbies;
        private final ArrayList<Message> messages;

        public Builder(int userId, String name, String email, ArrayList<Message> messages) {
            this.userId = userId;
            this.name = name;
            this.email = email;
            this.messages = messages;
        }

        public Builder(int userId, String name, String email) {
            this.userId = userId;
            this.name = name;
            this.email = email;
            this.messages = new ArrayList<>();
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder job(String job) {
            this.job = job;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder profileImageUrl(String profileImageUrl) {
            this.profileImageUrl = profileImageUrl;
            return this;
        }

        public Builder coverImageUrl(String coverImageUrl) {
            this.coverImageUrl = coverImageUrl;
            return this;
        }

        public Builder hasDrivingLicense(boolean hasDrivingLicense) {
            this.hasDrivingLicense = hasDrivingLicense;
            return this;
        }

        public Builder hobbies(String[] hobbies) {
            this.hobbies = hobbies;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public int getUserId() { return userId; }

    public void setUserId(int userId) { this.userId = userId; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Message> getMessages() { return messages; }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", job='" + job + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", profileImageUrl='" + profileImageUrl + '\'' +
                ", coverImageUrl='" + coverImageUrl + '\'' +
                ", hasDrivingLicense=" + hasDrivingLicense +
                ", hobbies=" + Arrays.toString(hobbies) +
                ", messages=" + messages +
                '}';
    }
}
