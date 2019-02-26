package info.m2sj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@SpringBootApplication
public class SessionclusteringApplication {

	public static void main(String[] args) {
		SpringApplication.run(SessionclusteringApplication.class, args);
	}

	@RestController
	public class TestController {

		@GetMapping("/test")
		public String getTest(HttpSession session) {
			if (session.getAttribute("name") == null) {
				session.setAttribute("name", "warpgate");
			}
			System.out.println(session.getAttribute("name"));
			return "hello spring boot2.0";
		}
	}
	/*@Component
	static class BaseHandler {
		public Mono<ServerResponse> hello(ServerRequest request) {
			return ServerResponse.ok()
					.contentType(MediaType.TEXT_HTML)
					.body(BodyInserters.fromObject("Hello Spring"));
		}
	}

	@Configuration
	static class Router {
		@Bean
		public RouterFunction<ServerResponse> route(BaseHandler baseHandler) {
			return RouterFunctions.route(RequestPredicates.GET("/mytest").and(RequestPredicates.accept(MediaType.TEXT_HTML)), baseHandler::hello);
		}
	}*/

}
