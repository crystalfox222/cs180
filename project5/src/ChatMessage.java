
import java.io.Serializable;

/**
 * [Add your documentation here]
 *
 * @author your name and section
 * @version date
 */
final class ChatMessage implements Serializable {
    private static final long serialVersionUID = 6898543889087L;

    private String message;
    private int type = 0;
    private String recipient;

    public ChatMessage(String message, int type) {
        this.message = message;
        this.type = type;
    }

    public ChatMessage(String message, String recipient) {
        this.message = message;
        this.recipient = recipient;
    }

    public ChatMessage(String message, String recipient, int type) {
        this.message = message;
        this.recipient = recipient;
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public String getRecipient() {
        return recipient;
    }
    // Here is where you should implement the chat message object.
    // Variables, Constructors, Methods, etc.
}
