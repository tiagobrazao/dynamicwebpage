package com.tb.mvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tb.mvc.dao.IDAO;
import com.tb.mvc.dao.impl.ServiceDao;
import com.tb.mvc.model.DropLabel;
import com.tb.mvc.model.DropView;
import com.tb.mvc.service.AbstractService;

@Service
public class DropService extends AbstractService<DropView, Integer>
        implements IDropViewService {
 
	private ServiceDao dv_dao; 
    
    public DropService() {}
    
    @Autowired
    public DropService(@Qualifier("serviceDao") IDAO<DropView, Integer> dv_dao) {
        super(dv_dao);
        this.dv_dao = (ServiceDao) dv_dao;
        this.dv_dao.setClazz(DropView.class);
    }

	public void saveLabels(DropView dropview, List<DropLabel> labels) {
		
		//needs label service to avoid null pointer
		
		/*LabelDao labeldao = new LabelDao();
		
		for (DropLabel label : labels) { 
			label.setDropview(dropview);
			labeldao.add(label);}
		*/
	}
    
}