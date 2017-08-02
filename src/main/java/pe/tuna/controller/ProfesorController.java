package pe.tuna.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;

import pe.tuna.entity.Profesor;
import pe.tuna.service.ProfesorService;

/**
 * @author miguelchinchay
 *
 */
@Controller
@RequestMapping("/profesor")
public class ProfesorController {
	private static Logger logger = Logger.getLogger(ProfesorController.class);

	private Gson gson = null;
	private PrintWriter out = null;

	private String mensaje;
	private String estadoOperacion;
	private String tipoProceso;
	private String view;

	@Autowired
	@Qualifier("profesorServiceImpl")
	private ProfesorService profesorService;

	@GetMapping("/activos")
	public String getAndFindProfesore(Model model) {
		logger.info("Listando o buscando profesor");
		model.addAttribute("lstProfesores", profesorService.getAndFindProfesores(""));
		return "profesor/lst";
	}

	@GetMapping("/nuevo")
	public String showForm(Model model) {
		model.addAttribute("op", "postProfesor");
		model.addAttribute("profesorForm", new Profesor());
		return "profesor/frm";
	}

	@PostMapping("/postProfesor")
	public String submitProfesor(@Valid @ModelAttribute("profesorForm") Profesor profesor, BindingResult result,
			Model model, HttpServletResponse response, RedirectAttributes redir) throws IOException {

		if (result.hasErrors()) {
			logger.info("objeto arrival: " + profesor);
			mensaje = "Error completar datos, verifique el formulario";

			view = "profesor/frm";

		} else {
			int flgOperacion = profesorService.addProfesor(profesor);
			if (flgOperacion == 1) {
				mensaje = "Se agrego con éxito el Profesor";
				estadoOperacion = "1";
				redir.addFlashAttribute("add_exito", mensaje);
				view = "redirect:/profesor/activos";
			} else {
				mensaje = "El número de DNI: " + profesor.getDni() + " ya existe, verifique por favor";
				model.addAttribute("existe", mensaje);
				estadoOperacion = "-1";
				view = "profesor/frm";
			}

			tipoProceso = "insertar";
			Map<String, String> respuesta = new LinkedHashMap<String, String>();

			respuesta.put("tipoProceso", tipoProceso);
			respuesta.put("mensaje", mensaje);
			respuesta.put("estadoOperacion", estadoOperacion);
			respuesta.put("view", view);

			String jsonData = null;
			jsonData = new Gson().toJson(respuesta);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(jsonData);

		}

		return view;

	}

	@GetMapping("edit/{id}")
	public String showFormEdit(@PathVariable("id") int id, Model model) {
		model.addAttribute("profesorForm", profesorService.getByIdProfesor(id));
		model.addAttribute("op", "../edit");
		return "profesor/frm";
	}

	@PostMapping("edit")
	public String submitEditProfesor(@Valid @ModelAttribute("profesorForm") Profesor profesor, BindingResult result,
			Model model, RedirectAttributes redir) {


		if (result.hasErrors()) {
			mensaje = "Existe un error, verifique el formulario";
			model.addAttribute("mensaje", mensaje);
			view = "profesor/frm";
		} else {
			int flgOperacion = profesorService.updateProfesor(profesor);
			if (flgOperacion > 0) {
				mensaje = "Se actualizo con éxito el profesor: " + profesor.getNombres() + " "
						+ profesor.getApe_paterno();
				redir.addFlashAttribute("add_exito", mensaje);
				view = "redirect:/profesor/activos";
			} else {
				mensaje = "El dni: " + profesor.getDni() + " ya esta registrado";
				model.addAttribute("op", "edit");
				model.addAttribute("mensaje", mensaje);
				view = "profesor/frm";
			}
		}
		return view;
	}
	
	@GetMapping("delete/{id}")
	public String deleteProfesor(@PathVariable("id") int id, Model model){
		int flgOperacion = profesorService.deleteProfesor(id);
		return "redirect:/profesor/activos";
	}

	/*
	 * @PostMapping("/postCove") public @ResponseBody ValidationResponse
	 * addProfesor(@Valid @ModelAttribute("profesorForm") Profesor profesor,
	 * BindingResult result){ ValidationResponse res = new ValidationResponse();
	 * 
	 * if(result.hasErrors()){ res.setStatus("FAIL"); List<FieldError> allErrors
	 * = result.getFieldErrors(); List<ErrorMessage> errorMessage = new
	 * ArrayList<ErrorMessage>(); for(FieldError objectError : allErrors){
	 * errorMessage.add(new ErrorMessage(objectError.getField(),
	 * objectError.getField() + " " + objectError.getDefaultMessage())); }
	 * 
	 * res.setErrorMessageList(errorMessage); }else{ res.setStatus("SUCCESS"); }
	 * 
	 * return res; }
	 */

}
