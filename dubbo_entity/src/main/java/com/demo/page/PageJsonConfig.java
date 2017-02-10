package com.demo.page;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import net.sf.json.JSONNull;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import net.sf.json.util.CycleDetectionStrategy;

/**
 * PageJsonConfig分页转换成JSON处理类
 * 
 * @Description :JsonConfig类重写
 * @author : liwenjian
 * @version : 1.0
 * @Date : 2016年5月6日 上午9:44:31
 */
public class PageJsonConfig extends JsonConfig {
	public PageJsonConfig() {
		this.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);// net.sf.json.JSONException:
																		// There
																		// is a
																		// cycle
																		// in
																		// the
																		// hierarchy!错误解决方案
		// 可同时注册处理多种数据
		this.registerJsonValueProcessor("condition", new EntityJsonValueProcessor());// 注入处理动态实体类condition=null
		this.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor());// 注入处理Date类
	}

	/**
	 * 
	 * @Description :JSONArray.fromObject()转换异常，时间类型空值处理类
	 * @author : liwenjian
	 * @version : 1.0
	 * @Date : 2016年5月6日 上午9:34:26
	 */
	public class DateJsonValueProcessor implements JsonValueProcessor {

		public Object processArrayValue(Object obj, JsonConfig jsonconfig) {
			return process(obj);
		}

		public Object processObjectValue(String s, Object obj, JsonConfig jsonconfig) {
			return process(obj);
		}

		private Object process(Object obj) {
			if (obj == null) {// 如果时间为null，则返回空字串
				return "";
			}
			if (obj instanceof Date) {
				obj = new java.util.Date(((Date) obj).getTime());
			}
			if (obj instanceof java.util.Date) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);// 格式化时间为yyyy-MM-dd类型
				return sdf.format(obj);
			} else {
				return new Object();
			}
		}

	}

	/**
	 * 
	 * @Description :实体类条件condition处理类，为空则返回""
	 * @author : liwenjian
	 * @version : 1.0
	 * @Date : 2016年5月6日 下午3:41:35
	 */
	public class EntityJsonValueProcessor implements JsonValueProcessor {

		public Object processArrayValue(Object obj, JsonConfig jsonconfig) {
			return obj;
		}

		public Object processObjectValue(String s, Object obj, JsonConfig jsonconfig) {
			if ("condition".equals(s)) {// com.lwj.page.Page分页类里面的condition动态实体对象,这里是以key的方式,如果condition为com.excenon.entity.Member类,则obj为传入的是com.lwj.entity.Member对象
				return JSONNull.getInstance().equals(obj) ? "" : JSONObject.fromObject(obj, new PageJsonConfig());// 为了方便这里就直接调用
																													// new
																													// PageJsonConfig(),不再编写另一个处理null的Date类型的类,PageJsonConfig中的DateJsonValueProcessor方法处理null
																													// Date类型
			}
			return obj;
		}

	}
}
