package cn.gaoyuexiang.model;

import java.util.List;

public class PaymentResult {
	private List<ResultItem> resultItems;
	private List<NoSaleItem> noSaleItems;
	private double sale;
	private double total;

	public List<ResultItem> getResultItems() {
		return resultItems;
	}

	public List<NoSaleItem> getNoSaleItems() {
		return noSaleItems;
	}

	public double getSale() {
		return sale;
	}

	public double getTotal() {
		return total;
	}
}
