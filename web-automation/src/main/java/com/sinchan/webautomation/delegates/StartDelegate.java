package com.sinchan.webautomation.delegates;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class StartDelegate {
    private final static Logger LOG = Logger.getLogger(StartDelegate.class.getName());
    @Autowired
    @Qualifier(value = "runtimeService")
    RuntimeService runtimeService;

    public String startProcessInstanceByKey(String process) throws Exception{
        LOG.info("process started");
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(process);
        System.out.println("Process instance is - "+ processInstance.getProcessInstanceId());
        return processInstance.getProcessInstanceId();

    }
}
