package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.github.kagkarlsson.scheduler.Scheduler;
import com.github.kagkarlsson.scheduler.task.helper.RecurringTask;
import com.github.kagkarlsson.scheduler.task.helper.Tasks;
import com.github.kagkarlsson.scheduler.task.schedule.FixedDelay;

@Component
public class ApplicationEventListener {
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private MyVoidExecutionHandler<TestPojo> testExecutionHandler;
	
	@EventListener
	public void onApplicationReadyEvent(final ApplicationReadyEvent pplicationReadyEvent) {
		
		RecurringTask<TestPojo> hourlyTask = Tasks.recurring("my-minute-task", FixedDelay.ofMinutes(1), TestPojo.class)
				.initialData(new TestPojo())
//				.execute((taskInstance, executionContext) -> {
//					System.out.println("Executing " + taskInstance.getTaskAndInstance() + " , data: " + taskInstance.getData());
//				});
		        .execute(testExecutionHandler);

		final Scheduler scheduler = Scheduler
		        .create(dataSource)
		        .startTasks(hourlyTask)
		        .threads(5)
		        .build();
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
		    @Override
		    public void run() {
		    	System.out.println("Received shutdown signal.");
		        scheduler.stop();
		    }
		});

		// hourlyTask is automatically scheduled on startup if not already started (i.e. exists in the db)
		scheduler.start();
	}
}
