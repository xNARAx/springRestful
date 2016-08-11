package spring.restful.study.sample.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.restful.study.sample.dao.SampleDao;
import spring.restful.study.vo.UserVO;

/**
 * Handles requests for the application home page.
 */
@Service("menuService")
public class SampleService {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleService.class);
	
	@Autowired SampleDao sampleDao;
	
	public List<UserVO> dataList(){
		
		List<UserVO> ul = new ArrayList<UserVO>();
		ul.add(new UserVO("userid1", "userpw1", "usernm1", "1", "1"));
		ul.add(new UserVO("userid2", "userpw2", "usernm2", "2", "2"));
		ul.add(new UserVO("userid3", "userpw3", "usernm3", "3", "3"));
		
		/*return sampleDao.dataList();*/
		
		return ul;
	}
	
	/*@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)*/
	public int dataInsert(){
		sampleDao.dataInsert();
		throw new RuntimeException("트랜잭션 테스트 : 강제로 오류를 발생시켜봄!!");
		//return menuDAO.dataInsert(); 
	}
}
