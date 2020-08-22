//Backtracking with purging:

public class CampusBikes {

	static int minSum = Integer.MAX_VALUE;

	public static void main(String[] args) {
		int[][] workers = { { 0, 0 }, { 1, 1 }, { 2, 0 } };

		int[][] bikes = { { 1, 0 }, { 2, 2 }, { 2, 1 } };
		boolean[] used = new boolean[bikes.length];

		minDistance(workers, bikes, 0, used, 0);
		System.out.println(minSum);

	}

	static void minDistance(int[][] workers, int[][] bikes, int idx, boolean[] used, int sum) {

		int n = workers.length;

		if (idx == n) {
			minSum = Math.min(sum, minSum);
			return;
		}

		// Bounding function(purging)use of backtracking:
		if (sum > minSum) {
			return;
		}

		for (int i = 0; i < bikes.length; i++) {
			if (!used[i]) {
				used[i] = true;
				minDistance(workers, bikes, idx + 1, used, sum + calculateDistance(workers[idx], bikes[i]));
				used[i] = false;
			}

		}

	}

	static int calculateDistance(int[] worker, int[] bike) {

		return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
	}

}
