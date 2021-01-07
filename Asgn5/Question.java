/*--------------------------------------------------------------------------------------------------------------------
*author:        Benjamin Davis
* description:  implements the question class which is one of the classes what will be used to represent different
*               threads in the threads structure
* class:        CS202
* date:         2019-08-09
--------------------------------------------------------------------------------------------------------------------*/
package Asgn5;

public class Question extends Thread_Node{
    protected String question;

    //-------------------------------------------------------
    //function:     constructor
    //description:  initializes data members to data passed in
    //args:         topic - the topic of the thread
    //              numAllowed - the number of responses allowed
    //              question - the actual question itself
    //return:       none
    //-------------------------------------------------------
    public Question(String topic, int numAllowed, String question)
    {
        super(topic, numAllowed);
        this.question = question;
    }



    //-------------------------------------------------------
    //function:     default constructor
    //description:  initializes elements to zero equivilant
    //              values
    //args:         none
    //return:       none
    //-------------------------------------------------------
    public Question()
    {
        super(null, 0);
        question = null;
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
        System.out.println("Question: " + question + "*");

        System.out.println("************************************************\n");

    }



}
