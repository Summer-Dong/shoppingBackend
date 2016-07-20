package cn.gaoyuexiang.model;

public class ThreeForTwoItem {
	private String name;
	private String unit;
	private Integer amount;

	public ThreeForTwoItem(Item item, int amount) {
		this.name = item.getName();
		this.unit = item.getUnit();
		this.amount = amount;
	}

	public Integer getAmount() {
		return amount;
	}

	public String getName() {
		return name;
	}

	public String getUnit() {
		return unit;
	}
}
