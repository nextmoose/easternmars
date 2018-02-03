# ComponentWise

## Objective

The following four questions are designed to get a feel for your understanding of the Java
programming language, basic object-oriented design, good programming practices, and
ability to learn new material. It is oriented towards server-side development. All of your
answers must be compatible with the JDK 1.7. This test is graded on technical merit,
attention to detail, and style.
Your responses to the coding questions must be submitted as .java files which can be
compiled. All classes must be placed in the `com.componentwise.eval` package.

## Questions

### Question One

#### Prompt

Describe how to implement a simple parser that does well-formedness checking on XML,
such as the following:

```
&lt;BackgroundCheck&gt;
        &lt;CriminalHistory&gt;
                &lt;HistoryCode&gt;x&lt;/HistoryCode&gt;
                &lt; HistoryCode&gt;y&lt;/HistoryCode&gt;
                &lt; HistoryCode&gt;z&lt;/HistoryCode&gt;
        &lt;/CriminalHistory&gt;
&lt;/BackgroundCheck&gt;
```
Please note that using a a parser like Xerces is not acceptable. You can either describe
the algorithm, write pseudo code or optionally implement the solution.

#### Response

### Question Two

#### Prompt
Instances of the following class must be placed into the session of a Servlet and used as
a key for a Hashtable of other objects. Make the necessary modifications to the UserKey
so that it meets the minimal requirements for an object which can be placed into the
HttpSession and ensure the test code following the class definition below produces the
indicated results. Fully document the revised UserKey class using standard javadoc
comments.

```
public class UserKey {
private String name;
private String userid;
public UserKey(String name, String userid) {
this.name = name;
this.userid = userid;
}
public String getName() {
return name;
}
public String getUserID() {
return userid;
}
}
```
Test Code (ensure the results are as indicated in the comments):
```
UserKey b1 = new UserKey(“Bill Smith”, “BSMITH”);
UserKey b2 = new UserKey(“Bill Smith”, “BSMITH”);
UserKey b3 = new UserKey(“Susan Smith”, “SSMITH”);
UserKey b4 = new UserKey(null,null);
System.out.println( b1.equals(b1) ); // prints true
System.out.println( b1.equals(b2) ); // prints true
System.out.println( b1.equals(b3) ); // prints false
System.out.println( b1.equals(null) ); // prints false
System.out.println( b1.equals(“Some String”) ); // prints false
System.out.println( b4.equals(b1) ); // prints false
java.util.Hashtable ht = new java.util.Hashtable();
ht.put(b1,”Some Data”);
String s = (String) ht.get(b2);
System.out.println( s.equals(“Some Data”) ); // prints true
```