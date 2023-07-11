package hahah.websocket.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import hahah.websocket.domain.dto.MemberDto;
import hahah.websocket.domain.entity.Member;
import hahah.websocket.service.MemberService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberService memberService;

	@PostMapping("/member")
	public String createMember(@RequestBody MemberDto memberDto, Model model) {
		Member savedMember = memberService.save(memberDto);
		model.addAttribute("member", savedMember);
		return "member/main";
	}
}
