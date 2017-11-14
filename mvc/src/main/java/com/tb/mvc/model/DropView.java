package com.tb.mvc.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/**
 * POJO, Persisted object;
 * Template for dynamic construction in view.
 * 
 *  @author Tiago Brazão
 *
 */
@Entity
public class DropView implements IPojo  {
	
	private static final long serialVersionUID = 1L;

	private int id;
	
	private String name;
	
	private List<DropLabel> drop_labels;
	
	//Equals by unique id
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof DropView))
            return false;
        DropView other = (DropView) obj;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue
	@Column(name = "drop_ID")
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	@OneToMany(mappedBy = "dropview")
	public List<DropLabel> getDrop_labels() {
		return drop_labels;
	}

	public void setDrop_labels(List<DropLabel> drop_labels) {
		this.drop_labels = drop_labels;
	}
	
}
