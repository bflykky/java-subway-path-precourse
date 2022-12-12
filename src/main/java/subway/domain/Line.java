package subway.domain;

import java.util.Arrays;
import java.util.List;

public class Line {
    private String name;

    private List<Station> stations;

    public Line(String name) {
        this(name, (Station) null);
    }

    public Line(String name, Station... stations) {
        this.name = name;

        if (stations.length > 0) {
            this.stations = Arrays.asList(stations);
        }
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public List<Station> getStations() {
        return stations;
    }
}
