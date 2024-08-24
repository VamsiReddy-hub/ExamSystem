public class Main {
    public static void main(String[] args) {
        // Create a sample user
        User user = new User("user1", "password123", "Profile: Student, Age: 20");

        // Create an exam system with the user
        ExamSystem examSystem = new ExamSystem(user);

        // Run the exam system
        examSystem.run();
    }
}
