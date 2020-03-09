package no.hvl.dat110.broker;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import com.sun.xml.internal.bind.unmarshaller.Messages;

import no.hvl.dat110.common.TODO;
import no.hvl.dat110.common.Logger;
import no.hvl.dat110.messagetransport.Connection;

public class Storage {

	// data structure for managing subscriptions
	// maps from a topic to set of subscribed users
	protected ConcurrentHashMap<String, Set<String>> subscriptions;
	
	// data structure for managing currently connected clients
	// maps from user to corresponding client session object
	
	protected ConcurrentHashMap<String, ClientSession> clients;
	protected ConcurrentHashMap<String, Set<Message>> bufferedMessage;
    
	
	public Storage() {
		subscriptions = new ConcurrentHashMap<String, Set<String>>();
		clients = new ConcurrentHashMap<String, ClientSession>();
		bufferedMessage = new ConcurrentHashMap<String, Set<Message>>();
	}

	public Collection<ClientSession> getSessions() {
		return clients.values();
	}

	public Set<String> getTopics() {

		return subscriptions.keySet();

	}

	// get the session object for a given user
	// session object can be used to send a message to the user
	
	public ClientSession getSession(String user) {

		ClientSession session = clients.get(user);

		return session;
	}

	public Set<String> getSubscribers(String topic) {
		return (subscriptions.get(topic));
	}

	public void addClientSession(String user, Connection connection) {
		// TODO: add corresponding client session to the storage
		clients.put(user, new ClientSession(user, connection));	
	}

	public void removeClientSession(String user) {
		// TODO: remove client session for user from the storage
		clients.remove(user);
	}

	public void createTopic(String topic) {
		// TODO: create topic in the storage
		subscriptions.put(topic, new HashSet<>());
	}

	public void deleteTopic(String topic) {
		// TODO: delete topic from the storage
		subscriptions.remove(topic);
	}

	public void addSubscriber(String user, String topic) {
		// TODO: add the user as subscriber to the topic
		subscriptions.get(topic).add(user);
	}

	public void removeSubscriber(String user, String topic) {
		// TODO: remove the user as subscriber to the topic
		subscriptions.get(topic).remove(user);
	}
	
	public void bufferedMsg(String user, Message message) {
		Set<Message> pendingUser = bufferedMessage.get(user);
		
		if(pendingUser == null) {
			pendingUser = ConcurrentHashMap.newKeySet();
			bufferedMessage.put(user, pendingUser);
		}
		pendingUser.add(message);
	}
	
	public Set<Message> getBufferedMessages (String user) {
		Set<Message> pendingUser = bufferedMessage.get(user);
		
		return pendingUser;
	}
	
	public void clearBufferedMessages(String user) {
		Set<Message> pendingUser = bufferedMessage.get(user);
		
		if(pendingUser != null) {
			pendingUser.clear();
		}
	}
}
