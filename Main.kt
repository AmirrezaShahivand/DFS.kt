class Graph(val vertices: Int) {
    private val adjacencyList = Array<MutableList<Int>>(vertices) { mutableListOf() }

    fun addEdge(start: Int, end: Int) {
        adjacencyList[start].add(end)
    }

    fun dfs(startVertex: Int) {
        val visited = BooleanArray(vertices)
        dfsRecursive(startVertex, visited)
    }

    private fun dfsRecursive(vertex: Int, visited: BooleanArray) {
        visited[vertex] = true
        print("$vertex ")

        for (neighbour in adjacencyList[vertex]) {
            if (!visited[neighbour]) {
                dfsRecursive(neighbour, visited)
            }
        }
    }
}

fun main() {
    val graph = Graph(7)

    graph.addEdge(0, 1)
    graph.addEdge(0, 2)
    graph.addEdge(1, 3)
    graph.addEdge(1, 4)
    graph.addEdge(2, 5)
    graph.addEdge(2, 6)

    println("DFS traversal starting from vertex 0:")
    graph.dfs(0)
}
