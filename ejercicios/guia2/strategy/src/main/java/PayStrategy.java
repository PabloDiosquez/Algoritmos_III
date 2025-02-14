import java.io.IOException;

/**
* Common interface for all strategies.
*/
public interface PayStrategy {
    boolean pay(int paymentAmount);
    void collectPaymentDetails() throws IOException;
}
