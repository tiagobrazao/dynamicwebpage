package com.tb.mvc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * POJO, Persisted object;
 * In the future add type (url, etc.) and other attr
 * 
 * @author Tiago Brazão
 *
 */
@Entity
public class DropLabel implements IPojo  {
	
	private int id;
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private String url;
	
	private DropView dropview;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	
	@SuppressWarnings("unused")
	private void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToOne
	@JoinColumn(name = "drop_ID")
	public DropView getDropview() {
		return dropview;
	}

	public void setDropview(DropView dropview) {
		this.dropview = dropview;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
