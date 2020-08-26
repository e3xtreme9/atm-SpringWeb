package th.go.rd.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class CustomerController {

    ArrayList<Customer> customers = new ArrayList<>();

    @GetMapping("/customer")
    public String getCustomer(Model model){
        model.addAttribute("allCustomers", customers);  //ส่งโมเดลที่เก็บออปเจ็ก customers ที่ชื่อ "allCustomers" ไปให้ view
        return "customer";  // customer.html
    }

    @PostMapping("/customer")
    public String registerCustomer(@ModelAttribute Customer customer, Model model){
        customers.add(customer);
        model.addAttribute("allCustomers", customers);
        return "redirect:customer";
    }
}
