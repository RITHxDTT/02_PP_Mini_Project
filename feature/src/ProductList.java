import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//private int prdId;
//private String prdName;
//private double unitPrice;
//private int qty;
//private String date;

public class ProductList {
   List<Products> products = new ArrayList<>();

    public void addProductClass(){
        Scanner sc = new Scanner(System.in);
        try(Connection con = DbConncetion.getConnection()) {
            String sql = "INSERT INTO products(name, unitprice, qty, importdate) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.print("please input Produce Name  : "); String name = sc.nextLine();
            System.out.print("please input Unite price :"); double unitPrice = sc.nextDouble();sc.nextLine();
            System.out.print("please input quantity : "); int qty = sc.nextInt();sc.nextLine();
            System.out.print("please input your date :"); String date = sc.nextLine();sc.nextLine();

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
            products.add(new Products(id,name,unitPrice,qty, date));
            if(row==1){
                System.out.println("add success");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}

