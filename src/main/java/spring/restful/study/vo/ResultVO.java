package spring.restful.study.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

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

@XmlRootElement(name = "result")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType( propOrder={ "resultMsg", "resultCode", "resultData" } )
public class ResultVO  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@XmlElement
	protected String resultCode = "0000";
	@XmlElement
	protected String resultMsg = "Success";
	
	@XmlElements(value = { 
            @XmlElement(name="resultData",  type=UserListVO.class),
            @XmlElement(name="resultData",  type=String.class)
    })
	protected Object resultData;
	
	
	public ResultVO(){
		
	}
	
	public ResultVO(String resultCode, String resultMsg, Object resultData){
		super();
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
		this.resultData = resultData;
	}
	
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultMsg() {
		return resultMsg;
	}
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
	public Object getResultData() {
		return resultData;
	}
	public void setResultData(Object resultData) {
		this.resultData = resultData;
	}
}
