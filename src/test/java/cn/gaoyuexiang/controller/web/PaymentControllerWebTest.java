package cn.gaoyuexiang.controller.web;

import cn.gaoyuexiang.StartBoot;
import cn.gaoyuexiang.controller.PaymentController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = StartBoot.class)
public class PaymentControllerWebTest {

	@Autowired
	private PaymentController paymentController;

	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(paymentController).build();
	}

	@Test
	public void should_return_ok() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/payment")
						.contentType(MediaType.APPLICATION_JSON_UTF8)
						.content("{\"items\":[\"ITEM00001\"]}")
						.accept(MediaType.APPLICATION_JSON_UTF8))
						.andExpect(status().isOk());
	}
}