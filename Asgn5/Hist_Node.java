/*--------------------------------------------------------------------------------------------------------------------
*author:        Benjamin Davis
* description:  implements the hist node class which is a binary tree node that is used to hold the history of
*               discussions that take place for a given topic
* class:        CS202
* date:         2019-08-09
--------------------------------------------------------------------------------------------------------------------*/
package Asgn5;

public class Hist_Node extends Question {
    protected Hist_Node left;
    protected Hist_Node right;
    protected Resp_Hist rHistory;



    //--------------------------------------------------
    //function:     constructor
    //description:  sets the data members to the values
    //              passed in
    //args:         topic - the topic of the thread
    //              numAllowed - the number of responses
    //              allowed for each topic
    //              args to kick start the rHistory class
    //return:       none
    //--------------------------------------------------
    public Hist_Node(String topic, int numAllowed, String question)
    {
        super(topic, numAllowed, question);
        rHistory = new Resp_Hist();
        left = null;
        right = null;
    }


    //--------------------------------------------------
    //function:     constructor
    //description:  sets the data members to the values
    //              passed in
    //args:         toCopy - the thread being copied into
    //              the current object
    //return:       none
    //--------------------------------------------------
    public Hist_Node(Question toCopy)
    {
        this.topic = toCopy.topic;
        this.responses = toCopy.responses;
        this.numResponsesAllowed = toCopy.numResponsesAllowed;
        this.question = toCopy.question;
        left = null;
        right = null;
        rHistory = new Resp_Hist();
    }



    //--------------------------------------------------
    //function:     constructor
    //description:  sets the data members to the values
    //              passed in
    //args:         toCopy - the thread being copied into
    //              the current object
    //return:       none
    //--------------------------------------------------
    public Hist_Node(Discussion toCopy)
    {
        this.topic = toCopy.topic;
        this.responses = toCopy.responses;
        this.numResponsesAllowed = toCopy.numResponsesAllowed;
        left = null;
        right = null;
        rHistory = new Resp_Hist();
    }



    //--------------------------------------------------
    //function:     leftNode
    //description:  returns the value of the left node
    //args:         none
    //return:       left - the value of the left node
    //--------------------------------------------------
    public Hist_Node leftNode()
    {
        return left;
    }



    ///--------------------------------------------------
    //function:     rightNode
    //description:  returns the value of the right node
    //args:         none
    //return:       right- the value of the left node
    //--------------------------------------------------
    public Hist_Node rightNode()
    {
        return right;
    }



    //--------------------------------------------------
    //function:     connLeft
    //description:  sets the value of the left node
    //args:         newLeft - the new left value
    //return:       none
    //--------------------------------------------------
    public void connLeft(Hist_Node newLeft)
    {
       left = newLeft;
    }



    ///--------------------------------------------------
    //function:     connRight
    //description:  sets the value of the right node
    //args:         newRight - the new right value
    //return:       none
    //--------------------------------------------------
    public void connRight(Hist_Node newRight)
    {
        left = newRight;
    }



    //--------------------------------------------------
    //function:     equals
    //description:  compares the data of two objects to
    //              determine if they are the same
    //args:         toCompare - the object being compared
    //return:       true - if the objects are the same
    //              false - otherwise
    //--------------------------------------------------
    public boolean equals(Hist_Node toCompare)
    {
        if(toCompare.topic.equalsIgnoreCase(topic) && toCompare.rHistory.head == this.rHistory.head)
            return true;

        return false;
    }



}
