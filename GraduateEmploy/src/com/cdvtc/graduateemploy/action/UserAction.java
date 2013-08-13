package com.cdvtc.graduateemploy.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.cdvtc.graduateemploy.model.Admin;
import com.cdvtc.graduateemploy.model.Enterprise;
import com.cdvtc.graduateemploy.model.Graduate;
import com.cdvtc.graduateemploy.service.IAdminService;
import com.cdvtc.graduateemploy.service.IEnterpriseService;
import com.cdvtc.graduateemploy.service.IGraduateService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Component("userAction")
public class UserAction extends ActionSupport {
	@Resource(name="adminService")
	public void setAs(IAdminService as) {
		this.as = as;
	}

	@Resource(name="graduateService")
	public void setGs(IGraduateService gs) {
		this.gs = gs;
	}

	@Resource(name="enterpriseService")
	public void setEs(IEnterpriseService es) {
		this.es = es;
	}

	public String login() {
		System.out.println("username:" + getUsername() + "   password: " + getPassword() + "  identity" + idenities[getIdentity()]);
		if(0 == getIdentity()) {
			Admin admin = new Admin();
			admin.setUsername(getUsername());
			admin.setPassword(getPassword());
			boolean bool = as.login(admin);
			System.out.println(bool);
		} else if (1 == getIdentity()) {
			
		} else if(2 == getIdentity()) {
			
		}
		return "input";
	}
	
	public String register() {
		System.out.println("username:" + getUsername() + "  password:" + getPassword() + "   rePassword:" + getRePassword()
				+ "   identity:" + idenities[getIdentity()] + "   email:" + getEmail() + "   phone:" + getPhone());
		if(getPassword() != null && !getPassword().equals(getRePassword())) {
			addActionError("两次输入的密码不一致");
			return INPUT;
		}
		if(1 == getIdentity()) {
			Enterprise enterprise = new Enterprise();
			enterprise.setUsername(getUsername());
			enterprise.setPassword(getPassword());
			enterprise.setEmail(getEmail());
			enterprise.setPhone(getPhone());
			es.register(enterprise);
		} else if(2 == getIdentity()) {
			Graduate graduate = new Graduate();
			graduate.setUsername(getUsername());
			graduate.setPassword(getPassword());
			graduate.setEmail(getEmail());
			graduate.setPhone(getPhone());
			gs.register(graduate);
		}
		return "registerSuc";
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRePassword() {
		return rePassword;
	}
	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
	public int getIdentity() {
		return identity;
	}
	public void setIdentity(int identity) {
		this.identity = identity;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	private String username;
	private String password;
	private String rePassword;
	private int identity;
	private String email;
	private String phone;
	private IAdminService as;
	private IEnterpriseService es;
	private IGraduateService gs;
	public final static String[] idenities = {"admin", "company", "graduate"};
}
