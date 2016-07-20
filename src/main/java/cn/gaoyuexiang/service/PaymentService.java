package cn.gaoyuexiang.service;

import cn.gaoyuexiang.model.PaymentItem;
import cn.gaoyuexiang.model.PaymentRequest;
import cn.gaoyuexiang.model.PaymentResult;
import cn.gaoyuexiang.service.calc.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PaymentService {
	private PaymentMapper paymentMapper;
	private List<Calculator> calculators = new ArrayList<>();

	@Autowired
	public PaymentService(PaymentMapper paymentMapper, Calculator... calculators) {
		this.paymentMapper = paymentMapper;
		Collections.addAll(this.calculators, calculators);
	}

	public PaymentResult payment(PaymentRequest paymentRequest) {
		List<PaymentItem> paymentItems = paymentMapper.map(paymentRequest);
		PaymentResult paymentResult = new PaymentResult();
		for (Calculator calculator :
						calculators) {
			PaymentResult result = calculator.calculate(paymentItems);
			paymentResult.add(result);
		}
		return paymentResult;
	}
}
