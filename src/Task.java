package task;

public class Task {
    public static void main(String[] args) {
        int[][] field ={
                {4, 4, 4, 4},
                {4, 2, 2, 4},
                {4, 2, 2, 4},
                {2, 1, 1, 2},
                {2, 4, 2, 2},
        };

        int[][] field0 ={
                {4, 4, 3, 3, 5},
                {4, 3, 3, 1, 3},
                {4, 1, 3, 2, 5},
                {3, 3, 3, 2, 2},
                {1, 1, 3, 3, 5},
                {3, 2, 2, 2, 5},
                {3, 3, 2, 3, 5},
        };
        int[][] field6 ={
                {4, 4, 4, 4, 4},
                {4, 2, 2, 3, 4},
                {3, 1, 3, 1, 2},
                {2, 4, 3, 2, 2},

        };
        int[][] field1 ={
                {1, 2, 2, 3},
                {2, 2, 1, 4},
                {4, 5, 6, 2},
        };
        int[][] field2 ={
                {2, 2, 3, 2},
                {3, 1, 2, 4},
                {4, 3, 3, 2},
        };

        int[][] field3 ={
                {2, 3, 4, 2},
                {2, 1, 3, 4},
                {3, 2, 3, 2},
                {2, 4, 2, 2},
        };

        int[][] field4 ={
                {3, 3, 3, 3},
                {3, 1, 3, 3},
                {3, 2, 1, 2},
                {3, 3, 3, 2},

        };
        int[][] field5 ={
                {3, 3, 3, 3},
                {3, 3, 1, 3},
                {3, 1, 2, 3},
                {3, 3, 2, 2},
        };
        print(findWater(field));
        System.out.println();
        print(findWater(field0));
        System.out.println();
        print(findWater(field1));
        System.out.println();
        print(findWater(field2));
        System.out.println();
        print(findWater(field3));
        System.out.println();
        print(findWater(field4));
        System.out.println();
        print(findWater(field5));
        System.out.println();
        print(findWater(field6));


    }
    public  static int[][] findWater (int[][] field){
        if (field== null)
            return null;
        int [][] water = new int [field.length] [field[0].length] ;
        int max = field[1][1];
        for (int i = 1;  i<field.length-1; i++){
            for (int j = 1; j< field[0].length-1; j++ ){
                if (max<field[i][j])
                    max= field[i][j];
            }
        }
        for (int k = 0; k<field.length; k++) {
            for (int z = 0; z < field[0].length; z++) {
                int up = 0;
                int down = 0;
                int right = 0;
                int left = 0;
                if (k == 0 || k == field.length - 1 || z == 0 || z == field[0].length - 1 || field[k][z] == 0)
                    water[k][z] = 0;
                else {
                    for (int m = z - 1; m >= 0; m--) {
                        if (field[k][m] == 0) {
                            water[k][z] = 0;
                            break;
                        }
                        if (field[k][m] >= field[k][m + 1]) {
                            if (field[k][m] > left)
                                left = field[k][m];
                        } else {
                            if (left > 0)
                                left = left;
                            else
                                left = 0;
                        }
                    }
                    for (int n = z + 1; n < field[k].length; n++) {
                        if (field[k][n] == 0) {
                            water[k][z] = 0;
                            break;
                        }
                        if (field[k][n] >= field[k][n - 1]) {
                            if (field[k][n] > right)
                                right = field[k][n];
                        } else {
                            if (right > 0)
                                right = right;
                            else
                                right = 0;
                        }
                    }
                    for (int q = k - 1; q >= 0; q--) {
                        if (field[q][z] == 0) {
                            water[k][z] = 0;
                            break;
                        }
                        if (field[q][z] >= field[q + 1][z]) {
                            if (field[q][z] > up)
                                up = field[q][z];
                        } else {
                            if (up > 0)
                                up = up;
                            else
                                up = 0;
                        }
                    }

                    for (int r = k + 1; r < field.length; r++) {
                        if (field[r][z] == 0) {
                            water[k][z] = 0;
                            break;
                        }
                        if (field[r][z] >= field[r - 1][z]) {
                            if (field[r][z] > down)
                                down = field[r][z];
                        } else {
                            if (down > 0)
                                down = down;
                            else
                                down = 0;
                        }

                    }
                    int min = Math.min(Math.min(up, down), Math.min(right, left));
                    if (field[k][z]==0){
                        water[k-1][z]=0;
                        water[k][z-1]=0;
                    }
                    else if (field[k-1][z]==0 || field[k][z-1]==0)
                        water[k][z]=0;
                    else if (field[k][z]==min)
                        water[k][z] = 0;
                    else water[k][z]=min;

                    if (min == field[k][z])
                    {water[k][z] = 0;
                        if (water[k][z-1]<water[k][z])
                        { water[k][z-1]=min;
                            if (water[k][z-1] == field[k][z-1])
                                water[k][z-1]=0; }
                        if (water[k-1][z]<water[k][z]  )
                        { water[k-1][z]=min;
                            if (water[k-1][z]==field[k-1][z])
                                water[k-1][z]=0;}
                    }
                    else if(field[k][z]>=water[k][z-1] && z-1!=0 && min>field[k][z-1] )
                    {
                        if(water[k][z] >= field[k][z-1] && field[k][z]>= field[k][z-1])
                            water[k][z] = 0;
                        else water[k][z] = field[k][z-1];}
                    else if( field[k][z]>=water[k-1][z] && k-1!=0 && min>field[k-1][z])
                    {
                        if (water[k][z] >= field[k-1][z] && field[k][z] >= field[k-1][z] )
                            water[k][z] = 0;
                        else water[k][z] = field[k-1][z];}
                    else
                        water[k][z] = min;

                    if (min < field[k][z])
                        water[k][z] = 0;
                    if (water[k][z-1]>0 && water[k][z] > water[k][z-1] )
                        water[k][z] = water[k][z-1];
                    if ( water[k-1][z]>0 &&  water[k][z] > water[k-1][z])
                        water[k][z] = water[k-1][z];
                }}
        }

//------сверху-вправо
        for (int i = 1; i<field.length-1; i++) {
            for (int j = 1; j < field[0].length-1; j++) {
                if (field[i][j] <= field[i][j + 1] && water[i][j] < water[i][j + 1]) {
                    if (field[i][j + 1] >= water[i][j])
                        water[i][j + 1] = 0;
                    else water[i][j + 1] = water[i][j];
                }
                if (field[i][j] <= field[i + 1][j] && water[i][j] < water[i + 1][j]) {
                    if (field[i + 1][j] >= water[i][j])
                        water[i + 1][j] = 0;
                    else water[i + 1][j] = water[i][j];
                }

                if (field[i][j]>= field[i+1][j] && water[i+1][j]> field[i][j] && water[i+1][j]> water[i][j] ){ //corr
                    if (field[i+1][j] == field[i][j])
                        water[i+1][j] = 0;
                    else water[i+1][j] = field[i][j];
                }
                if (field[i][j]>= field[i][j+1] && water[i][j+1]> field[i][j] && water[i][j+1]> water[i][j] ){ //corr
                    if (field[i][j+1] == field[i][j])
                        water[i][j+1] = 0;
                    else water[i][j+1] = field[i][j];
                }
            }}

        for (int i = 1; i<field.length-1; i++) {
            for (int j = 1; j < field[0].length-1; j++) {
                if( (field[i][j]== field[i][j-1] || field[i][j]== water[i][j-1]) && water[i][j]< water[i+1][j] && field[i][j]> field[i+1][j] && field[i][j] != max)
                {if (field[i+1][j] == field[i][j])
                    water[i+1][j] = 0;
                else water[i+1][j] = field[i][j];}
                if( (field[i][j]== field[i-1][j] || field[i][j]== water[i-1][j]) && water[i][j]< water[i+1][j] && field[i][j]> field[i+1][j] && field[i][j] != max)
                {if (field[i+1][j] == field[i][j])
                    water[i+1][j] = 0;
                else water[i+1][j] = field[i][j];}
                if( (field[i][j]== field[i][j-1] || field[i][j]== water[i][j-1]) && water[i][j]< water[i][j+1] && field[i][j]> field[i][j+1] && field[i][j] != max)
                {if (field[i][j+1] == field[i][j])
                    water[i][j+1] = 0;
                else water[i][j+1] = field[i][j];}
                if( (field[i][j]== field[i-1][j] || field[i][j]== water[i-1][j]) && water[i][j]< water[i][j+1] && field[i][j]> field[i][j+1] && field[i][j] != max)
                {if (field[i][j+1] == field[i][j])
                    water[i][j+1] = 0;
                else water[i][j+1] = field[i][j];}

                if (water[i][j] == 0 && field[i][j - 1] == field[i][j] && field[i][j] <= field[i][j+1] && water[i][j] < water[i][j + 1]) {
                    if (field[i][j + 1] == water[i][j])
                        water[i][j + 1] = 0;
                    else water[i][j + 1] = water[i][j]; }
                if (water[i][j] == 0 && field[i][j - 1] == field[i][j] && field[i][j] <= field[i+1][j] && water[i][j] < water[i+1][j]) {
                    if (field[i+1][j] == water[i][j])
                        water[i+1][j] = 0;
                    else water[i+1][j] = water[i][j]; }
                if (water[i][j] == 0 && field[i-1][j] == field[i][j] && field[i][j] <= field[i+1][j] && water[i][j] < water[i+1][j]) {
                    if (field[i+1][j] == water[i][j])
                        water[i+1][j] = 0;
                    else water[i+1][j] = water[i][j]; }
                if (water[i][j] == 0 && field[i-1][j] == field[i][j] && field[i][j] <= field[i][j+1] && water[i][j] < water[i][j + 1]) {
                    if (field[i][j + 1] == water[i][j])
                        water[i][j +1] = 0;
                    else water[i][j +1] = water[i][j]; }

            }}


//---сверху-влево
        for (int i = 1; i< field.length-1; i++){
            for (int j = field[0].length-2; j>0; j--) {
                if (field[i][j] <= field[i][j - 1] && water[i][j] < water[i][j - 1]) {
                    if (field[i][j - 1] >= water[i][j])
                        water[i][j - 1] = 0;
                    else
                        water[i][j - 1] = water[i][j];
                }
                if (field[i][j] <= field[i + 1][j] && water[i][j] < water[i + 1][j]) {
                    if (field[i + 1][j] >= water[i][j])
                        water[i + 1][j] = 0;
                    else
                        water[i + 1][j] = water[i][j];
                }
                if (field[i][j]> field[i+1][j] && water[i+1][j]> field[i][j] && water[i+1][j]> water[i][j]){
                    if (field[i+1][j] == field[i][j])
                        water[i+1][j] = 0;
                    else water[i+1][j] = field[i][j];
                }
                if (field[i][j]> field[i][j-1] && water[i][j-1]> field[i][j] && water[i][j-1]> water[i][j]){
                    if (field[i][j-1] == field[i][j])
                        water[i][j-1] = 0;
                    else water[i][j-1] = field[i][j];
                }
            }}
        for (int i = 1; i< field.length-1; i++){
            for (int j = field[0].length-2; j>0; j--) {
                if( (field[i][j]== field[i][j+1] || field[i][j]== water[i][j+1]) && water[i][j]< water[i+1][j] && field[i][j]> field[i+1][j] && field[i][j] != max)
                {if (field[i+1][j] == field[i][j])
                    water[i+1][j] = 0;
                else water[i+1][j] = field[i][j];}
                if( (field[i][j]== field[i-1][j] || field[i][j]== water[i-1][j]) && water[i][j]< water[i+1][j] && field[i][j]> field[i+1][j] && field[i][j] != max)
                {if (field[i+1][j] == field[i][j])
                    water[i+1][j] = 0;
                else water[i+1][j] = field[i][j];}
                if( (field[i][j]== field[i][j+1] || field[i][j]== water[i][j+1]) && water[i][j]< water[i][j-1] && field[i][j]> field[i][j-1] && field[i][j] != max)
                {if (field[i][j-1] == field[i][j])
                    water[i][j-1] = 0;
                else water[i][j-1] = field[i][j];}
                if( (field[i][j]== field[i-1][j] || field[i][j]== water[i-1][j]) && water[i][j]< water[i][j-1] && field[i][j]> field[i][j-1] && field[i][j] != max)
                {if (field[i][j-1] == field[i][j])
                    water[i][j-1] = 0;
                else water[i][j-1] = field[i][j];}

                if (water[i][j] == 0 && field[i][j + 1] == field[i][j] && field[i][j] <= field[i][j-1] && water[i][j] < water[i][j - 1]) {
                    if (field[i][j - 1] == water[i][j])
                        water[i][j - 1] = 0;
                    else water[i][j - 1] = water[i][j]; }
                if (water[i][j] == 0 && field[i][j + 1] == field[i][j] && field[i][j] <= field[i+1][j] && water[i][j] < water[i+1][j]) {
                    if (field[i+1][j] == water[i][j])
                        water[i+1][j] = 0;
                    else water[i+1][j] = water[i][j]; }
                if (water[i][j] == 0 && field[i-1][j] == field[i][j] && field[i][j] <= field[i+1][j] && water[i][j] < water[i+1][j]) {
                    if (field[i+1][j] == water[i][j])
                        water[i+1][j] = 0;
                    else water[i+1][j] = water[i][j]; }
                if (water[i][j] == 0 && field[i-1][j] == field[i][j] && field[i][j] <= field[i][j-1] && water[i][j] < water[i][j - 1]) {
                    if (field[i][j - 1] == water[i][j])
                        water[i][j -1] = 0;
                    else water[i][j - 1] = water[i][j]; }
            }}

//----снизу-вправо
        for(int i = field.length-2; i>0; i--){
            for (int j = 1; j< field[0].length-1;  j++) {
                if (field[i][j] <= field[i][j + 1] && water[i][j] < water[i][j + 1]) {
                    if (field[i][j + 1] >= water[i][j])
                        water[i][j + 1] = 0;
                    else
                        water[i][j + 1] = water[i][j];
                }
                if (field[i][j] <= field[i - 1][j] && water[i][j] < water[i - 1][j]) {
                    if (field[i - 1][j] >= water[i][j])
                        water[i - 1][j] = 0;
                    else
                        water[i - 1][j] = water[i][j];
                }

                if (field[i][j]> field[i-1][j] && water[i-1][j]> field[i][j] && water[i-1][j]> water[i][j]){
                    if (field[i-1][j] == field[i][j])
                        water[i-1][j] = 0;
                    else water[i-1][j] = field[i][j];
                }
                if (field[i][j]> field[i][j+1] && water[i][j+1]> field[i][j] && water[i][j+1]> water[i][j] ){
                    if (field[i][j+1] == field[i][j])
                        water[i][j+1] = 0;
                    else water[i][j+1] = field[i][j];
                }
            }}
        for(int i = field.length-2; i>0; i--){
            for (int j = 1; j< field[0].length-1;  j++) {
                if( (field[i][j]== field[i][j-1] || field[i][j]== water[i][j-1]) && water[i][j]< water[i-1][j] && field[i][j]> field[i-1][j] && field[i][j] != max)
                {if (field[i-1][j] == field[i][j])
                    water[i-1][j] = 0;
                else water[i-1][j] = field[i][j];}
                if( (field[i][j]== field[i+1][j] || field[i][j]== water[i+1][j]) && water[i][j]< water[i-1][j] && field[i][j]> field[i-1][j] && field[i][j] != max)
                {if (field[i-1][j] == field[i][j])
                    water[i-1][j] = 0;
                else water[i-1][j] = field[i][j];}
                if( (field[i][j]== field[i][j-1] || field[i][j]== water[i][j-1]) && water[i][j]< water[i][j+1] && field[i][j]> field[i][j+1] && field[i][j] != max)
                {if (field[i][j+1] == field[i][j])
                    water[i][j+1] = 0;
                else water[i][j+1] = field[i][j];}
                if( (field[i][j]== field[i+1][j] || field[i][j]== water[i+1][j]) && water[i][j]< water[i][j+1] && field[i][j]> field[i][j+1] && field[i][j] != max)
                {if (field[i][j+1] == field[i][j])
                    water[i][j+1] = 0;
                else water[i][j+1] = field[i][j];}

                if (water[i][j] == 0 && field[i][j - 1] == field[i][j] && field[i][j] <= field[i][j+1] && water[i][j] < water[i][j + 1]) {
                    if (field[i][j + 1] == water[i][j])
                        water[i][j + 1] = 0;
                    else water[i][j + 1] = water[i][j]; }
                if (water[i][j] == 0 && field[i][j - 1] == field[i][j] && field[i][j] <= field[i-1][j] && water[i][j] < water[i-1][j]) {
                    if (field[i-1][j] == water[i][j])
                        water[i-1][j] = 0;
                    else water[i-1][j] = water[i][j]; }
                if (water[i][j] == 0 && field[i+1][j] == field[i][j] && field[i][j] <= field[i-1][j] && water[i][j] < water[i-1][j]) {
                    if (field[i-1][j] == water[i][j])
                        water[i-1][j] = 0;
                    else water[i-1][j] = water[i][j]; }
                if (water[i][j] == 0 && field[i+1][j] == field[i][j] && field[i][j] <= field[i][j+1] && water[i][j] < water[i][j + 1]) {
                    if (field[i][j + 1] == water[i][j])
                        water[i][j +1] = 0;
                    else water[i][j + 1] = water[i][j]; }
            }}

//----снизу-влево
        for(int i = field.length-1; i>0; i--){
            for(int j =  field[0].length-1; j>0; j--){
                if (field[i][j]<= field[i][j-1] && water[i][j]< water[i][j-1]){
                    if (field[i][j-1] >= water[i][j])
                        water[i][j-1] = 0;
                    else water[i][j-1] = water[i][j];
                }
                if (field[i][j]<= field[i-1][j] && water[i][j]< water[i-1][j]){
                    if (field[i-1][j] >= water[i][j])
                        water[i-1][j] = 0;
                    else water[i-1][j] = water[i][j];}

                if (field[i][j]> field[i-1][j] && water[i-1][j]> field[i][j] && water[i-1][j]> water[i][j] ){
                    if (field[i-1][j] == field[i][j])
                        water[i-1][j] = 0;
                    else water[i-1][j] = field[i][j];
                }
                if (field[i][j]> field[i][j-1] && water[i][j-1]> field[i][j] && water[i][j-1]> water[i][j]){
                    if (field[i][j-1] == field[i][j])
                        water[i][j-1] = 0;
                    else water[i][j-1] = field[i][j];
                }
            }}
        for(int i = field.length-2; i>0; i--) {
            for (int j = field[0].length - 2; j > 0; j--) {

                if ((field[i][j] == field[i][j + 1] || field[i][j] == water[i][j + 1]) && water[i][j] < water[i - 1][j] && field[i][j] >= field[i - 1][j] && field[i][j] != max) {
                    if (field[i - 1][j] == field[i][j])
                        water[i - 1][j] = 0;
                    else water[i - 1][j] = field[i][j];
                }
                if ((field[i][j] == field[i + 1][j] || field[i][j] == water[i + 1][j]) && water[i][j] < water[i - 1][j] && field[i][j] >= field[i - 1][j] && field[i][j] != max) {
                    if (field[i - 1][j] == field[i][j])
                        water[i - 1][j] = 0;
                    else water[i - 1][j] = field[i][j];
                }
                if ((field[i][j] == field[i][j + 1] || field[i][j] == water[i][j + 1]) && water[i][j] < water[i][j - 1] && field[i][j] >= field[i][j - 1] && field[i][j] != max) {
                    if (field[i][j - 1] == field[i][j])
                        water[i][j - 1] = 0;
                    else water[i][j - 1] = field[i][j];
                }
                if ((field[i][j] == field[i + 1][j] || field[i][j] == water[i + 1][j]) && water[i][j] < water[i][j - 1] && field[i][j] >= field[i][j - 1] && field[i][j] != max) {
                    if (field[i][j - 1] == field[i][j])
                        water[i][j - 1] = 0;
                    else water[i][j - 1] = field[i][j];
                }

                if (water[i][j] == 0 && field[i][j + 1] == field[i][j] && field[i][j] <= field[i][j-1] && water[i][j] < water[i][j - 1]) {
                    if (field[i][j - 1] == water[i][j])
                        water[i][j - 1] = 0;
                    else water[i][j - 1] = water[i][j]; }
                if (water[i][j] == 0 && field[i][j + 1] == field[i][j] && field[i][j] <= field[i-1][j] && water[i][j] < water[i-1][j]) {
                    if (field[i-1][j] == water[i][j])
                        water[i-1][j] = 0;
                    else water[i-1][j] = water[i][j]; }
                if (water[i][j] == 0 && field[i+1][j] == field[i][j] && field[i][j] <= field[i-1][j] && water[i][j] < water[i-1][j]) {
                    if (field[i-1][j] == water[i][j])
                        water[i-1][j] = 0;
                    else water[i-1][j] = water[i][j]; }
                if (water[i][j] == 0 && field[i+1][j] == field[i][j] && field[i][j] <= field[i][j-1] && water[i][j] < water[i][j - 1]) {
                    if (field[i][j - 1] == water[i][j])
                        water[i][j - 1] = 0;
                    else water[i][j - 1] = water[i][j]; }
            }
        }

        return water;
    }
    static void print (int[][] water){
        for (int i = 0; i<water.length; i++){
            for (int j = 0 ; j< water[0].length; j++){
                System.out.print(water[i][j] +" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
