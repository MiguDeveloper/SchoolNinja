package pe.tuna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.tuna.entity.Grado;
import pe.tuna.service.GradoService;

@Controller
@RequestMapping("grado")
public class GradoController {

	
	@Autowired
	@Qualifier("gradoServiceImpl")
	private GradoService gradoService;
	
	//obtenemos todos los grados en la vista lst
	@GetMapping("activos")
	public String getGrados(Model model){
		model.addAttribute("lstGrados", gradoService.getAndFindGrados(""));
		
		return "grado/lst";
	}
	
	//Creamos un nuevo grado
	@GetMapping("nuevo")
	public String showFormAdd(Model model){
		model.addAttribute("op", "postGrado");
		model.addAttribute("frmGrado", new Grado());
		return "grado/frm";
	}
	
}
