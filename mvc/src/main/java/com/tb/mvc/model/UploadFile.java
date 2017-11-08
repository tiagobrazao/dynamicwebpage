package com.tb.mvc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
 
@Entity
public class UploadFile {
	
    private int id;
    private String fileName;
    private byte[] data;
 
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
 
    public byte[] getData() {
        return data;
    }
 
    public void setData(byte[] data) {
        this.data = data;
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
