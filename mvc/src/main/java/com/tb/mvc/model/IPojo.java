package com.tb.mvc.model;

import java.io.Serializable;

/**
 * Interface for Model POJO persisted.
 * 
 * @author Tiago Brazão
 *
 */
public interface IPojo extends Serializable {
	
	/**
	 * Get id unique value from IPojo impl instance
	 * 
	  @return int id unique value
	 */
	 public int getId(); 
	
}
