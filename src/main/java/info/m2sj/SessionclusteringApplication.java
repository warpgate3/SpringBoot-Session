package info.m2sj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@SpringBootApplication
public class SessionclusteringApplication {

	public static void main(String[] args) {
		SpringApplication.run(SessionclusteringApplication.class, args);
	}

	@RestController
	@RequestMapping("/")
	public class TestController {

		@GetMapping("/set-session")
		public String setSession(HttpSession session) {
			System.out.println(session.getId());
			session.setAttribute("name", "warpgate");
			System.out.println(session.getAttribute("name"));
			return "set session";
		}

		@GetMapping("/get-name")
		public String getSessionName(HttpSession session) {
			System.out.println(session.getId());
			return String.valueOf(session.getAttribute("name"));
		}
	}
}
