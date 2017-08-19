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

import pe.tuna.entity.Tipo_documentos;
import pe.tuna.service.Tipo_documentosService;

@Controller
@RequestMapping("/tipoDocumento")
public class Tipo_documentosController {

	private String mensaje;
	private String view;

	@Autowired
	@Qualifier("Tipo_documentosServiceImpl")
	private Tipo_documentosService tipoDocService;

	@GetMapping("/activos")
	public String getAndFindTipoDocs(Model model) {
		model.addAttribute("lstTipoDocs", tipoDocService.getAndFindTipoDocumentos(""));
		return "tipoDocumento/lst";
	}

	@GetMapping("/nuevo")
	public String showFormAdd(Model model) {
		model.addAttribute("frmTipoDoc", new Tipo_documentos());
		model.addAttribute("op", "postTipodoc");
		return "tipoDocumento/frm";
	}

	@PostMapping("/postTipodoc")
	public String submitAddNewTipoDoc(@Valid @ModelAttribute("frmTipoDoc") Tipo_documentos tipoDoc,
			BindingResult result, Model model, RedirectAttributes redir) {

		if (result.hasErrors()) {
			mensaje = "Error verifique el formulario";
			model.addAttribute("mensaje", mensaje);
			view = "tipoDocumento/frm";
		} else {
			int flgOperacion = tipoDocService.addTipoDocumentos(tipoDoc.getDescripcion());
			if (flgOperacion > 0) {
				mensaje = "El tipo de documento '" + tipoDoc.getDescripcion() + "' fue creado con éxito";
				redir.addFlashAttribute("add_exito", mensaje);
				view = "redirect:/tipoDocumento/activos";
			} else {
				mensaje = "El tipo de documento '" + tipoDoc.getDescripcion() + "' ya existe, intente con otro";
				model.addAttribute("mensaje", mensaje);
				view = "tipoDocumento/frm";
			}
		}

		return view;
	}

	@GetMapping("edit/{id}")
	public String showFormEdit(@PathVariable("id") int id, Model model) {
		model.addAttribute("frmTipoDoc", tipoDocService.getByIdTipoDocumentos(id));
		model.addAttribute("op", "../edit");
		return "tipoDocumento/frm";
	}

	@PostMapping("edit")
	public String submitEdit(@Valid @ModelAttribute("frmTipoDoc") Tipo_documentos tipoDoc, BindingResult result,
			Model model, RedirectAttributes redir) {

		if (result.hasErrors()) {
			mensaje = "Revisar el formulario, falta ingresar campos";
			model.addAttribute("mensaje", mensaje);
			model.addAttribute("op", "edit");
			view = "tipoDocumento/frm";
		} else {
			int flgOperacion = tipoDocService.updateTipoDocumentos(tipoDoc);
			if (flgOperacion > 0) {
				mensaje = "Se actualizo con éxito el tipo de documento '" + tipoDoc.getDescripcion() + "';";
				redir.addFlashAttribute("add_exito", mensaje);
				view = "redirect:/tipoDocumento/activos";
			} else {
				mensaje = "El tipo de documento '" + tipoDoc.getDescripcion() + "' ya existe.";
				model.addAttribute("op", "edit");
				model.addAttribute("mensaje", mensaje);
				view = "tipoDocumento/frm";
			}
		}

		return view;
	}

	@GetMapping("delete/{id}")
	public String deleteTipoDoc(@PathVariable("id") int id, RedirectAttributes redir) {
		
		int flgOperacion = tipoDocService.deleteTipoDocumentos(id);
		if (flgOperacion > 0) {
			mensaje = "El tipo de documento fue eliminado con éxito";
			redir.addFlashAttribute("add_exito", mensaje);
		} else {
			mensaje = "Hubo un error al intentar eliminar el tipo de documento con id: '" + id + "'";
			redir.addFlashAttribute("add_exito", mensaje);
		}

		return "redirect:/tipoDocumento/activos";
		
	}
}
