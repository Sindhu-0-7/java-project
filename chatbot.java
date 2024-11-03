import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class chatbot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput;
        
        // Initialize a HashMap to store questions and responses
        Map<String, String> responses = new HashMap<>();
        responses.put("hello", "Hello! How can I assist you today?");
        responses.put("hi", "Hi there! What's on your mind?");
        responses.put("how are you", "I'm just a program, but I'm here to help!");
        responses.put("your name", "I'm Chatbot, your virtual assistant.");
        responses.put("what is java", "Java is a popular programming language used for building applications.");
        responses.put("what is your purpose", "My purpose is to help answer your questions!");
        responses.put("tell me a joke", "Why do programmers prefer dark mode? Because light attracts bugs!");
        responses.put("who created you", "I was created by a team of developers!");
        responses.put("bye", "Goodbye! Feel free to chat anytime.");
       
        System.out.println("Hello! I'm Chatbot. How can I help you today?");
        
        while (true) {
            System.out.print("You: ");
            userInput = scanner.nextLine().toLowerCase();

            // Exit condition
            if (userInput.contains("exit") || userInput.contains("bye")) {
                System.out.println("Chatbot: " + responses.get("bye"));
                break;
            }
            
            // Check if any key in the HashMap matches the user's input
            boolean foundResponse = false;
            for (Map.Entry<String, String> entry : responses.entrySet()) {
                if (userInput.contains(entry.getKey())) {
                    System.out.println("Chatbot: " + entry.getValue());
                    foundResponse = true;
                    break;
                }
            }
            
            // Default response if no matching keyword is found
            if (!foundResponse) {
                System.out.println("Chatbot: I'm not sure how to respond to that.");
            }
        }
        
        scanner.close();
    }
}
