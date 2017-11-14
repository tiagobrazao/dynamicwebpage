package com.tb.mvc.service.impl;

import java.util.List;

import com.tb.mvc.model.DropLabel;
import com.tb.mvc.model.DropView;
import com.tb.mvc.service.IService;

/**
 * Interface for Project Service
 * 
 * @author Tiago Brazão
 *
 */
public interface IDropViewService extends IService<DropView,Integer> {
	
	//methods
	
	/**
	 * Persist ddroplabes in db
	 * @param dropview the id to one to many relation
	 * @param labels to be saved
	 */
	public void saveLabels(DropView dropview, List<DropLabel> labels);
	
}
