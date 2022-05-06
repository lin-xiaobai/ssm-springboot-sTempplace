package demo.Bean.bean.pub;

import java.util.ArrayList;
import java.util.HashMap;

/**抽象、封装树节点中的数据*/
public class Node {
	HashMap attributes=new HashMap();//保存自定义属性，扩展节点保存的数据 
	Long id,pid;//id-节点的唯一标识  pid-节点归属于哪个父节点
	String state="open";//标记有没有子节点
	String text;
	ArrayList<Node> children=new ArrayList<Node>();//保存子节点
	public HashMap getAttributes() {
		return attributes;
	}
	public void setAttributes(HashMap attributes) {
		this.attributes = attributes;
	}
	public Long getId() {
		return id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public ArrayList<Node> getChildren() {
		return children;
	}
	public void setChildren(ArrayList<Node> children) {
		this.children = children;
	}
}
