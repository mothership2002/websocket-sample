package hahah.websocket.service;

import org.springframework.stereotype.Service;

import hahah.websocket.domain.dto.MemberDto;
import hahah.websocket.domain.entity.Member;
import hahah.websocket.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;

	public Member save(MemberDto member) {
		return memberRepository.save(member);
	}
}
