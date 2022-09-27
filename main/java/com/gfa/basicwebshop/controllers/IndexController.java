package com.gfa.basicwebshop.controllers;

import com.gfa.basicwebshop.models.Item;
import com.gfa.basicwebshop.models.ItemList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Comparator;
import java.util.stream.Collectors;

@Controller
public class IndexController {
    ItemList itemList = new ItemList();

    @GetMapping("/")
    public String indexPage(Model model) {
        model.addAttribute("items", itemList.getItemList());
        return "index";
    }

    @GetMapping("/only-available")
    public String showOnlyAvailable(Model model) {
        model.addAttribute("items", itemList.getItemList().stream()
                .filter(s -> s.getStock() > 0)
                .collect(Collectors.toList()));
        return "index";
    }

    @GetMapping("/cheapest-first")
    public String sortCheapestFirst(Model model) {
        model.addAttribute("items", itemList.getItemList().stream()
                .sorted(Comparator.comparing(Item::getPrice))
                .collect(Collectors.toList()));
        return "index";
    }

    @GetMapping("/contains-stratocaster")
    public String containsStratocaster(Model model) {
        model.addAttribute("items", itemList.getItemList().stream()
                .filter(s -> s.getName().toLowerCase().contains("stratocaster") || s.getDescription().toLowerCase().contains("stratocaster"))
                .collect(Collectors.toList()));
        return "index";
    }

    @GetMapping("/average-stock")
    public String averageStock(Model model) {
        model.addAttribute("averageStock", itemList.getAverageStock());
        return "index";
    }

    @GetMapping("/most-expensive")
    public String mostExpensive(Model model) {
        model.addAttribute("mostExpensive", itemList.getMostExpensive());
        return "index";
    }
}
