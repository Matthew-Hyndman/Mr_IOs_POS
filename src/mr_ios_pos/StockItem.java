package mr_ios_pos;

public class StockItem {

	private String itemName;
	private int id, noInStock;
	private double cost, sellingPrice, markUp, rrp;
	private boolean is_Mark_Up_Percent;

	/*
	 * markUp - is in reference to what is added on to of the cost price
	 * 
	 * rrp (recommended retail price) - the manufatuere's recommend max price
	 * 
	 * cost - the purchase price to have in stock
	 */

	public StockItem() {
            this.id = 0;
            this.itemName = "";
            this.noInStock = 0;
            this.sellingPrice = 0;
            this.cost = 0;
            this.markUp = 0;
            this.is_Mark_Up_Percent = true;
            this.rrp = 0;
	}

    public StockItem(int id, String itemName, int noInStock, double sellingPrice, double cost, double markUp,
            boolean is_Mark_Up_Percent, double rrp) {
        this.id = id;
        this.itemName = itemName;
        this.noInStock = noInStock;
        this.sellingPrice = sellingPrice;
        this.cost = cost;
        this.markUp = markUp;
        this.is_Mark_Up_Percent = is_Mark_Up_Percent;
        this.rrp = rrp;

    }

	public String isIs_Mark_Up_Percent() {		
		
		if (this.is_Mark_Up_Percent) {
			return "%";
		}
		else {
			return "£";
		}
		
	}

        public  int getId(){
            return id;            
        }
        
        public void setId(int id){
            this.id = id;
        }
        
	public void setIs_Mark_Up_Percent(boolean is_Mark_Up_Percent) {
		this.is_Mark_Up_Percent = is_Mark_Up_Percent;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public double getMarkUp() {
		return markUp;
	}

	public void setMarkUp(double markUp) {
		this.markUp = markUp;
	}

	public double getRrp() {
		return rrp;
	}

	public void setRrp(double rrp) {
		this.rrp = rrp;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getNoInStock() {
		return noInStock;
	}

	public void setNoInStock(int noInStock) {
		this.noInStock = noInStock;
	}

	public double getPrice() {
		return sellingPrice;
	}

	public void setPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public String toStringHeader() {
		String string = String.format("%50s%10s%10s%10s%6s%6%10s", "Item Name", "Sell Price", "Stock", "Cost", "MarkUp", "%/�",
				"RRP");
		return string;
	}

	public String toString() {
		String markUpTypeString;
		
		if (this.is_Mark_Up_Percent) {
			markUpTypeString = "%";
		}
		else {
			markUpTypeString = "�";
		}
		
		String string = String.format("%50s%10s%10s%10s%6s%6s%10s", this.itemName, this.sellingPrice, this.noInStock,
				this.cost, this.markUp, markUpTypeString, this.rrp);
		return string;
	}
}
