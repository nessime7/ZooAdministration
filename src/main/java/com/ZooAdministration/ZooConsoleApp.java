package com.ZooAdministration;

import com.ZooAdministration.model.customers.Adults;
import com.ZooAdministration.model.customers.Kids;
import com.ZooAdministration.repository.AnimalsRepository;
import com.ZooAdministration.repository.WorkersRepository;
import com.ZooAdministration.service.ZooProfitableCalculator;

public class ZooConsoleApp {

    public static void main(String[] args) {
        new ZooProfitableCalculator(new AnimalsRepository(), new WorkersRepository(), new Adults(20), new Kids(10)).process();
    }
}
