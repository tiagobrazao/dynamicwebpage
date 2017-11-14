package com.tb.mvc.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


/**
 * POJO, Persisted object;
 * Template for dynamic construction in view.
 * Whit bean validation
 * 
 *  @author Tiago Brazão
 *
 */
@Entity
@Table (name="PROJECT")
public class Project implements IPojo  {
	
	private static final long serialVersionUID = 1L;

	private int id;
	
	@NotEmpty(message = "Insira nome de projecto.")
    @Size(min = 2, max = 15, message = "Nome de projecto: entre 2 and 15 caracteres.")
	private String name;
	
	@NotEmpty(message = "Insira descrição.")
	private String description;
	
	@AssertFalse
	private boolean closed;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
    @NotNull (message = "Insira data válida.")
	//@Past (see all annotations possibilities)
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

	/*public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}*/

}
