/*--------------------------------------------------------------------------------------------------------------------
*author:        Benjamin Davis
* description:  implements the thread class which serves as the base class for all discussions in the news feed
* class:        CS202
* date:         2019-08-09
--------------------------------------------------------------------------------------------------------------------*/

package Asgn5;

public class Thread {
    //The protected class members
    protected String topic;
    protected String[] responses;
    protected int numResponsesAllowed;



    //----------------------------------------------------------
    //function:     default constructor
    //description:  sets data members to null
    //args:         none
    //return:       none
    //----------------------------------------------------------
    public Thread()
    {
        topic = new String();
        responses = null;
        numResponsesAllowed = 0;
    }



    //----------------------------------------------------------
    //function:     constructor with arguments
    //description:  creates an instance of the thread class based
    //              on args passed in
    //args:         topic - the new topic
    //              numAllowed - the number of responses allowed
    //              (before the responses are stored in history)
    //return:       none
    //----------------------------------------------------------
    public Thread(String topic, int numAllowed)
    {
       this.topic = topic;
       this.numResponsesAllowed = numAllowed;
       this.responses = initialize(responses);
    }



    //----------------------------------------------------------
    //function:     initialize
    //description:  initializes a string array to actual string
    //              objects based on the number of responses
    //              allowed
    //args:         to_init - the string being initialized
    //return:       to_init - the same value once it has been
    //              initialized
    //----------------------------------------------------------
    public String[] initialize(String[] toInit)
    {
        toInit = new String[numResponsesAllowed];

        for(int i = 0; i < toInit.length; ++i)
            toInit[i] = null;

       return toInit;
    }



    //----------------------------------------------------------
    //function:     isEqual
    //description:  returns whether or not two threads are equal
    //args:         toCompare - the string being compared to this
    //return:       true - if they are equal
    //              false - otherwise
    //----------------------------------------------------------
    public boolean isEqual(Thread toCompare)
    {
        if(this.topic.equalsIgnoreCase(toCompare.topic) && this.numResponsesAllowed == toCompare.numResponsesAllowed)
            return true;

        return false;
    }


    //----------------------------------------------------------
    //function:     isRespFull
    //description:  determines whether the response array is full
    //              or not
    //args:         none
    //return:       true - if the array is full
    //              false - if not
    //----------------------------------------------------------
    public boolean isRespFull()
    {
        boolean respond = true;

        for(int i = 0; i < responses.length; ++i)
        {
            if(responses[i] == null)
                respond = false;
        }

        return respond;
    }



    //----------------------------------------------------------
    //function:     sameTopic
    //description:  returns whether two Threads have the same
    //              topic or not
    //args:         toCompare - the thread being compared to
    //              this
    //return:       true - if the topics match
    //              false - otherwise
    //----------------------------------------------------------
    public boolean sameTopic(Thread toCompare)
    {
        if(this.topic.equalsIgnoreCase(toCompare.topic))
            return true;
        else
            return false;
    }



    //----------------------------------------------------------
    //function:     shift
    //description:  shifts the contents of the responses array
    //              down by 1, setting the 0th index to null
    //              and returning the string that was removed
    //              from the bottom
    //args:         none
    //return:       responses[i] - the value of the last node
    //              in the array
    //----------------------------------------------------------
    public String shift()
    {
        String last=null;
        String temp = null;

        //shift everything down
        for(int i = 0; i < responses.length; ++i)
        {
            if(i == responses.length -1) //catch the last node before it is overwritten
            {
                last = responses[i];
                responses[i] = temp;
            }

            if(i == 0)
            {
                temp = responses[i];
            }

            if(i > 0 && i < responses.length-1)
            {
                if(i == 1)
                {
                    responses[i] = temp;
                    temp = responses[i+1];
                }

                else {
                    responses[i + 1] = temp;
                    temp = responses[i];
                }
            }

        }

        responses[0] = null; //the 0th index is now "empty"
        return last;
    }



    //----------------------------------------------------------
    //function:     addResp
    //description:  adds a new response to the responses array,
    //              if the array is full, shift it down and return
    //              the displaced index
    //args:         toAdd - the string to add
    //return:       shifted - the value of the node that was shifted
    //----------------------------------------------------------
    public String addResp(String toAdd)
    {
        String shifted = null;

        if(isRespFull() || responses[0] != null)
            shifted = shift();//make space for the new comment

        responses[0] = toAdd; //always add new responses to the "top"

        return shifted;
    }



    //----------------------------------------------------------
    //function:     display
    //description:  displays the entire thread
    //args:         none
    //return:       none
    //----------------------------------------------------------
    public void display()
    {
        System.out.println("\n************************************************");
        System.out.println("*Topic: "+topic + " *");
        System.out.println("*Number of Responses: " +numResponsesAllowed+ " *");

        for(int i = 0; i < responses.length; ++i)
        {
            if(responses[i] != null)
                System.out.println(responses[i] );
        }

    }



    //----------------------------------------------------------
    //function:     removeResp
    //description:  removes a response from a given index
    //args:         index - the index to make availible
    //return:       removed - the value of the string removed
    //----------------------------------------------------------
    public String removeResp(int index)
    {
        String removed = responses[index];

        responses[index] = null;

        return removed;
    }



}
