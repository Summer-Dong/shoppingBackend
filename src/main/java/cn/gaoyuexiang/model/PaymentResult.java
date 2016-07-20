package cn.gaoyuexiang.model;

import cn.gaoyuexiang.serialize.custom.CustomDoubleSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;
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

	@JsonSerialize(using = CustomDoubleSerialize.class)
	public double getSale() {
		return sale;
	}

	public double getTotal() {
		return total;
	}

	public void add(PaymentResult other) {
		if (other.getResultItems() != null) {
			if (this.resultItems == null) this.resultItems = new ArrayList<>(other.getResultItems());
			else this.resultItems.addAll(other.getResultItems());
		}
		if (other.getThreeForTwoItems() != null) {
			if (this.threeForTwoItems == null) this.threeForTwoItems = new ArrayList<>(other.getThreeForTwoItems());
			else if (other.getThreeForTwoItems() != null) this.threeForTwoItems.addAll(other.getThreeForTwoItems());
		}
		this.total += other.getTotal();
		this.sale += other.getSale();
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

	public void setResultItems(List<ResultItem> resultItems) {
		this.resultItems = resultItems;
	}

	public void setThreeForTwoItems(List<ThreeForTwoItem> threeForTwoItems) {
		this.threeForTwoItems = threeForTwoItems;
	}

	public void setSale(double sale) {
		this.sale = sale;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public void addResultItem(ResultItem resultItem) {
		if (this.resultItems == null)
			this.resultItems = new ArrayList<>();
		this.resultItems.add(resultItem);
	}

	public void addThreeForTowItem(ThreeForTwoItem threeForTwoItem) {
		if (this.threeForTwoItems == null)
			this.threeForTwoItems = new ArrayList<>();
		this.threeForTwoItems.add(threeForTwoItem);
	}
}
