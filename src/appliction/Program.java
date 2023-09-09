package appliction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdfIn = new SimpleDateFormat("dd/MM/yyyy");
		List<Product> list = new ArrayList<Product>();
		
		System.out.print("Enter the number of products: ");
		int N = sc.nextInt();
		
		for (int i = 1; i <= N; i++) {
			System.out.printf("Product #%d data: %n", i);
			System.out.print("Common, used or imported (c/u/i): ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			if (ch == 'i') {
				System.out.print("Customs: ");
				double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
			} else if (ch == 'u') {
				System.out.print("Manufature date (dd/MM/yyyy): ");
				Date date = sdfIn.parse(sc.next());
				list.add(new UsedProduct(name, price, date));
			} else {
				list.add(new Product(name, price));
			}			
		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		for(Product product : list) {
			System.out.println(product.priceTag());
		}
		
		sc.close();
	}

}
