package datastructures.array.matrix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class CricketBatManufacturer {

	public static void main(String[] args) {
		Set<WeightPrice> batSet = new HashSet<>();
		Set<WeightPrice> cricketerSet = new HashSet<>();
		Scanner scan = new Scanner(System.in);
		Integer cricketers = scan.nextInt();
		Integer bats = scan.nextInt();
		
		List<WeightPrice> batsList = new ArrayList<>(bats);
		List<WeightPrice> cricketersList = new ArrayList<>(cricketers);

		for (int i = 0; i < cricketers; i++) {
			cricketersList.add(new WeightPrice(scan.nextInt(), scan.nextInt()));
		}
		for (int i = 0; i < bats; i++) {
			batsList.add(new WeightPrice(scan.nextInt(), scan.nextInt()));
		}
		scan.close();

		for (WeightPrice cricketer : cricketersList) {

			List<WeightPrice> selectedList = new ArrayList<>();
			for (WeightPrice bat : batsList) {
				if (bat.getPrice() <= cricketer.getPrice() && bat.getWeight() > cricketer.getWeight()) {
					selectedList.add(bat);
				}
			}
			if (!selectedList.isEmpty()) {
				cricketerSet.add(cricketer);
			}
			batSet.addAll(selectedList);
		}
		Integer finalResult = cricketerSet.size() > batSet.size() ? batSet.size() : cricketerSet.size();
		System.out.println(finalResult);
	}

	public static class WeightPrice {
		private Integer weight;
		private Integer price;

		public WeightPrice(Integer weight, Integer price) {
			super();
			this.weight = weight;
			this.price = price;
		}

		public Integer getWeight() {
			return weight;
		}

		public void setWeight(Integer weight) {
			this.weight = weight;
		}

		public Integer getPrice() {
			return price;
		}

		public void setPrice(Integer price) {
			this.price = price;
		}

		@Override
		public String toString() {
			return "WeightPrice [weight=" + weight + ", price=" + price + "]";
		}

		@Override
		public int hashCode() {
			return 1;
		}

		@Override
		public boolean equals(Object obj) {
			return this == obj;
		}

	}
}
