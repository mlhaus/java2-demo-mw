package edu.kirkwood.learnx.model;

public class LearnxUser {
    private int userId;
    private String firstName;
    private String lastName;

    public LearnxUser(int userId, String firstName, String lastName) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public LearnxUser() {}

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "LearnxUser [userId=" + userId + ", firstName=" + firstName + ", lastName="
                + lastName + "]";
    }

    
}
