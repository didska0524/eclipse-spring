package kr.ac.seoil.sample.vo;

import java.util.Arrays;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Data
//@Getter
//@Setter
public class SampleVO {
	private String userName;
	private Integer userAge;
	private String[] hobby;
	
	@DateTimeFormat (pattern= "yyyy-MM-dd")
	private Date regDate;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getUserAge() {
		return userAge;
	}
	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "SampleVO [userName=" + userName + ", userAge=" + userAge + ", hobby=" + Arrays.toString(hobby)
				+ ", regDate=" + regDate + "]";
	}
	
	
}
