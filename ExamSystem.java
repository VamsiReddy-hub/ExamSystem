import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ExamSystem {
    private User user;
    private Map<String, String> questions;
    private Scanner scanner;
    private int score;

    public ExamSystem(User user) {
        this.user = user;
        this.scanner = new Scanner(System.in);
        this.questions = new HashMap<>();
        this.questions.put("What is the capital of France?", "Paris");
        this.questions.put("What is 2 + 2?", "4");
        this.questions.put("What is the largest planet?", "Jupiter");
        this.score = 0;
    }

    public void startExam() {
        System.out.println("Starting the exam...");
        int totalQuestions = questions.size();
        long startTime = System.currentTimeMillis();
        long duration = 60000; // 60 seconds for the entire exam

        for (Map.Entry<String, String> question : questions.entrySet()) {
            System.out.println(question.getKey());
            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase(question.getValue())) {
                score++;
            }

            if (System.currentTimeMillis() - startTime > duration) {
                System.out.println("Time is up! Auto-submitting the exam.");
                break;
            }
        }

        System.out.printf("Exam completed. Your score: %d/%d%n", score, totalQuestions);
    }

    public void run() {
        System.out.println("Welcome to the Online Examination System!");
        
        while (true) {
            System.out.println("\n1. Login");
            System.out.println("2. Update Profile");
            System.out.println("3. Change Password");
            System.out.println("4. Start Exam");
            System.out.println("5. Logout");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    handleLogin();
                    break;
                case 2:
                    handleProfileUpdate();
                    break;
                case 3:
                    handleChangePassword();
                    break;
                case 4:
                    startExam();
                    break;
                case 5:
                    handleLogout();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void handleLogin() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (user.login(username, password)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private void handleProfileUpdate() {
        System.out.print("Enter new profile details: ");
        String newDetails = scanner.nextLine();
        user.updateProfile(newDetails);
    }

    private void handleChangePassword() {
        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();
        user.changePassword(newPassword);
    }

    private void handleLogout() {
        System.out.println("Logging out...");
        System.out.println("Session closed.");
    }
}
