/**
 * Created by Firdaus on 2/20/2016.
 */
import  java.util .*;
public  class  ControlFlowGraph {
    //  invariant: set "nodes" contains  all  nodes  in the graph , i.e., if
//  there is an edge "m->n", both "m" and "n" are in "nodes"
    Set <Node> nodes; // set of nodes
    Map <Node, Set <Node >> edges;    //  adjacency  set


    ///////////////////////////////////////////
   ///////////////////////////////////////////
  //Node/////////////////////////////////////
    static class  Node {
        String  clazz;   //  containing  class
        String  method; //  containing  method
        int id;               //  unique  identifier

        public  Node(String  clazz , String  method , int id) {
            this.clazz = clazz;
            this.method = method;
            this.id = id;
        }

        public  String  toString () {
            return  clazz + "." + method + ": " + id;
        }

        public  boolean  equals(Object o) {
//  postcondition: returns  true  iff  all  attributes  match (up to "equals ")
            //return (this == o);          // o.equals(this);              //
            if(!(o instanceof Node))
                return false;
            if(o.hashCode() == this.hashCode())
            {
                return true;
            }
            return false;
        }
        public  int  hashCode () {
//  postcondition: satisfies  the hash -code  contract
            //...
            int ascii = 0;
            int counter = 3;
            String temp = clazz + method + id;
          for(int i = 0; i < temp.length(); i++ )
              ascii += (counter*((int)temp.charAt(i)));
            return ascii;
        }
    }
///////////////////////////////////////////
///////////////////////////////////////////
///////////////////////////////////////////

    public  String  toString () { // for  ControlFlowGraph
        return  "#nodes = " + nodes.size() + "\n nodes = " + nodes + "\n edges = " + edges;
    }
    public  ControlFlowGraph () {
        nodes = new  HashSet <Node>();
        edges = new  HashMap<Node,Set <Node>>();
    }
    public  void  addNode(String  clazz , String  method , int id) {
//  postcondition: adds  Node(clazz , method , id) to the  set of nodes , and if the
// node is not  previously  in the set , updates  the  adjacency -set
//  representation  to map  the  given  node to an empty  set
        //...
        Node temp = new Node(clazz, method, id);

        if (nodes.contains(temp)) {
            return;
        } else {
            nodes.add(temp);
                }
        Set <Node> TempNodes = new HashSet<Node>();
        edges.put(temp,TempNodes);       // the node is now pointing to an empty set.
    }

    public void addEdge(String  clazz1 , String  method1 , int id1 ,
                          String  clazz2 , String  method2 , int  id2) {
//  postcondition: adds  edge  Node(clazz1 , method1 , id1) -> Node(clazz2 , method2 , id2)
// if any of the  two  nodes  is not  already  in the  set of nodes ,
// the  set is  updated  to  include  them
        Node temp1 = new Node(clazz1, method1, id1);
        Node temp2 = new Node(clazz2, method2, id2);

        if(!nodes.contains(temp1))
            {
                nodes.add(temp1);
            }
        if (!nodes.contains(temp2))
            {
                nodes.add(temp2);
            }
       // edges.put(temp1,nodes);
        Set <Node> tempNodes;
        if(edges.containsKey(temp1))                //Java.lang.String.equalsIgnoreCase()
        {   //("hello", (k, v) -> v + 1);
            edges.computeIfPresent(temp1, (k,v)->{
                boolean add = v.add(temp2);
                return v;
            });
        }
        //...
    }
    public void addEdge(String  clazz , String  method , int id1 , int  id2) {
//  postcondition: adds  edge  between  nodes  identified  by "id1" and "id2",
// which  are in the  same  method "method" in class "clazz"
        //...
        Node temp1 = new Node(clazz, method, id1);
        Node temp2 = new Node(clazz, method, id2);
        if(edges.containsKey(temp1))                //Java.lang.String.equalsIgnoreCase()
        {   //("hello", (k, v) -> v + 1);
            edges.computeIfPresent(temp1, (k, v) -> {
                boolean add = v.add(temp2);
                return v;
            });
        }

    }
}