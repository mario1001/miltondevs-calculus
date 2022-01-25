package org.miltondevs.maven.miltondevscalculus.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.miltondevs.maven.miltondevscalculus.service.IArithmeticService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ArithmeticControllerTest {

	private MockMvc mockMvc;

	@Mock
	private IArithmeticService arithmeticService;

	@InjectMocks
	private ArithmeticController arithmeticController;

	@BeforeEach
	public void init() {
		mockMvc = MockMvcBuilders.standaloneSetup(arithmeticController)
				.setMessageConverters(new MappingJackson2HttpMessageConverter()).build();
	}

	@Test
	public void testArithmeticControllerAdditionWithStringQueryParameter() throws Exception {
		mockMvc.perform(get("/arithmetic/addition").param("param", "1").param("param", "abc"))
				.andExpect(status().isBadRequest()).andDo(log());
	}
}
