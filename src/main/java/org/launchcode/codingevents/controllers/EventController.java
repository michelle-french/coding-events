package org.launchcode.codingevents.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("events")
public class EventController {

    private static List<String> events = new ArrayList<>();

    @GetMapping
    public String displayAllEvents(Model model) {
//        model.addAttribute("events", events);
//        return "eventsMap/index";
        Map<String, String> eventsMap = new HashMap<>();
        eventsMap.put("Menteaship","A fun meetup for connecting with mentors");
        eventsMap.put("Code With Pride","A fun meetup sponsored by LaunchCode");
        eventsMap.put("Javascripty", "An imaginary meetup for Javascript developers");
        model.addAttribute("events", eventsMap);
        return "exercises/fragments";
    }

//    lives at /events/create
    @GetMapping("create")
    public String renderCreateEventForm() {
        return "events/create";
    }

//    lives at /events/create
    @PostMapping("create")
    public String createEvent(@RequestParam String eventName) {
        events.add(eventName);
        return "redirect:";
    }
}
