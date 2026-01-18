import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Answer1 {
    public static void main(String[] args) {
        List<Float> ls = new ArrayList<>();
        ls.add(1.1f);
        ls.add(1.4f);
        ls.add(2.1f);
        ls.add(5.1f);
        ls.add(6.1f);

        float sum = 0;
        Iterator<Float> itr = ls.iterator();
        while (itr.hasNext()) {
            sum += itr.next();
        }

        System.out.println("Sum: " + sum);
    }
}

