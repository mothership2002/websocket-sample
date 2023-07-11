package hahah.websocket.domain.entity;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import lombok.Getter;

public class ChatRoom {

	@Getter
	private String chatRoomId;
	@Getter
	private String chatRoomName;
	@Getter
	private Member createMember;
	private Map<Long, Member> memberList;
	
	public ChatRoom(String chatRoomName, Member createMember) {
		
		this.chatRoomId = UUID.randomUUID().toString();
		this.chatRoomName = chatRoomName;
		this.createMember = createMember;
		
		this.memberList = new LinkedHashMap<>();
		memberList.put(createMember.getId(), createMember);
	}
	
	public void addMember(Member member) {
		memberList.put(member.getId(), member);
	}
	
	public List<Member> getMemberList() {
		return memberList.values().stream().collect(Collectors.toCollection(ArrayList::new));
	}
	
	public void exitMember(Member member) {
		memberList.remove(member.getId());
	}
	
}
