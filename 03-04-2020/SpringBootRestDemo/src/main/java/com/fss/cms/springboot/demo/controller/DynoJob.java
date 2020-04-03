package com.fss.cms.springboot.demo.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronSequenceGenerator;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.PeriodicTrigger;
@Configuration
public class DynoJob implements SchedulingConfigurer   {
	@Value(value = "nextExecutionTime")
	String nextExecutionTime;
	static int count=1;
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		  taskRegistrar.addTriggerTask(new Runnable() {
	            @Override
	            public void run() {
	                // Do not put @Scheduled annotation above this method, we don't need it anymore.
	               //logic to run once per day lastextn must be after current dt, ie runs once per day
	            	System.out.println("Running Schedular JobLogic......"+new Date());
	            }
	        }, new CronTrigger("0 * * ? * *")/*new PeriodicTrigger(2, TimeUnit.MINUTES)*//*,  Trigger() {
	            public Date nextExecutionTime(TriggerContext triggerContext) {
	                Calendar nextExecutionTime = new GregorianCalendar();
	                System.out.println("let::"+triggerContext.lastActualExecutionTime());
	                Date lastActualExecutionTime = triggerContext.lastActualExecutionTime();
	                boolean lastExDtTom=false;
	                if(lastActualExecutionTime!=null ) {
	            	   lastExDtTom=lastActualExecutionTime.before(new Date());
		                System.out.println("lastExDtTom:"+lastExDtTom);
		                
		                   
	               }
	                if(count==1 && lastActualExecutionTime==null) {
	                	lastExDtTom=true;
	                	System.out.println("count = 1");
	                }
	                if(!lastExDtTom && count>2) {
	                	System.out.println("count > 2");
	                	lastExDtTom=false;
	                	
	                }
	                else {
	                	System.out.println("count = 2");
	                	lastExDtTom=true;
	                }
	                if(lastExDtTom ) {
	                nextExecutionTime.setTime(lastActualExecutionTime != null ? lastActualExecutionTime : new Date());
	                nextExecutionTime.add(Calendar.MILLISECOND, getNewExecutionTime());
	                count++;
	                System.out.println("count:"+count);
	                System.out.println("nET::"+nextExecutionTime.getTime());
	                return nextExecutionTime.getTime();
	            }
	                else {
		            	System.out.println("nulll---");
	                	return null;
		            	
		            	
		            }}
	            
	        }*/);
	}
	//running job dynmically twice per day in 20sec interval
	private int getNewExecutionTime() {
		//Load Your execution time from database or property file
		System.out.println("nextExecutionTime:"+nextExecutionTime);
		return 20000;
	}
	
	/*@Bean
  public TaskScheduler poolScheduler() {
      ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
      scheduler.setThreadNamePrefix("ThreadPoolTaskScheduler");
      scheduler.setPoolSize(1);
      scheduler.initialize();
      return scheduler;
  }*/
		
	

}
