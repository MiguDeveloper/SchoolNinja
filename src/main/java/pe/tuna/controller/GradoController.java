package pe.tuna.controller;

import javax.validation.Valid;

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

import pe.tuna.entity.Grado;
import pe.tuna.service.GradoService;

@Controller
@RequestMapping("grado")
public class GradoController {

	private String view;
	private String mensaje;

	@Autowired
	@Qualifier("gradoServiceImpl")
	private GradoService gradoService;

	// obtenemos todos los grados en la vista lst
	@GetMapping("activos")
	public String getGrados(Model model) {
		model.addAttribute("lstGrados", gradoService.getAndFindGrados(""));

		return "grado/lst";
	}

	// Mostramos el formulario para crear un nuevo grado
	@GetMapping("nuevo")
	public String showFormAdd(Model model) {
		model.addAttribute("op", "postGrado");
		model.addAttribute("frmGrado", new Grado());
		return "grado/frm";
	}

	// Guardamos el nuevo cove
	@PostMapping("postGrado")
	public String submitFormAddNew(@Valid @ModelAttribute("frmGrado") Grado grado, BindingResult result, Model model,
			RedirectAttributes redir) {

		if (result.hasErrors()) {
			mensaje = "Verifique los datos del formulario";
			model.addAttribute("mensaje", mensaje);
			view = "grado/frm";
		} else {
			int flgEstado = gradoService.addGrado(grado.getNombre());

			if (flgEstado > 0) {
				mensaje = "Se agrego con exito el grado: '" + grado.getNombre() + "'";
				redir.addFlashAttribute("add_exito", mensaje);
				view = "redirect:/grado/activos";
			} else {
				mensaje = "el grado con nombre: ' " + grado.getNombre() + "' ya existe, ingrese otro nombre";
				model.addAttribute("mensaje", mensaje);
				view = "grado/frm";
			}

		}

		return view;
	}

	// Buscamos el grado para retornarlo en el formulario
	@GetMapping("edit/{id}")
	public String showFormEdit(@PathVariable("id") int id, Model model) {

		model.addAttribute("frmGrado", gradoService.getById(id));
		model.addAttribute("op", "../edit");
		return "grado/frm";

	}

	// Recibimo el grado a actualizar
	@PostMapping("edit")
	public String submitFormEdit(@Valid @ModelAttribute("frmGrado") Grado grado, BindingResult result, Model model,
			RedirectAttributes redir) {

		if (result.hasErrors()) {
			mensaje = "Verifique el formulario por favor";
			model.addAttribute("mensaje", mensaje);
			model.addAttribute("op", "edit");
			view = "grado/frm";
		} else {
			int flgOperacion = gradoService.updateGrado(grado.getId(), grado.getNombre());
			if (flgOperacion > 0) {
				mensaje = "el grado: '" + grado.getNombre() + "' fue actualizado con éxito";
				redir.addFlashAttribute("add_exito", mensaje);
				view = "redirect:/grado/activos";
			} else {
				mensaje = "El nombre de grado '" + grado.getNombre() + "' ya se encuentra en uso";
				model.addAttribute("mensaje", mensaje);
				model.addAttribute("op", "edit");
				view = "grado/frm";
			}

		}

		return view;

	}

	@GetMapping("delete/{id}")
	public String deleteGrado(@PathVariable("id") int id, RedirectAttributes redir) {

		Grado grado = gradoService.getById(id);
		int flgOperacion = gradoService.deleteGrado(id);
		
		if (flgOperacion > 0) {
			mensaje = "El " + grado.getNombre() + " fue eliminado con éxito";
			redir.addFlashAttribute("add_exito", mensaje);
		} else {
			mensaje = "Hubo un error al intentar eliminar el grado con id: '" + id + "' ya que no existe";
			redir.addFlashAttribute("add_exito", mensaje);
		}

		return "redirect:/grado/activos";
		
	}

}
