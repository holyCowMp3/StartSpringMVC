package viti.kaf22;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

/**
 * Created by korch on 27.10.17
 * Modified by Tesla on 18.01.18
 */
@Controller
public class MainController {
    PersonContainer container = new PersonContainer();


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView hello(ModelAndView modelAndView){
        modelAndView =  new ModelAndView("index");
        modelAndView.addObject(createPerson());
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView add(ModelAndView modelAndView, @ModelAttribute("person") Person person){
        container.getPersonList().add(person);
        modelAndView.setViewName("index");
        modelAndView.addObject("message", "SUCCESS");
        return modelAndView;
    }

    @RequestMapping(value = "/showTable", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView showTable(ModelAndView modelAndView, @ModelAttribute("person") Person person){

        modelAndView.setViewName("index");
        modelAndView.addObject( "tableView",container.getPersonList());
        return modelAndView;
    }

    @RequestMapping(value = "/clear", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView clear(ModelAndView modelAndView, @ModelAttribute("person") Person person){
        container.getPersonList().clear();
        modelAndView.setViewName("index");
        modelAndView.addObject( "tableView",container.getPersonList());
        return modelAndView;
    }

    private Person createPerson(){
        Person person = new Person();
        person.setName("Dmitry");
        person.setSurname("Teslov");
        return person;
    }
}

