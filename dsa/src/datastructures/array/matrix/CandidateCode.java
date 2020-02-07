package datastructures.array.matrix;

/* Read input from STDIN. Print your output to STDOUT*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CandidateCode {
	public static void main(String[] args) throws Exception {

		Scanner scan = new Scanner(System.in);
		String firstLine = scan.nextLine();
		Integer cricketers = Integer.parseInt(firstLine.split(" ")[0]);
		Integer bats = Integer.parseInt(firstLine.split(" ")[1]);
		List<WeightPrice> batsList = new ArrayList<>();
		List<WeightPrice> cricketersList = new ArrayList<>();
		for (int i = 0; i < cricketers; i++) {
			String cricketerReq = scan.nextLine();
			cricketersList.add(new WeightPrice(Integer.parseInt(cricketerReq.split(" ")[0]),
					Integer.parseInt(cricketerReq.split(" ")[1])));
		}

		for (int i = 0; i < bats; i++) {
			String batReq = scan.nextLine();
			batsList.add(
					new WeightPrice(Integer.parseInt(batReq.split(" ")[0]), Integer.parseInt(batReq.split(" ")[1])));
		}
		scan.close();
		List<List<WeightPrice>> finalList = new ArrayList<>();
		for (WeightPrice cricketer : cricketersList) {
			List<WeightPrice> selectedList = new ArrayList<>();
			for (WeightPrice bat : batsList) {
				if (bat.getPrice() <= cricketer.getPrice() && bat.getWeight() > cricketer.getWeight()) {
					selectedList.add(bat);
				}
			}
			if (!selectedList.isEmpty()) {
				finalList.add(selectedList);
			}
		}
		System.out.println("");
	}

	public static class WeightPrice {
		private Integer weight;
		private Integer price;

		public WeightPrice(Integer weight, Integer price) {
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
		public int hashCode() {
			return 1;
		}

		@Override
		public boolean equals(Object obj) {
			return this == obj;
		}

	}
}