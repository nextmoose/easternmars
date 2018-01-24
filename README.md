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

I will describe the algorithm and leave implementation as an exercise for the reader.

I will assume that XML documents can be arbitrarily large.
However, as a practical matter the algorithm will fail if the document is extremely large.

The algorithm will read in the XML document as a stream and examine each character one at a time.

The algorithm will maintain a "STATE" which will determine how it reacts to the characters.

Here are the states that would suffice for the prompt document:

1. Begin (Initial)
2. Free
3. OpenTag
4. CloseTag1
5. CloseTag2
5. WellFormed (Terminal)
6. PoorlyFormed (Terminal)

1. The algorithm starts in 'Begin' state.
2. When it scans the '<' tag it transitions into 'OpenTag' state.
3. In 'OpenTag' state it records each scanned character into the 'tag' variable.
4. When it scans the '>' character
   1. it stops recording the tag ... tag="BackgroundCheck"
   2. it recursively applies itself to the stream
      1. The algorithm start in 'Begin' state (independent of other invocations)
      2. It scans through white space.
      3. When it scans '<' it transitions into 'OpenTag'.
      4. In 'OpenTag' state it records each scanned character into the 'tag' variable.
      5. When it scans the '>' character
         1. it stops recording the tag ... tag="CriminalHistory"
         2. it recursively applies itself to the stream
            1. The algorithm starts in 'Begin' state (independent of other invocations)
            2. It scans through white space
            3. When it scans the '<' it transisitions into 'OpenTag'
            4. In 'OpenTag' state it records each scanned character into the 'tag' varable.
            5. When it scans the '>' characters.
               1. it stops recording the tag ... tag="HistoryCode"
               2. it recursively applies itself to the stream.
                  1. The algorithm starts in 'Begin' state (independent of other invocations)
                  2. It scans through the 'x'
                  3. When it scans the '</' characters it transitions into 'CloseTag' states
                  4. In CloseTag state it compares each scanned character to the stored 'tag' variable.
                  5. Since the tags match and it finds the closing '>', it transitions into 'WellFormed' state
               3. Since the recursive application terminated WellFormed, the algorithm transitions into "Free" state
               4. In 'Free' State, it scans through the white space
               5. When it scans the '<' it transitions into "OpenTag" state.
               6. In 'OpenTag' state it records each scanned character into the 'tag' variable.
               7. When it scans the '>'
                  1. it stops recording the tag ... tag = " HistoryCode"
                  2. it recursively applies itself to the stream.
                     1. the algorithm starts in 'Begin' state (independent of other invocations)
                     2. It scans through the 'y'.
                     3. When the scans the '</' characters it transitions into 'CloseTag' states
                     4. In CloseTag state it compares each scanned character to the stored 'tag' variable
                     5. Since it does not match it transitions into 'PoorlyFormed' state
    6. Since the recursive invocation terminated in 'PoorlyFormed', the algorithm will now also transition to 'Poorly Formed'.
5. Since the recursive invocation terminated in 'Poorly Formed', the algorith will now also transition to 'Poorly Formed'


As stated, the algorithm would handle the prompt document.
However there are lots of complexities not covered.

I kind of introduced CloseTag1 and CloseTag2 and skipped over it in the description.
Basically when the algorithm scans a "<" and if the next character is "/" then it is a closing tag
and otherwise it is a child opening tag.
It makes intuitive state to a human being but the states should be fixed so that the computer
does not get fooled by that.

In addition, the algorithm as presented would not handle more complex XML documents with attributes and comments.
The algorithm could be extended with more states to handle those situations.

The algorithm can not handle (and could not reasonably be fixed to handle) extremely large documents.
The algorithm is storing a set of "opening" tags that must be "balanced" with closing tags.
An extremely large document could overwhelm the computer's capacity to store opening tags and crash the computer.

That being said the algorithm could reasonably handle very large documents.
I anticipate that it would handle all documents thrown at it.

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

#### Response

See the code in the 'question-02' directory.

### Question Three

#### Prompt

You have been tasked to modify a human resources application. The current Employee
class looks like this:

```
Employee
- managerFlag : boolean
- name : String
- dateHired : Date
- id : int
+ getName() : String
+ getID() : String
+ getDateHired() : Date
+ isManager() : boolean
```

Currently everyone is an Employee and some of those are Managers, which is
determined by calling the isManager() method. The company has now started hiring part-
time employees, so the system must be modified to keep track of them.

Create a new implementation of the Employee class which provides the flexibility
required to support the new part-time employee notion. You are free to refactor this class
as required and add additional classes if needed. Describe your rationale for making the
changes in the javadoc of the new Employee class. If you create any new classes,
include your reasons for creating the class in its javadoc.

#### Response

See the code in the 'question-03' directory.

### Question Four

#### Prompt
When you used the test code in Question 2 above, you probably placed it in the main()
method of the same class. A more efficient approach is to make use of a testing
framework so the tests are repeatable and can be integrated into a larger test plan. JUnit
is our preferred tool for this task. If you are not familiar with JUnit, go to www.junit.org for
information and download the library.
Write a TestCase for the UserKey class. Include a test for each public method in the
class, the suite() method, and a main() method which runs the test using the
junit.textui.TestRunner. Also test to ensure the UserKey can be safely serialized.

#### Response

See the code in the 'question-02' directory.