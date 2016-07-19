package cn.gaoyuexiang.controller;

import cn.gaoyuexiang.model.Rule;
import cn.gaoyuexiang.service.RuleService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RuleControllerTest {

	@Mock
	private RuleService ruleService;

	private RuleController ruleController;

	@Before
	public void setUp() throws Exception {
		ruleController = new RuleController(ruleService);
	}

	@Test
	public void should_return_a_list() throws Exception {
		ArrayList<Rule> rules = new ArrayList<>();

		when(ruleService.getRules()).thenReturn(rules);

		List<Rule> result = ruleController.getRules();

		assertThat(result, is(rules));
	}
}