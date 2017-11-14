package mvc;

import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringContextTest {
	
	/**
	 * Loads spring context and messages properties
	 * 
	 */
	@Test
	public void bundleResourceTest() {
		ConfigurableApplicationContext  acontext = 
				new FileSystemXmlApplicationContext("/src/main/webapp/WEB-INF/spring_context.xml");
	    String message = acontext.getMessage("msg.text", null, Locale.ENGLISH);
	    Assert.assertEquals("OK", message);     
	    acontext.close();
	}
}
