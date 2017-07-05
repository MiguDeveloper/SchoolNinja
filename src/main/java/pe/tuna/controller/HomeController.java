package pe.tuna.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	private static final Logger logger = Logger.getLogger(HomeController.class);
	
	@GetMapping("")
	public String inicio(Model model){
		logger.info("Mostramos la vista home");
		model.addAttribute("mensaje","Bienvenido al sistema de boletas");
		return "home/inicio";
	}
}
