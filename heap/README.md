Heap

*Concepts*

`Complete Binary Tree` - In a complete binary tree, all the levels of a tree are filled entirely except the last level.   
In the last level, nodes might or might not be filled fully.   
Also, let’s note that all the nodes should be filled from the left.  
This property of Binary Heap makes them suitable to be stored in an array.  

`Min Heap` - In a Min Binary Heap, the key at the root must be minimum among all keys present in Binary Heap. 
The same property must be recursively true for all nodes in Binary Tree.

`Max Heap` - Exactly opposite of a `Min Heap`

Since we can represent Complete Binary Tree as an array, it is important to know the relationship between the root and the child nodes.
Given `root` at index `n`, the indices of children can be calculated as follows:  
`left = 2*n`  
`right = (2*n) + 1`


https://www.youtube.com/watch?v=HqPJF2L5h9U


Implementations:
- Binary Min Heap
- Heapify (Algorthim to restore the Complete Binary Tree property)
- Heap Sort
- Priority Queue using a Binary Min Heap, from first principles.