package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.github.kagkarlsson.scheduler.task.ExecutionContext;
import com.github.kagkarlsson.scheduler.task.TaskInstance;
import com.github.kagkarlsson.scheduler.task.VoidExecutionHandler;

@Component
public class MyVoidExecutionHandler<T> implements VoidExecutionHandler<T> {
	@Autowired
	ApplicationContext applicationContext;
	
	@Override
	public void execute(TaskInstance<T> taskInstance, ExecutionContext executionContext) {
		// TODO Auto-generated method stub
		System.out.println("executing, " + ((TestPojo)taskInstance.getData()).getName());
	}

}
