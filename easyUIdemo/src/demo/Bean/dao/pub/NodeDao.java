package demo.Bean.dao.pub;

import demo.Bean.bean.pub.Node;
import demo.Bean.pub.Database;

import java.util.ArrayList;


import java.sql.*;
/**增删改查tb_node表*/
public class NodeDao {
	/**
	 * 给一个父节点，查询出其下的所有子节点
	 * @param parent 父节点  如果查询根节点（没有父节点的节点）传入null
	 * @return 返回子节点，如果没有子节点，返回size=0的ArrayList
	 * */
	public ArrayList<Node> selectByParent(Node parent){
		ArrayList<Node> children=new ArrayList<Node>();
		Long pid=null;
		if(parent==null) {
			pid=-1L;
		}else {
			pid=parent.getId();
		}
		try {
			Connection con= Database.connect();
			String sql="select * "
					+ ", (select 'closed' from tb_node b where b.pid=a.id limit 0,1) as state "
					+ " from tb_node a where pid="+pid;
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				Long id=rs.getLong("id");
				String text=rs.getString("text");
				Node node=new Node();
				node.setId(id);node.setText(text);node.setPid(pid);
				String state=rs.getString("state");
				if("closed".equals(state)) {
					node.setState("closed");//有子节点
				}else {
					node.setState("open");
				}
				//把节点和一个功能页面绑定
				node.getAttributes().put("url", "http://gdaib.test."+id);
				children.add(node);
			}
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return children;
	}
}
