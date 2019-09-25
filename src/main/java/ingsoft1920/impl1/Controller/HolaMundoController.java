package ingsoft1920.impl1.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HolaMundoController {

	@GetMapping("/")
	public String holaMundo() {
		return "hello";
	}
}
