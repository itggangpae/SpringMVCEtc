package kr.co.pk.domain;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Member {
	@NotNull
	@Pattern(regexp ="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.(?:[a-zA-Z]{2,6})$", message="Invalid E-Mail")
	private String email;
	@NotNull
	@Size(min=5)
	private String pw;

	private String loginType;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	@DateTimeFormat(pattern="yyyyMMDD")
	private Date Birthday;
	
	public Date getBirthday() {
		return Birthday;
	}
	public void setBirthday(Date birthday) {
		Birthday = birthday;
	}

	
	@Override
	public String toString() {
		return "Member [email=" + email + ", pw=" + pw + ", loginType=" + loginType + "]";
	}
}
