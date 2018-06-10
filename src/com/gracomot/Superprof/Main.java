package com.gracomot.Superprof;


import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[][] queries = {{1,0,5},{1,1,7},{1,0,3},{2,1,0},{2,1,1}};
        int n = 2;
        int[] res = dynamicArray(n,queries);
        for(int i: res)  {
            System.out.println(i);
        }

    }
    static int[] dynamicArray(int n, int[][] queries) {
        /*
         * Write your code here.
         */
        int last_answer = 0;
        String[] sequence = new String[n];
        Arrays.fill(sequence,"");
        ArrayList<Integer> last_answers_list = new ArrayList<Integer>();
        for(int i = 0; i < queries.length; i++) {
            int query_type = queries[i][0];
            int x = queries[i][1];
            int y = queries[i][2];
            int result = (x ^ last_answer) % n;
            String curseq = sequence[result];
            if(query_type  == 1)    {
                curseq =  curseq+y+"-";
                sequence[result] = curseq;
            }else{
                String[] cur_arr =  curseq.split("-");
                int num = y %cur_arr.length;
                last_answer = Integer.parseInt(cur_arr[(y % cur_arr.length)]);
                last_answers_list.add(last_answer);

            }
        }
        int[] res = new int[last_answers_list.size()];
        for(int i = 0 ; i < last_answers_list.size(); i++) {
            res[i] = last_answers_list.get(i);
        }
        return res;
    }

}
