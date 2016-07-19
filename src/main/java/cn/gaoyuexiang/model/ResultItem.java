package cn.gaoyuexiang.model;

public class ResultItem {
	private String name;
	private String unit;
	private int amount;
	private double price;
	private double save;//判断参加95折的优惠，为0表示未参加

	public ResultItem(String name, String unit, int amount, double price, double save) {
		this.name = name;
		this.unit = unit;
		this.amount = amount;
		this.price = price;
		this.save = save;
	}

	public String getName() {
		return name;
	}

	public String getUnit() {
		return unit;
	}

	public int getAmount() {
		return amount;
	}

	public double getPrice() {
		return price;
	}

	public double getSave() {
		return save;
	}
}
