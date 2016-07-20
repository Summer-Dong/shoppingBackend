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
	
}
