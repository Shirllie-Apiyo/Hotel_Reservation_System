public class MpesaService {
    public String processPayment(String phoneNumber, double amount) {
        // Simulate API Call
        System.out.println("Payment of KES " + amount + " processed for phone: " + phoneNumber);
        return "Payment Successful!";
    }
}
