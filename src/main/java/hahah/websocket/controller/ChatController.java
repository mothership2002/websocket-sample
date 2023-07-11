package hahah.websocket.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hahah.websocket.domain.entity.ChatRoom;
import hahah.websocket.domain.entity.Member;
import hahah.websocket.service.ChatService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatController {

	private final ChatService chatService;
	
	public String mainView() {
		return "chat/main";
	}

	@ResponseBody
	@GetMapping("/list")
	public List<ChatRoom> selectChatRoomList() {
		return chatService.findAllChatRoom();
	}
	
	@GetMapping("/search")
	@ResponseBody
	public ChatRoom findChatRoom(@RequestParam String chatRoomName) {
		return chatService.findOneChatRoom(chatRoomName);
	}

	@PostMapping("/{chatRoomId}")
	public String joinChatRoom(@PathVariable String chatRoomId, @RequestBody Member member, Model model) {
		ChatRoom joinChatRoom = chatService.joinChatRoom(chatRoomId, member);
		model.addAttribute("chatRoomDetail", joinChatRoom);
		return "chat/detail";
	}

	@PostMapping("/{chatRoomId}/exit")
	public String exitChatRoom(@PathVariable String chatRoomId, @RequestBody Member member) {
		chatService.exitChatRoom(chatRoomId, member);
		return "redirect:/chat";
	}

	@PostMapping("/create")
	public String createChatRoom(@RequestBody String chatRoomName, @RequestBody Member createMember) {
		return chatService.createChatRoom(chatRoomName, createMember);
	}
}
