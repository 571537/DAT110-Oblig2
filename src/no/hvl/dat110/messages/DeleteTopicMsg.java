package no.hvl.dat110.messages;

public class DeleteTopicMsg extends Message {

	// message sent from client to create topic on the broker

	// TODO:
	// Implement object variables - a topic is required
	// Constructor, get/set-methods, and toString method
	// as described in the project text
	private String DeleteTopic;
	
	public DeleteTopicMsg(String user, String DeleteTopic) {
		super(MessageType.DELETETOPIC, user);
		this.DeleteTopic = DeleteTopic;
	}
	
	public String getDeleteTopic() {
		return DeleteTopic;
	}
	
	public void setDeleteTopic(String DeleteTopic) {
		this.DeleteTopic = DeleteTopic;
	}
	
	@Override
	public String toString() {
		return super.toString() + " topic to delete: " + this.DeleteTopic;
	}
}
