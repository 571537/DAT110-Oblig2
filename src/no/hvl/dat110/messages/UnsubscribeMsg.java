package no.hvl.dat110.messages;

public class UnsubscribeMsg extends Message {

	// message sent from client to unsubscribe on a topic 

	// TODO:
	// Implement object variables - a topic is required
	// Constructor, get/set-methods, and toString method
	// as described in the project text
	private String unsubscribe;
	
	public UnsubscribeMsg(String user, String unsubscribe) {
		super(MessageType.UNSUBSCRIBE, user);
		this.unsubscribe = unsubscribe;
	}
	
	public String getUnsubscribe() {
		return unsubscribe;
	}
	
	public void setUnsubscribe() {
		this.unsubscribe = unsubscribe;
	}
	
	@Override
	public String toString() {
		return super.toString() + " unsubscribe to: " + this.unsubscribe;
	}
}
