package cn.gaoyuexiang.service;

import cn.gaoyuexiang.model.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuleService {

	private SerializeService serializeService;

	@Autowired
	public RuleService(SerializeService serializeService) {
		this.serializeService = serializeService;
	}

	public List<Rule> getRules() {
		return null;
	}
}
