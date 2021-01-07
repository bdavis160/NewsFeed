/*--------------------------------------------------------------------------------------------------------------------
*author:        Benjamin Davis
* description:  implements the threads class to hold discussions and questions that the user can view, explore, and
*               add to
* class:        CS202
* date:         2019-08-09
--------------------------------------------------------------------------------------------------------------------*/
package Asgn5;

public class Threads {
    Thread_Node head;

    //---------------------------------------------------
    //function:     constructor
    //description:  initializes head to null
    //args:         none
    //return:       none
    //---------------------------------------------------
    public Threads()
    {
        head = null;
    }



    //---------------------------------------------------
    //function:     insertD
    //description:  inserts a discussion into the
    //              structure
    //args:         head - the current "head"
    //              toInsert - the discussion being added
    //return:       head - the new head
    //---------------------------------------------------
    public Thread_Node insertD(Discussion toInsert)
    {
        this.head = insertD(this.head, toInsert);
        return this.head;
    }



    //---------------------------------------------------
    //function:     insertD
    //description:  inserts a discussion into the
    //              structure
    //args:         head - the current "head"
    //              toInsert - the discussion being added
    //return:       head - the new head
    //---------------------------------------------------
    protected Thread_Node insertD(Thread_Node head, Discussion toInsert)
    {
        if(head == null)
        {
            head = toInsert;
            head.next = null;
            head.prev = null;
            return head;
        }

       if(head.next == null)
       {
           head.next = toInsert;
           toInsert.next = null;
           toInsert.prev = head;
           return this.head;
       }

       return insertD(head.next, toInsert);
    }



    //---------------------------------------------------
    //function:     insertQ
    //description:  inserts a question into the
    //              structure
    //args:         head - the current "head"
    //              toInsert - the question being added
    //return:       head - the new head
    //---------------------------------------------------
    public Thread_Node insertQ(Question toInsert)
    {
        this.head = insertQ(this.head, toInsert);
        return this.head;
    }



    //---------------------------------------------------
    //function:     insertQ
    //description:  inserts a question into the
    //              structure
    //args:         head - the current "head"
    //              toInsert - the question being added
    //return:       head - the new head
    //---------------------------------------------------
    protected Thread_Node insertQ(Thread_Node head, Question toInsert)
    {
        if(head == null)
        {
            head = toInsert;
            head.next = null;
            head.prev = null;
            return head;
        }

        if(head.next == null)
        {
            head.next = toInsert;
            toInsert.next = null;
            toInsert.prev = head;
            return this.head;
        }

        return insertQ(head.next, toInsert);
    }



    //---------------------------------------------------
    //function:     removeD
    //description:  removes a discussion from the list
    //args:         toRemove - the discussion to be removed
    //return:       head - the head of the new list
    //---------------------------------------------------
    public Thread_Node removeD(Discussion toRemove)
    {
        this.head = removeD(this.head, toRemove);
        return this.head;
    }



    //---------------------------------------------------
    //function:     removeD
    //description:  removes a discussion from the list
    //args:         head - the current "head" of the list
    //              toRemove - the discussion to be removed
    //return:       head - the head of the new list
    //---------------------------------------------------
    protected Thread_Node removeD(Thread_Node head, Discussion toRemove)
    {
        if(head == null)
            return head;

        if(head == toRemove)
        {
            Thread_Node temp = head;
            if(head.prev != null)
                head.prev.next = head.next;

            if(head.next != null)
                head.next.prev = head.prev;

            //head = null;
            return head.next;
        }

        return removeD(head.next, toRemove);
    }



    //---------------------------------------------------
    //function:     removeQ
    //description:  removes a question from the list
    //args:         toRemove - the question to be removed
    //return:       head - the head of the new list
    //---------------------------------------------------
    public Thread_Node removeQ(Question toRemove)
    {
        this.head = removeQ(this.head, toRemove);
        return this.head;
    }



    //---------------------------------------------------
    //function:     removeQ
    //description:  removes a question from the list
    //args:         head - the current "head" of the list
    //              toRemove - the question to be removed
    //return:       head - the head of the new list
    //---------------------------------------------------
    protected Thread_Node removeQ(Thread_Node head, Question toRemove)
    {
        if(head == null)
            return head;

        if(head == toRemove)
        {
            Thread_Node temp = head;
            if(head.prev != null)
                head.prev.next = head.next;

            if(head.next != null)
                head.next.prev = head.prev;

            //head = null;
            return head.next;
        }

        return removeQ(head.next, toRemove);
    }



    //---------------------------------------------------
    //function:     findD
    //description:  finds a discussion by topic and
    //              turns the node that contains it
    //args:         toFind - the discussion to find
    //---------------------------------------------------
    public Thread_Node findD(Discussion toFind)
    {
        return findD(this.head, toFind);
    }



    //---------------------------------------------------
    //function:     findD
    //description:  finds a discussion by topic and
    //              turns the node that contains it
    //args:         head - the current "head" of the list
    //              toFind - the discussion to find
    //---------------------------------------------------
    protected Thread_Node findD(Thread_Node head, Discussion toFind)
    {
        if(head == null)
            return null; //we didn't find it

        if(head == toFind)
        {
            return head;
        }

        return findD(head.next, toFind);
    }


    //---------------------------------------------------
    //function:     findQ
    //description:  finds a question by topic and
    //              turns the node that contains it
    //args:         toFind - the question to find
    //---------------------------------------------------
    public Thread_Node findQ(Question toFind)
    {
        return findQ(this.head, toFind);
    }



    //---------------------------------------------------
    //function:     findD
    //description:  finds a question by topic and
    //              turns the node that contains it
    //args:         head - the current "head" of the list
    //              toFind - the question to find
    //---------------------------------------------------
    protected Thread_Node findQ(Thread_Node head, Question toFind)
    {
        if(head == null)
            return null; //we didn't find it

        if(head == toFind)
        {
            return head;
        }

        return findQ(head.next, toFind);
    }



    //---------------------------------------------------
    //function:     copy
    //description:  copies the current list into the args
    //              passed in
    //args:         newList - the new list being populated
    //return:       newList.head - the head of the new list
    //---------------------------------------------------
    public Thread_Node copy(Threads newList)
    {
        newList.head = copy(newList.head, this.head);
        return newList.head;
    }



    //---------------------------------------------------
    //function:     copy
    //description:  copies the current list into the args
    //              passed in
    //args:         newList - the new list being populated
    //              oldList - the old list being copied from
    //return:       newList.head - the head of the new list
    //---------------------------------------------------
    protected Thread_Node copy(Thread_Node newList, Thread_Node oldList)
    {
        if(oldList.next == null)
        {
            newList = oldList;
            newList.prev = oldList.prev;
            newList.next = oldList.next;
            return newList;
        }

        newList = oldList;
        newList.prev = oldList.prev;
        newList.next = copy(newList.next, oldList.next);
        return newList;

    }



    //---------------------------------------------------
    //function:     deleteAll
    //description:  removes all nodes from the list
    //args:         none
    //return:       head - a pointer to the head once the
    //              list has been deallocated
    //---------------------------------------------------
    public Thread_Node deleteAll()
    {
        this.head = deleteAll(this.head);
        return this.head;
    }



    //---------------------------------------------------
    //function:     deleteAll
    //description:  removes all nodes from the list
    //args:         head - the current "head" of the list
    //return:       head - a pointer to the head once the
    //              list has been deallocated
    //---------------------------------------------------
    protected Thread_Node deleteAll(Thread_Node head)
    {
        if(head == null)
            return head;

        deleteAll(head.next);

        head = null;
        return head;
    }



    //-------------------------------------------------
    //function:     display
    //description:  displays the threads housed in the
    //              structure
    //args:         none
    //return:       none
    //-------------------------------------------------
    public void display()
    {
        System.out.println("Displaying threads(oldest to newest): ");
        display(this.head);
    }



    //-------------------------------------------------
    //function:     display
    //description:  displays the threads housed in the
    //              structure
    //args:         head - the current "head" of the list
    //return:       none
    //-------------------------------------------------
    protected void display(Thread_Node head)
    {
        if(head == null)
            return;

        head.show();

        display(head.next);

    }


}
