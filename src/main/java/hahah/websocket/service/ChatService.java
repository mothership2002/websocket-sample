package hahah.websocket.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import hahah.websocket.domain.entity.ChatRoom;
import hahah.websocket.domain.entity.Member;

@Service
public class ChatService {
	
	private final Map<String, ChatRoom> activeChatRoom = new LinkedHashMap<>();
	private final Map<String, String> chatRoomIndex = new HashMap<>();
	
	public String createChatRoom(String chatRoomName, Member createMember) {
		
		if (chatRoomIndex.containsKey(chatRoomName)) {
			return "duplicate room name";
		}
		
		ChatRoom chatRoom = new ChatRoom(chatRoomName, createMember);
		activeChatRoom.put(chatRoom.getChatRoomId(), chatRoom);
		chatRoomIndex.put(chatRoomName, chatRoom.getChatRoomId());
		
		return chatRoom.getChatRoomId();
	}
	
	public ChatRoom joinChatRoom(String chatRoomId, Member member) {
		ChatRoom chatRoom = getChatRoom(chatRoomId);
		chatRoom.addMember(member);
		return chatRoom;
	}
	
	public void exitChatRoom(String chatRoomId, Member member) {
		ChatRoom chatRoom = getChatRoom(chatRoomId);
		chatRoom.exitMember(member);
		if (chatRoom.getMemberList().isEmpty()) {
			activeChatRoom.remove(chatRoom.getChatRoomId());
			chatRoomIndex.remove(chatRoom.getChatRoomName());
		}
	}

	public List<ChatRoom> findAllChatRoom() {
		return activeChatRoom.values().stream().collect(Collectors.toCollection(LinkedList::new));
	}

	public ChatRoom findOneChatRoom(String chatRoomName) {
		return activeChatRoom.get(chatRoomIndex.get(chatRoomName));
	}
	
	
	
	private ChatRoom getChatRoom(String chatRoomId) {
		return activeChatRoom.get(chatRoomId);
	}
}
