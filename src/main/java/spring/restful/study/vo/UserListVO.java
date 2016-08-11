package spring.restful.study.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Class Name : SampleVO.java
 * @Description : SampleVO Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2009.03.16           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2009. 03.16
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UserListVO  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@XmlElementWrapper( name="userlist" )
	@XmlElement(name="user")
	List<UserVO> user = new ArrayList<UserVO>();
	
	public UserListVO(){
	}
	
	public UserListVO(List<UserVO> userlist){
		super();
		this.user = userlist;
	}
	
	public List<UserVO> getUser() {
		return user;
	}
	public void setUser(List<UserVO> user) {
		this.user = user;
	}
}
