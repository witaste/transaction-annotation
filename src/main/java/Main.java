
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.zno.service.AService;

public class Main {

	
	
	public static void main(String[] args) throws SQLException {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:Beans-Transaction.xml");
		
		AService aService = ctx.getBean("aService",AService.class);
		// 最外层方法被@ 标注，则这个方法包含的所有CUD操作（方法内，类内，其他类内）是一个事务
		
		// 事务内的CUD事务内可见，其他事务不可见
		
		// 最外层方法抛出RuntimeException 则事务回滚（可以是内层抛到外层，可以是外层抛）
		
		// 内层抛出RuntimeException，但在内层被处理，则不会回滚
		
		// 如果异常被处理，最外层没有抛出。则所有正常执行的CUD会被提交
		
		aService.case1();
		
		// 如果最外层方法被@ 标注，内部方法也有@ ，只有最外层起作用。
		
	}
}
