package com.ZooAdministration.service;

import com.ZooAdministration.model.animals.Birds;
import com.ZooAdministration.model.animals.Mammals;
import com.ZooAdministration.model.animals.Reptiles;
import com.ZooAdministration.model.customers.Adults;
import com.ZooAdministration.model.customers.Kids;
import com.ZooAdministration.model.workers.Admins;
import com.ZooAdministration.model.workers.Ushers;
import com.ZooAdministration.model.workers.Zookeepers;
import com.ZooAdministration.repository.AnimalsRepository;
import com.ZooAdministration.repository.CostsRepository;
import com.ZooAdministration.repository.RevenueRepository;
import com.ZooAdministration.repository.WorkersRepository;

import java.util.Scanner;

public class ZooProfitableCalculator {

    private final AnimalsRepository animalsRepository;
    private final WorkersRepository workersRepository;
    private final Adults adults;
    private final Kids kids;
    private final RevenueRepository revenueRepository = new RevenueRepository();
    private final CostsRepository costsRepository = new CostsRepository();
    private final Scanner scanner = new Scanner(System.in);

    public ZooProfitableCalculator(AnimalsRepository animalsRepository, WorkersRepository workersRepository, Adults adults, Kids kids) {
        this.animalsRepository = animalsRepository;
        this.workersRepository = workersRepository;
        this.adults = adults;
        this.kids = kids;
    }

    public void process() {
        System.out.println("Welcome to our ZOO");
        while (true) {
            System.out.println("""
                    Choose the option:
                    >>> exit - if you want to exit a program
                    >>> 1. Show all animals
                    >>> 2. Show all workers
                    >>> 3. Calculate revenue
                    >>> 4. Calculate costs
                    >>> 5. Calculate profitability
                    >>> 6. Add worker
                    """);

            String choice = scanner.nextLine();
            switch (choice) {
                case "exit" -> exit();
                case "1" -> printAnimals();
                case "2" -> printWorkers();
                case "3" -> calculateRevenue();
                case "4" -> calculateCosts();
                case "5" -> calculateProfitability();
                case "6" -> addWorker();
            }
        }
    }

    public void calculateProfitability() {
        int revenue = revenueRepository.getRevenue();
        int costs = costsRepository.getCosts();
        int sumOfIncome = revenue - costs;
        System.out.println("!!! The profitability of this case is: " + sumOfIncome);
        if (sumOfIncome > 0) {
            System.out.println(":) The zoo is profitable!\n");
        } else {
            System.out.println(":( The zoo is not profitable!\n");
        }
    }

    private void calculateCosts() {
        int adminsSalarySum = workersRepository.getAdmins().stream()
                .mapToInt(Admins::getSalary).sum();
        System.out.println("- The sum of payments for administration is: " + adminsSalarySum + " PLN");

        int ushersSalarySum = workersRepository.getUshers().stream()
                .mapToInt(Ushers::getSalary).sum();
        System.out.println("- The sum of payments for ushers is: " + ushersSalarySum + " PLN");

        int zookeepersSalarySum = workersRepository.getZookeepers().stream()
                .mapToInt(Zookeepers::getSalary).sum();
        System.out.println("- The sum of payments for zookeepers is: " + zookeepersSalarySum + " PLN");

        int sumOfAllWorkersCosts = adminsSalarySum + ushersSalarySum + zookeepersSalarySum;
        System.out.println("--- The sum of all Workers Costs: " + sumOfAllWorkersCosts + " PLN");

        int birdsCostsSum = animalsRepository.getBirds().stream()
                .mapToInt(Birds::getLivingCosts).sum();
        System.out.println("- The sum of costs of birds is: " + birdsCostsSum + " PLN");

        int mammalsCostsSum = animalsRepository.getMammals().stream()
                .mapToInt(Mammals::getLivingCosts).sum();
        System.out.println("- The sum of costs of mammals is: " + mammalsCostsSum + " PLN");

        int reptilesCostsSum = animalsRepository.getReptiles().stream()
                .mapToInt(Reptiles::getLivingCosts).sum();
        System.out.println("- The sum of costs of mammals is: " + reptilesCostsSum + " PLN");

        int sumOfAllAnimalsCosts = birdsCostsSum + mammalsCostsSum + reptilesCostsSum;
        System.out.println("--- The sum of all animals costs: " + sumOfAllAnimalsCosts + " PLN");
        costsRepository.setCosts(sumOfAllAnimalsCosts+sumOfAllWorkersCosts);
    }

    private void addWorker() {
        System.out.println("""
                Choose the option:
                1. 1. Add admin
                1. 2. Add usher
                1. 3. Add zookeeper
                """
        );
        String choice1 = scanner.nextLine();
        switch (choice1) {
            case "1" -> {
                System.out.println("Enter the name of worker: ");
                String name = scanner.nextLine();
                System.out.println("Enter the salary of worker: ");
                int salary = scanner.nextInt();
                workersRepository.addAdmin(name, salary);
            }
            case "2" -> {
                System.out.println("Enter the name of worker: ");
                String name = scanner.nextLine();
                System.out.println("Enter the salary of worker: ");
                int salary = scanner.nextInt();
                workersRepository.addUsher(name, salary);
            }
            case "3" -> {
                System.out.println("Enter the name of worker: ");
                String name = scanner.nextLine();
                System.out.println("Enter the salary of worker: ");
                int salary = scanner.nextInt();
                workersRepository.addZookeeper(name, salary);
            }
        }
    }

    public void calculateRevenue() {
        System.out.println("Enter the number of sold adults tickets: ");
        int numberOfSoldAdultsTickets = scanner.nextInt();
        int adultResult = numberOfSoldAdultsTickets * adults.getTicketCosts();
        System.out.println("We sold " + numberOfSoldAdultsTickets + " adult tickets.\n+ The revenue from these tickets are " + adultResult + " PLN");
        System.out.println("Enter the number of sold kids tickets: ");
        int numberOfSoldKidsTickets = scanner.nextInt();
        int kidsResult = numberOfSoldKidsTickets * kids.getTicketCosts();
        System.out.println("We sold " + numberOfSoldKidsTickets + " adult tickets.\n+ The revenue from these tickets are " + kidsResult + " PLN");
        int revenue = adultResult + kidsResult;
        System.out.println("+++ The sum of revenue: " + revenue + " PLN +++");
        revenueRepository.setRevenue(revenue);
    }

    private void printWorkers() {
        workersRepository.getAdmins()
                .forEach(System.out::println);
        workersRepository.getUshers()
                .forEach(System.out::println);
        workersRepository.getZookeepers()
                .forEach(System.out::println);
    }

    private void printAnimals() {
        animalsRepository.getBirds()
                .forEach(System.out::println);
        animalsRepository.getMammals()
                .forEach(System.out::println);
        animalsRepository.getReptiles()
                .forEach(System.out::println);
    }

    private void exit() {
        System.exit(0);
    }

}
