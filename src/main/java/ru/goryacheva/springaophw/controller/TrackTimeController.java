package ru.goryacheva.springaophw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.goryacheva.springaophw.model.TrackTimeModel;
import ru.goryacheva.springaophw.service.TrackTimeService;

import static ru.goryacheva.springaophw.service.TrackTimeService.ADD;
import static ru.goryacheva.springaophw.service.TrackTimeService.ADD_ASYNC;

@RestController
@RequestMapping(value = "/tracktime", produces = MediaType.APPLICATION_JSON_VALUE)
public class TrackTimeController {

    private final TrackTimeService service;

    @Autowired
    public TrackTimeController(TrackTimeService service) {
        this.service = service;
    }

    /**
     * общее время выполнения методов
     */
    @GetMapping("/alltime")
    public Long allTime() {
        return service.getAll().stream().mapToLong(TrackTimeModel::getTime).sum();
    }

    /**
     * среднее время выполнения методов
     */
    @GetMapping("/avgtime")
    public Double avgTime() {
        return service.getAll().stream().mapToLong(TrackTimeModel::getTime).average().getAsDouble();
    }

    /**
     * сохранение время выполнения в БД
     */
    @PostMapping("/save")
    public void save() {
       service.save(getTrackTimeModel(ADD_ASYNC, service.addAsync()),
               getTrackTimeModel(ADD, service.add()));
    }

    /**
     * создание модели
     * @param name имя метода
     * @param time время выполнения
     * @return модель
     */
    private TrackTimeModel getTrackTimeModel(String name, Long time) {
        TrackTimeModel model = new TrackTimeModel();
        if (time != null && name != null){
            model.setTime(time);
            model.setName(name);
        }
        return model;
    }
}
