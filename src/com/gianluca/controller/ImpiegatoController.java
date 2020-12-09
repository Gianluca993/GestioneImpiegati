package com.gianluca.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gianluca.architecture.dao.ImpiegatoDAO;
import com.gianluca.bc.model.Img;
import com.gianluca.bc.model.Impiegato;
import com.gianluca.bc.utilities.FileUploader;

@Controller
public class ImpiegatoController {

	@Autowired
	ImpiegatoDAO dao;
	
	//di default è GET quindi non lo specifichiamo
	@RequestMapping("/impform")
	public String visualizzaForm(Model m, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if(username == null) {
			return "accessonegato";
		}
		m.addAttribute("impiegato", new Impiegato());
		m.addAttribute("img", new Img());
		return "paginaform";
	}
	
	@RequestMapping("/impreport")
	public ModelAndView visualizzaImpiegati(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if(username == null) {
			return new ModelAndView("accessonegato");
		}
		List<Impiegato> lista = dao.getAll();
		//alla view paginareport viene passato lista
		return new ModelAndView("paginareport", "lista", lista);
	}
	
	@RequestMapping("/stats")
	public ModelAndView statisticheImpiegati(HttpServletRequest request, Model m) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if(username == null) {
			return new ModelAndView("accessonegato");
		}
		List<Impiegato> listaHigh = dao.getHighStip();
		List<Impiegato> listaLow = dao.getLowStip();
		m.addAttribute("listaLow", listaLow);
		return new ModelAndView("paginastats", "listaHigh", listaHigh);
	}
	
	@RequestMapping(value = "/salva", method = RequestMethod.POST)
	public ModelAndView createImpiegato(@Valid @ModelAttribute("impiegato") Impiegato impiegato, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if(username == null) {
			return new ModelAndView("accessonegato");
		}
		String filePath = FileUploader.upload(impiegato.getImg(), impiegato);
		if(filePath != null)
			impiegato.setImgUrl(filePath);
		dao.create(impiegato);
		return new ModelAndView("forward:/impreport");
	}
	
//	@RequestMapping("/modificatemp/{id}")
//	public ModelAndView updateTemp(@PathVariable long id, HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		String username = (String) session.getAttribute("username");
//		if(username == null) {
//			return new ModelAndView("accessonegato");
//		}
//		Impiegato impiegato = dao.getById(id);
//		return new ModelAndView("paginamodifica", "command", impiegato);
//	}
	
	@RequestMapping("/modificatemp/{id}")
	public String updateTemp(@PathVariable long id, Model m, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if(username == null) {
			return "accessonegato";
		}
		Impiegato impiegato = dao.getById(id);
		m.addAttribute("impiegato", impiegato);
		return "paginamodifica";
	}
	
	@RequestMapping(value= "/modifica", method = RequestMethod.POST)
	public ModelAndView updateImpiegato(@Valid @ModelAttribute("impiegato") Impiegato impiegato, BindingResult br, HttpServletRequest request) {
		if(br.hasErrors())
			return new ModelAndView("paginamodifica", "command", impiegato);
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if(username == null) {
			return new ModelAndView("accessonegato");
		}
		String filePath = FileUploader.upload(impiegato.getImg(), impiegato);
		if(filePath != null)
			impiegato.setImgUrl(filePath);
		dao.update(impiegato);
		return new ModelAndView("redirect:/impreport");
	}
	
	@RequestMapping("/cancella/{id}")
	public ModelAndView cancellaImpiegato(@PathVariable long id, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if(username == null) {
			return new ModelAndView("accessonegato");
		}
		dao.delete(id);
		return new ModelAndView("redirect:/impreport");
	}
}
