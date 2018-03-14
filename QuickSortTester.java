import java.io.*;

public class QuickSortTester {
    
    public static String write(String toWrite, String fileName) { //courtesy of Joan Chirinos
	File f = new File(fileName);
	f.delete();
	try {
	    FileWriter fw = new FileWriter(fileName);
	    BufferedWriter bw = new BufferedWriter(fw);
	    bw.write(toWrite);
	    bw.close();
	}
	catch (IOException e) {
	    throw new IllegalArgumentException("\n\tCannot write to file");
	}
	return toWrite;
    }//end write
    
    
    public static String read(String fileName) { //courtesy of Joan Chirinos
	File f = new File("./" + fileName);
	if (!(f.exists()))
	    throw new IllegalArgumentException("\n\tFile does not exist");
	String ret = "";
	try {
	    FileReader fr = new FileReader(fileName);
	    BufferedReader br = new BufferedReader(fr);
	    String toAdd;
	    while ((toAdd = br.readLine()) != null)
		ret += toAdd + "\n";
	}
	catch (IOException e) {
	    throw new IllegalArgumentException("\n\tUnable to read file");
	}
	return ret;
    }//end read
    
    public static void main(String[] args) {
	QuickSort sort = new QuickSort();


	for (int num = 100; num < 10050; num += 50){
	
	int[] tester1 = sort.buildArray(num, 10000);
	
	int i = 0;
	long startTime;
	long totalTime;
	long sum = 0;
	
	while (i<1000){
	    //sort.shuffle(tester1);
	    startTime = System.nanoTime();
	    sort.qsort(tester1);
	    totalTime = System.nanoTime() - startTime;
	    sum += totalTime;
	    i++;
	    tester1 = sort.buildArray(num,10000);
	    
	}
	String ans = read("BestData") + num + "," + sum/1000 + "\n";
	write(ans,"BestData");}
    }
}
