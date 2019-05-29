package com.example.demo.repository;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@DataJpaTest
@TestPropertySource(properties = {
        "spring.jpa.hibernate.ddl-auto=validate"
})
public class ScheduledTaskRepositoryTest {
	@Autowired
	private EntityManager entityManager;

	@Autowired
	private ScheduledTaskRepository scheduledTaskRepository;

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	public void testFindByscheduledTaskKey_TaskName() {
		assertThat(entityManager, notNullValue());
	    assertThat(scheduledTaskRepository, notNullValue());
	}

}
