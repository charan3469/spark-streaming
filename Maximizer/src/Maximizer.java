class Maximizer
{


    static void swap(int[] arr, int target_position,
                        int current_position)
    {
        int aux;
        for (int i = current_position;
             i > target_position; i--)
        {
            aux = arr[i - 1];
            arr[i - 1] = arr[i];
            arr[i] = aux;
        }
    }

    static int[] maximize(String num,
                              int length, int M)
    {
        String[] st = num.split("");
        int[] arr = new int[st.length];
        for (int i = 0; i < st.length; i++) {
            arr[i] = Integer.parseInt(st[i]);
        }

        if (M == 0)
            return arr;

        for (int i = 0; i < length; i++)
        {
            int max_index = 0, max = Integer.MIN_VALUE;

            int limit = Math.min((M + i), length);
            for (int j = i; j <= limit; j++)
            {
                if (arr[j] > max)
                {
                    max = arr[j];
                    max_index = j;
                }
            }
            M -= (max_index - i);
            swap(arr, i, max_index);

            if (M == 0)
                break;
        }
        return arr;
    }

    public static void main(String[] args)
    {
        String num = "1123";
        int length = num.length();
        int M = 1;
        int[] output = maximize(num, length, M);
        for(int i:output)
            System.out.print(i);
    }
}