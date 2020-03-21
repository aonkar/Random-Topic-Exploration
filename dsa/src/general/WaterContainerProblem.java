package general;

public class WaterContainerProblem {

	public static void main(String[] args) {
		System.out.println(maxArea(new int[] {1,8,6,2,5,4,8,3,7 }));
	}

	public static int maxArea(int[] height) {
		int[] leftToRight = new int[height.length];
		int[] rightToLeft = new int[height.length];
		int leftToRightMax = 0;
		int rightToLeftMax = 0;
		int result = 0;
		for (int i = 0; i < height.length; i++) {
			leftToRightMax = height[i] > leftToRightMax ? height[i] : leftToRightMax;
			leftToRight[i] = leftToRightMax;
		}
		for (int i = height.length - 1; i > -1; i--) {
			rightToLeftMax = height[i] > rightToLeftMax ? height[i] : rightToLeftMax;
			rightToLeft[i] = rightToLeftMax;
		}
		for (int i = 0; i < height.length; i++) {
			int currentMin = Math.min(leftToRight[i], rightToLeft[i]);
			if (currentMin > height[i]) {
				result += currentMin - height[i];
			}
		}
		return result;
	}
}
