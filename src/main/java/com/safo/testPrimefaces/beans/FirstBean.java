package com.safo.testPrimefaces.beans;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ManagedBean(name="firstBean")
@ViewScoped
public class FirstBean {

	private String text;
	private int number;
	private String btnName="tu klikni";
	private String user;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getBtnName() {
		return btnName;
	}

	public void setBtnName(String btnName) {
		this.btnName = btnName;
	}
	
	public void onBtnClick(){
		System.out.println("kliknutie");
		btnName = "zmenil som nazov buttonu";
	}
	
	@PostConstruct
	public void init(){
		System.out.println("inicializujem firstBean");
		number = 0;
	}
	
	public void increment(){
		System.out.println("abcd: "+ new Date());
		number++;
	}
	
	public void decrement(){
		System.out.println("efgh: "+ new Date());
		number--;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public void login(){
		System.out.println("login");
		/*try {
			getRequest2().login("aa", "bb");
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		user = "test";
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.setAttribute("username", user);
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

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	
}
