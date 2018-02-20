package pagh.cphbusiness;

import java.util.*;

public class Assignment1
{
    private int N;

    public int inputScanner()
    {
        int n;
        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            System.out.println("please enter an integer, N!");
            try
            {
                n = Integer.parseInt(scanner.next());
                break;
            }
            catch (Exception e)
            {
                System.out.println("Please enter a valid integer!");
            }
        }
        scanner.close();

        return n;
    }

    public void opgave1()
    {

        N = inputScanner();

        List<Double> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++)
        {
            int[] randomSequence = generateRandomSequence();
            list.add(tester(randomSequence));
        }

        Double sum = 0.0;
        for (int i = 0; i < list.size(); i++)
        {
            sum = sum + list.get(i);
        }
        double actual = sum / list.size();

        System.out.println("actual er: " + actual);

        double approx = Math.sqrt((Math.PI * N) / 2);

        System.out.println("approx er: " + approx);
        double diff = Math.abs(actual - approx) / ((actual + approx) / 2) * 100;
        System.out.println("Diviation er: " + diff + "%");


    }

    /*
Returns an array of a thousand ints ranging from 0 to N.
 */
    private int[] generateRandomSequence()
    {
        int[] randomIntegers = new int[10000];
        Random random = new Random();

        for (int i = 0; i < 10000; i++)
        {
            randomIntegers[i] = random.nextInt(N - 1);
        }
        return randomIntegers;
    }


    private Double tester(int[] randomSequence)
    {
        HashSet<Integer> dupliChecker = new HashSet<>();
        for (int i = 0; i < randomSequence.length; i++)
        {
            if (dupliChecker.add(randomSequence[i]))
            {
            }
            else
            {
                return new Double(i);
            }
        }
        return null;
    }

}
