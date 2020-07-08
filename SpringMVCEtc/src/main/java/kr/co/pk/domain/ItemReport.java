package kr.co.pk.domain;

import java.util.List;

import javax.xml.bind.annotation.*;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ITEMLIST")

public class ItemReport {
	@XmlElement(name = "ITEM")
	private List<Item> list;
	public ItemReport() {
	}
	public ItemReport(List<Item> list) {
		this.list = list;
	}
	public List<Item> getList() {
		return list;
	}
}
