package viti.kaf22;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by korch on 27.10.17
 * Modified by Tesla on 18.01.18
 * Rewrited by Tesla on 03.02.18
 */
@Controller
public class MainController {
    private List<LessonEvent> LessonEventList = new ArrayList<LessonEvent>();


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView hello(ModelAndView modelAndView){
        modelAndView =  new ModelAndView("index");
        modelAndView.addObject(createLessonEvent());
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView add(ModelAndView modelAndView, @ModelAttribute("LessonEvent") LessonEvent LessonEvent){
        LessonEventList.add(LessonEvent);
        modelAndView.setViewName("index");
        modelAndView.addObject("message", "SUCCESS");
        return modelAndView;
    }

    @RequestMapping(value = "/showTable", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView showTable(ModelAndView modelAndView, @ModelAttribute("LessonEvent") LessonEvent LessonEvent){

        modelAndView.setViewName("index");
        modelAndView.addObject( "tableView",LessonEventList);
        return modelAndView;
    }

    @RequestMapping(value = "/clear", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView clear(ModelAndView modelAndView, @ModelAttribute("LessonEvent") LessonEvent LessonEvent){
        LessonEventList.clear();
        modelAndView.setViewName("index");
        modelAndView.addObject( "tableView",LessonEventList);
        return modelAndView;
    }

    private LessonEvent createLessonEvent(){
        LessonEvent LessonEvent = new LessonEvent();
        return LessonEvent;
    }
}

