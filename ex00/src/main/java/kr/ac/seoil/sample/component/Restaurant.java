package kr.ac.seoil.sample.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
//import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Component
@Data
//@RequiredArgsConstructor
public class Restaurant {
	//아오 인텔리제이 쓰고싶다 이클립스 시치 개불편하네
	@Setter(onMethod_=@Autowired)
	private Chef chef;
}
