public class Swapping {
    public static int[] swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }
    public static void print(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"\t");
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,};
       System.out.print("Before Swapping\t");
       print(arr);
       int[] swapArr = swap(arr,2,4);
        System.out.print("\nAfter Swapping\t");
        print(arr);
    }
}
