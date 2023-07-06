package org.example;

import org.example.domain.*;
import org.example.domain.enums.ClientType;
import org.example.domain.enums.StatePayment;
import org.example.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;


@SpringBootApplication
public class App  implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }

    public void run(String ...args) throws Exception {
        Category cat1 = new Category(null, "Informática");
        Category cat2 = new Category(null, "Escritório");

        Product p1 = new Product(null, "Computador", 2000.00);
        Product p2 = new Product(null, "Impressora", 800.00);
        Product p3 = new Product(null, "Mouse", 80.00);

        cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProducts().addAll(Arrays.asList(p2));

        p1.getCategories().addAll(Arrays.asList(cat1));
        p2.getCategories().addAll(Arrays.asList(cat1, cat2));
        p3.getCategories().addAll(Arrays.asList(cat1));


        categoryRepository.saveAll(Arrays.asList(cat1, cat2));
        productRepository.saveAll(Arrays.asList(p1, p2, p3));


        State est1 = new State(null, "Minas Gerais");
        State est2 = new State(null, "São Paulo");

        City c1 = new City(null, "Uberlandia", est1);
        City c2 = new City(null, "São Paulo", est2);
        City c3 = new City(null, "Campinas", est2);

        est1.getCities().addAll(Arrays.asList(c1));
        est2.getCities().addAll(Arrays.asList(c2, c3));

        stateRepository.saveAll(Arrays.asList(est1, est2));
        cityRepository.saveAll(Arrays.asList(c1, c2, c3));

        Client client1 = new Client(null, "Maria silva", "maria@gmail.com", "339595487", ClientType.PESSOAFISICA );
        client1.getTelefones().addAll(Arrays.asList("123123321", "2548464"));

        Address address1 = new Address(null, "Rua Flores", "300", "Apto 303", "Jardim", "337833", client1, c1);
        Address address2 = new Address(null, "Avenida Matos", "105", "Sala 800", "Centro", "213213", client1, c2);

        client1.getAddresses().addAll(Arrays.asList(address1, address2));

        clientRepository.saveAll(Arrays.asList(client1));
        addressRepository.saveAll(Arrays.asList(address1, address2));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        PurchaseOrder ped1 = new PurchaseOrder(null, sdf.parse("30/09/2017 10:32"), client1, address1);
        PurchaseOrder ped2 = new PurchaseOrder(null, sdf.parse("10/10/2017 19:35"), client1, address2);

        Payment pagto1 = new CardPayment(null, StatePayment.QUITADO, ped1, 6);
        ped1.setPayment(pagto1);

        Payment pagto2 = new TicketPayment(null, StatePayment.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
        ped2.setPayment(pagto2);

        client1.getOrders().addAll(Arrays.asList(ped1, ped2));

        purchaseOrderRepository.saveAll(Arrays.asList(ped1, ped2));
        paymentRepository.saveAll(Arrays.asList(pagto1, pagto2));

        OrderItem ip1 = new OrderItem(ped1, p1, 0.00, 1, 2.000);
        OrderItem ip2 = new OrderItem(ped1, p3, 0.00, 2, 80.00);
        OrderItem ip3 = new OrderItem(ped2, p2, 100.00, 1, 800.00);

        ped1.getItems().addAll(Arrays.asList(ip1, ip2));
        ped2.getItems().addAll(Arrays.asList(ip3));

        p1.getItems().addAll(Arrays.asList(ip1));
        p2.getItems().addAll(Arrays.asList(ip2));
        p3.getItems().addAll(Arrays.asList(ip3));

        orderItemRepository.saveAll(Arrays.asList(ip1, ip2, ip3));

    }
}
