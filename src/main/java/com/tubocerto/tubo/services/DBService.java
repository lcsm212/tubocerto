package com.tubocerto.tubo.services;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tubocerto.tubo.entities.Category;
import com.tubocerto.tubo.entities.Order;
import com.tubocerto.tubo.entities.OrderProduct;
import com.tubocerto.tubo.entities.Payment;
import com.tubocerto.tubo.entities.Product;
import com.tubocerto.tubo.entities.User;
import com.tubocerto.tubo.entities.enums.OrderStatus;
import com.tubocerto.tubo.repositories.CategoryRepository;
import com.tubocerto.tubo.repositories.OrderProductRepository;
import com.tubocerto.tubo.repositories.OrderRepository;
import com.tubocerto.tubo.repositories.ProductRepository;
import com.tubocerto.tubo.repositories.UserRepository;

@Service
public class DBService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderProductRepository orderProductRepository;
	
	public void instantiateTestDatabase() {
			
			Category cat1 = new Category(null, "Trefilação");
			Category cat2 = new Category(null, "Tratamento Témico");
			Category cat3 = new Category(null, "Tratamento Químico");
			Category cat4 = new Category(null, "Endireitamento");
			Category cat5 = new Category(null, "Formação de Ponta");
			Category cat6 = new Category(null, "Inspeção de Processos");
			Category cat7 = new Category(null, "Apontar Parada");
			Category cat8 = new Category(null, "Inventario");
			
			Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
			Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
			Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
			Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
			Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
			
			categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8));
			productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
			
			p1.getCategories().add(cat2);
			p2.getCategories().add(cat1);
			p2.getCategories().add(cat3);
			p3.getCategories().add(cat3);
			p4.getCategories().add(cat3);
			p5.getCategories().add(cat2);
			
			productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
			User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456", "1"); 
			User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456", "1");
			
			Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1); 
			Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2); 
			Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);
			
			userRepository.saveAll(Arrays.asList(u1, u2));
			orderRepository.saveAll(Arrays.asList(o1, o2, o3));
			
			OrderProduct oi1 = new OrderProduct(o1, p1, 2, p1.getPrice()); 
			OrderProduct oi2 = new OrderProduct(o1, p3, 1, p3.getPrice()); 
			OrderProduct oi3 = new OrderProduct(o2, p3, 2, p3.getPrice()); 
			OrderProduct oi4 = new OrderProduct(o3, p5, 2, p5.getPrice());
			
			orderProductRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
			
			Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
			o1.setPayment(pay1);
			
			orderRepository.save(o1);
	}
}
