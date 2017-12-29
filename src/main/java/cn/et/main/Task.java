package cn.et.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;

import cn.et.model.NewsUtils;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

public class Task extends TimerTask {

	public Task() {
		System.out.println("定时任务类实例化");
	}

	/**
	 * 此方法要实现的功能： 1.从数据库获取新闻标题和文件名。 2.生成数据模型，传递到模板生成首页。
	 * 
	 */
	
	NewsUtils newsUtils = new NewsUtils();
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void run() {
		// 初始化配置对象
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);

		try {
			// 模板文件(ftl)的存放目录
			cfg.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));

			// 设置数据的抓取方式
			cfg.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_22));

			// 创建数据模型
			Map root = new HashMap<>();
			
			List<Map<String, String>> list = newsUtils.getNews();
			root.put("newsList", list);
			
			
			// 创建模板对象
			Template temp = cfg.getTemplate("index.ftl");

			// 创建输出流
			FileOutputStream fos = new FileOutputStream("src/main/webapp/index.html");

			// 保存到本地
			Writer out = new OutputStreamWriter(fos);
			temp.process(root, out);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
