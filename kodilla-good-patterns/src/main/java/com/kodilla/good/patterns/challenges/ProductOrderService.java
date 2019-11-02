package com.kodilla.good.patterns.challenges;

public class ProductOrderService
{
    private InformationService informationService;
    private OrderService orderService;
    private OrderRepository orderRepository;

    public ProductOrderService(final InformationService informationService,
                               final OrderService orderService,
                               final OrderRepository orderRepository)
    {
        this.informationService = informationService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    public OrderDTO process(final OrderRequest orderRequest)
    {
        boolean isOrdered = orderService.order(orderRequest.getCustomer(), orderRequest.getProduct(),
                orderRequest.getDate());

        if (isOrdered)
        {
            String information = "your order has been placed.";
            informationService.inform(orderRequest.getCustomer(), information); // added functionality
            orderRepository.createOrder(orderRequest.getCustomer(), orderRequest.getProduct(), orderRequest.getDate());
            return new OrderDTO(orderRequest, true); // added scope of DTO
        }
        else
        {
            return new OrderDTO(orderRequest, false);
        }
    }
}
