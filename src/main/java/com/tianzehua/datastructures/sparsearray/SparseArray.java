package com.tianzehua.datastructures.sparsearray;

/**
 * 稀疏数组的应用--棋盘的存盘和复盘
 * <p>
 *     因为棋盘中会存在大量的空的位置，那么使用普通的二维数组存盘的话，
 *     会浪费大量的存储空间，所以采用稀疏数组来进行棋盘的存盘和复盘；
 * </p>
 * @author tianzehua
 * @date 2019/07/11
 */
public class SparseArray {

    public static void main(String[] args) {
        /* 1.构建一个11*11的棋盘 */
        /* 创建一个原始的二维数组，0代表没有棋子，1代表黑子，2代表白色棋子 */
        int chessArr[][] = new int[11][11];
        /* 2.在棋盘的第二排，第三列落黑子，在棋盘的第三排，第四列落白子 */
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;

        /* 打印棋盘 */
        for (int[] ints : chessArr) {
            for (int anInt : ints) {
                System.out.print(anInt + "  ");
            }
            System.out.println();
        }

        /* 3.开始存盘*/
        /* 将普通的二维数组转换成稀疏数组 */
        /* 思路，1.稀疏数组的第一行要知道二维数组的大小和包含的值
        2.将每个值的位置信息和值的信息放入到稀疏数组当中
         稀疏数组的行为有效数据的值+1，列数为3 */

        /* 创建稀疏数组 */
        /* 获取棋盘数组的有效数据个数 */
        int flag =0;
        int count =1;

        for (int i  = 0;i < 11 ; i++) {
            for (int j  = 0;j < 11 ; j++) {
                if (chessArr[i][j] > 0){
                    flag++;
                }
            }
        }

        int sparseArr[][] = new  int[flag+1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = flag;

        for (int i  = 0;i < 11 ; i++) {
            for (int j  = 0;j < 11 ; j++) {
                if (chessArr[i][j] > 0){
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                    count++;
                }
            }
        }

        /* 打印稀疏数组 */
        System.out.println("---------------------------");
        for (int[] ints : sparseArr) {
            for (int anInt : ints) {
                System.out.print(anInt+ "  ");
            }
            System.out.println();
        }

        /* 4.开始复盘 */
        /* 将稀疏数组变为普通的二维数组 */
        int h =  sparseArr[0][0];
        int l =  sparseArr[0][1];
        int z =  sparseArr[0][2];

        int  arr[][] = new int[h][l];
        for (int i  = 1;i <z + 1 ; i++) {
            arr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        System.out.println("---------------------");
        /* 打印棋盘 */
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + "  ");
            }
            System.out.println();
        }

    }

}
