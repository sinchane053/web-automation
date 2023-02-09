package com.sinchan.webautomation.delegates;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class TestDelegate implements JavaDelegate {
    private final static Logger LOG = Logger.getLogger(TestDelegate.class.getName());
    @Autowired
    @Qualifier(value = "runtimeService")
    RuntimeService runtimeService;
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("in test delegate");
        String processId = execution.getProcessInstanceId();
        runtimeService.setVariable(processId,"demoKey","demo");
        execution.setVariable("isReset", true);

    }
}
