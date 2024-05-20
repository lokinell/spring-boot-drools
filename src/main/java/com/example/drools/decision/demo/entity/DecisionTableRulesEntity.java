package com.example.drools.decision.demo.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

import java.lang.Long;
import java.util.Date;
import java.lang.String;
import java.lang.Integer;

/**
 * 实体类。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
@Data
@Table(value = "decision_table_rules")
public class DecisionTableRulesEntity {

    @Id(keyType = KeyType.Auto)
    private Long id;

    @Column(value = "rule_name")
    private String ruleName;

    @Column(value = "rule_description")
    private String ruleDescription;

    @Column(value = "rule_data")
    private String ruleData;

    @Column(value = "version")
    private Integer version;

    @Column(value = "created_at")
    private Date createdAt;

    @Column(value = "updated_at")
    private Date updatedAt;

    @Column(value = "effective_from")
    private Date effectiveFrom;

    @Column(value = "effective_to")
    private Date effectiveTo;
}
