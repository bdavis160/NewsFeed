/*--------------------------------------------------------------------------------------------------------------------
*author:        Benjamin Davis
* description:  implements the news feed class which uses a threads object to store discussions and questions and
*               a history object to store them
* class:        CS202
* date:         2019-08-09
--------------------------------------------------------------------------------------------------------------------*/
package Asgn5;

public class News_Feed {
    Threads threads;
    History history;

    //-------------------------------------------------------
    //function:     constructor
    //description:  initializes threads and history
    //args:         none
    //return:       none
    //-------------------------------------------------------
    public News_Feed()
    {
        threads = new Threads();
        history = new History();//initializeHisroty(history);
    }



    //-------------------------------------------------------
    //function:     insertD
    //description:  inserts a new discussion into both the
    //              history and threads objects
    //args:         discussion - the discussion being inserted
    //return:       head - the head to the modified threads
    //-------------------------------------------------------
    public Thread_Node insertD(Discussion discussion)
    {
            Hist_Node newNode = new Hist_Node(discussion);
            threads.insertD(discussion);
            history.insert(newNode);

            return threads.head;
    }



    //-------------------------------------------------------
    //function:     insertQ
    //description:  inserts a new question into both the
    //              history and threads objects
    //args:         question - the question being inserted
    //return:       head - the head to the modified threads
    //-------------------------------------------------------
    public Thread_Node insertQ(Question question)
    {
        Hist_Node newNode = new Hist_Node(question);
        threads.insertQ(question);
        history.insert(newNode);

        return threads.head;
    }




    //-------------------------------------------------------
    //function:     removeQ
    //description:  removes a question from the threads and
    //              places it into history
    //args:         question - the question being removed
    //return:       head - the new head of threads
    //-------------------------------------------------------
    public Thread_Node removeQ(Question question)
    {
        Hist_Node temp;
        Hist_Node newNode = new Hist_Node(question);

        threads.head = threads.removeQ(question);

       temp = history.traverse(newNode);

       if(temp == null)//not in the list already
           history.insert(newNode);

        return threads.head;
    }



    //-------------------------------------------------------
    //function:     removeD
    //description:  removes a discussion from the threads and
    //              places it into history
    //args:         discussion - the discussion being removed
    //return:       head - the new head of threads
    //-------------------------------------------------------
    public Thread_Node removeD(Discussion discussion)
    {
        Hist_Node temp;
        Hist_Node newNode = new Hist_Node(discussion);

        threads.head = threads.removeD(discussion);

        temp = history.traverse(newNode);

        if(temp == null)//not in the list already
            history.insert(newNode);

        return threads.head;
    }



    //-------------------------------------------------------
    //function:     addQuestionResp
    //description:  adds a response to a question object,
    //              adding overflow items to the history LLL
    //              for that node
    //args:         question - the question being added to
    //              newResp - the new response being added
    //return:       head - the head of the newly modified
    //              threads
    //-------------------------------------------------------
    public Thread_Node addQuestionResp(Question question, String newResp)
    {
       Thread_Node temp = threads.findQ(question);
        Question q = (Question) temp;
        String hist = null;
        Hist_Node add = null;

       if(temp != null)
       {
           hist = temp.addResp(newResp);
           threads.head = removeQ(question);
           threads.head = threads.insertQ(q);

           if(hist != null)
           {
              add = new Hist_Node(question);
              add = history.traverse(add);
              history.remove(add);
              add.addResp(newResp);
              history.insert(add);
           }

       }


       return threads.head;
    }



    //-------------------------------------------------------
    //function:     addDiscussionResp
    //description:  adds a response to a discussion object,
    //              adding overflow items to the history LLL
    //              for that node
    //args:         discussion - the discussion being added to
    //              newResp - the new response being added
    //return:       head - the head of the newly modified
    //              threads
    //-------------------------------------------------------
    public Thread_Node addDiscussionResp(Discussion discussion, String newResp)
    {
        Thread_Node temp = threads.findD(discussion);
        Discussion d = (Discussion) temp;
        String hist = null;
        Hist_Node add = null;

        if(temp != null)
        {
            hist = temp.addResp(newResp);
            threads.head = removeD(discussion);
            threads.head = threads.insertD(d);

            if(hist != null)
            {
                add = new Hist_Node(discussion);
                add = history.traverse(add);
                history.remove(add);
                add.addResp(newResp);
                history.insert(add);
            }

        }
        return threads.head;
    }



    //-------------------------------------------------------
    //function:     findQ
    //description:  returns a given question from the list if
    //              exists
    //args:         question - the question being found
    //return:       found - the found question
    //-------------------------------------------------------
    public Question findQ(Question question)
    {
        Thread_Node temp = null;
        Question found = null;

        temp = threads.findQ(question);

        found = (Question) temp;

        return found;
    }



    //-------------------------------------------------------
    //function:     findD
    //description:  returns a given discussion from the list if
    //              exists
    //args:         discussion - the discussion being found
    //return:       found - the found discussion
    //-------------------------------------------------------
    public Discussion findD(Discussion discussion)
    {
        Thread_Node temp = null;
        Discussion found = null;

        temp = threads.findD(discussion);

        found = (Discussion) temp;

        return found;
    }



    //-------------------------------------------------------
    //function:     displayFeed
    //description:  displays the contents of the feed
    //args:         none
    //return:       none
    //-------------------------------------------------------
    public void displayFeed()
    {
        threads.display();
    }



    //-------------------------------------------------------
    //function:     displayHistory
    //description:  displays the history of the feed
    //args:         none
    //description:  none
    //-------------------------------------------------------
    public void displayHistory()
    {
        history.display();
    }



    //-------------------------------------------------------
    //function:     displayRespHistoryQ
    //description:  displays the response history for a given
    //              node
    //args:         question - the question whose responses
    //              should be displayed
    //return:       none
    //-------------------------------------------------------
    public void displayRespHistQ(Question question)
    {
        Hist_Node quest = new Hist_Node(question);
        Hist_Node temp = history.traverse(quest);

        if(temp != null)
        {
            temp.rHistory.display();
        }

    }



    //-------------------------------------------------------
    //function:     displayRespHistoryD
    //description:  displays the response history for a given
    //              node
    //args:         discussion - the discussion whose responses
    //              should be displayed
    //return:       none
    //-------------------------------------------------------
    public void displayRespHistD(Discussion discussion)
    {
        Hist_Node quest = new Hist_Node(discussion);
        Hist_Node temp = history.traverse(quest);

        if(temp != null)
        {
            temp.rHistory.display();
        }

    }

}
