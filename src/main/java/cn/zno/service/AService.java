package cn.zno.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.zno.dao.PersonMapper;
import cn.zno.pojo.Person;
import cn.zno.pojo.PersonExample;
import cn.zno.pojo.PersonExample.Criteria;

@Service
public class AService {

	@Autowired
	private PersonMapper personMapper;

	@Autowired
	private BService bService;

	@Transactional(propagation = Propagation.REQUIRED)
	public void case1() {
		Person person = new Person();
		person.setId("1");
		person.setName("xiaoming");
		person.setAge(new BigDecimal(11));
		
		PersonExample personExample = new PersonExample();
		Criteria criteria = personExample.createCriteria();
		criteria.andIdEqualTo("1");
		
		personMapper.insert(person);
		showPerson();
		update(person);
		showPerson();
		bService.update(person);
		showPerson();
		
	}

	public void update(Person person) {
		PersonExample personExample = new PersonExample();
		Criteria criteria = personExample.createCriteria();
		criteria.andIdEqualTo("1");
		person.setAge(new BigDecimal(12));
		personMapper.updateByExample(person, personExample);
	}

	public void showPerson(){
		PersonExample personExample = new PersonExample();
		Criteria criteria = personExample.createCriteria();
		criteria.andIdEqualTo("1");
		System.out.println(personMapper.selectByExample(personExample).get(0).toString());
	}
	
}
