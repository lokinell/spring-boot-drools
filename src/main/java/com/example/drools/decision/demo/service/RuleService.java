package com.example.drools.decision.demo.service;

import com.example.drools.decision.demo.entity.StudentEntity;
import com.example.drools.decision.demo.mapper.StudentMapper;
import org.drools.core.impl.KnowledgeBaseImpl;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class RuleService {

    @Autowired
    private StudentService studentService;

    @Autowired
    private KieContainer kieContainer;

    @PostConstruct
    public void init() {
        loadRulesFromDatabase();
    }

    private void loadRulesFromDatabase() {


        KieFileSystem kieFileSystem = KieServices.Factory.get().newKieFileSystem();
        List<StudentEntity> studentEntities = studentService.list();

        KieBuilder kieBuilder = KieServices.Factory.get().newKieBuilder(kieFileSystem);
        kieBuilder.buildAll();
        KieModule kieModule = kieBuilder.getKieModule();
        kieContainer = KieServices.Factory.get().newKieContainer(kieModule.getReleaseId());

    }

    public void fireRules(Object... facts) {
        KieBase kieBase = kieContainer.getKieBase();
        KieSession kieSession = kieBase.newKieSession();

        for (Object fact : facts) {
            kieSession.insert(fact);
        }

        kieSession.fireAllRules();
        kieSession.dispose();
    }
}