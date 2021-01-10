package com.crm.controller;

import com.crm.model.CallList;
import com.crm.model.Client;
import com.crm.model.Company;
import com.crm.model.Staff;
import com.crm.service.ClientService;
import com.crm.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ClientController {

    private CompanyService companyService;
    private ClientService clientService;


    @Autowired
    public ClientController(CompanyService companyService, ClientService clientService) {
        this.companyService = companyService;
        this.clientService = clientService;
    }

    @GetMapping("clientAdd/{id}")
    public String addClient(@PathVariable("id") Long id, Model model) {

        Company company = companyService.getCompanyById(id);
        Client client = new Client();
        client.setCompany(company);
        model.addAttribute("company", company);
        model.addAttribute("client", client);

        return "add_client";
    }
    @GetMapping(value = "editClient/{id}")
    public String editClient(@PathVariable("id") Long id, Model model) {
        Client client = clientService.getClientById(id);
        Company company = companyService.getCompanyById(client.getCompany().getId());

        model.addAttribute("company", company);
        model.addAttribute("client", client);
        return "add_client";
    }

    @RequestMapping("clientAdd/clientSave")
    public String save(@ModelAttribute("client") @Valid Client client, BindingResult result, Model model) {
        if (result.hasErrors()) {
            Company company = client.getCompany();
            model.addAttribute("company", company);
            return "add_client";
        }
       clientService.saveClient(client);
        return "redirect:/showClient";
    }
    @RequestMapping("editClient/clientSave")
    public String editSave(@ModelAttribute("client") @Valid Client client, BindingResult result, Model model) {
        if (result.hasErrors()) {
            Company company = client.getCompany();
            model.addAttribute("company", company);
            return "add_client";
        }
        clientService.saveClient(client);
        return "redirect:/showClient";
    }
    @RequestMapping("/showClient")
    public String showClient(Model model) {

        model.addAttribute("clientList", clientService.findAll());
        return "clients_list";
    }

    @RequestMapping(value = "deleteClient/{id}", method = RequestMethod.GET)
    public String deleteClient(@PathVariable("id") Long id) {
        clientService.deleteCompany(id);

        return "redirect:/showClient";
    }

    /*@PostMapping("/posts/{postId}/comments")
    public Client createComment(@PathVariable (value = "postId") Long postId,
                                 @Valid @RequestBody Client comment) throws ResourceNotFoundException {
        return companyRepository.findById(postId).map(post -> {
            comment.setCompany(post);
            return clientRepository.save(comment);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }*/
}
