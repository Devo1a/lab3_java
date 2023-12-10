import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Avialib {
    public static class Customer {
        private String fio;
        private String tel;
        private String date;
        private String address;

        public Customer(String fio, String tel, String date, String address) {
            this.fio = fio;
            this.tel = tel;
            this.date = date;
            this.address = address;
        }

        public String getFio() {
            return fio;
        }

        public String getTel() {
            return tel;
        }

        public String getDate() {
            return date;
        }

        public String getAddress() {
            return address;
        }
    }

    public static class Order {
        private String company_name;
        private String distributor;
        int price;
        int ticked_id;

        public Order(String company_name, String distributor, int price, int ticked_id) {
            this.company_name = company_name;
            this.distributor = distributor;
            this.price = price;
            this.ticked_id = ticked_id;
        }

        public String getCompany() {
            return company_name;
        }

        public String getDistributor() {
            return distributor;
        }

        public int getPrice() {
            return price;
        }

        public int getTickedID() {
            return ticked_id;
        }
    }

    public static class Ticket {
        private String depart;
        private String destination;
        private String distributor;
        private int price;
        private int ticket_id;
        private String fio;

        public Ticket(String depart, String destination, String distributor, int price, int ticket_id, String fio) {
            this.depart = depart;
            this.destination = destination;
            this.distributor = distributor;
            this.price = price;
            this.ticket_id = ticket_id;
            this.fio = fio;
        }

        public String getDepart() {
            return depart;
        }

        public String getDestination() {
            return destination;
        }

        public String getDistributor() {
            return distributor;
        }

        public int getPrice() {
            return price;
        }

        public int getTicketID() {
            return ticket_id;
        }

        public String getFio() {
            return fio;
        }
    }

    public static class Operation {
        private String ticket_operation;
        private String operation_date;
        private int ticket_id;
        private String tel;

        public Operation(String ticket_operation, String operation_date, int ticket_id, String tel) {
            this.ticket_operation = ticket_operation;
            this.operation_date = operation_date;
            this.ticket_id = ticket_id;
            this.tel = tel;
        }

        public String getOperation() {
            return ticket_operation;
        }

        public String getOperationDate() {
            return operation_date;
        }

        public int getTicketID() {
            return ticket_id;
        }

        public String getTel() {
            return tel;
        }
    }

    public static class AviaDataBase {
        private List<Customer> customers;
        private List<Order> orders;
        private List<Ticket> tickets;
        private List<Operation> operations;
        private Scanner in;  // Добавлен Scanner как поле класса

        public AviaDataBase() {
            customers = new ArrayList<>();
            orders = new ArrayList<>();
            tickets = new ArrayList<>();
            operations = new ArrayList<>();
            in = new Scanner(System.in);  // Инициализация Scanner в конструкторе
        }

        public void addCustomer(Customer customer) {
            customers.add(customer);
        }

        public void addOrder(Order order) {
            orders.add(order);
        }

        public void addTicket(Ticket ticket) {
            tickets.add(ticket);
        }

        public void addOperation(Operation operation) {
            operations.add(operation);
        }

        public void printCustomerList() {
            if (customers.isEmpty()) {
                System.out.println("Список пользователей пуст");
            } else {
                System.out.println("Список пользователей:");
                System.out.println("----------------------------------");
                for (Customer customer : customers) {
                    System.out.println("ФИО: " + customer.getFio());
                    System.out.println("Телефон: " + customer.getTel());
                    System.out.println("Дата рождения: " + customer.getDate());
                    System.out.println("Адрес: " + customer.getAddress());
                    System.out.println("----------------------------------");
                }
            }
        }

        public void printTicketList() {
            if (tickets.isEmpty()) {
                System.out.println("Список билетов пуст");
            } else {
                System.out.println("Список билетов:");
                System.out.println("----------------------------------");
                for (Ticket ticket : tickets) {
                    System.out.println("ФИО: " + ticket.getFio());
                    System.out.println("Пункт отправления: " + ticket.getDepart());
                    System.out.println("Пункт прибытия: " + ticket.getDestination());
                    System.out.println("Дистрибьютор: " + ticket.getDistributor());
                    System.out.println("Цена: " + ticket.getPrice());
                    System.out.println("ID билета: " + ticket.getTicketID());
                    System.out.println("----------------------------------");
                }
            }
        }

        public void printOrderList() {
            if (orders.isEmpty()) {
                System.out.println("Список заказов пуст");
            } else {
                System.out.println("Список заказов:");
                System.out.println("----------------------------------");
                for (Order order : orders) {
                    System.out.println("Фирма: " + order.getCompany());
                    System.out.println("Дистрибьютор: " + order.getDistributor());
                    System.out.println("Цена: " + order.getPrice());
                    System.out.println("ID билета: " + order.getTickedID());
                    System.out.println("----------------------------------");
                }
            }
        }

        public void printOperationList() {
            if (operations.isEmpty()) {
                System.out.println("Список операций пуст");
            } else {
                System.out.println("Список операций:");
                System.out.println("----------------------------------");
                for (Operation operation : operations) {
                    System.out.println("Операция: " + operation.getOperation());
                    System.out.println("Дата операции: " + operation.getOperationDate());
                    System.out.println("ID билета: " + operation.getTicketID());
                    System.out.println("Телефон: " + (operation.getTel().isEmpty() ? "Нет данных" : operation.getTel()));
                    System.out.println("----------------------------------");
                }
            }
        }

        public Customer inputCustomerFromUser() {
            String fio;
            String tel;
            String date;
            String address;
            try {
                System.out.println("Введите ФИО: ");
                fio = in.nextLine();
                System.out.println("Введите номер телефона: ");
                tel = in.nextLine();
                System.out.println("Введите дату рождения: ");
                date = in.nextLine();
                System.out.println("Введите адрес: ");
                address = in.nextLine();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            return new Customer(fio, tel, date, address);
        }

        public Order inputOrderFromUser() {
            String company_name;
            String distributor;
            int price;
            int ticked_id;
            try {
                System.out.println("Введите название компании: ");
                company_name = in.nextLine();
                System.out.println("Введите дистрибьютора: ");
                distributor = in.nextLine();
                System.out.println("Введите цену: ");
                price = in.nextInt();
                System.out.println("Введите ID билета: ");
                ticked_id = in.nextInt();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            return new Order(company_name, distributor, price, ticked_id);
        }

        public Ticket inputTicketFromUser() {
            String depart;
            String destination;
            String distributor;
            int price;
            int ticket_id;
            String fio;
            try {
                System.out.println("Введите ФИО: ");
                fio = in.nextLine();
                System.out.println("Введите место отправления: ");
                depart = in.nextLine();
                System.out.println("Введите место прибытия: ");
                destination = in.nextLine();
                System.out.println("Введите дистрибьютора: ");
                distributor = in.nextLine();
                System.out.println("Введите цену: ");
                price = in.nextInt();
                System.out.println("Введите ID билета: ");
                ticket_id = in.nextInt();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            return new Ticket(depart, destination, distributor, price, ticket_id, fio);
        }

        public Operation inputOperationFromUser() {
            String ticket_operation;
            String operation_date;
            int ticket_id;
            String tel;
            try {
                System.out.println("Введите операцию: ");
                ticket_operation = in.nextLine();
                System.out.println("Введите дату операции: ");
                operation_date = in.nextLine();
                System.out.println("Введите ID билета: ");
                ticket_id = Integer.parseInt(in.nextLine());
                System.out.println("Введите телефон: ");
                tel = in.nextLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            return new Operation(ticket_operation, operation_date, ticket_id, tel);
        }

        public void closeScanner() {
            in.close();
        }
    }

    public static void main(String[] args) {
        AviaDataBase aviaDataBase = new AviaDataBase();

        Customer customer1 = aviaDataBase.inputCustomerFromUser();
        aviaDataBase.addCustomer(customer1);

        Order order1 = aviaDataBase.inputOrderFromUser();
        aviaDataBase.addOrder(order1);

        Ticket ticket1 = aviaDataBase.inputTicketFromUser();
        aviaDataBase.addTicket(ticket1);

        Operation operation1 = aviaDataBase.inputOperationFromUser();
        aviaDataBase.addOperation(operation1);

        aviaDataBase.printCustomerList();
        aviaDataBase.printOrderList();
        aviaDataBase.printTicketList();
        aviaDataBase.printOperationList();

        aviaDataBase.closeScanner();  // Закрыть Scanner после использования
    }
}
