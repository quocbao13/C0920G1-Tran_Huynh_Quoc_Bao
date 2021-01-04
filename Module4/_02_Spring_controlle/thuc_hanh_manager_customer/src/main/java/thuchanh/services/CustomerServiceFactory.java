package thuchanh.services;

public class CustomerServiceFactory {
    private static CustomerService singleton;

    public static synchronized CustomerService getInstance() {
        if (singleton == null) {
            singleton = new CustomerService();
        }
        return singleton;
    }
}
