package com.courtauction.pojo;

import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor(staticName = "of")
public class CourtClass {

    private final Set<String> courtClass;

    public static CourtClass of(List<String> courtClass) {
        return CourtClass.of(new HashSet<>(courtClass));
    }
}
