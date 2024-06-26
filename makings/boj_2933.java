package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static char[][] arr;
    public static int R, C, N;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];

        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
//            System.out.println(st);
            String line = st.nextToken();
            System.out.println(line);
            for(int j=0; j<C; j++){
                arr[i][j] = line.charAt(j);
            }
        }

        N =  Integer.valueOf(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int h = Integer.valueOf(st.nextToken());
            if(i%2 == 0){
                startFromLeft(h);
            }else{
                startFromRight(h);
            }
            findFlyClusters();
            applyGravityForClusters();
        }

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void startFromLeft(int h){
        for(int i=0; i<C; i++){
            if(arr[R-h][i] == 'x'){
                arr[R-h][i] = '.';
                break;
            }
        }
    }

    public static void startFromRight(int h){
        for(int i=C-1; i>=0; i--){
            if(arr[R-h][i] == 'x'){
                arr[R-h][i] = '.';
                break;
            }
        }
    }

    public static void applyGravity(){
        for(int j=0; j<C; j++){
            for(int i=R-1; i>=0; i--){
                if(i-1 >=0 && arr[i-1][j] == 'x' && arr[i][j] == '.'){
                    arr[i][j] = 'x';
                    arr[i-1][j] = '.';
                }
            }
        }
    }
}

