package mvc;

import org.junit.Test;

import com.tb.mvc.model.Project;

import org.junit.Assert;

public class ProjectTest {
	
	@Test
	public void addUploadFile() {
		Project project = new Project();
		project.setName("test");
		
		//expected / actual
		Assert.assertEquals("test", project.getName());
	}
}
