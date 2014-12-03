package graphimmplement.graph;

import java.util.LinkedList;

public abstract class AbstractGraph {
    int maxNodes;
    Vertex origin;
    LinkedList[] nodeLists;
    public abstract void addEdge(Vertex a, Vertex b);
    public abstract void addVertex(GraphVertex parent, Object content);
    public abstract void getVertex(Object o);
    public abstract void BFS(Vertex origin);
    public abstract void DFS(Vertex origin);
    @Override
    public abstract String toString();
}
