package com.example.drools.decision.demo.controller;

import com.mybatisflex.core.paginate.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.drools.decision.demo.service.DecisionTableRulesService;
import com.example.drools.decision.demo.entity.DecisionTableRulesEntity;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

/**
 * 控制层。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
@RestController
@RequestMapping("/decisionTableRules")
public class DecisionTableRulesController {

    @Autowired
    private DecisionTableRulesService decisionTableRulesService;

    /**
     * 添加
     *
     * @param decisionTableRules
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("/save")
    public boolean save(@RequestBody DecisionTableRulesEntity decisionTableRules) {
        return decisionTableRulesService.save(decisionTableRules);
    }


    /**
     * 根据主键删除
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("/remove/{id}")
    public boolean remove(@PathVariable Serializable id) {
        return decisionTableRulesService.removeById(id);
    }


    /**
     * 根据主键更新
     *
     * @param decisionTableRules
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("/update")
    public boolean update(@RequestBody DecisionTableRulesEntity decisionTableRules) {
        return decisionTableRulesService.updateById(decisionTableRules);
    }


    /**
     * 查询所有
     *
     * @return 所有数据
     */
    @GetMapping("/list")
    public List<DecisionTableRulesEntity> list() {
        return decisionTableRulesService.list();
    }


    /**
     * 根据主键获取详细信息。
     *
     * @param id decisionTableRules主键
     * @return 详情
     */
    @GetMapping("/getInfo/{id}")
    public DecisionTableRulesEntity getInfo(@PathVariable Serializable id) {
        return decisionTableRulesService.getById(id);
    }


    /**
     * 分页查询
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("/page")
    public Page<DecisionTableRulesEntity> page(Page<DecisionTableRulesEntity> page) {
        return decisionTableRulesService.page(page);
    }
}