package com.safo.testPrimefaces.beans;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ManagedBean(name="loginBean")
@ViewScoped
public class LoginBean {

	private String username;

	@PostConstruct
	public void init(){
		System.out.println("inicializujem loginBean");
	}
	
	
	public void login(){
		System.out.println("login as "+username);
		/*try {
			getRequest2().login("aa", "bb");
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.setAttribute("username", username);
	}
	
	public String logout() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.invalidate();
		return "login";
	}
	
	private HttpServletRequest getRequest2(){

		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		if (request == null) {
				throw new RuntimeException("Sorry. Got a null request from faces context");
		}
	
		return request;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}
	
}
