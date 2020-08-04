static int boatsToSave(int[] people, int limit) {

		int start = 0;
		int end = people.length - 1;
		int result = 0;

		Arrays.parallelSort(people);

		while (start <= end) {
			if (people[start] + people[end] <= limit) {
				start++;
			}
			end--;
			result++;
		}

		return result;

	}
