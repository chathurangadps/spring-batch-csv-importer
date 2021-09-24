package com.example.batch.csv.importer.controller;

import lombok.SneakyThrows;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class TestController {

    private final JobLauncher jobLauncher;
    private final Job job;

    public TestController(JobLauncher jobLauncher, Job job) {
        this.jobLauncher = jobLauncher;
        this.job = job;
    }

    @SneakyThrows
    @GetMapping("/test")
    public String test()  {

        Map<String , JobParameter> stringJobParameterMap = new LinkedHashMap<>();
        stringJobParameterMap.put("time" , new JobParameter(System.currentTimeMillis()));
        JobParameters jobParameters = new JobParameters(stringJobParameterMap);

        jobLauncher.run(job , jobParameters);

        return "Done!";
    }
}
