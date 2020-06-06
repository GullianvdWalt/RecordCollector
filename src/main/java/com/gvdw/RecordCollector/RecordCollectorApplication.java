package com.gvdw.RecordCollector;



import com.gvdw.RecordCollector.Controllers.RecordsController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
public class RecordCollectorApplication{
        
    
	public static void main(String[] args) {
		SpringApplication.run(RecordCollectorApplication.class, args);
	}

}
