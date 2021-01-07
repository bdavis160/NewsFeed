/*--------------------------------------------------------------------------------------------------------------------
*author:        Benjamin Davis
* description:  implements a main class to allow the news feed program to run
* class:        CS202
* date:         2019-08-09
--------------------------------------------------------------------------------------------------------------------*/
package Asgn5;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to the News Feed!");

        News_Feed newsFeed = new News_Feed();
        System.out.println("Generating questions to get things started...");

        Question q1 = new Question("Whales", 10, "Are whales going extinct?");
        Question q2 = new Question("Whales", 10, "What is the largest species of whale?");
        Question q3 = new Question("Whales", 10, "Are dolphins whales too?");

        newsFeed.insertQ(q1);
        newsFeed.insertQ(q2);
        newsFeed.insertQ(q3);

        newsFeed.addQuestionResp(q1, "I sure hope not! Whales are great!");
        newsFeed.addQuestionResp(q1, "!");
        newsFeed.addQuestionResp(q2, "Could it be the blue whale?");
        newsFeed.addQuestionResp(q3, "I think Dolphins are just big fish");


       System.out.println("Adding Discussion topics...");

       Discussion d1 = new Discussion("Movies", 10, "Starwars");
        Discussion d2 = new Discussion("Movies", 10, "John Wick");
        Discussion d3 = new Discussion("Movies", 10, "Disney");

        newsFeed.insertD(d1);
        newsFeed.insertD(d2);
        newsFeed.insertD(d3);

        newsFeed.addDiscussionResp(d1, "What do y'all think of the new Star Wars film?");
        newsFeed.addDiscussionResp(d2, "Is Tarentino retiring soon?");
        newsFeed.addDiscussionResp(d3, "Is the new Lion king any good?");

        System.out.println("Displaying the News Feed...");

        newsFeed.displayFeed();

        System.out.println("Displaying the News Feed  history...");

        newsFeed.displayHistory();

    }
}
