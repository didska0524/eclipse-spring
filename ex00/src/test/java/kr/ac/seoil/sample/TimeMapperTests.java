package kr.ac.seoil.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.seoil.sample.mapper.TimeMapper;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TimeMapperTests {

	@Autowired
	private TimeMapper timeMapper;
	
	@Test
	public void testGetTime() {
		log.info(timeMapper.getClass().getName());
		log.info("getTime:" + timeMapper.getTime());
		log.info("getTime2:" + timeMapper.getTime2());
	}
	
	@Test
	public void testGetTime2(){
		log.info("getTime2");
		log.info(timeMapper.getTime2());
	}
	
	
	//given
	
	//when
		
	//then
}
