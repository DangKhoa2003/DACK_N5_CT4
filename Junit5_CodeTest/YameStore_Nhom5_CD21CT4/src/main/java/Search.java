public class Search {
        public int search(int x)
        {
            int result=0;
            int arr[] = new int[]{2, 3, 4, 9};
            for (int i = 0; i < 3; i++) {
                if (arr[i] == x)
                    return result = 1;
            }
            if (result == 0) {
                System.out.print("het hang");
            }
            else {
                System.out.print("con hang");
            }
            return result;
        }
    }

