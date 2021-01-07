/*--------------------------------------------------------------------------------------------------------------------
*author:        Benjamin Davis
* description:  implements the thread node class, a doubly linked list node that is used to create the interface for
*               users to interact with topics
* class:        CS202
* date:         2019-08-09
--------------------------------------------------------------------------------------------------------------------*/
package Asgn5;

abstract public class Thread_Node extends Thread{
    protected Thread_Node next;
    protected Thread_Node prev;

    //-------------------------------------------------------
    //function:     default constructor
    //description:  sets data members to default values
    //args:         none
    //return:       none
    //-------------------------------------------------------
    public Thread_Node(String topic, int allowed)
    {
        super(topic, allowed);
        next = null;
        prev = null;
    }



    //-------------------------------------------------------
    //function:     nextNode
    //description:  returns the next node pointer
    //args:         none
    //return:       next - the value of the next node
    //-------------------------------------------------------
    abstract public Thread_Node nextNode();



    //-------------------------------------------------------
    //function:     prevNode
    //description:  returns the value of the previous node
    //args:         none
    //return:       prev - the value of the previous node
    //-------------------------------------------------------
    abstract public Thread_Node pervNode();


    //-------------------------------------------------------
    //function:     connNext
    //description:  sets the value of the next node
    //args:         newNext - the new value of next
    //return:       none
    //-------------------------------------------------------
    abstract public void connNext(Thread_Node newNext);


    //-------------------------------------------------------
    //function:     connPrev
    //description:  sets the value of the previous node
    //args:         newPrev - the new previous node
    //return:       none
    //-------------------------------------------------------
    abstract public void connPrev(Thread_Node newPrev);



    //-------------------------------------------------------
    //function:     show
    //description:  displays the thread nodes derived classes
    //args:         none
    //return:       none
    //-------------------------------------------------------
    abstract void show();



    //-------------------------------------------------------
    //-------------------------------------------------------
    //-------------------------------------------------------
    //-------------------------------------------------------
    //-------------------------------------------------------
    //-------------------------------------------------------
    //-------------------------------------------------------
    //-------------------------------------------------------
    //-------------------------------------------------------
    //-------------------------------------------------------
    //-------------------------------------------------------
    //-------------------------------------------------------
    //-------------------------------------------------------
    //-------------------------------------------------------
    //-------------------------------------------------------
    //-------------------------------------------------------
}
