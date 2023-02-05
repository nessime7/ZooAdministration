package com.ZooAdministration.model.customers;

public class Kids implements Customers {

    private final int ticketCost;

    public Kids(int ticketCost) {
        this.ticketCost = ticketCost;
    }

    @Override
    public int getTicketCosts() {
        return ticketCost;
    }
}
