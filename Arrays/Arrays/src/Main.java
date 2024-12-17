import java.util.Scanner;

public class Main{
    //updation in a array
     public static void updates(int[] marks){
         for(int i=0;i<marks.length;i++){
             marks[i]=marks[i]+2;
         }
     }
     //Linear search
    public static int lSearch(int[] marks,int key){
         for(int i=0;i<marks.length;i++) {
             if (marks[i] == key) {
                 return i;
             }
         }
         return -1;
    }
    //menu search
    public static int menuSearch(String[] menu, String key){
         for(int i=0;i<menu.length;i++){
             if(menu[i]==key){
                 return i;
             }
         }return -1;
    }

    //Largest Number in an Array
    public static int largest(int[] a){
         int max=a[0];
         for(int i=0;i<a.length;i++){
             if(a[i]>=max){
                 max=a[i];
             }
         }
         return max;
    }

    //Binary Search
    public static int bSearch(int[] a, int key){
         int start=0,end=a.length-1;
        System.out.println(a.length);
         while(start<=end){
             int mid=(start+end)/2;
             if(a[mid]==key){
                 return mid;
             }
             if(a[mid]<key){
                 start=mid+1;
             }
             else{
                 end=mid-1;
             }
         }
         return -1;
    }

    //Reverse of an array
    public static void reverse(int[] a){
         for(int i=a.length-1;i>=0;i--){
             System.out.print(a[i]+",");
         }
    }

    //Pair in an Array
    public static void pair(int[] a) {
        int j,i;
        for (i = 0; i <= a.length-1; i++) {
            for (j = i + 1; j <= a.length-1; j++) {
                System.out.print("(" + a[i] + "," + a[j] + ")");
            }
            System.out.println();
        }
    }

    // Print SubArray
    public static void SubArray(int[] a){
         int ts=0;
         for(int i=0;i<a.length;i++){
             for(int j=i;j<a.length;j++){
                 for(int k=i;k<=j;k++){
                     System.out.print(a[k]+" ");
                 }
                 ts++;
                 System.out.println();
             }
             System.out.println();
         }
        System.out.println(" total subarray : "+ts);
    }

    //Print sum of max and min of subarray
    public static void sumSubArray(int[] a) {
        int l = a.length;
        int currSum;
        int maxSum = 0;
        int[] arr = new int[l * (l + 1) / 2];
        for (int i = 0; i < l; i++) {
            for (int j = i ; j < l; j++) {
                currSum=0;
                for (int k = i; k <= j; k++) {
                    currSum += a[k];
                }
                System.out.println(currSum);
                if(maxSum < currSum){
                    maxSum = currSum;
                }
            }
        }
        System.out.println("max sum : "+maxSum);
    }

    //Take array as  an input
    public static void inputArray(int[] a){
        int[] main1=new int[5];
        Scanner sc=new Scanner(System.in);
//        int b=sc.nextInt();
        System.out.print("enter an array  : ");
        for(int i=0;i<main1.length;i++){
            main1[i]=sc.nextInt();
        }
        System.out.print("Array elements are : ");
        for(int i=0;i<main1.length;i++){
            System.out.print(main1[i]+", ");
        }
    }

    //Maximum sum of an array by using KADANES
    public static void kadanes(int[] a){
         int maxsum=Integer.MIN_VALUE;
         int minsum=Integer.MAX_VALUE;
         int currsum=0;
         for(int i=0;i<a.length;i++){
             currsum=currsum+a[i];
             if(currsum<0){
                 minsum=currsum;
                 currsum=0;

             }
             maxsum=Math.max(maxsum,currsum);
             minsum=Math.min(minsum,currsum);
         }
        System.out.println("Max sum of subArray : "+maxsum);
        System.out.println("Min sum of subArray : "+minsum);
    }

    //Trapped Water
    public static int trappedWater(int[] a){
         int n=a.length;
         int[] lm=new int[n];
         lm[0]=a[0];
         for(int i=1;i<n;i++) { //Calculating left max boundary
             lm[i] = Math.max(lm[i-1], a[i]);
         }
         int[] rm=new int[n];
         rm[n-1]=a[n-1];
         for(int i=n-2;i>=0;i--){ //Calculating Right max boundary
             rm[i]=Math.max(rm[i+1],a[i]);
         }
         int trappedwater=0;
         for(int i=0;i<n;i++){
             int wl=Math.min(lm[i],rm[i]); //Calculating water level
             trappedwater+=(wl-a[i]);
         }

         return trappedwater;
    }

    //Buy and Sell Stocks
    public static int buyAndSellStocks(int[] prices){
         int buyPrice=Integer.MAX_VALUE;
         int maxProfit=0;
         for(int i=0;i<prices.length;i++){
             if(buyPrice<prices[i]){   //Profit
                 int profit=prices[i]-buyPrice;  //Today's Profit
                 maxProfit=Math.max(maxProfit,profit);
             }else{
                 buyPrice=prices[i];
             }
         }return maxProfit;
    }

    //Main Function
    public static void main(String[ ] args){
        //updates(marks);
        //menuSearch(menu,key);
        //int[] a={4,2,0,6,3,2,5};
        //System.out.println(largest(a));
        //System.out.println("number found at index :"+bSearch(a,45));
        //reverse(a);
        //pair(a);
        //subArray(a);
        //sumSubArray(a);
        //System.out.println("max is : "+sumSubArray(a));
        //inputArray(a);
        //subArray(a);
        //kadanes(a);
        //System.out.println("Water trapped : "+trappedWater(a));
        int[] prices={7,1,5,3,6,4};
        System.out.println(buyAndSellStocks(prices));
    }
}