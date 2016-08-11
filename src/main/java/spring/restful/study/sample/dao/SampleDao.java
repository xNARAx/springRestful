package spring.restful.study.sample.dao;

import java.util.List;

import javax.annotation.Resource;

import spring.restful.study.vo.UserVO;


/**
 * Handles requests for the application home page.
 */
@Resource
public interface SampleDao {
	public List<UserVO> dataList();
	public int dataInsert();
}
