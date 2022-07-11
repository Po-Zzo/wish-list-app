package com.courtauction.pojo;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor(staticName = "of")
public class CourtClass {

    private final Set<String> courtClass;

    public static CourtClass of(List<String> courtClass) {
        return CourtClass.of(courtClass.stream().toList());
    }
}
