import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NeevChatBot {

    private static final Map<String, String> responses = new HashMap<>();

    static {
        responses.put("hello", "Hi there! How can I help you?");
        responses.put("how are you", "I'm just a computer program, but I'm doing well. How about you?");
        responses.put("neev app", "Neev app is a platform for quality education. You can find courses, resources, and more.");
        responses.put("thanks", "You're welcome! If you have more questions, feel free to ask.");
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Neev ChatBot: Hi! I'm here to help you. Type 'exit' to end the conversation.");

            while (true) {
                System.out.print("You: ");
                String userMessage = scanner.nextLine().toLowerCase();

                if (userMessage.equals("exit")) {
                    System.out.println("Neev ChatBot: Goodbye! If you have more questions, feel free to return.");
                    break;
                }

                String response = getChatBotResponse(userMessage);
                System.out.println("Neev ChatBot: " + response);
            }
        }
    }

    private static String getChatBotResponse(String userMessage) {
        for (Map.Entry<String, String> entry : responses.entrySet()) {
            if (userMessage.contains(entry.getKey())) {
                return entry.getValue();
            }
        }
        return "I'm sorry, I didn't understand that. Can you please rephrase your question?";
    }
}
