package kr.co.pk.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

public class DataStructure {
	private String subject;
	private String content;

	public DataStructure() {
		super();
	}

	public DataStructure(String subject, String content) {
		super();
		this.subject = subject;
		this.content = content;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "DataStructure [subject=" + subject + ", content=" + content + "]";
	}
}
