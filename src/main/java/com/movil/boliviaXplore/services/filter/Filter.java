package com.movil.boliviaXplore.services.filter;
import java.util.List;

public interface Filter<T> {
    List<T> filter(List events);
}
