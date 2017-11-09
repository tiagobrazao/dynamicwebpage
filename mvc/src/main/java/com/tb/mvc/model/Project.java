package com.tb.mvc.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * POJO, Persisted object;
 * Template for dynamic construction in view.
 * 
 *  @author Tiago Brazão
 *
 */
@Entity
@Table (name="PROJECT")
public class Project implements IPojo  {
	
	private static final long serialVersionUID = 1L;

	private int id;
	
	private String name;
	
	private String description;
	
	private String e_mail;
	
	private boolean closed = false;
	
	private Date entry_date;
	
	private UploadFile photo;
	
	//GAS

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
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getEntry_date() {
		return entry_date;
	}
	
	public void setEntry_date(Date entry_date) {
		this.entry_date = entry_date;
	}
	
	@ManyToOne
	@JoinColumn(name = "file_id")
	public UploadFile getPhoto() {
		return photo;
	}
	
	public void setPhoto(UploadFile photo) {
		this.photo = photo;
	}

	public boolean isClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}	
	
	//Equals by unique id
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Project))
            return false;
        Project other = (Project) obj;
        if (id != other.id)
            return false;
        return true;
    }
    
    //Hash-code
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        Integer id_integer = new Integer(id);
        result = prime * result + ( (id_integer == null) ? 0 : id_integer.hashCode() );
        return result;
    }

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

}
