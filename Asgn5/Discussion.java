/*--------------------------------------------------------------------------------------------------------------------
*author:        Benjamin Davis
* description:  implements the discussion class which serves as one of two types of threads that will be stored in the
*               threads class
* class:        CS202
* date:         2019-08-09
--------------------------------------------------------------------------------------------------------------------*/
package Asgn5;

public class Discussion extends Thread_Node {
    protected String theme;

    //-------------------------------------------------------
    //function:     constructor
    //description:  sets data members to values passed in
    //args:         topic - the topic of the thread
    //              numAllowed - the number of allowed responses
    //              theme - the theme of the discussion
    //-------------------------------------------------------
    public Discussion(String topic, int numAllowed, String theme)
    {
        super(topic, numAllowed);
        this.theme = theme;
    }



    //-------------------------------------------------------
    //function:     nextNode
    //description:  returns the next node pointer
    //args:         none
    //return:       next - the value of the next node
    //-------------------------------------------------------
    public Thread_Node nextNode()
    {
        return next;
    }



    //-------------------------------------------------------
    //function:     prevNode
    //description:  returns the value of the previous node
    //args:         none
    //return:       prev - the value of the previous node
    //-------------------------------------------------------
    public Thread_Node pervNode()
    {
        return prev;
    }



    //-------------------------------------------------------
    //function:     connNext
    //description:  sets the value of the next node
    //args:         newNext - the new value of next
    //return:       none
    //-------------------------------------------------------
    public void connNext(Thread_Node newNext)
    {
        next = newNext;
    }



    //-------------------------------------------------------
    //function:     connPrev
    //description:  sets the value of the previous node
    //args:         newPrev - the new previous node
    //return:       none
    //-------------------------------------------------------
    public void connPrev(Thread_Node newPrev)
    {
        prev = newPrev;
    }




    //-------------------------------------------------------
    //function:     show
    //description:  displays the thread nodes derived classes
    //args:         none
    //return:       none
    //-------------------------------------------------------
    public void show()
    {
        super.display();
        System.out.println("Discussion topic: " + theme + "*");

        System.out.println("************************************************\n");

    }
}
