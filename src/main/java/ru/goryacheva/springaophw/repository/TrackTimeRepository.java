package ru.goryacheva.springaophw.repository;

import ru.goryacheva.springaophw.model.TrackTimeModel;

import java.util.List;

public interface TrackTimeRepository {

    void save(TrackTimeModel trackTimeModel);

    List<TrackTimeModel> getAll();
}
