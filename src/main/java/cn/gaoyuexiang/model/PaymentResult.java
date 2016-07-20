package cn.gaoyuexiang.model;

import java.util.List;

public class PaymentResult {
	private List<ResultItem> resultItems;
	private List<ThreeForTwoItem> threeForTwoItems;
	private double sale;
	private double total;

	public List<ResultItem> getResultItems() {
		return resultItems;
	}

	public List<ThreeForTwoItem> getThreeForTwoItems() {
		return threeForTwoItems;
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
		return getThreeForTwoItems() != null ? getThreeForTwoItems().equals(result.getThreeForTwoItems()) : result.getThreeForTwoItems() == null;

	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = getResultItems() != null ? getResultItems().hashCode() : 0;
		result = 31 * result + (getThreeForTwoItems() != null ? getThreeForTwoItems().hashCode() : 0);
		temp = Double.doubleToLongBits(getSale());
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(getTotal());
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
}
