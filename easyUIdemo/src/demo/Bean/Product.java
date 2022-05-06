package demo.Bean;

import java.util.Date;

public class Product {
	String name;
	String code;
	int price;
	Date produceDate;
	@Override
	public String toString(){
		return "name="+name+" code="+code+" price="+price+" produceDate="+produceDate;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getProduceDate() {
		return produceDate;
	}

	public void setProduceDate(Date produceDate) {
		this.produceDate = produceDate;
	}
}
