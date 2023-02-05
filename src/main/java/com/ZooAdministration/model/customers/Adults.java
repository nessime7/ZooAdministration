package com.ZooAdministration.model.customers;

public class Adults implements Customers {

    private final int ticketCost;

    public Adults(int ticketCosts) {
        this.ticketCost = ticketCosts;
    }

    @Override
    public int getTicketCosts() {
        return ticketCost;
    }

}
