package com.kodilla.good.patterns.challenges;

public class OrderProcessor {

    private final InformationService informationService;
    private final ProductOrderService productOrderService;

    public OrderProcessor(final InformationService informationService, final ProductOrderService productOrderService) {
        this.productOrderService = productOrderService;
        this.informationService = informationService;
    }

    public void process(OrderRequest orderRequest) {
        User buyer = orderRequest.buyer();
        User seller = orderRequest.seller();
        Product product = orderRequest.product();
        Payment payment = orderRequest.payment();
        Delivery delivery = orderRequest.delivery();

        boolean orderConfirmed = productOrderService.order(buyer, seller, product, payment,delivery);
        if (orderConfirmed) {
            informationService.sendMessage(buyer, "Your " + product.getName() + " will be delivered in " +
                    delivery.getDeliveryTime(product) + " days.");
            informationService.sendMessage(seller, product.getName() +  " is ordered. Payment with " +
                    payment.getNameOfPaymentMethod() + " succesful. Delivery method: " + delivery.getNameOfDeliveryMethod());
        } else {
            informationService.sendMessage(buyer, "Your order has been rejected.");
        }
    }

}
