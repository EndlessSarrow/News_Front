package cn.et.model;

import java.util.List;
import java.util.Map;

import cn.et.utils.JdbcUtlis;

public class NewsUtils {

	
	/**
	 * 获取所有新闻的标题和文件名
	 * @return
	 * @throws Exception 
	 */
	public List<Map<String, String>> getNews() throws Exception{
		String sql = "select title , htmlpath from news";
		return JdbcUtlis.getDataBySql(sql);
	}
}
