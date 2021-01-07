/*--------------------------------------------------------------------------------------------------------------------
*author:        Benjamin Davis
* description:  implements the history class, which is a bas to store the threads that are started as well as
*               to store linear linked lists of responses
* class:        CS202
* date:         2019-08-09
--------------------------------------------------------------------------------------------------------------------*/
package Asgn5;

public class History extends Resp_Hist{
    Hist_Node root;


    //-----------------------------------------------------------
    //function:     constructor
    //description:  initialized head to null
    //args:         none
    //return:       none
    //-----------------------------------------------------------
    public History()
    {
       root = null;
    }



    //-----------------------------------------------------------
    //function:     insert
    //description:  inserts a new history thread into the tree
    //args:         toInsert - the hist node being inserted
    //return:       root - the new root of the tree
    //-----------------------------------------------------------
    public Hist_Node insert(Hist_Node toInsert)
    {
        this.root = insert(this.root, toInsert);
        return this.root;
    }



    //-----------------------------------------------------------
    //function:     insert
    //description:  inserts a new history thread into the tree
    //args:         root - the current "root" in the tree
    //              toInsert - the hist node being inserted
    //return:       root - the new root of the tree
    //-----------------------------------------------------------
    protected Hist_Node insert(Hist_Node root, Hist_Node toInsert)
    {
        if(root == null)
        {
           root = toInsert;
           root.left = null;
           root.right = null;
           return root;
        }


        if(root.left == null && toInsert.topic.compareToIgnoreCase(root.topic) <= 0)
        {
            root.left = toInsert;
            //root.left.left = null;
            //root.left.right = null;
            return root;
        }

        if(root.right == null && toInsert.topic.compareToIgnoreCase(root.topic) > 0)
        {
            root.right = toInsert;
            //root.right.right = null;
            //root.left.right = null;
            return root;
        }

        if(toInsert.topic.compareToIgnoreCase(root.topic) <= 0)
            root.right = insert(root.right, toInsert);

        if(toInsert.topic.compareToIgnoreCase(root.topic) > 0)
            root.left = insert(root.left, toInsert);

        return root;
    }



    //-----------------------------------------------------------
    //function:     remove
    //description:  removes a node from history
    //args:         root - the current "root" of the tree
    //              toRemove - the hist node being removed
    //return:       root - the root of the modified tree
    //-----------------------------------------------------------
    public Hist_Node remove(Hist_Node toRemove)
    {
        this.root = remove(this.root, toRemove);
        return this.root;
    }



    //-----------------------------------------------------------
    //function:     remove
    //description:  removes a node from history
    //args:         root - the current "root" of the tree
    //              toRemove - the hist node being removed
    //return:       root - the root of the modified tree
    //-----------------------------------------------------------
    protected Hist_Node remove(Hist_Node root, Hist_Node toRemove)
    {
        if(root == null)
            return root; //we did not find it

        if(root.equals(toRemove))
        {
            //no children
            if (root.left == null && root.right == null) {
                root = noChildren(root, toRemove);
                return this.root;
            }

            //left child
            if (root.left != null && root.right == null) {
                root = leftChild(root, toRemove);
                return this.root;
            }

            //right child
            if (root.left == null && root.right != null) {
                root = rightChild(root, toRemove);
                return this.root;
            }

            //two children
            if (root.left != null && root.right != null) {
                root = bothChildren(root, toRemove);
                return this.root;

            }
        }

       if(root.left != null && root.left.equals(toRemove)) {
           //no children
           if (root.left.right == null && root.left.left == null) {
               root = noChildren(root, toRemove);
               return this.root;
           }

           //left child
           if (root.left.left != null && root.left.right == null) {
               root = leftChild(root, toRemove);
               return this.root;
           }

           //right child
           if (root.left.left == null && root.left.right != null) {
               root = rightChild(root, toRemove);
               return this.root;
           }

           //two children
           if (root.left.right != null && root.left.right != null) {
               root = bothChildren(root, toRemove);
               return this.root;
           }
       }

       if(root.right != null && root.right.equals(toRemove))
       {
           //no children
           if(root.right.right == null && root.right.left == null)
           {
               root = noChildren(root, toRemove);
               return this.root;
           }

           //left child
           if(root.right.left != null && root.right.right ==null)
           {
               root = leftChild(root, toRemove);
               return this.root;
           }

           //right child
           if(root.right.left == null && root.right.right != null)
           {
               root = rightChild(root, toRemove);
               return this.root;
           }

           //two children
           if(root.right.right != null && root.right.right != null)
           {
               root = bothChildren(root, toRemove);
               return this.root;
           }
       }

       if(root.topic.compareTo(toRemove.topic) > 0)
           return remove(root.right, toRemove);

       if(root.topic.compareTo(toRemove.topic) <= 0)
           return remove(root.right, toRemove);

       return root;
    }



    //-----------------------------------------------------------
    //function:     noChildren
    //description:  removes a given node from the tree provided
    //              that node has no children
    //args:         toRemove - the node with no children to remove
    //              prevRemove - the node before the one to remove
    //return:       prevRemove - the modified node before
    //-----------------------------------------------------------
    protected Hist_Node noChildren(Hist_Node prevRemove, Hist_Node toRemove)
    {
        if(prevRemove == null || toRemove == null)
            return this.root;

        if(prevRemove.equals(toRemove))
        {
            prevRemove = null;
            return prevRemove;
        }

        if(prevRemove.left == toRemove)
            prevRemove.left = null;

        if(prevRemove.right == toRemove)
            prevRemove.right = null;

        return prevRemove;
    }




    //-----------------------------------------------------------
    //function:     leftChild
    //description:  removes a given node from the tree, provided
    //              only has a left child
    //args:         toRemove - the node with no children to remove
    //              prevRemove - the node before the one to remove
    //return:       this.root - the root of the modified tree
    //-----------------------------------------------------------
    protected Hist_Node leftChild(Hist_Node prevRemove, Hist_Node toRemove)
    {
        if(prevRemove == null || toRemove == null)
            return this.root;

        if(prevRemove.equals(root) && root.equals(toRemove))
        {
            root = root.left;
            return root;
        }

        if(prevRemove.left.equals(toRemove))
        {
           prevRemove.left = prevRemove.left.left;
           return prevRemove;
        }

        if(prevRemove.right.equals(toRemove))
        {
           prevRemove.right = prevRemove.right.left;
           return prevRemove;
        }

      return prevRemove;
    }



    //-----------------------------------------------------------
    //function:     rightChild
    //description:  removes a given node from the tree, provided
    //              only has a right child
    //args:         toRemove - the node with no children to remove
    //              prevRemove - the node before the one to remove
    //return:       this.root - the root of the modified tree
    //-----------------------------------------------------------
    protected Hist_Node rightChild(Hist_Node prevRemove, Hist_Node toRemove)
    {
        if(prevRemove == null || toRemove == null)
            return this.root;

        if(prevRemove.equals(root) && root.equals(toRemove))
        {
            root = root.right;
            return root;
        }

        if(prevRemove.right.equals(toRemove))
        {
            prevRemove.right = prevRemove.right.right;
            return prevRemove;
        }

        if(prevRemove.left.equals(toRemove))
        {
            prevRemove.left = prevRemove.left.right;
            return prevRemove;
        }

        return prevRemove;
    }



    //-----------------------------------------------------------
    //function:     bothChildren
    //description:  removes a given node from the tree, provided
    //              that node has both a left and a right child
    //args:         toRemove - the node with no children to remove
    //              prevRemove - the node before the one to remove
    //return:       this.root - the root of the modified tree
    //-----------------------------------------------------------
    protected Hist_Node bothChildren(Hist_Node prevRemove, Hist_Node toRemove)
    {
        if(prevRemove == null || toRemove == null)
            return this.root;

//        Hist_Node temp;
        Hist_Node replace;
        if(prevRemove.equals(root) && root.equals(toRemove))
        {
            replace = findBiggest(root.left);
            replace.right = root.right;
            root = replace;
            return root;
        }

        if(prevRemove.right != null && prevRemove.right.equals(toRemove))
        {
            replace = findBiggest(prevRemove.right.left);
            replace.right = prevRemove.right.right;
            prevRemove.right = replace;
            return prevRemove;
        }

        if(prevRemove.left != null && prevRemove.left.equals(toRemove))
        {
            replace = findBiggest(prevRemove.left);
            replace.left = prevRemove.left.left;
            prevRemove.left = replace;
            return prevRemove;
        }

       return prevRemove;
    }



    //-----------------------------------------------------------
    //function:     findBiggest
    //description:  finds the biggest value in the given subtree
    //args:         root - the root of the subtree
    //return:       root - the biggest value in the subtree
    //-----------------------------------------------------------
    protected Hist_Node findBiggest(Hist_Node root)
    {
        if(root.right == null)
            return root;

        return findBiggest(root.right);
    }




    //-----------------------------------------------------------
    //function:     copy
    //description:  copies the one bst into another one passed in
    //args:         newTree - the new tree copy
    //return:       newRoot - the new trees root
    //-----------------------------------------------------------
    public Hist_Node copy(History newTree)
    {
        newTree.root = copy(newTree.root, this.root);
        return newTree.root;
    }



    //-----------------------------------------------------------
    //function:     copy
    //description:  copies the one bst into another one passed in
    //args:         newRoot - the current "root" of the tree
    //              oldRoot - the "root" of the old tree
    //return:       newRoot - the new trees root
    //-----------------------------------------------------------
    protected Hist_Node copy(Hist_Node newRoot, Hist_Node oldRoot)
    {

        if(oldRoot == null)
            return newRoot;

        if(oldRoot.left == null && oldRoot.right == null)
        {
            newRoot = oldRoot;
            newRoot.left = oldRoot.left;
            newRoot.right = oldRoot.right;
            return newRoot;
        }

        newRoot = oldRoot;
        newRoot.left = copy(newRoot.left, oldRoot.left);
        newRoot.right = copy(newRoot.right, oldRoot.right);

        return newRoot;


    }


    //-----------------------------------------------------------
    //function:     deleteAll
    //description:  removes all the nodes from the tree
    //args:         none
    //return:       root - the root after everything has been
    //              deleted
    //-----------------------------------------------------------
    public Hist_Node removeAll()
    {
        return removeAll(root);
    }



    //-----------------------------------------------------------
    //function:     deleteAll
    //description:  removes all the nodes from the tree
    //args:         root - the current "root" of the tree
    //return:       root - the root after everything has been
    //              deleted
    //-----------------------------------------------------------
    protected Hist_Node removeAll(Hist_Node root)
    {
        if(root == null)
           return root;

        Hist_Node temp;
        temp = removeAll(root.left);
        temp = removeAll(root.right);

        root.rHistory.deleteAll();
        this.root = null;


        return this.root;
    }



    //-----------------------------------------------------------
    //function:     traverse
    //description:  finds a history node based on topic an returns
    //              it
    //args:         topic - the topic being found
    //return:       root - the root with the correct topic
    //-----------------------------------------------------------
    public Hist_Node traverse(Hist_Node toFind)
    {
       return traverse(root, toFind);
    }



    //-----------------------------------------------------------
    //function:     traverse
    //description:  finds a history node based on topic an returns
    //              it
    //args:         root - the current "root" of the tree
    //              topic - the topic being found
    //return:       root - the root with the correct topic
    //-----------------------------------------------------------
    protected Hist_Node traverse(Hist_Node root, Hist_Node toFind)
    {
        if(root == null)
            return root; //we did not find it

       if(root.equals(toFind))
           return root;

       if(root.topic.compareTo(toFind.topic) > 0)
           return traverse(root.left, toFind);

       if(root.topic.compareTo(toFind.topic) <= 0)
           return traverse(root.right, toFind);

       return root;
    }



    //-----------------------------------------------------------
    //function:     display
    //description:  displays the whole history structure, including
    //              response histories
    //args:         root - the current "root"
    //return:       none
    //-----------------------------------------------------------
    public void display()
    {
        System.out.println("Displaying History...\n");
        display(root);
    }



    //-----------------------------------------------------------
    //function:     display
    //description:  displays the whole history structure, including
    //              response histories
    //args:         root - the current "root"
    //return:       none
    //-----------------------------------------------------------
    protected void display(Hist_Node root)
    {
        if(root == null)
            return;

        display(root.left);

        System.out.println("********************************************");
        root.display();
        root.rHistory.display();
        System.out.println("********************************************");

        display(root.right);
    }




}
