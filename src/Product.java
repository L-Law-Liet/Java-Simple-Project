import java.io.Serializable;

public class Product implements Serializable {
    private String productName, category;
    private double price;
    private Discount discount;

    public Product(){}
    public Product(String productName, String category, double price, Discount discount) {
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.discount = discount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double priceForSale(double d, double p){
        p = p*(100-d)/100;
        return p;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                '}';
    }
}
