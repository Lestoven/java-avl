# <a href="https://en.wikipedia.org/wiki/AVL_tree" target="_blank">AVL tree</a> implementation in <span style="color:red">**Java**</span>
The **AvlTree** class represents the tree structure. To avoid using *null*, all occurrences of **Node** are wrapped with *Optional*. The children of leaf nodes are represented as *Optional.empty()*, and the empty tree is also denoted by *Optional.empty()*. While using *Optional* can help prevent bugs during development, it introduces some performance overhead, which can be significant for large trees. The implementation is more of a playful experiment driven by my curiosity.
In a real-world codebase, it might be better to use *null* within the **AvlTree** and **Node** classes for private members and use *Optional* exclusively for parts exposed to API consumers.