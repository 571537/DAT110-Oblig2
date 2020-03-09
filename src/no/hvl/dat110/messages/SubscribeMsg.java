package no.hvl.dat110.messages;

public class SubscribeMsg extends Message {

	// message sent from client to subscribe on a topic 

	// TODO:
	// Implement object variables - a topic is required
	// Constructor, get/set-methods, and toString method
	// as described in the project text
	private String subscribe;
	
	public SubscribeMsg(String user, String subscribe) {
		super(MessageType.SUBSCRIBE, user);
		this.subscribe = subscribe;
	}
	
	public String getSubscribe() {
		return subscribe;
	}
	
	public void setSubscribe() {
		this.subscribe = subscribe;
	}
	
	@Override
	public String toString() {
		return super.toString() + " subscribe to: " + this.subscribe;
	}
		
}
