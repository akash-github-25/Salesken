
# Student_Reporting_System

This is a Student Reporting System where a Student's data like Semester , marks etc will be 
present and the user will be able to do functions 
like calulate average marks across semester,
average marks in a particular subject , data of
top two consitent performers etc.


## Features

- Add Student.
- Add Marks.
- Get Average Marks Across Semester.
- Get Average Marks In a Particular Semester.
- Top Two Performing Student Across Semester.





## Tech Stack

* SPRING BOOT
* SPRING DATA JPA
* SPRING BOOT DEVTOOLS
* MySQL DATABASE

## ASSUMPTIONS

* Two Semester.
* Three Subjects.
## FLOW
* ADD  STUDENT IN THE DATABASE.
* ADD MARKS FOR RESPECTIVE SEMETER OF A STUDENT IN THE DATABASE.
* GET AVERAGE MARKS ACROSS ALL SEMESTER IN A SUBJECT.
* GET AVERAGE MARKS IN A PARTICULAR SEMESTER.
* GET TOP TWO CONSITENT PERFORMER.
## DATABASE DETAILS
*  I have used port 8321 , and the name  of my database is "studentReport" with three tables namely -
     student , marks , marks_students .

## API Reference

#### ADD STUDENT

```http
  /saveStudent
```

#### ADD MARKS

```http
  /addMarks/{studentId}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `studentId` | `Integer` | **Required**. |


#### GET AVERAGE BY SEMESTER

```http
  /getAvgBySem/{semesterId}
  ```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `semesterId` | `Integer` | **Required**. |

#### GET AVERAGE ACROSS SEMESTER

```http
  /getAvgAcrossSem/{studentId}/{subject}
  ```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `studentId` | `Integer` | **Required**. |
| `subject` | `String` | **Required**. |

#### TOP TWO PERFORMER ACROSS SEMESTER

```http
  /getTwoConsistentTopPerformerAcrossSem
  ```





