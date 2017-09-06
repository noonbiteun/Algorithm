package graph;

/**
 * Created by zf
 * Date: 2017/8/11
 */
public class GraphMatrix {
    private static final int MAX_NUM = 20;
    private static final int MAX_VALUE = 65535;

    private int vertexNum;//顶点数量
    private int edgeNum;//边数量
    private String[] vertex;//顶点数组
    private int graphType;//图类型：0无向
    private int[][] edge;
    private int[] isTraversal;

    public void creatGraph(String[] vertex, int[][] edge, int graphType) {
        if (vertex == null || vertex.length > MAX_NUM) {
            System.out.println("图创建失败，顶点数组错误");
            return;
        }
        this.vertex = vertex;
        this.edge = edge;
        this.graphType = graphType;
        this.vertexNum = vertex.length;
        this.edgeNum = sumEdgeNum(edge, graphType);
    }

    //计算边的数量
    private int sumEdgeNum(int[][] edge, int graphType) {
        int sum = 0;
        if (graphType == 0) {
            //无向图
            for (int i = 0; i < edge.length; i++) {
                for (int j = 0; j <= i; j++) {
                    sum++;
                }
            }
        } else if (graphType == 1) {
            //有向图
            for (int i = 0; i < edge.length; i++) {
                for (int j = 0; j < edge.length; j++) {
                    sum++;
                }
            }
        }
        return sum;
    }

    //清空图
    public void clearGraph(GraphMatrix graphMatrix) {
        graphMatrix.vertex = null;
        graphMatrix.edge = null;
        graphMatrix.vertexNum = 0;
        graphMatrix.edgeNum = 0;
        graphMatrix.graphType = 0;
    }

    //输出图
    public void outGraph(GraphMatrix graphMatrix) {
        for (int i = 0; i < graphMatrix.vertexNum; i++) {
            System.out.printf("\t%s", graphMatrix.vertex[i]);
        }
        System.out.println();
        for (int i = 0; i < graphMatrix.vertexNum; i++) {
            System.out.printf("%s", graphMatrix.vertex[i]);
            for (int j = 0; j < graphMatrix.vertexNum; j++) {
                System.out.printf("\t%d", graphMatrix.edge[i][j]);
            }
            System.out.println();
        }
    }

    //深度遍历第n个顶点
    private void deepTraversal(GraphMatrix gm, int n) {
        gm.isTraversal[n] = 1;//表示该点已经处理
        System.out.printf("->%s", gm.vertex[n]);
        //遍历该顶点的邻接点
        for (int i = 0; i < gm.vertexNum; i++) {
            if (gm.edge[n][i] != 0 && gm.isTraversal[i] == 0) {
                //递归
                deepTraversal(gm, i);
            }
        }
    }

    public void deepTraversalGraph(GraphMatrix gm) {
        gm.isTraversal = new int[gm.vertexNum];
        for (int i = 0; i < gm.vertexNum; i++) {
            gm.isTraversal[i] = 0;
        }
        System.out.println("深度优先遍历：");
        for (int i = 0; i < gm.vertexNum; i++) {
            if (gm.isTraversal[i] == 0) {
                deepTraversal(gm, i);
            }
        }
        System.out.println();
    }

    //广度优先遍历
    public void wideTraversalGraph(GraphMatrix gm) {
        gm.isTraversal = new int[gm.vertexNum];
        for (int i = 0; i < gm.vertexNum; i++) {
            gm.isTraversal[i] = 0;
        }
        int head = 0;
        int tail = 0;
        gm.isTraversal[0] = 1;
        tail++;
        System.out.printf("->%s", gm.vertex[0]);
        while (head != tail) {
            for (int i = 0; i < gm.vertexNum; i++) {
                if (gm.edge[head][i] != 0 && gm.isTraversal[i] == 0) {
                    System.out.printf("->%s", gm.vertex[i]);
                    tail++;
                    gm.isTraversal[i] = 1;
                }
            }
            head++;
        }
    }
}
