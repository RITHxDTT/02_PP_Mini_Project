import java.sql.*;
import java.util.Scanner;

public class ProductList {


    public void addProduct() {

        Scanner sc = new Scanner(System.in);

        try (Connection con = DbConncetion.getConnection()) {

            String sql = "INSERT INTO products(name, unitprice, qty, importdate) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            System.out.print("Please input Product Name: ");
            String name = sc.nextLine();

            System.out.print("Please input Unit Price: ");
            double unitPrice = sc.nextDouble();
            sc.nextLine();

            System.out.print("Please input Quantity: ");
            int qty = sc.nextInt();
            sc.nextLine();

            System.out.print("Please input Date (yyyy-mm-dd): ");
            String date = sc.nextLine();

            ps.setString(1, name);
            ps.setDouble(2, unitPrice);
            ps.setInt(3, qty);
            ps.setDate(4, java.sql.Date.valueOf(date));

            int row = ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            int id = 0;
            if (rs.next()) {
                id = rs.getInt(1);
            }

            if (row == 1) {
                System.out.println("Add success! Product ID: " + id);


                Pagination.products.add(
                        new Products(id, name, unitPrice, qty, date)
                );

                Pagination.total++;
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }



    public void updateProduct() {

        Scanner sc = new Scanner(System.in);

        try (Connection con = DbConncetion.getConnection()) {

            String sql = "UPDATE products SET name=?, unitprice=?, qty=?, importdate=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            System.out.print("Please input product id: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("New product name: ");
            String name = sc.nextLine();

            System.out.print("New unit price: ");
            double unitPrice = sc.nextDouble();
            sc.nextLine();

            System.out.print("New quantity: ");
            int qty = sc.nextInt();
            sc.nextLine();

            System.out.print("New date (yyyy-mm-dd): ");
            String date = sc.nextLine();

            ps.setString(1, name);
            ps.setDouble(2, unitPrice);
            ps.setInt(3, qty);
            ps.setDate(4, java.sql.Date.valueOf(date));
            ps.setInt(5, id);

            int row = ps.executeUpdate();

            if (row == 1) {
                System.out.println("Update success");


                for (int i = 0; i < Pagination.products.size(); i++) {

                    if (Pagination.products.get(i).getPrdId() == id) {

                        Pagination.products.set(i,
                                new Products(id, name, unitPrice, qty, date));

                        break;
                    }
                }

            } else {
                System.out.println("ID not found");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }



    public void deleteProduct() {

        Scanner sc = new Scanner(System.in);

        try (Connection con = DbConncetion.getConnection()) {

            String sql = "DELETE FROM products WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            System.out.print("Please input product id to delete: ");
            int id = sc.nextInt();

            ps.setInt(1, id);

            int row = ps.executeUpdate();

            if (row == 1) {
                System.out.println("Delete success");


                for (int i = 0; i < Pagination.products.size(); i++) {

                    if (Pagination.products.get(i).getPrdId() == id) {
                        Pagination.products.remove(i);
                        break;
                    }
                }

                Pagination.total--;

            } else {
                System.out.println("ID not found");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}