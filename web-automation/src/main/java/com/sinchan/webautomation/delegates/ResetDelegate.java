package com.sinchan.webautomation.delegates;

import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class ResetDelegate implements JavaDelegate {
    private final static Logger LOG = Logger.getLogger(ResetDelegate.class.getName());
    @Autowired
    @Qualifier(value = "runtimeService")
    RuntimeService runtimeService;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("in ResetDelegate");
        System.out.println("### reset initiated ###");
        LOG.warning("sub process id - " + execution.getProcessInstanceId());
        System.out.println("process Ending.......");



    }
}
