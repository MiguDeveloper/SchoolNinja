package pe.tuna.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.tuna.service.ProfesorService;

@Controller
@RequestMapping("/profesor")
public class ProfesorController {
	private static Logger logger = Logger.getLogger(ProfesorController.class);
	
	@Autowired
	@Qualifier("profesorServiceImpl")
	private ProfesorService profesorService;
	
	
	@GetMapping("/activos")
	public String getAndFindProfesore(Model model){
		logger.info("Listando o buscando profesor");
		model.addAttribute("lstProfesores", profesorService.getAndFindProfesores(""));
		return "profesor/lst";
	}
}
