package th.go.rd.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class CustomerController {

    @RequestMapping("/customer")
    public String getCustomer(Model model){
        ArrayList<String> customer = new ArrayList<>();
        customer.add("Peter Corp");
        customer.add("Nancy Girl");
        customer.add("Riddick Gay");
        model.addAttribute("allCustomers", customer);
        return "customer";  // customer.html
    }
}
