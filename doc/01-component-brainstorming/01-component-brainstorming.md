# Portfolio Part 1: Component Brainstorming

- **Name**: Shailly Kerkar
- **Dot Number**: kerkar.1
- **Due Date**: 09/19 @ 1:50 PM EST

## Assignment Overview
The overall goal of the portfolio project is to have you design and implement
your own OSU component. There are no limits to what you choose to design and
implement, but your component must fit within the constraints of our software
sequence discipline. In other words, the component must extend from Standard and
must include both a kernel and a secondary interface.

Because this is a daunting project, we will be providing you with a series of
activities to aid in your design decisions. For example, the point of this
assignment is to help you brainstorm a few possible components and get some
feedback. For each of these components, you will need to specify the high-level
design in terms of the software sequence discipline. In other words, you will
describe a component, select a few kernel methods for your component, and select
a few secondary methods to layer on top of your kernel methods.

You are not required to specify contracts at this time. However, you are welcome
to be as detailed as you'd like. More detail means you will be able to get more
detailed feedback, which may help you decide which component to ultimately
implement.

## Assignment Checklist
To be sure you have completed everything on this assignment, we have littered
this document with TODO comments. You can browse all of them in VSCode by
opening the TODOs window from the sidebar. The icon looks like a tree and will
likely have a large number next to it indicating the number of TODOS. You'll
chip away at that number over the course of the semester. However, if you'd
like to remove this number, you can disable it by removing the following
line from the `settings.json` file:

```json
"todo-tree.general.showActivityBarBadge": true,
```

Which is not to be confused with the following setting that adds the counts
to the tree diagram (you may remove this one as well):

```json
"todo-tree.tree.showCountsInTree": true,
```

## Assignment Learning Objectives
Without learning objectives, there really is no clear reason why a particular
assessment or activity exists. Therefore, to be completely transparent, here is
what we're hoping you will learn through this particular aspect of the portfolio
project. Specifically, students should be able to:

1. Integrate their areas of interest in their personal lives and/or careers with
   their knowledge of software design
2. Determine the achievablility of a software design given time constraints
3. Design high-level software components following the software sequence
   discipline

## Assignment Rubric: 10 Points
Again, to be completely transparent, most of the portfolio project, except the
final submission, is designed as a formative assessment. Formative assessments
are meant to provide ongoing feedback in the learning process. Therefore,
the rubric is designed to assess the learning objectives *directly* in a way
that is low stakes—meaning you shouldn't have to worry about the grade. Just
do good work.

| Learning Objective                                                                                        | Subcategory                 | Weight | Missing                                                     | Beginning                                                                              | Developing                                                                                     | Meeting                                                                                 |
| --------------------------------------------------------------------------------------------------------- | --------------------------- | ------ | ----------------------------------------------------------- | -------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- |
| Students should be able to identify their values, interests, and/or goals as they relate to their designs | Metacognitive Memory        | 3      | (0) No attempt to summarize values, interests, and/or goals | (1) A brief description of values, interests, and/or goals is provided but lacks depth | (2) A description of values, interests, and/or goals is provided by are not related to designs | (3) A description of values, interests, and/or goals is provided and relates to designs |
| Students should be able to predict the feasibility of their designs                                       | Metacognitive Understanding | 3      | (0) No attempt to design components that are feasible       | (1) At least one component is feasible                                                 | (2) At least two components are feasible                                                       | (3) All three components are feasible                                                   |
| Students should be able to use the OSU discipline in all three designs                                    | Metacognitive Application   | 4      | (0) No attempt to follow the OSU discipline in designs      | (1) At least one design follows the OSU discipline                                     | (3) At least two designs follow the OSU discipline                                             | (4) All three designs follow the OSU discipline                                         |

Below is further rationale/explanation for the rubric items above:

1. Each design must align with your personal values and long-term
   goals. Because the goal of this project is to help your build out a
   portfolio, you really ought to care about what you're designing. We'll give
   you a chance to share your personal values, interests, and long-term goals
   below.
2. Each design must be achievable over the course of a single
   semester. Don't be afraid to design something very small. There is no shame
   in keeping it simple.
3. Each design must fit within the software sequence discipline. In
   other words, your design should expect to inherit from Standard, and it
   should contain both kernel and secondary methods. Also, null and aliasing
   must be avoided, when possible. The methods themselves must also be in
   justifiable locations, such as kernel or secondary.

## Pre-Assignment

> Before you jump in, we want you to take a moment to share your interests
> below. Use this space to talk about your career goals as well as your personal
> hobbies. These will help you clarify your values before you start
> brainstorming. Plus it helps us get to know you better! Feel free to share
> images in this section.
>
 I’ve always been someone who finds balance between creativity and technology. Outside of school, my biggest hobbies are reading and writing poetry. Writing, in particular, has been my way of making sense of the world, and one of my long-term dreams is to publish a poetry book one day—though I’d prefer to do it anonymously. I also enjoy sketching on and off, but unlike my other hobbies, that comes in phases. Reading and writing are constants for me, and they’ve shaped how I think and express myself.
 On the professional side, I’m a Computer Science and Engineering major with a deep interest in AI. I want to use AI not just as a tool but as a way to solve meaningful problems. Having lived with Type 1 diabetes most of my life, I know firsthand how medical technology can both empower and frustrate people. Devices like insulin pumps are lifesaving, but they’re also imperfect. One of my long-term career goals is to improve or even redesign these systems—making them smarter, more accessible, and less intimidating, especially for children. I want to contribute to AI research that creates real social good, whether that’s in healthcare or beyond.
 I want to build a life that balances responsibility with passion. Financial independence matters to me, not just to support myself but also to give back. At the same time, I want to chase personal passions like motorcycles and casual motorsports. I’m also really interested in research and problem-solving. I don’t picture myself in a typical 9–5 forever—I’d rather be part of a team working on discoveries that actually help people. What excites me is being at that intersection of creativity, technology, and making a real impact.

## Assignment
As previously stated, you are tasked with brainstorming 3 possible components.
To aid you in this process, we have provided [some example components][example-components]
that may help you in your brainstorming. All of these components were made at
some point by one of your peers, so you should feel confident that you can
accomplish any of them.

There is no requirement that you use any of the components listed above.
If you want to model something else, go for it! Very common early object
projects usually attempt to model real-world systems like banks, cars,
etc. Make of this whatever seems interesting to you, and keep in mind that
you're just brainstorming right now. You do not have to commit to anything.

### Example Component
To help you brainstorm a few components, we've provided an example below of a
component you already know well: NaturalNumber. We highly recommend that you
mirror the formatting as close as possible in your designs. By following this
format, we can be more confident that your designs will be possible.

- Example Component: `NaturalNumber`
  - **Description**:
    - The purpose of this component is to model a non-negative
      integer. Our intent with this design was to keep a simple kernel that
      provides the minimum functionality needed to represent a natural number.
      Then, we provide more complex mathematical operations in the secondary
      interface.
  - **Kernel Methods**:
    - `void multiplyBy10(int k)`: multiplies `this` by 10 and adds `k`
    - `int divideBy10()`: divides `this` by 10 and reports the remainder
    - `boolean isZero()`: reports whether `this` is zero
  - **Secondary Methods**:
    - `void add(NaturalNumber n)`: adds `n` to `this`
    - `void subtract(NaturalNumber n)`: subtracts `n` from `this`
    - `void multiply(NaturalNumber n)`: multiplies `this` by `n`
    - `NaturalNumber divide(NaturalNumber n)`: divides `this` by `n`, returning
      the remainder
    - ...
  - **Additional Considerations** (*note*: "I don't know" is an acceptable
    answer for each of the following questions):
    - Would this component be mutable? Answer and explain:
      - Yes, basically all OSU components have to be mutable as long as they
        inherit from Standard. `clear`, `newInstance`, and `transferFrom` all
        mutate `this`.
    - Would this component rely on any internal classes (e.g., `Map.Pair`)?
      Answer and explain:
      - No. All methods work with integers or other NaturalNumbers.
    - Would this component need any enums or constants (e.g.,
      `Program.Instruction`)? Answer and explain:
      - Yes. NaturalNumber is base 10, and we track that in a constant called
          `RADIX`.
    - Can you implement your secondary methods using your kernel methods?
      Answer, explain, and give at least one example:
      - Yes. The kernel methods `multiplyBy10` and `divideBy10` can be used to
        manipulate our natural number as needed. For example, to implement
        `increment`, we can trim the last digit off with `divideBy10`, add 1 to
        it, verify that the digit hasn't overflown, and multiply the digit back.
        If the digit overflows, we reset it to zero and recursively call
        `increment`.

Keep in mind that the general idea when putting together these layered designs
is to put the minimal implementation in the kernel. In this case, the kernel is
only responsible for manipulating a digit at a time in the number. The secondary
methods use these manipulations to perform more complex operations like
adding two numbers together.

Also, keep in mind that we don't know the underlying implementation. It would be
completely reasonable to create a `NaturalNumber1L` class which layers the
kernel on top of the existing `BigInteger` class in Java. It would also be
reasonable to implement `NaturalNumber2` on top of `String` as seen in
Project 2. Do not worry about your implementations at this time.

On top of everything above, there is no expectation that you have a perfect
design. Part of the goal of this project is to have you actually use your
component once it's implemented to do something interesting. At which point, you
will likely refine your design to make your implementation easier to use.

### Component Designs

> Please use this section to share your designs.

- Component Design #1: PoetryCollection
  - **Description**:
    The purpose of this component is to model a collection of poems, including drafts and finished pieces. The design focuses on organizing poems with titles, tags, and dates while allowing editing and retrieval. The intent is to support a writer in managing their creative work over time.
  - **Kernel Methods**:
    - `void addPoem(String title, String content)`: adds a new poem with a title and content.
    - `String getPoem(String title)`: retrieves the content of a poem by title
    - `void removePoem(String title)`: removes a poem by title.
  - **Secondary Methods**:
    - `List<String> listTitles()`: lists all poem titles in the collection.
    - `List<String> searchByTag(String tag)`: returns all poems that include a specific tag.
    - `void updatePoem(String title, String newContent)`: updates the content of an existing poem.
    - `String getLatestPoem()`: retrieves the most recently added poem.
  - **Additional Considerations** (*note*: "I don't know" is an acceptable
    answer for each of the following questions):
    - Would this component be mutable? Answer and explain:
      - Yes, Poems will be added, edited, and removed.
    - Would this component rely on any internal classes (e.g., `Map.Pair`)?
      Answer and explain:
      - Possibly since I want to add things like title, content, tags, and date to represent every poem?
    - Would this component need any enums or constants (e.g.,
      `Program.Instruction`)? Answer and explain:
      - A small set of constants for poem status (example `Draft`, `Final`, etc.)
    - Can you implement your secondary methods using your kernel methods?
      Answer, explain, and give at least one example:
      - Yes, for instance, `updatePoem` can be implemented by removing and re-adding a poem with the same title.

- Component Design #2: Reading List
  - **Description**:
    - The purpose of this component is to model the organization of a personal reading list. It supports books/articles that are “to-read,” “in progress,” or “completed,” with the ability to update status and store notes. The intent is to help readers manage and track their reading goals.
  - **Kernel Methods**:
  - `void addBook(String title, String author)`: adds a book with a given title and author.
  - `void removeBook(String title)`: removes a book by title.
  - `String getBook(String title)`: retrieves book details.
  - **Secondary Methods**:
    - `void updateStatus(String title, String status)`: changes a book’s status (example `To_Read`, `In_Progress`, `Completed`).
    - `List<String> listByStatus(String status)`: lists all books under a specific status.
    - `void addNotes(String title, String notes)`: attaches personal notes to a book.
    - `List<String> recommendNextReads()`: suggests books based on unfinished items or certain genres (optional feature).
  - **Additional Considerations** (*note*: "I don't know" is an acceptable
    answer for each of the following questions):
    - Would this component be mutable? Answer and explain:
      - Yes, books will be added, updates, and removed.
    - Would this component rely on any internal classes (e.g., `Map.Pair`)?
      Answer and explain:
      - A book record with fields such as title, authot, status, notes, maybe even genres.
    - Would this component need any enums or constants (e.g.,
      `Program.Instruction`)? Answer and explain:
      - Most probably yes, for reading statuses (To_read, In_Progress, Completed etc.)
    - Can you implement your secondary methods using your kernel methods?
      Answer, explain, and give at least one example:
      - Yep, `updateStatus` relies on retrieving a book first using `getBook`.

- Component Design #3: Watermelon Sugar High! (sorry, I meant GlucoseLog)
  - **Description**:
    - The purpose of this component is to track and store blood glucose levels over time. Each entry includes date, time, and value, along with optional notes such as meal or exercise context. The intent is to provide a structured way for people with diabetes to log and review their glucose patterns.
  - **Kernel Methods**:
    - `void addEntry(int value, String date, String time)`: adds a glucose measurement with date and time.
    - `int getEntry(String date, String time)`: retrieves a glucose measurement for a specific timestamp.
    - `void removeEntry(String date, String time)`: removes a glucose measurement.
  - **Secondary Methods**:
    - `double averageGlucose(String date)`: calculates the average glucose for a given day.
    - `List<Integer> getRange(String startDate, String endDate)`: retrieves glucose values within a date range.
    - `String flagHighLow(int thresholdHigh, int thresholdLow)`: reports if any values fall outside safe ranges.
    - `int getLatestReading()`: retrieves the most recent glucose value.
  - **Additional Considerations** (*note*: "I don't know" is an acceptable
    answer for each of the following questions):
    - Would this component be mutable? Answer and explain:
      - Yes. Data entries of glucose levels will be constantly added and removed.
    - Would this component rely on any internal classes (e.g., `Map.Pair`)?
      Answer and explain:
      - Uhh yes, to represent a log entry with tags/fields such as value, date, time, additonal notes.
    - Would this component need any enums or constants (e.g.,
      `Program.Instruction`)? Answer and explain:
      - Constants for high/low glucose thresholds.
    - Can you implement your secondary methods using your kernel methods?
      Answer, explain, and give at least one example:
      - Yessss. `averageGlucose` is implemented by retrieving all entries with getEntry and calculating a mean.


  > I also had these ideas which I wanted to submit incase any interested you.

  #1 MealPlanner : models the creation of meal plans with nutritional data (carbs, proteins, calories) to support dietary goals.
  Note: I thought this was a litle complicated because I'd have to include all kinds of nutritional info? Which would be frustrating to dooo but let's see.

  #2 Sketchbook : stores sketches with attributes like title, medium, and date for personal tracking.
  Note: really cute. I thought of this while cleaning out my shelf and I found my sketchbook. I think this would be sure fun for people who do digital art but not limited to them.

  #3 Garage: models the customization and maintenance of motorcycles (almost like a game with parts and upgrades)
  Note: very random, more like a game but also super fun??

  #4 FinancialGoalTracker : tracks saving targets, expenses, and investments.

## Post-Assignment

The following sections detail everything that you should do once you've
completed the assignment.

### Changelog

<!-- TODO: create CHANGELOG then delete this comment -->

At the end of every assignment, you should update the
[CHANGELOG.md](../../CHANGELOG.md) file found in the root of the project folder.
Since this is likely the first time you've done this, we would recommend
browsing the existing file. It includes all of the changes made to the portfolio
project template. When you're ready, you should delete this file and start your
own. Here's what I would expect to see at the minimum:

```markdown
# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## YYYY.MM.DD

### Added

- Designed a <!-- insert name of component 1 here --> component
- Designed a <!-- insert name of component 2 here --> component
- Designed a <!-- insert name of component 3 here --> component
```

Here `YYYY.MM.DD` would be the date of your submission, such as 2024.04.21.

You may notice that things are nicely linked in the root CHANGELOG. If you'd
like to accomplish that, you will need to make GitHub releases after each pull
request merge (or at least tag your commits). This is not required.

In the future, the CHANGELOG will be used to document changes in your
designs, so we can gauge your progress. Please keep it updated at each stage
of development.

### Submission
If you have completed the assignment using this template, we recommend that
you convert it to a PDF before submission. If you're not sure how, check out
this [Markdown to PDF guide][markdown-to-pdf-guide]. However, PDFs should be
created for you automatically every time you save, so just double check that
all your work is there before submitting. For future assignments, you will
just be submitting a link to a pull request. This will be the only time
you have to submit any PDFs.

<!-- TODO: upload a PDF of this document and the CHANGELOG to Carmen then delete this comment -->

### Peer Review

<!-- TODO: review the peer review guidelines then delete this comment -->

Following the completion of this assignment, you will be assigned three
students' component brainstorming assignments for review. Your job during the
peer review process is to help your peers flesh out their designs. Specifically,
you should be helping them determine which of their designs would be most
practical to complete this semester. When reviewing your peers' assignments,
please treat them with respect. Note also that we can see your comments, which
could help your case if you're looking to become a grader. Ultimately, we
recommend using the following feedback rubric to ensure that your feedback is
both helpful and respectful (you may want to render the markdown as HTML or a
PDF to read this rubric as a table).

| Criteria of Constructive Feedback | Missing                                                                                                                           | Developing                                                                                                                                                                                                                                | Meeting                                                                                                                                                               |
| --------------------------------- | --------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Specific                          | All feedback is general (not specific)                                                                                            | Some (but not all) feedback is specific and some examples may be provided.                                                                                                                                                                | All feedback is specific, with examples provided where possible                                                                                                       |
| Actionable                        | None of the feedback provides actionable items or suggestions for improvement                                                     | Some feedback provides suggestions for improvement, while some do not                                                                                                                                                                     | All (or nearly all) feedback is actionable; most criticisms are followed by suggestions for improvement                                                               |
| Prioritized                       | Feedback provides only major or minor concerns, but not both. Major and minar concerns are not labeled or feedback is unorganized | Feedback provides both major and minor concerns, but it is not clear which is which and/or the feedback is not as well organized as it could be                                                                                           | Feedback clearly labels major and minor concerns. Feedback is organized in a way that allows the reader to easily understand which points to prioritize in a revision |
| Balanced                          | Feedback describes either strengths or areas of improvement, but not both                                                         | Feedback describes both strengths and areas for improvement, but it is more heavily weighted towards one or the other, and/or descusses both but does not clearly identify which part of the feedback is a strength/area for improvement  | Feedback provides balanced discussion of the document's strengths and areas for improvement. It is clear which piece of feedback is which                             |
| Tactful                           | Overall tone and language are not appropriate (e.g., not considerate, could be interpreted as personal criticism or attack)       | Overall feedback tone and language are general positive, tactul, and non-threatening, but one or more feedback comments could be interpretted as not tactful and/or feedback leans toward personal criticism, not focused on the document | Feedback tone and language are positive, tactful, and non-threatening. Feedback addesses the document, not the writer                                                 |

### Assignment Feedback

If you'd like to give feedback for this assignment (or any assignment, really),
make use of [this survey][survey]. Your feedback helps make assignments
better for future students.

<!-- TODO: follow the link to share your feedback then delete this comment -->

[example-components]: https://therenegadecoder.com/code/the-never-ending-list-of-small-programming-project-ideas/
[markdown-to-pdf-guide]: https://therenegadecoder.com/blog/how-to-convert-markdown-to-a-pdf-3-quick-solutions/
[survey]: https://forms.gle/dumXHo6A4Enucdkq9
