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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
		model.addAttribute("op", "postCove");
		model.addAttribute("profesorForm", new Profesor());
		return "profesor/frm";
	}

	@PostMapping("/postCove")
	public String submitProfesor(@Valid @ModelAttribute("profesorForm") Profesor profesor, BindingResult result,
			HttpServletResponse response) throws IOException {

		String validacion;

		if (result.hasErrors()) {
			logger.info("objeto arrival: " + profesor);
			mensaje = "Error completar datos, verifique el formulario";

			validacion = "noOk";
			view = "profesor/frm";
			return "profesor/frm";
		} else {
			validacion = "ok";
			int flgOperacion = profesorService.addProfesor(profesor);
			if (flgOperacion == 1) {
				mensaje = "Se agrego con éxito el Profesor";
				estadoOperacion = "1";
				view = "profesor/activos";
			} else {
				mensaje = "el DNI: " + profesor.getDni() + ", ya existe";
				estadoOperacion = "-1";
				view = "profesor/frm";
			}

			tipoProceso = "insertar";
			Map<String, String> respuesta = new LinkedHashMap<String, String>();

			respuesta.put("tipoProceso", tipoProceso);
			respuesta.put("validacion", validacion);
			respuesta.put("mensaje", mensaje);
			respuesta.put("estadoOperacion", estadoOperacion);
			respuesta.put("view", view);

			String jsonData = null;
			jsonData = new Gson().toJson(respuesta);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(jsonData);

			return "profesor/activos";
		}

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
