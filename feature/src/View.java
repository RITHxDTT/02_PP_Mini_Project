import java.util.Scanner;

public class View {
    public static  void main(String[] args){
        ProductList productList = new ProductList();
        Scanner sc = new Scanner(System.in);
        company.dataEmployee();
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
                    company.showEmployee();
                    break;
                }
                case "2" :{
                    System.out.println("========add item=======");
                    company.addEmployee();

                    break;
                }
                case "3" :{
                    System.out.println("=====update item=======");
                    company.updateEmployee();
                    break;
                }
                case "4" :{
                    System.out.println("=====delete item=======");
                    company.deleteEmployee();
                    break;
                }
                default: {
                    System.out.println("Invalid choice");
                }

            }

        }while (true) ;

    }
}
