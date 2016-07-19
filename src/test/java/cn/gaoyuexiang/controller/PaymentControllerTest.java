package cn.gaoyuexiang.controller;

import cn.gaoyuexiang.service.PaymentService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PaymentControllerTest {

	@Mock
	private PaymentService paymentService;

	private PaymentController paymentController;

	@Before
	public void setUp() throws Exception {
		paymentController = new PaymentController(paymentService);

	}
}