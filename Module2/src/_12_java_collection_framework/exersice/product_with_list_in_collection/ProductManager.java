package _12_java_collection_framework.exersice.product_with_list_in_collection;

import java.util.*;

public class ProductManager extends Product {
    private static int countId = 0;
    private static List<Product> listProduct = new ArrayList<>();
    ProductManager(){

    }

    ProductManager(String name, int price){
        super(++countId,name,price);
    }

    public void displayProduct() {
        for (Product p: listProduct) {
            System.out.print("ID: "+p.getId());
            System.out.print(", Name: " + p.getName());
            System.out.println(", Price: "+p.getPrice());
        }
    }

    private Scanner getScanner(){
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }

    public void createProduct() {
        Product product = new Product();
        System.out.println("Enter Name: ");
        product.setName(getScanner().nextLine());
        product.setId(++countId);
        System.out.println("Enter Price: ");
        product.setPrice(getScanner().nextInt());
        listProduct.add(product);
    }

    public void uploadProduct(){
        System.out.println("Enter product id to upload: ");
        int idEdit = getScanner().nextInt();
        boolean isId = true;
        for (Product p : listProduct){
            if (idEdit == p.getId() && listProduct.size() > 0){
                System.out.println("Id: " + p.getId() + ", Name: " + p.getName() + ", Price: " + p.getPrice());
                System.out.println("Enter new name for " + p.getName() + " : ");
                String setName = getScanner().nextLine();
                if (setName.equals("")) {
                    p.setName(p.getName());
                }else {
                    p.setName(setName);
                }
                System.out.println("Enter 0 to save old price. \nEnter new price for " + p.getName() + " : ");
                int setPrice = getScanner().nextInt();
                if (setPrice == 0) {
                    p.setPrice(p.getPrice());
                }else {
                    p.setPrice(setPrice);
                }
                isId = true;
                break;
            }else {
                isId = false;
            }
        }
        if (!isId){
            System.out.println("Don't have this id.");
            getNext();
        }
    }

    public void deleteProduct() {
        System.out.println("Enter product id to delete: ");
        int idDelete = getScanner().nextInt();
        boolean isId = true;
        for (Product p : listProduct){
            if (idDelete == p.getId()){
                System.out.println("Id: " + p.getId() + ", Name: " + p.getName() + ", Price: " + p.getPrice());
                System.out.println("Do you want to delete?\n1. Yes, 2. No.");
                int numChose = getScanner().nextInt();
                if (numChose == 1){
                    listProduct.remove(p);
                    System.out.println("Deleted");
                    getNext();
                    isId = true;
                }else {
                    break;
                }
                break;
            }else {
                isId = false;
            }
        }
        if (!isId){
            System.out.println("Didn't delete");
            getNext();
        }
    }

    public void getNext() {
        System.out.println("Enter to next.");
        getScanner().nextLine();
    }

    public void searchProduct() {
        System.out.println("Enter product name to delete: ");
        String nameSearch = getScanner().nextLine();
        for (Product p : listProduct) {
            if (p.getName().contains(nameSearch)){
                System.out.println("Id: " + p.getId() + ", Name: " + p.getName() + ", Price: " + p.getPrice());
                getNext();
            }
        }
    }

    public void getSort() {
        PriceComparator priceComparator = new PriceComparator();
        Collections.sort(listProduct, priceComparator);
        Stack<Product> myStack = new Stack<>();
        System.out.println("Do you want to show sorting up or down?\n1. Up, 2. Down");
        int numChose = getScanner().nextInt();
        if (numChose == 1) {
            for (Product p : listProduct) {
                System.out.println("Id: " + p.getId() + ", Name: " + p.getName() + ", Price: " + p.getPrice());
            }
        }else {
            for (Product p : listProduct) {
                myStack.push(p);
            }
            for (int i = 0; i < listProduct.size(); i++) {
                Product p = myStack.pop();
                System.out.println("Id: " + p.getId() + ", Name: " + p.getName() + ", Price: " + p.getPrice());
            }
        }
    }
}
