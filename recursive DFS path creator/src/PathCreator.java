import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PathCreator {
    int[][] track;
    int a,b;
    Random random;

    PathCreator(int a, int b){
        this.a = a;
        this.b = b;
        random = new Random();

        track = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                track[i][j] = 0;
            }
        }
    }

    int[][] create(){
        next_tile(0, 0);
        return  track;
    }
    int next_tile(int x, int y){
        if (track[x][y]==1){
            return 1;
        }
        track[x][y] = 1;
        if (x==a-1 && y==b-1){
            track[x][y] = 2;
            return 2;
        }

        List<int[]> tiles = addTiles(x,y);
        if (tiles.isEmpty()){
            return 1;
        }

        int i = random.nextInt(tiles.size());
        for (int j = 0; j < tiles.size(); j++){
            int flag = next_tile(tiles.get((j+i)%tiles.size())[0],tiles.get((j+i)%tiles.size())[1]);
            if (flag == 2){
                track[x][y] = 2;
                return 2;
            }
        }
        return 1;
    }
    List<int[]> addTiles(int x, int y) {
        List<int[]> pairs = new ArrayList<>();
        if (x > 0 && track[x - 1][y] == 0 && !next_to_the_path(x - 1, y)) {
            pairs.add(new int[]{x - 1, y});
        }
        if (x < a - 1 && track[x + 1][y] == 0 && !next_to_the_path(x + 1, y)) {
            pairs.add(new int[]{x + 1, y});
        }
        if (y > 0 && track[x][y - 1] == 0 && !next_to_the_path(x, y - 1)) {
            pairs.add(new int[]{x, y - 1});
        }
        if (y < b - 1 && track[x][y + 1] == 0 && !next_to_the_path(x, y + 1)) {
            pairs.add(new int[]{x, y + 1});
        }
        return pairs;
    }

    boolean next_to_the_path(int x, int y) {
        int n = 0;
        if (x > 0 && track[x - 1][y] == 1) {
            n++;
        }
        if (x < a - 1 && track[x + 1][y] == 1) {
            n++;
        }
        if (y > 0 && track[x][y - 1] == 1) {
            n++;
        }
        if (y < b - 1 && track[x][y + 1] == 1) {
            n++;
        }
        return n != 1;
    }

}
/*

0 - nieodwiedzone
1 - odwiedzone
2 - ścieżka - jak dojdzie do końca to zaczyna zwracać do gałęzi nad nim że to jest ścieżka


 */