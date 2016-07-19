package cn.gaoyuexiang.service;

import cn.gaoyuexiang.model.Rule;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
public class RuleService {

	private static final String RULE_DS = "/rule.json";
	private SerializeService serializeService;

	@Autowired
	public RuleService(SerializeService serializeService) {
		this.serializeService = serializeService;
	}

	public List<Rule> getRules() {
		InputStream stream = getClass().getResourceAsStream(RULE_DS);
		return serializeService.convertTo(stream, new TypeReference<List<Rule>>() {
		});
	}
}
