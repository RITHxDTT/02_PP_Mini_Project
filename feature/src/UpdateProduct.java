import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateProduct {

    public void updateProductAllField() {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try (Connection connection = DbConncetion.getConnection();
             Scanner sc = new Scanner(System.in)) {

            System.out.print("Please Input Id: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Input update Name: ");
            String name = sc.nextLine();

            System.out.print("Input Update price: ");
            double unitPrice = sc.nextDouble();

            System.out.print("Input Update quantity: ");
            int qty = sc.nextInt();

            String update = """
                    UPDATE products
                    SET name = ?,
                        unitprice = ?,
                        qty = ?
                    WHERE id = ?
                    """;

            PreparedStatement ps = connection.prepareStatement(update);

            ps.setString(1, name);
            ps.setDouble(2, unitPrice);
            ps.setInt(3, qty);
            ps.setInt(4, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Product updated successfully!");
            } else {
                System.out.println("Invalid product id (" + id + ")");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void updateProductName() {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try (Connection connection = DbConncetion.getConnection();
             Scanner sc = new Scanner(System.in)) {

            System.out.print("Please Input Id: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Input update Name: ");
            String name = sc.nextLine();


            String update = """
                    UPDATE products
                    SET name =?
                    WHERE id = ?;
                    """;

            PreparedStatement ps = connection.prepareStatement(update);

            ps.setString(1, name);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Product updated successfully!");
            } else {
                System.out.println("Invalid product id (" + id + ")");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void updateProductUnitPrice() {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try (Connection connection = DbConncetion.getConnection();
             Scanner sc = new Scanner(System.in)) {

            System.out.print("Please Input Id: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Input update UnitPrice: ");
            double unitprice = sc.nextDouble();
            sc.nextLine();


            String update = """
                    UPDATE products
                    SET unitprice =?
                    WHERE id = ?;
                    """;

            PreparedStatement ps = connection.prepareStatement(update);

            ps.setDouble(1, unitprice);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Product updated successfully!");
            } else {
                System.out.println("Invalid product id (" + id + ")");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void updateProductQty() {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try (Connection connection = DbConncetion.getConnection();
             Scanner sc = new Scanner(System.in)) {

            System.out.print("Please Input Id: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Input update Qty: ");
            int qty = sc.nextInt();
            sc.nextLine();


            String update = """
                    UPDATE products
                    SET qty =?
                    WHERE id = ?;
                    """;

            PreparedStatement ps = connection.prepareStatement(update);

            ps.setInt(1, qty);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Product updated successfully!");
            } else {
                System.out.println("Invalid product id (" + id + ")");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
