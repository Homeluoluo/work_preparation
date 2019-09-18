package vivo;

import java.io.*;
import java.util.*;

/**
 * Welcome to vivo !
 */

public class Main2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        String[] input = inputStr.split(" ");
        int totalDisk = Integer.parseInt(input[0]);
        int totalMemory = Integer.parseInt(input[1]);
        List<Service> services = parseServices(input[2].split("#"));
        int output = solution(totalDisk, totalMemory, services);
        System.out.println(output);
    }

    private static int solution(int totalDisk, int totalMemory, List<Service> services) {
        int[][] matrix_memory=new int[services.size()+1][totalDisk+1];
        for (int i = 0; i <totalMemory+1 ; i++) {
            matrix_memory[0][i]=0;
        }
        for (int i = 0; i <services.size()+1 ; i++) {
            matrix_memory[i][0]=0;
        }
        for (int i = 1; i < services.size()+1; i++) {
            for (int j = 1; j <totalMemory+1; j++) {
                if(j<services.get(i-1).memory){
                    matrix_memory[i][j]=matrix_memory[i-1][j];
                }else{
                    matrix_memory[i][j]=Math.max(matrix_memory[i-1][j],matrix_memory[i-1][j-services.get(i-1).memory]+services.get(i-1).users);
                }
            }
        }

        /*int[][] matrix_disk=new int[services.size()+1][totalDisk+1];
        for (int i = 0; i <totalDisk+1 ; i++) {
            matrix_disk[0][i]=0;
        }
        for (int i = 0; i <services.size()+1 ; i++) {
            matrix_disk[i][0]=0;
        }
        for (int i = 1; i < services.size()+1; i++) {
            for (int j = 1; j <totalDisk+1; j++) {
                if(j<services.get(i-1).disk){
                    matrix_disk[i][j]=matrix_disk[i-1][j];
                }else{
                    matrix_disk[i][j]=Math.max(matrix_disk[i-1][j],matrix_disk[i-1][j-services.get(i-1).disk]+services.get(i-1).users);
                }
            }
        }*/
        return 0;
    }

    private static List<Service> parseServices(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new ArrayList<Service>(0);
        }
        List<Service> services = new ArrayList<>(strArr.length);
        for (int i = 0; i < strArr.length; i++) {
            String[] serviceArr = strArr[i].split(",");
            int disk = Integer.parseInt(serviceArr[0]);
            int memory = Integer.parseInt(serviceArr[1]);
            int users = Integer.parseInt(serviceArr[2]);
            services.add(new Service(disk, memory, users));
        }
        return services;
    }

    static class Service {
        private int disk;

        private int memory;

        private int users;

        public Service(int disk, int memory, int users) {
            this.disk = disk;
            this.memory = memory;
            this.users = users;
        }

        public int getDisk() {
            return disk;
        }

        public void setDisk(int disk) {
            this.disk = disk;
        }

        public int getMemory() {
            return memory;
        }

        public void setMemory(int memory) {
            this.memory = memory;
        }

        public int getusers() {
            return users;
        }

        public void setusers(int users) {
            this.users = users;
        }
    }
}