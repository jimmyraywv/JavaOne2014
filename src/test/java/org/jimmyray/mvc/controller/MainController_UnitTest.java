package org.jimmyray.mvc.controller;

import org.jimmyray.config.MvcConfig;
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
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = MvcConfig.class)
public class MainController_UnitTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void echoGetTest() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.get("/echo.do?echo=TEST").accept(
						MediaType.ALL))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.view().name("echo"))
				.andExpect(
						MockMvcResultMatchers.model().attribute("echo", "TEST"))
				.andExpect(
						MockMvcResultMatchers
								.forwardedUrl("/WEB-INF/jsp/echo.jsp"));
	}

	@Test
	public void memoryPostTest() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.post("/remember.do")
						.param("memory", "TEST MEMORY").accept(MediaType.ALL))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.view().name("memory"))
				.andExpect(
						MockMvcResultMatchers.model().attribute("memory",
								"TEST MEMORY"))
				.andExpect(
						MockMvcResultMatchers
								.forwardedUrl("/WEB-INF/jsp/memory.jsp"));
	}

	@Test
	public void memoryGetTest() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.get("/remember.do")
						.accept(MediaType.ALL))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.view().name("memory"))
				.andExpect(
						MockMvcResultMatchers.model().attribute("memory", ""))
				.andExpect(
						MockMvcResultMatchers
								.forwardedUrl("/WEB-INF/jsp/memory.jsp"));
	}

	@Test
	public void systemInfoGetTest() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.get("/system.do").accept(MediaType.ALL))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.view().name("systemInfo"))
				.andExpect(
						MockMvcResultMatchers.model().attributeExists(
								"jvmArgs", "systemProperties",
								"otherProperties"))
				.andExpect(
						MockMvcResultMatchers
								.forwardedUrl("/WEB-INF/jsp/systemInfo.jsp"));
	}

	@Test
	public void appPropsGetTest() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.get("/appProps.do").accept(MediaType.ALL))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.view().name("appProps"))
				.andExpect(
						MockMvcResultMatchers.model().attributeExists(
								"applicationBuilder",
								"applicationBuildDateTime",
								"applicationVersion"))
				.andExpect(
						MockMvcResultMatchers
								.forwardedUrl("/WEB-INF/jsp/appProps.jsp"));
	}
}
