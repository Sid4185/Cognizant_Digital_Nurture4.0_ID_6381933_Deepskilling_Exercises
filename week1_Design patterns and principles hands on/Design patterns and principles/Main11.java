interface CustomerRepository {
    String findCustomerById(String id);
}

class CustomerRepositoryImpl implements CustomerRepository {
    public String findCustomerById(String id) {
        return "Customer: " + id;
    }
}

class CustomerService {
    private CustomerRepository repo;
    public CustomerService(CustomerRepository repo) { this.repo = repo; }
    public void displayCustomer(String id) {
        System.out.println(repo.findCustomerById(id));
    }
}

public class Main11 {
    public static void main(String[] args) {
        CustomerRepository repo = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repo);
        service.displayCustomer("123");
    }
}
