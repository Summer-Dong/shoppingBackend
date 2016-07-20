package cn.gaoyuexiang.model;

public class PaymentItem {
	private Item item;
	private Integer amount;
	private Rule rule;

	public PaymentItem(Item item, int amount) {
		this.item = item;
		this.amount = amount;
	}

	public Item getItem() {
		return item;
	}

	public void setRule(Rule rule) {
		this.rule = rule;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		PaymentItem that = (PaymentItem) o;

		if (getItem() != null ? !getItem().equals(that.getItem()) : that.getItem() != null) return false;
		if (getAmount() != null ? !getAmount().equals(that.getAmount()) : that.getAmount() != null) return false;
		return rule != null ? rule.equals(that.rule) : that.rule == null;

	}

	@Override
	public int hashCode() {
		int result = getItem() != null ? getItem().hashCode() : 0;
		result = 31 * result + (getAmount() != null ? getAmount().hashCode() : 0);
		result = 31 * result + (rule != null ? rule.hashCode() : 0);
		return result;
	}

	public Rule getRule() {
		return rule;
	}
}
