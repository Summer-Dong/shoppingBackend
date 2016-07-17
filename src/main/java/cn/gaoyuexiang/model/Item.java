package cn.gaoyuexiang.model;

public class Item {

	private String barcode;
	private String name;
	private String unit;
	private String category;
	private String subCategory;
	private Double price;

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
