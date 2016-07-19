package cn.gaoyuexiang.controller;

import cn.gaoyuexiang.model.Rule;
import cn.gaoyuexiang.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rules")
public class RuleController {
	private RuleService ruleService;

	@Autowired
	public RuleController(RuleService ruleService) {
		this.ruleService = ruleService;
	}

	@RequestMapping
	public List<Rule> getRules() {
		return ruleService.getRules();
	}
}
