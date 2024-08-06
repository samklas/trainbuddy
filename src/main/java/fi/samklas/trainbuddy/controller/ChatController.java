package fi.samklas.trainbuddy.controller;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fi.samklas.trainbuddy.model.Response;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class ChatController {

	private final ChatClient chatClient;

	

	public ChatController(ChatClient.Builder chatClient) {
		this.chatClient = chatClient.build();
	}


	@GetMapping("/generate")
	public ResponseEntity<Response> generateWorkout(@RequestParam String prompt) {
		return new ResponseEntity<>(new Response(prompt), HttpStatus.OK);
	}
  
	@GetMapping("/joke")
	public String generateJoke() {
		return chatClient.prompt()
					.user("Tell me a joke!")
					.call()
					.content();
	}
	
  
}
