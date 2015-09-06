package cn.zno.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zno.dao.PersonMapper;
import cn.zno.pojo.Person;
import cn.zno.pojo.PersonExample;
import cn.zno.pojo.PersonExample.Criteria;
@Service
public class BService {
	@Autowired
	private PersonMapper personMapper;

	public void update(Person person) {
		PersonExample personExample = new PersonExample();
		Criteria criteria = personExample.createCriteria();
		criteria.andIdEqualTo("1");
		person.setAge(new BigDecimal(13));
		personMapper.updateByExample(person, personExample);
		
	}

}
