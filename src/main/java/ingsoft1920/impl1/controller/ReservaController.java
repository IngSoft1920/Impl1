package ingsoft1920.impl1.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ingsoft1920.impl1.DAO.ReservaDAO;
import ingsoft1920.impl1.beans.NewReservaBean;
import ingsoft1920.impl1.model.ReservaModel;

@Controller
public class ReservaController {

	@GetMapping("/reservar")
	public String reservaGet(Model model) {
		model.addAttribute("reservaBean", new ReservaModel());
		return "reserva";
	}
	
	@PostMapping("/reservar")
	public String reservaPost(@Valid @ModelAttribute("reservaBean") NewReservaBean reservaBean,
			Model model) {
		ReservaModel reservaModel = new ReservaModel(reservaBean);
		if(!reservaModel.checkValidData()) {
			reservaGet(model);
		}
		
		ReservaDAO.save(reservaModel);
		
		return "";
	}
}
