package pagh.cphbusiness;

import java.util.*;

public class Assignment2
{

    public void couponCollector()
    {
        int N;
        N = new Assignment1().inputScanner();
        List<Double> resList = new ArrayList<>();

        for (int b = 0; b < 10000; b++)
        {
            resList.add(tester(N));
        }

        double testMean = 0.0;

        for (int c = 0; c < resList.size(); c++)
        {
            testMean = testMean + resList.get(c);
        }

        System.out.println("Her er test mean: " + testMean / resList.size());
        Double numberOfValues = tester(N);

        double H_N = 0.0;
        for (int a = 1; a <= N; a++)
        {
            H_N = H_N + (1.0 / a);
        }

        System.out.println("her er N*H_N: " + (N * H_N));

        double actual = testMean;
        double approx = (N * H_N);


        double diff = 100 * ((Math.abs(actual-approx))/((actual+approx)/(2)));

        System.out.println("Her er diff: " + diff);


    }

    private Double tester(int N)
    {
        int numberOfValues = 0;
        int[] randomSequence = generateRandomSequence(N);
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < randomSequence.length; i++)
        {
            set.add(randomSequence[i]);

            if (set.size() == (N - 1))
            {
                numberOfValues = i;
                break;
            }
        }
        return new Double(numberOfValues);
    }

    private int[] generateRandomSequence(int limit)
    {
        int[] randomIntegers = new int[100000];
        Random random = new Random();

        for (int i = 0; i < 100000; i++)
        {
            randomIntegers[i] = random.nextInt(limit - 1);
        }
        return randomIntegers;
    }


}
