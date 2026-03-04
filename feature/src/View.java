import java.util.Scanner;

public class View {
    public static  void main(String[] args){
        ProductList productList = new ProductList();
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("=========================");

            System.out.println("""
                    1. show Employee
                    2. add Employee
                    3. update Employee
                    4. delete Employee
                    """);
            System.out.print("please choose the option : ");
            String op = sc.nextLine();
            switch (op){
                case "1" :
                {
                    System.out.println("========show item============");
                    productList.showProducts();
                    break;
                }
                case "2" :{
                    System.out.println("========add item=======");
                    productList.addProduct();

                    break;
                }
                case "3" :{
                    System.out.println("=====update item=======");
                    productList.updateProduct();
                    break;
                }
                case "4" :{
                    System.out.println("=====delete item=======");
                    productList.deleteProduct();
                    break;
                }
                default: {
                    System.out.println("Invalid choice");
                }

            }

        }while (true) ;

    }
}
