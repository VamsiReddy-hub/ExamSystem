import java.util.Scanner;

public class User {
    private String username;
    private String password;
    private String profileDetails;

    public User(String username, String password, String profileDetails) {
        this.username = username;
        this.password = password;
        this.profileDetails = profileDetails;
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public void updateProfile(String newDetails) {
        this.profileDetails = newDetails;
        System.out.println("Profile updated successfully.");
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
        System.out.println("Password changed successfully.");
    }

    public String getProfileDetails() {
        return profileDetails;
    }
}
