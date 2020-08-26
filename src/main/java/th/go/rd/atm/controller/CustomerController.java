package th.go.rd.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.go.rd.atm.model.Customer;
import th.go.rd.atm.service.CustomerService;


@Controller
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //@GetMapping("/customer")  ย้ายไปใช้ข้างบนแทน
    @GetMapping
    public String getCustomer(Model model){
        model.addAttribute("allCustomers", customerService.getCustomer());
        return "customer";  // customer.html
    }

    //@PostMapping("/customer")  ย้ายไปใช้ข้างบนแทน
    @PostMapping
    public String registerCustomer(@ModelAttribute Customer customer, Model model){
        customerService.createCustomer(customer);
        model.addAttribute("allCustomers", customerService.getCustomer());
        return "redirect:customer";
    }
}
