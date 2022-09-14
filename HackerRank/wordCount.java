import java.util.*;

public class wordCount {

	public static void main(String[] args) {
		int [] l = { 1 , 3, 5, 6, 9, 9, 10, 1, 3, 5};
		int temp = 0;
		Set<Integer> s = new HashSet<>();
		for(int i = 0; i < l.length; i++) {
			for(int j = 0; j < l.length; j++) {
				if(l[i] == l[j]) temp++;
			}
			if(temp >= 2) s.add(l[i]);
			temp = 0;
		}
		List<Integer> list = new ArrayList<>(s);
		for(int t : s) System.out.print(t + " ");
		
	}
}
