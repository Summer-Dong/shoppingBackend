package cn.gaoyuexiang.controller;

import cn.gaoyuexiang.model.PaymentRequest;
import cn.gaoyuexiang.model.PaymentResult;
import cn.gaoyuexiang.service.PaymentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PaymentControllerTest {

	@Mock
	private PaymentService paymentService;

	private PaymentController paymentController;

	@Before
	public void setUp() throws Exception {
		paymentController = new PaymentController(paymentService);
	}

	@Test
	public void should_get_return() throws Exception {
		//request
		PaymentRequest paymentRequest = new PaymentRequest();
		//response
		PaymentResult paymentResult = new PaymentResult();
		when(paymentService.payment(paymentRequest)).thenReturn(paymentResult);
		PaymentResult result = paymentController.payment(paymentRequest);
		assertThat(result, is(paymentResult));
	}
}