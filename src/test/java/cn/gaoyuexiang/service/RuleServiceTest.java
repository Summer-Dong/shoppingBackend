package cn.gaoyuexiang.service;

import cn.gaoyuexiang.model.Rule;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RuleServiceTest {

	@Mock
	private SerializeService serializeService;

	private RuleService ruleService;

	@Before
	public void setUp() throws Exception {
		ruleService = new RuleService(serializeService);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void should_return_result() throws Exception {
		Rule rule = new Rule();
		ArrayList<Rule> rules = new ArrayList<>();
		rules.add(rule);
		when(serializeService.convertTo(
						Mockito.any(InputStream.class),
						Mockito.any(TypeReference.class)
		)).thenReturn(rules);
		List<Rule> result = ruleService.getRules();
		assertThat(result, is(rules));
	}
}