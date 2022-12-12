package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void setInitialData() {
        addLine(new Line(
                "2호선",
                StationRepository.getStation("교대역"),
                StationRepository.getStation("강남역"),
                StationRepository.getStation("역삼역")));
        addLine(new Line(
                "3호선",
                StationRepository.getStation("교대역"),
                StationRepository.getStation("남부터미널역"),
                StationRepository.getStation("양재역"),
                StationRepository.getStation("매봉역")));
        addLine(new Line(
                "신분당선",
                StationRepository.getStation("강남역"),
                StationRepository.getStation("양재역"),
                StationRepository.getStation("양재시민의숲역")));
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void deleteAll() {
        lines.clear();
    }
}
