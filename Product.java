package Exam1;
public class Product {

    private static final double TAX_RATE_STATE = 0.100; // 10.0%
    private static final double TAX_RATE_CITY =  0.015; // 1.5%
    private static final double AD_FEES_PERCENTAGE = 0.03; // 3.0%

    private double purchasePrice;
    private double sellingPrice;
    private int inventoryQuantity;

    /**
     * Product Constructor
     */
    public Product(double purchasePrice, double sellingPrice, int inventoryQuantity){
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
        this.inventoryQuantity = inventoryQuantity;
    }

    public double getSellingPrice() {return sellingPrice;}
	
    public void setSellingPrice(double sellingPrice) {
         this.sellingPrice = sellingPrice;}
	
    public int getInventory() {return inventoryQuantity;}

	public void setInventory(int inventory) {
		this.inventoryQuantity = inventory;}
	
	
	/**
     * Returns the price markup of the Product
     */
    public double getMarkup() {
        return sellingPrice - purchasePrice;
    }

    /**
     * Returns the markup % (markup/purchase price)
     */
    public double getPercentMarkup() {
        return (getMarkup() / purchasePrice) * 100;
    }
	
    /**
     * Returns the profit margin % (markup/selling price)
     */
    public double getPercentProfitMargin() {
        return (getMarkup() / sellingPrice) * 100;
    }
	
    /**
     * Returns a new selling price based on a specific markup.
     */
    public void setNewSellingPrice(int percentMarkupGoal){
        this.sellingPrice =  purchasePrice * (1.0 + percentMarkupGoal/100);
    }	
    
    
    /**
     * Increases the inventory quantity by the given amount.
     */
    public void addInventory(int quantity) {
    	this.inventoryQuantity += quantity;
    }
    
    
    /**
     *  Returns the total cost value of the current inventory
     */
    public double getValueOfInventory() {
    	return this.purchasePrice * this.inventoryQuantity;
    }
    
    /**
     *  Returns the total revenue value of the current inventory
     */
    public double getPotentialRevenue() {
    	return this.sellingPrice * this.inventoryQuantity;
    }   
    
    
   /** 
    *  Exercise #1
    *  Returns the total amount paid for one unit of the target
    *  product, including City & State taxes.
    *  Hint: See the constants provided for tax rates.
    */
   public double getTotalCostWithTax(){
	   double state= this.sellingPrice*TAX_RATE_STATE;
	   double city= this.sellingPrice*TAX_RATE_CITY;
       return this.sellingPrice + city + state;
    }

  
    
   /**  
     *  Exercise #2
     *  Updates a product's selling price.  Given a total amount to be paid 
     *  that includes taxes, set the selling price to the corresponding price 
     *  before taxes.
     *  
     */
    public void setPriceBeforeTax(double totalWithTax){
        this.sellingPrice=totalWithTax/(1+TAX_RATE_CITY + TAX_RATE_STATE);
       
        
    	
    }


	
    /**  
     *  Exercise #3
     *  Returns the net profit from selling one unit of the target product 
     *  after subtracting the purchase price and the advertising fees 
     *  (see constants) from its selling price. The fees are a constant 
     *  percentage applied to the product's purchase price.
     */
    public double getNetProfit(){
	double NetProfit= this.sellingPrice-(this.purchasePrice + this.purchasePrice*AD_FEES_PERCENTAGE);
		return NetProfit; // Dummy return
    }
    
    
    /**
     *  Exercise #4
     *  Reduces the inventory quantity of the target product by the given 
     *  quantity or sets the inventory to zero if the remaining inventory
     *  is less than the parameter quantity.
     *  
     */
    public void subtractInventory(int quantity) {
    	if(this.inventoryQuantity-quantity<quantity) {
    		this.inventoryQuantity=0;
    	}
    	else this.inventoryQuantity-=quantity;
    }    
 
    
    /**
     * Exercise #5
     * Returns the potential total profit of all available units of the target 
     * product by considering the total cost value and the total revenue value
     * (without taxes) of the current available inventory.  It also considers 
     * (includes) the advertising fees.
     * 
     * HINT: Check if you can use any of the given helper methods
     */
    public double getPotentialProfit() {
		return this.getPotentialRevenue()*this.getTotalCostWithTax() - this.sellingPrice*AD_FEES_PERCENTAGE; 
		// Dummy return
    }
    
}