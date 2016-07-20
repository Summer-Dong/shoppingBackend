package cn.gaoyuexiang.service;

import cn.gaoyuexiang.model.PaymentItem;
import cn.gaoyuexiang.model.PaymentRequest;
import cn.gaoyuexiang.model.PaymentResult;
import cn.gaoyuexiang.service.calc.CostPriceCalculator;
import cn.gaoyuexiang.service.calc.DiscountCalculator;
import cn.gaoyuexiang.service.calc.FullOffCalculator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PaymentServiceTest {

	@Mock
	private PaymentMapper paymentMapper;

	@Mock
	private FullOffCalculator fullOffCalculator;

	@Mock
	private DiscountCalculator discountCalculator;

	@Mock
	private CostPriceCalculator costPriceCalculator;
	
	private PaymentService paymentService;

	@Before
	public void setUp() throws Exception {
		paymentService = new PaymentService(
						paymentMapper,
						fullOffCalculator,
						discountCalculator,
						costPriceCalculator);
	}

	@Test
	public void should_get_result() throws Exception {
		PaymentResult paymentResult = new PaymentResult();
		PaymentRequest paymentRequest = new PaymentRequest();
		ArrayList<PaymentItem> paymentItems = new ArrayList<>();

		when(paymentMapper.map(paymentRequest)).thenReturn(paymentItems);
		when(fullOffCalculator.calculate(paymentItems))
						.thenReturn(paymentResult);
		when(discountCalculator.calculate(paymentItems))
						.thenReturn(paymentResult);
		when(costPriceCalculator.calculate(paymentItems))
						.thenReturn(paymentResult);

		paymentResult.add(paymentResult);
		paymentResult.add(paymentResult);
		paymentResult.add(paymentResult);

		PaymentResult result = paymentService.payment(paymentRequest);

		assertThat(result, equalTo(paymentResult));
	}
}