public class QuickSortTester {
    
    public static void main(String[] args) {
	QuickSort sort = new QuickSort();
	//buildArray uses s (size) as the first param and maxVal as the
	//second param
	int[] tester1 = sort.buildArray(100, 10000);
	int[] tester2 = sort.buildArray(500, 10000);
	int[] tester3 = sort.buildArray(1000, 10000);
	int[] tester4 = sort.buildArray(10500, 10000);

	int i = 0;
	long startTime;
	long totalTime;
	long sum = 0;
	
	while (i<1000){
	
	startTime = System.nanoTime();
	sort.qsort(tester4);
	totalTime = System.nanoTime() - startTime;
        sum += totalTime;
	i++;
	}
	System.out.println(sum/1000);
    }
}
