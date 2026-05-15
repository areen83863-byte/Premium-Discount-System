public class DiscountCalculator {
    public double calculateDiscount(String customerType, int totalOrdersInLastYear, boolean isSubscribedToNewsletter) {
        
      
        if ("NEW".equals(customerType) && totalOrdersInLastYear >= 10) {
            throw new IllegalArgumentException("Infeasible: NEW customers cannot have 10 or more orders.");
        }

        double discount = 5.0; 

        
        if (isSubscribedToNewsletter) {
            discount += 2.0;
        }

      
        switch (customerType) {
            case "REGULAR":
                discount += 3.0;
                break;
            case "PREMIUM":
                discount += 5.0;
                break;
            case "NEW":
            default:
                discount += 0.0;
                break;
        }

        
        if (totalOrdersInLastYear >= 10) {
            discount += 5.0;
        }

       
        if (discount > 15.0) {
            discount = 15.0;
        }

        return discount;
    }
}
