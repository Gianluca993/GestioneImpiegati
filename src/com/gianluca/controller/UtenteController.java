package com.gianluca.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gianluca.architecture.dao.UtenteDAO;
import com.gianluca.bc.model.Utente;

@Controller
public class UtenteController {

	@Autowired
	UtenteDAO dao;
	
	@RequestMapping("/signupform")
	public String visualizzaForm(Model m) {
		m.addAttribute("utente", new Utente());
		return "paginasignup";
	}
	
	@RequestMapping("/loginform")
	public ModelAndView loginForm() {
		return new ModelAndView("paginalogin", "command", new Utente());
	}

	@RequestMapping(value = "/ussalva", method = RequestMethod.POST)
	public ModelAndView createUtente(@Valid @ModelAttribute("utente") Utente utente, BindingResult br, HttpServletRequest request) {
		if(br.hasErrors())
			return new ModelAndView("paginasignup", "command", utente);
		HttpSession session = request.getSession();
		dao.create(utente);
		session.setAttribute("username", utente.getUsername());
		return new ModelAndView("forward:/impreport");
	}
	
	@RequestMapping(value = "/uslogin", method = RequestMethod.POST)
	public ModelAndView loginUtente(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Utente utente = dao.getByUsername(username);
		if(utente == null || !password.equals(utente.getPassword())) {
			return new ModelAndView("loginerror");
		}
		session.setAttribute("username", username);
		return new ModelAndView("forward:/impreport");
	}
	
	@RequestMapping("/uslogout")
	public ModelAndView logoutUtente(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if(username == null)
			return new ModelAndView("accessonegato");
		session.invalidate();
		return new ModelAndView("forward:/index.jsp");
	}
	
	@RequestMapping("/usmodificatemp/{username}")
	public String updateTemp(@PathVariable String username, Model m) {
		Utente u = dao.getByUsername(username);	
		m.addAttribute("utente", u);
		return "paginamodifica";
	}
	
	@RequestMapping(value= "us/modifica", method = RequestMethod.POST)
	public ModelAndView updateUtente(@Valid @ModelAttribute("utente") Utente u) {
		dao.update(u);
		return new ModelAndView("redirect:/impreport");
	}
	
	@RequestMapping("/uscancella/{username}")
	public ModelAndView cancellaUtente(@PathVariable String username) {
		dao.delete(username);
		return new ModelAndView("redirect:/impreport");
	}
}
