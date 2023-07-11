package hahah.websocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.HtmlUtils;

import hahah.websocket.enetity.Message;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ControllerV1 {

	@GetMapping("/test")
	public String test() {
		log.info("test");
		return "/chat-window";
	}
	
	@MessageMapping("/chatting")
	@SendTo("/topic/hello")
	public Message messagging(Message message) {
		return new Message(HtmlUtils.htmlEscape(message.getNickname()),
				HtmlUtils.htmlEscape(message.getMessage()));
	}

}
