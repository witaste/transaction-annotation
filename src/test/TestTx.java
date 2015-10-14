import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.zno.service.FooService;

@ContextConfiguration(locations = { "classpath:applicationContext-Transaction.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestTx {

	@Autowired
	private FooService fooService;

	@Test
	public void ff() {
		fooService.a();
	}
}
