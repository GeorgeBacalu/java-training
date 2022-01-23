package clean.code.design_patterns.requirements._1_user_profile;

public class Message {
    private int messageId;
    private String text;

    public Message(int messageId, String text) {
        this.messageId = messageId;
        this.text = text;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Message{" + "messageId='" + messageId + '\'' + ", text=" + text + '}';
    }
}
