/*--------------------------------------------------------------------------------------------------------------------
*author:        Benjamin Davis
* description:  implements the resp node class, a linear linked list node that is used to staore the actual response
                for each node in the history bst
* class:        CS202
* date:         2019-08-09
--------------------------------------------------------------------------------------------------------------------*/
package Asgn5;

public class Resp_Node {
    protected Resp_Node next;
    protected String data;

    //---------------------------------------------
    //function:     constructor
    //description:  constructs an instance of the
    //              class using args passed in
    //args:         topic - the topic of the thread
    //              numAllowed - the number of
    //              responses allowed
    //              response - the response being
    //              stored
    //return:       none
    //---------------------------------------------
    public Resp_Node(String response)
    {
       data = response;
    }



    //-------------------------------------------------------
    //function:     nextNode
    //description:  returns the next node pointer
    //args:         none
    //return:       next - the value of the next node
    //-------------------------------------------------------
    public Resp_Node nextNode()
    {
        return next;
    }



    //-------------------------------------------------------
    //function:     connNext
    //description:  sets the value of the next node
    //args:         newNext - the new value of next
    //return:       none
    //-------------------------------------------------------
    public void connNext(Resp_Node newNext)
    {
        next = newNext;
    }



    //---------------------------------------------
    //function:     oldResp
    //description:  returns the response in the node
    //args:         none
    //return:       data - the response in the node
    //---------------------------------------------
    public String oldResp()
    {
        return data;
    }



    //---------------------------------------------
    //function:     setResp
    //description:  sets the value of the node to a
    //              new value
    //args:         newResp - the new response
    //return:       none
    //---------------------------------------------
    public void setResp(String newResp)
    {
        data = newResp;
    }



}
