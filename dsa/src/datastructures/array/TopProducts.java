package datastructures.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TopProducts {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numberOfTestCases = Integer.parseInt(scan.nextLine());
		List<List<String>> finalList = new ArrayList<>();
		for (int i = 0; i < numberOfTestCases; i++) {
			List<String> arrayList = new ArrayList<>();
			int cases = Integer.parseInt(scan.nextLine());
			for (int j = 0; j < cases; j++) {
				arrayList.add(scan.nextLine());
			}
			finalList.add(arrayList);
		}
		scan.close();
		for (List<String> list : finalList) {
			findTopProducts(list);
		}

	}

	private static void findTopProducts(List<String> arrayList) {
		Map<String, Integer> productSaleCount = new HashMap<>();
		for (String currentElement : arrayList) {
			if (currentElement.equalsIgnoreCase("top")) {
				Integer maxValue = productSaleCount.values().parallelStream()
						.max(Comparator.comparing(Integer::valueOf)).get();
				List<String> listToPrint = productSaleCount.keySet().parallelStream()
						.filter(key -> productSaleCount.get(key).equals(maxValue)).collect(Collectors.toList());
				Collections.sort(listToPrint);
				System.out.println(String.join(" ", listToPrint));
			} else {
				productSaleCount.compute(currentElement.split(" ")[0],
						(product, value) -> (value == null) ? Integer.parseInt(currentElement.split(" ")[1])
								: value + Integer.parseInt(currentElement.split(" ")[1]));
			}
		}
	}

}
