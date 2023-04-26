package com.sinchan.webautomation.repositories;


import com.sinchan.webautomation.Dtos.IncidentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;


@Repository
public class CamundaDaoImpl {

    private final static String GET_ALL_INCIDENT = "SELECT ID_, INCIDENT_TIMESTAMP_," +
            "INCIDENT_MSG_,EXECUTION_ID_ FROM practice.act_ru_incident";

    @Autowired
    EntityManager em;

    public List<String> getIncident(){

        List<Object> ls =  (List<Object>)em.createNativeQuery(GET_ALL_INCIDENT).getResultList();
        List<String> ans = new ArrayList<>();
        ls.forEach(obj ->{
            ans.add(obj.;
        });
        return ans;
    }
}
