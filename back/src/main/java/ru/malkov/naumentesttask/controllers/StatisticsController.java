package ru.malkov.naumentesttask.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.malkov.naumentesttask.dto.FrequencyDto;
import ru.malkov.naumentesttask.services.StatisticsService;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "statistics")
public class StatisticsController {
    private final StatisticsService statisticsService;

    public StatisticsController(@Autowired StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping(value = "/frequency")
    public FrequencyDto getFrequencyMap(){
        HashMap<String, Integer> map = statisticsService.getFrequencyHashmap();
        String[] names = new String[map.size()];
        String[] frequencies = new String[map.size()];
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        int i=0;
        while(iterator.hasNext()){
            Map.Entry<String, Integer> mapping = iterator.next();
            names[i] = mapping.getKey();
            frequencies[i] = mapping.getValue().toString();
            i++;
        }
        return new FrequencyDto(names, frequencies);
    }
}
