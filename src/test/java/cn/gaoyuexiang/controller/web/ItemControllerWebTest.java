package cn.gaoyuexiang.controller.web;

import cn.gaoyuexiang.controller.ItemController;
import cn.gaoyuexiang.service.ItemService;
import cn.gaoyuexiang.service.SerializeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ItemController.class,
				ItemService.class,
				SerializeService.class})
@WebAppConfiguration
public class ItemControllerWebTest {

	@Autowired
	private ItemController itemController;

	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(itemController).build();
	}

	@Test
	public void should_get_ok() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/item")
						.accept(MediaType.APPLICATION_JSON_UTF8))
						.andExpect(status().isOk());
	}
}