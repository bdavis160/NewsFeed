/*--------------------------------------------------------------------------------------------------------------------
*author:        Benjamin Davis
* description:  implements the resp history class which is essentially a linear linked list class to store discarded
*               responses
* class:        CS202
* date:         2019-08-09
--------------------------------------------------------------------------------------------------------------------*/
package Asgn5;

public class Resp_Hist {
    protected Resp_Node head;

    //----------------------------------------------------------
    //function:     constructor
    //description:  sets head to null
    //args:         none
    //return:       none
    //----------------------------------------------------------
    public Resp_Hist()
    {
        head = null;
    }



    //----------------------------------------------------------
    //function:     insert
    //description:  inserts a new node into the list
    //              (at the front)
    //args:         list - the list itself
    //              to_insert - the string to be inserted
    //return:       head - the modified list
    //----------------------------------------------------------
    protected Resp_Node insert(String to_insert)
    {
        //if no head, head is a new node, return
        if(this.head == null)
        {
            this.head = new Resp_Node(to_insert);
            this.head.next = null;
            return this.head;
        }


        //otherwise set head == to new node and head next = to old head
        Resp_Node temp = this.head;
        this.head = new Resp_Node(to_insert);
        this.head.next = temp;

        return this.head;
    }



    //----------------------------------------------------------
    //function:     removeResp
    //description:  removes a response from the list
    //args:         to_remove - the string to be removed
    //return:       head - the head of the new list
    //----------------------------------------------------------
    public Resp_Node remove(String to_remove)
    {
       this.head = remove(this.head, to_remove);
       return this.head;
    }


    //----------------------------------------------------------
    //function:     removeResp
    //description:  removes a response from the list
    //args:         head - the head of the list
    //              to_remove - the string to be removed
    //return:       head - the head of the new list
    //----------------------------------------------------------
    protected Resp_Node remove(Resp_Node head, String to_remove)
    {
        if(head == null)
            return head;

       //remove head case
        if(head.data == to_remove)
        {
            Resp_Node temp = head;
            head = head.next;

            if(head.next != null)
                head.next = head.next.next;
            else
                head.next = null;

            temp = null;
            return head;
        }

        remove(head.next, to_remove);
        return head;
    }



    //----------------------------------------------------------
    //function:     copy
    //description:  copies the given list, returning a copy
    //args:         newList - the new copy
    //return:       newList.head - the head of the new list
    //----------------------------------------------------------
    public Resp_Node copy(Resp_Hist newList)
    {
       newList.head = copy(newList.head, this.head);
       return newList.head;
    }



    //----------------------------------------------------------
    //function:     copy
    //description:  copies the given list, returning a copy
    //args:         newList - the new copy
    //              oldList - the list being copied
    //return:       newList.head - the head of the new list
    //----------------------------------------------------------
    protected Resp_Node copy(Resp_Node newList, Resp_Node oldList)
    {
       //if there are no more nodes to copy, return
        if(oldList.next == null)
        {
            newList = new Resp_Node(oldList.data);
            newList.next = null;
            return newList;
        }

        //copy old node into new list
        newList = new Resp_Node(oldList.data);
        newList.next = copy(newList.next, oldList.next);

        //traverse to the next node
       //newList = copy(newList.next, oldList.next);
       return newList;

    }



    //----------------------------------------------------------
    //function:     deleteAll
    //description:  removes all nodes from the list
    //args:         none
    //return:       head - the head of the list (null)
    //----------------------------------------------------------
    public Resp_Node deleteAll()
    {
        this.head = deleteAll(this.head);
        return this.head;
    }



    //----------------------------------------------------------
    //function:     deleteAll
    //description:  removes all nodes from the list
    //args:         head - the curren "head' of the list
    //return:       head - the head of the list (null)
    //----------------------------------------------------------
    protected Resp_Node deleteAll(Resp_Node head)
    {
        if(head == null)
            return head;

        //traverse to the end
        deleteAll(head.next);

        //start "deleting"
        head = null;
        return head;
    }



    //----------------------------------------------------------
    //function:     find
    //description:  finds the string in the list ( if it's there)
    //              and returns the node housing it
    //args:         toFind - the item bing found
    //return:       the node housing that string
    //----------------------------------------------------------
    public Resp_Node find(String toFind)
    {
        return find(this.head, toFind);
    }



    //----------------------------------------------------------
    //function:     find
    //description:  finds the string in the list ( if it's there)
    //              and returns the node housing it
    //args:         head - the "head" of the list
    //              toFind - the item bing found
    //return:       the node housing that string
    //----------------------------------------------------------
    protected Resp_Node find(Resp_Node head, String toFind)
    {
        if(head == null)
            return head; //we did not find it

        if(head.data.equalsIgnoreCase(toFind))
            return head;

        return find(head.next, toFind);
    }



    //----------------------------------------------------------
    //function:     display
    //description:  displays the items in the list in order
    //args:         none
    //return:       none
    //----------------------------------------------------------
    public void display()
    {
        System.out.println("Responses(newest to oldest): ");
        display(this.head);
    }



    //----------------------------------------------------------
    //function:     display
    //description:  displays the items in the list in order
    //args:         head - the current "head of the list
    //return:       none
    //----------------------------------------------------------
    protected void display(Resp_Node head)
    {
       if(head == null)
           return;


       System.out.println(head.data + " ");

       display(head.next);
    }


}
