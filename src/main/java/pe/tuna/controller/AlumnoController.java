package pe.tuna.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

import pe.tuna.entity.Alumno;
import pe.tuna.entity.Tipo_documentos;
import pe.tuna.service.AlumnoService;
import pe.tuna.service.Tipo_documentosService;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {

	private static final Logger logger = Logger.getLogger(AlumnoController.class);
	private String mensaje;
	private String view;

	@Autowired
	@Qualifier("alumnoServiceImpl")
	private AlumnoService alumnoService;

	// Autowired para obtener todos los tipo de documento
	@Autowired
	@Qualifier("Tipo_documentosServiceImpl")
	private Tipo_documentosService tipoDocService;

	@GetMapping("activos")
	public String getAndFindAlumnos(Model model) {
		model.addAttribute("lstAlumnos", alumnoService.getAndFindAlumno(""));
		return "alumno/lst";
	}

	@GetMapping("/nuevo")
	public String showFormAdd(Model model) {
		model.addAttribute("op", "postAlumno");
		model.addAttribute("frmAlumno", new Alumno());
		return "alumno/frm";
	}

	@PostMapping("postAlumno")
	public String submitAddAlumno(@Valid @ModelAttribute("frmAlumno") Alumno alumno, BindingResult result,
			RedirectAttributes redir, Model model) {
		if (result.hasErrors()) {
			mensaje = "Verificar el formulario,  ingrese todos los campos requeridos";
			model.addAttribute("mensaje", mensaje);
			view = "alumno/frm";
		} else {
			int flgOperacion = alumnoService.addAlumno(alumno);
			if (flgOperacion > 0) {
				mensaje = "el alumno fue creado con éxito";
				redir.addFlashAttribute("add_exito", mensaje);
				view = "redirect:/alumno/activos";
			} else {
				mensaje = "El número de documento ya esta registrado: " + alumno.getNro_documento()
						+ " verifique por favor";
				model.addAttribute("mensaje", mensaje);
				view = "alumno/frm";
			}
		}

		return view;

	}

	// Método para obtener por id
	@GetMapping("edit/{id}")
	public String showFormEdit(@PathVariable("id") int id, Model model) {
		model.addAttribute("frmAlumno", alumnoService.getByIdAlumno(id));
		model.addAttribute("op", "../edit");
		return "alumno/frm";
	}

	// Método para actualizar alumno
	@PostMapping("edit")
	public String submitEditAlumno(@Valid @ModelAttribute("frmAlumno") Alumno alumno, BindingResult result, Model model,
			RedirectAttributes redir) {

		logger.info("fecha Nacimiento Alumno: " + alumno.getFecha_nacimiento());

		if (result.hasErrors()) {
			mensaje = "Revisar los campos del formulario contiene errores";
			model.addAttribute("mensaje", mensaje);
			model.addAttribute("op", "edit");
			view = "alumno/frm";
		} else {
			int flgOperacion = alumnoService.updateAlumno(alumno);
			if (flgOperacion > 0) {
				mensaje = "Se actualizo con exito el alumno " + alumno.getNombres() + " " + alumno.getApe_paterno();
				redir.addFlashAttribute("add_exito", mensaje);
				view = "redirect:/alumno/activos";
			} else {
				mensaje = "El Nro de documento '" + alumno.getNro_documento() + "' ya esta registrado.";
				model.addAttribute("mensaje", mensaje);
				view = "alumno/frm";
			}
		}
		return view;
	}

	// Metodo para hacer el delete
	@GetMapping("delete/{id}")
	public String deleteAlumno(@PathVariable("id") int id, Model model, RedirectAttributes redir) {
		int flgOperacion = alumnoService.deleteAlumno(id);
		if (flgOperacion > 0) {
			mensaje = "Se elimino con éxito el alumno";
			redir.addFlashAttribute("add_exito", mensaje);
		} else {
			mensaje = "El Alumno seleccionado no existe ID: " + id;
			redir.addFlashAttribute("add_exito", mensaje);
		}

		return "redirect:/alumno/activos";
	}

	// Rellenamos el combo de tipo de documento
	@ModelAttribute("lstTipoDocumento")
	public Map<Integer, String> getAllTipoDocumento() {

		Map<Integer, String> lstTipoDoc = new LinkedHashMap<>();
		List<Tipo_documentos> lstDocIdentidad = tipoDocService.getAndFindTipoDocumentos("");
		for (Tipo_documentos tipoDoc : lstDocIdentidad) {
			lstTipoDoc.put(tipoDoc.getId(), tipoDoc.getDescripcion());
		}

		return lstTipoDoc;

	}

}
