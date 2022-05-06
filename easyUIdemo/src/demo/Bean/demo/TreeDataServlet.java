package demo.Bean.demo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.Bean.bean.pub.Node;
import demo.Bean.dao.pub.NodeDao;
import com.google.gson.Gson;


/**向树组件提供数据*/
@WebServlet("/servlet/treedata")//  http://ip:port/javaee/servlet/treedata
public class TreeDataServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Node aib=new Node();
//		aib.setText("广东农工商职业技术学院");
//		Node computer=new Node();
//		computer.setText("计算机学院");
//		//ArrayList aibChildren=new ArrayList();
//		//aibChildern.add(computer);
//		//aibChildern.add(art);
//		//aib.setChildreen(aibChildren);
//		Node soft=new Node();
//		soft.setText("软件技术");
//		computer.getChildren().add(soft);
//		aib.getChildren().add(computer);
//		Node hospital=new Node();
//		hospital.setText("中新医院");
//		Node[] tree=new Node[] {aib,hospital};
		String idString=req.getParameter("id");//要查看哪个节点下的子节点
		NodeDao dao=new NodeDao();
		ArrayList tree=null;
		if(idString==null) {//加载第一层节点
			tree=dao.selectByParent(null);
		}else {
			Long id=Long.parseLong(idString);
			Node parent=new Node();
			parent.setId(id);
			tree=dao.selectByParent(parent);
		}
		Gson gson=new Gson();
		String json=gson.toJson(tree);
		System.out.println(json);
//		String json="[ {\"text\":\"GDAIB\"} ]";
		resp.setContentType("application/json;charset=utf-8");
		PrintWriter w=resp.getWriter();
		w.println(json);
	}
}
