package inventory;

public class Item {
	private String name;
	private String SKU;
	private int quantity;
	
	public Item(String name, String SKU, int quantity) {
		this.setName(name);
		this.setSKU(SKU);
		this.setQuantity(quantity);
	}

	public  String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSKU() {
		return SKU;
	}

	public void setSKU(String sKU) {
		SKU = sKU;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
