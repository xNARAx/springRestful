package spring.restful.study.sample.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.restful.study.sample.service.SampleService;
import spring.restful.study.vo.ResultVO;
import spring.restful.study.vo.UserListVO;
import spring.restful.study.vo.UserVO;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/samples")
public class SampleController {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	@Value("#{comnProperties['comn.sample']}") String sampleProperties;
	
	@Autowired SampleService sampleService;
	
	/**
	 * ViewResolver를 이용한 View Mapping Sample
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/viewpage/list", method = RequestMethod.GET)
	public String viewpage(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		List<UserVO> userVO = sampleService.dataList();
		
		model.addAttribute("list", userVO);
		
        return "menu/list";
    }
	
	/**
	 * MessageConverter 를 이용한 기본 Restful Request Mapping URL 호출 Sample 1
	 * 
	 * <p>Spring 4에서 부터 <i>&#064;Controller + &#064;ResponseBody</i> 를 조합 한 <i>&#064;RestController</i> 소개 하였다.<br/>
	 * <i>&#064;RestController</i>를 사용하면 <i>&#064;ResponseBody</i> 사용하지 않아도 된다</p>
	 * <p><i>참고 URL :  http://howtodoinjava.com/spring/spring-restful/spring-rest-hello-world-xml-example/</i></p>
	 *  
	 *  
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/msgcvt/list", method = RequestMethod.GET)
	public @ResponseBody ResultVO getMessageConverterJsonAndXmlList(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		List<UserVO> userVO = sampleService.dataList();
		
		UserListVO userList = new UserListVO(userVO);
		
		ResultVO rvo = null;
		rvo = new ResultVO("0000", "성공", userList);
        
        return rvo;
    }
	
	
	/**
	 * ViewResolver를 이용한 기본 Restful Request Mapping URL 호출 Sample 1
	 * 
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/viewrgvr/list", method = RequestMethod.GET)
	public String viewResolverViewAndJsonAndXml(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		List<UserVO> userVO = sampleService.dataList();
		
		UserListVO userList = new UserListVO(userVO);
		
		ResultVO rvo = null;
		rvo = new ResultVO("0000", "성공", userList);
		
        model.addAttribute(rvo);
        
        return "menu/list";
    }

	/**
	 * ViewResolver를 이용한 기본 Restful Request Mapping URL 호출 Sample 2
	 * 
	 * <p>"/sample/list/<b>{type}</b>" 이와같은 URI Template에 포함된 변수 값을 추출할 수 있도록<br/> &#064;PathVariable이라는  Annotation 사용</p>
	 * <p>
	 * <i>&#064;PathVariable String type</i> 이와 같이 사용하며 <br/>
	 * <i>&#064;PathVariable("type") String value1</i> 이와 같이 변수명을 지정 해줄수도 있다. 
	 * </p>
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/viewrgvr/list/{type}", method = RequestMethod.POST)
	public String viewResolverViewAndJsonAndXml2(@PathVariable("type") String type, Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		logger.info("=====> See Value,  Type : {} ", type);
		
		List<UserVO> userVO = sampleService.dataList();
		
		UserListVO userList = new UserListVO(userVO);
		
		ResultVO rvo = null;
		rvo = new ResultVO("0000", "성공", userList);
		
        model.addAttribute(rvo);
        
        return "menu/list";
    }
	
	
}
