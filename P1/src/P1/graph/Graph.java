/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P1.graph;

import java.util.Map;
import java.util.Set;

/**
 * A mutable weighted directed graph with labeled vertices.
 * Vertices have distinct labels of an immutable type {@code L} when compared
 * using the {@link Object#equals(Object) equals} method.
 * Edges are directed and have a positive weight of type {@code int}.
 * 
 * <p>PS2 instructions: this is a required ADT interface.
 * You MUST NOT change the specifications or add additional methods.
 * 
 * @param <L> type of vertex labels in this graph, must be immutable
 */
public interface Graph<L> {
	static final int MaxSize = 20;         //图的最大顶点数
	static final int INFINITE = 65535;    //最大值
	class GraphMaterix{
		int GType;      //图的类型（0:无向图  1：有向图）
		int VertexNum[] = new int[MaxSize];        //顶点集合
		static int EdgeWeight[][] = new int [MaxSize][MaxSize];   // 边集合
	
    
    /**
     * Create an empty graph.
     * 
     * @param <L> type of vertex labels in the graph, must be immutable
     * @return a new empty weighted directed graph
     */

    public static <L> Graph<L> empty() {
        /*throw new RuntimeException("not implemented");*/
    	int i,j;
    	
        for (i = 0; i < MaxSize; i++) {
            for (j = 0; j < MaxSize; j++) {
                if (i == j) {
                	EdgeWeight[i][j] = 0;
                }
                else {
                    EdgeWeight[i][j] = INFINITE;
                }
            }
        }
		return null;
    
    }
    
    /**
     * Add a vertex to this graph.
     * 
     * @param vertex label for the new vertex 标记为新的顶点
     * @return true if this graph did not already include a vertex with the 
     * given label; otherwise false (and this graph is not modified)
     *如果这个图没有包含一个顶点，则返回true。
     *给定的标签；否则为false（此图未被修改）
     */
    
    public boolean add(L vertex);
    {
    	
    }
    
    /**
     * Add, change, or remove a weighted directed edge in this graph.
     * If weight is nonzero, add an edge or update the weight of that edge;
     * vertices with the given labels are added to the graph if they do not
     * already exist.
     * If weight is zero, remove the edge if it exists (the graph is not
     * otherwise modified).
     * 
     * @param source label of the source vertex
     * @param target label of the target vertex
     * @param weight nonnegative weight of the edge
     * @return the previous weight of the edge, or zero if there was no such
     *         edge
     */
    public int set(L source, L target, int weight);
    
    /**
     * Remove a vertex from this graph; any edges to or from the vertex are
     * also removed.
     * 
     * @param vertex label of the vertex to remove
     * @return true if this graph included a vertex with the given label;
     *         otherwise false (and this graph is not modified)
     */
    public boolean remove(L vertex);
    
    /**
     * Get all the vertices in this graph.
     * 
     * @return the set of labels of vertices in this graph
     */
    public Set<L> vertices();
    
    /**
     * Get the source vertices with directed edges to a target vertex and the
     * weights of those edges.
     * 
     * @param target a label
     * @return a map where the key set is the set of labels of vertices such
     *         that this graph includes an edge from that vertex to target, and
     *         the value for each key is the (nonzero) weight of the edge from
     *         the key to target
     */
    public Map<L, Integer> sources(L target);
    
    /**
     * Get the target vertices with directed edges from a source vertex and the
     * weights of those edges.
     * 
     * @param source a label
     * @return a map where the key set is the set of labels of vertices such
     *         that this graph includes an edge from source to that vertex, and
     *         the value for each key is the (nonzero) weight of the edge from
     *         source to the key
     */
    public Map<L, Integer> targets(L source);
    
}
