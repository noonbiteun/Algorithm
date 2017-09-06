package graph;

/**
 * Created by zf
 * Date: 2017/8/11
 */
public class GrapgMatrixTest {
    public static void main(String[] args) {
        String[] vertex = {"a", "b", "c", "d", "e"};
        int[][] edge =
                        {{0, 1, 0, 0, 1},
                         {1, 0, 0, 1, 0},
                         {0, 0, 0, 1, 0},
                         {0, 1, 1, 0, 0},
                         {1, 0, 0, 0, 0}};
        GraphMatrix gm = new GraphMatrix();
        gm.creatGraph(vertex, edge, 0);
//        gm.deepTraversalGraph(gm);
//        gm.outGraph(gm);
        gm.wideTraversalGraph(gm);
    }
}
