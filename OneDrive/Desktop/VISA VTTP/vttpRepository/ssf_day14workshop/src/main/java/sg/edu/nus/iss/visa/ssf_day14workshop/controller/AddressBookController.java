package sg.edu.nus.iss.visa.ssf_day14workshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import sg.edu.nus.iss.visa.ssf_day14workshop.model.Contact;
import sg.edu.nus.iss.visa.ssf_day14workshop.repository.ContactsRedis;

@Controller
@RequestMapping(path = "/")
public class AddressBookController {
    
    @Autowired
    ContactsRedis repository;

//request method to load landing page
@GetMapping
public String showAddressBook(Model model){
    model.addAttribute("contact", new Contact());
    return "addressBook";
}

// to save contact information
@PostMapping(consumes = "application/x-www-form-urlencoded", path = "/contact")
public String saveAddressBook(@ModelAttribute @Valid Contact contact, BindingResult bindingResult, Model model){
    if (bindingResult.hasErrors()){
        return "addressBook";
    }

    repository.saveContact(contact,model);
    model.addAttribute("successMessage", "Contact saved successfully, with status code: " +HttpStatus.CREATED+".");
    return "showContact";
}

// to show contacts by ID
@GetMapping("/contact/{contactId}")
public String getContactById(Model model, @PathVariable String contactId){
    Contact contact = new Contact();
    contact = repository.getContactById(contactId);
    if (contact == null){
        model.addAttribute("errorMessage", "Contact not found");
        return "error";
    }
    model.addAttribute("contact", contact);
    return "showContact";
}

@GetMapping(path = "/list")
public String getAllContacts(Model model){
    List<Contact> contacts = repository.getAllContacts(model);
    model.addAttribute("contacts",contacts);
    return "contacts";
}

}
