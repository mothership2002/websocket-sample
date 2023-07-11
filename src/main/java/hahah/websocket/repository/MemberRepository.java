package hahah.websocket.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import hahah.websocket.domain.dto.MemberDto;
import hahah.websocket.domain.entity.Member;

@Repository
public class MemberRepository {

	private final Map<Long, Member> store = new HashMap<Long, Member>();
	private long sequence = 0l;
	
	public Member save(MemberDto member) {
		return addMember(member);
	}
	
	
	
	
	private Member addMember(MemberDto memberDto) {
		Member member = new Member(getSequence(), memberDto.getMenberName());
		store.put(member.getId(), member);
		return member;
	}
	
	private long getSequence() {
		return ++sequence;
	}
	
}
