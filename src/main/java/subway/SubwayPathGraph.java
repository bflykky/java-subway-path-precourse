package subway;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.Arrays;
import java.util.List;

public class SubwayPathGraph {
	private static final List<Integer> DISTANCE_WEIGHT = Arrays.asList(2, 2, 3, 6, 1, 2, 10);
	private static final List<Integer> TIME_WEIGHT = Arrays.asList(3, 3, 2, 5, 1, 8, 3);

	private static final List<List<Integer>> WEIGHT_CANDIDATES = Arrays.asList(DISTANCE_WEIGHT, TIME_WEIGHT);
	public static final WeightedMultigraph<Station, DefaultWeightedEdge> graph = new WeightedMultigraph<>(DefaultWeightedEdge.class);

	/*
	public SubwayPathGraph(int graphWeightMenu) {
		setVertexData();
		setEdgeAndWeightData(WEIGHT_CANDIDATES.get(graphWeightMenu - 1));
	}
	*/

	public static void setData(int graphWeightMenu) {
		setVertexData();
		setEdgeAndWeightData(WEIGHT_CANDIDATES.get(graphWeightMenu - 1));
	}

	private static void setVertexData() {
		for (Station station : StationRepository.stations()) {
			graph.addVertex(station);
		}
	}

	private static void setEdgeAndWeightData(List<Integer> weightData) {
		int weightIndex = 0;
		for (Line line : LineRepository.lines()) {
			List<Station> stations = line.getStations();
			for (int i = 0; i < stations.size() - 1; i++) {
				Station sourceStation = stations.get(i);
				Station destinationStation = stations.get(i + 1);
				DefaultWeightedEdge edge = graph.addEdge(sourceStation, destinationStation);
				graph.setEdgeWeight(edge, weightData.get(weightIndex++));
			}
		}
	}

}
