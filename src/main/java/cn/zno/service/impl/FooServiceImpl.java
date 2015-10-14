package cn.zno.service.impl;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.zno.dao.FooMapper;
import cn.zno.pojo.Foo;
import cn.zno.service.FooService;

@Service
public class FooServiceImpl implements FooService {

	@Autowired
	private FooMapper fooMapper;

	public void a() {
		try{
			((FooService) AopContext.currentProxy()).b();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void b() {
		fooMapper.insert(new Foo("1"));
		int i = 1 / 0;
		fooMapper.insert(new Foo("2"));
	}
}
