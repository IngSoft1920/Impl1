package ingsoft1920.impl1.PMS1.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ingsoft1920.impl1.PMS1.model.ReservaPMSModel;
import ingsoft1920.impl1.model.ReservaModel;

@Controller
public class WelcomeController_PMS1 {
	@GetMapping("/pms1/welcome")
	public String welcome(Model model) {
		ReservaModel mc = new ReservaModel();
		ReservaPMSModel mpms = new ReservaPMSModel();
		
		mc.getDatosCliente();
		mpms.getDatosCliente();
		return "pms1/welcome";
	}
}
