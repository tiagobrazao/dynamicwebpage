package com.tb.mvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
 
@Entity
public class UploadFile implements IPojo {
	
	private static final long serialVersionUID = 1L;

	private int id;
    
    private String fileName;
    

    
    private byte[] file_data;
 
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }
 
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
 
    @Lob
    @Column(name="file_data", nullable=false, columnDefinition="blob")
    public byte[] getData() {
        return this.file_data;
    }
 
    public void setData(byte[] data) {
        this.file_data = data;
    }
    
	//Equals by unique id
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof UploadFile))
            return false;
        UploadFile other = (UploadFile) obj;
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
    
}
