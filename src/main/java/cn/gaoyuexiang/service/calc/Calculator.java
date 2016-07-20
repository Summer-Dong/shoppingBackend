package cn.gaoyuexiang.service.calc;

import cn.gaoyuexiang.model.PaymentItem;
import cn.gaoyuexiang.model.PaymentResult;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface Calculator {
	PaymentResult calculate(List<PaymentItem> paymentItems);
}
