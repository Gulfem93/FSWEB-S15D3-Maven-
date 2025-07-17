package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.example.entity.Employee;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        List<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(4, "Burak", "Cevizli"));

    }

    public static List<Employee> findDuplicates(List<Employee> list) {
        //Senden isteğimiz findDuplicates methodu içerisinde tekrar eden employeeleri 
        //başka bir listeye eklemen ve bu listeyi return etmen.
        List<Employee> duplicates = new ArrayList<>();
        Set<Employee> seen = new HashSet<>();
        Set<Employee> duplicateSet = new HashSet<>();

        for (Employee employee : list) {
            if (!seen.add(employee)) {
                duplicateSet.add(employee);
            }
        }

        duplicates.addAll(duplicateSet);
        return duplicates;

    }

    public static Map<Integer, Employee> findUniques(List<Employee> list) {
        //findUniques LinkedList içerisinde geçen 
        //tekrar eden elemanlardan sadece bir tanesini ve tekrar etmeyen eleman varsa 
        //bu elemanları bulup bir mape eklemeli.

        if (list == null) {
            return new HashMap<>(); // or throw IllegalArgumentException
        }

        Map<Integer, Employee> resultMap = new HashMap<>();
        Map<Integer, Integer> countMap = new HashMap<>();

        // First pass: Count occurrences of each employee ID (skip nulls)
        for (Employee employee : list) {
            if (employee != null) {
                int id = employee.getId();
                countMap.put(id, countMap.getOrDefault(id, 0) + 1);
            }
        }

        // Second pass: Add to result map (skip nulls)
        for (Employee employee : list) {
            if (employee != null) {
                int id = employee.getId();
                if (!resultMap.containsKey(id)) {
                    resultMap.put(id, employee);
                }
            }
        }

        return resultMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
