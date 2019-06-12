import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner L = new Scanner(System.in);
        PriceManagementSystem pms = new PriceManagementSystem();

        byte choice = -4;
        while (choice != 0) {
            System.out.println("1.Add product");
            System.out.println("2.Remove product");
            System.out.println("3.Find product");
            System.out.println("4.Print all product’s information");
            System.out.println("5.Save products into file");
            System.out.println("6.Read products from file");
            System.out.println("0.Exit");
            choice = L.nextByte();
            switch (choice) {
                case 1:
                    Product product = new Product();
                    System.out.println("Name of Product:");
                    product.setProductName(L.next());
                    System.out.println("Category of Product:");
                    product.setCategory(L.next());
                    if (pms.Check(product.getProductName(), product.getCategory())) {
                        System.out.println("Price of Product:");
                        product.setPrice(L.nextDouble());
                        Discount discount = new Discount();
                        int p = 0;
                        for (int ascii = 'A'; ascii < 'A'+3; ascii++) {
                            char ch = (char) ascii;
                            if (product.getCategory().charAt(0)==(ch)){
                                System.out.println("Percent is " + p);
                                discount.setPercent(p);
                                break;
                            }
                            p+=10;

                        }
                        product.setDiscount(discount);
                        pms.AddProduct(product);
                    }
                    break;
                case 2:

                    System.out.println("Name of Product:");
                    String name = L.next();
                    System.out.println("Category of Product:");
                    String category = L.next();
                    pms.RP(name, category);
                    break;

                case 3:
                    System.out.println("Name of Product:");
                    String n = L.next();
                    System.out.println("Category of Product:");
                    String cat = L.next();
                    pms.FP(n, cat);
                    break;

                case 4:
                    pms.Print();
                    break;
                case 5:
                    pms.SF();
                    break;

                case 6:
                    pms.RF();
                    break;
            }
        }
    }
}
