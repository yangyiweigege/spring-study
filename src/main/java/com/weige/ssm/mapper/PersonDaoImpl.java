package com.weige.ssm.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.weige.ssm.domain.Person;

@Repository
public class PersonDaoImpl {

	@Autowired
	private MongoTemplate mongoTemplate;

	public void updateExistDataById(Person person) {
		System.out.println("的确更新到这里了");
		Query query = new Query();
		Criteria criteria = new Criteria();
		criteria.and("_id").is(person.getId());
		query.addCriteria(criteria);
		Update update = new Update();
		if (person.getName() != null) {
			update.set("name", person.getName());
		}
		if (person.getAge() != null) {
			update.set("age", person.getAge());
		}
		mongoTemplate.updateFirst(query, update, Person.class);
	}
}
