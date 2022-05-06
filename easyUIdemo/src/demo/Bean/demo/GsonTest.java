package demo.Bean.demo;
import java.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
public class GsonTest {
	public static void main(String[] args) {
		GsonBuilder gb=new GsonBuilder();//builder设计模式
		gb.serializeNulls();
		gb.setDateFormat("yyyy-MM-dd");
		// 1. Java对象-->JSON字符串
		// 1.1 单个对象
		Product p=new Product();
		p.setName("钢笔");p.setPrice(10);//  {"name":"钢笔","price":10}
		p.setProduceDate(new java.util.Date());
		Gson gson=gb.create();//new Gson();
		String str=gson.toJson(p);
		System.out.println(str);
		// 1.2 数组
		Product[] array=new Product[]{ p,p };
		str = gson.toJson(array);
		System.out.println(str);
		// 2. JSON字符串-->Java对象
		str="{\"name\":\"水彩笔\",\"price\":25}";
		Product p2=gson.fromJson(str, Product.class);
		System.out.println("p2中的成员变量值是:"+p2);
		Staff staff=gson.fromJson(str, Staff.class);
		System.out.println("staff中的成员变量值是:"+staff);//gson会忽略无法塞到Java对象中的数据，不会抛异常
		str="[  {\"name\":\"水彩笔1\"} , {\"name\":\"水彩笔2\"}  ]";
		Product[] array2=gson.fromJson(str, Product[].class);
		System.out.println(Arrays.toString(array2));
		p2.setQcStaff(staff);
		str=gson.toJson(p2);
		System.out.println(str);
	}
}
