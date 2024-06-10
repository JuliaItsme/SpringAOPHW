package ru.goryacheva.springaophw.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.goryacheva.springaophw.annotation.TrackAsyncTime;
import ru.goryacheva.springaophw.annotation.TrackTime;
import ru.goryacheva.springaophw.model.TrackTimeModel;
import ru.goryacheva.springaophw.repository.TrackTimeRepository;

import java.util.List;

@Service
@Slf4j
public class TrackTimeService {
    public static final String ADD = "add";
    public static final String ADD_ASYNC = "addAsync";

    private final TrackTimeRepository repository;

    @Autowired
    public TrackTimeService(TrackTimeRepository repository) {
        this.repository = repository;
    }

    /**
     * возвращает время выполнение метода
     */
    @TrackAsyncTime
    public Long addAsync() {
        log.info("Выполняется метод addAsync");
        return null;
    }

    /**
     * возвращает время выполнение метода
     */
    @TrackTime
    public Long add() {
        log.info("Выполняется метод add");
        return null;
    }

    /**
     * сохранение в БД
     */
    @Async
    @Transactional
    public void save(TrackTimeModel model1, TrackTimeModel model2) {
        log.info("Сохраняется в БД");
        repository.save(model1);
        repository.save(model2);
    }

    /**
     * получение списка TrackTimeModels для анализа данных
     * @return список полученный из БД
     */
    @Transactional(readOnly = true)
    public List<TrackTimeModel> getAll() {
        return repository.getAll();
    }
}
