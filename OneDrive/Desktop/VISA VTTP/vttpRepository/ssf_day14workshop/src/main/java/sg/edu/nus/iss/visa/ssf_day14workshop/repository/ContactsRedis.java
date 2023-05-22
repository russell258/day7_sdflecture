package sg.edu.nus.iss.visa.ssf_day14workshop.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import sg.edu.nus.iss.visa.ssf_day14workshop.model.Contact;

@Repository
public class ContactsRedis {
    final String CONTACT_LIST = "contactList";

    @Autowired
    RedisTemplate<String, Object> template;

    public void saveContact(Contact contact, Model model){
        
    }

}
