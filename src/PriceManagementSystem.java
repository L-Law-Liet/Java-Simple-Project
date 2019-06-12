import java.io.*;
import java.util.ArrayList;

public class PriceManagementSystem {
    private ArrayList<Product> products = new ArrayList<>();

    public PriceManagementSystem(){}
    public PriceManagementSystem(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
    int amount;
    public boolean Check(String name, String category){
        for (int i=0; i<products.size(); i++){
            if (products.get(i).getProductName().equals(name) && products.get(i).getCategory().equals(category)){
                System.out.println("Same product");
                return false;
            }
        }
        return true;
    }

    public void AddProduct(Product product){
        products.add(product);
        System.out.println("Added");
    }

    public void RP(String n, String c){
        byte b =0;
        for (int i = 0; i<products.size(); i++){
            if (products.get(i).getProductName().equals(n) && products.get(i).getCategory().equals(c)){
                products.remove(i);
                b=1;
                System.out.println("Removed");
                break;
            }
        }
        if (b!=1){
            System.out.println("Product doesn't exist!");
        }
    }

    public void FP(String n, String c){
        byte b= 1;
        for (int i=0; i<products.size(); i++){
            if(products.get(i).getProductName().equals(n) && products.get(i).getCategory().equals(c)){
                b=0;
                System.out.println(products.get(i).toString()+", Price for Sale:" +
                        products.get(i).priceForSale(products.get(i).getDiscount().getPercent(), products.get(i).getPrice()));
            }
        }
        if (b==1){
            System.out.println("Not found");}
    }
    public void Print(){
        for (int i=0; i<products.size(); i++){
            System.out.println("Product №"+(i+1)+ " " +products.get(i).toString()+ ", Price for Sale:" +
                    products.get(i).priceForSale(products.get(i).getDiscount().getPercent(), products.get(i).getPrice()));
        }
    }

    public void SF(){
        try {
            FileOutputStream fos = new FileOutputStream("L.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (int i=0; i<products.size(); i++){
                oos.writeObject(products.get(i));
                amount = i;
            }
            System.out.println("Saved!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void RF(){
        try {
            FileInputStream fis = new FileInputStream("L.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            products.clear();
            for (int i=0; i<=amount; i++){
                Product product;
                product = (Product) ois.readObject();
                products.add(product);
            }
            System.out.println("Read!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
