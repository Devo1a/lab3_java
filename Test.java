public class Test {
    public static void main(String[] args) {

        Avialib.AviaDataBase aviaDataBase = new Avialib.AviaDataBase();

        Avialib.Customer customer = aviaDataBase.inputCustomerFromUser();
        aviaDataBase.addCustomer(customer);

        Avialib.Order order = aviaDataBase.inputOrderFromUser();
        aviaDataBase.addOrder(order);

        Avialib.Ticket ticket = aviaDataBase.inputTicketFromUser();
        aviaDataBase.addTicket(ticket);

        Avialib.Operation operation = aviaDataBase.inputOperationFromUser();
        aviaDataBase.addOperation(operation);

        aviaDataBase.printCustomerList();
        aviaDataBase.printOrderList();
        aviaDataBase.printTicketList();
        aviaDataBase.printOperationList();
    }
}
