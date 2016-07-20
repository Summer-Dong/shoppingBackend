package cn.gaoyuexiang.model;

import java.text.DecimalFormat;

public class ResultItem {
	private String name;
	private String unit;
	private int amount;
	private double price;
	private double total;
	private String save;//判断参加95折的优惠，为0表示未参加

	public ResultItem(Item item, int amount) {
		this.name = item.getName();
		this.unit = item.getUnit();
		this.price = item.getPrice();
		this.amount = amount;
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

	public String getSave() {
		return save;
	}

	public void setSave(double save) {
		DecimalFormat df = new DecimalFormat("#0.00");
		this.save = "节省" + df.format(save) + "(元)";
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getTotal() {
		return total;
	}
}
