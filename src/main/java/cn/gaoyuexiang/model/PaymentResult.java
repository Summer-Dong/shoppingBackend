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

	public void add(PaymentResult other) {

	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		PaymentResult result = (PaymentResult) o;

		if (Double.compare(result.getSale(), getSale()) != 0) return false;
		if (Double.compare(result.getTotal(), getTotal()) != 0) return false;
		if (getResultItems() != null ? !getResultItems().equals(result.getResultItems()) : result.getResultItems() != null)
			return false;
		return getNoSaleItems() != null ? getNoSaleItems().equals(result.getNoSaleItems()) : result.getNoSaleItems() == null;

	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = getResultItems() != null ? getResultItems().hashCode() : 0;
		result = 31 * result + (getNoSaleItems() != null ? getNoSaleItems().hashCode() : 0);
		temp = Double.doubleToLongBits(getSale());
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(getTotal());
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
}
