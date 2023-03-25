# Academia-Planner
The system we are going to build is a course registration system.  
## Software Patterns
- **Singleton**  
Classes: Database
- **Proxy** (enrollments)  
Classes: EnrollmentProxy
- **Builder** (enrollments)
Classes: EnrollmentBuilder
- **Factory method** (department)
Interface: Department, DepartmentFactory Classes: CSDepartment(Factory), SWEDepartment(Factory), ECEDepartment(Factory)
- **Adaptor** (record, recordAdaptor)
Classes: Record, RecordAdaptor
- **Iterator** (students, courses)
Interface: Iterator, Classes: StudentIterator, CourseIterator
- **Composite** (enrollment, transcript)
Interface: Registration, Classes: Transcript
## Result
Demo: Example to create a student's transcript
```
CS1073 Java I A 16.0
CS1073 Java I A 16.0
CS1083 Java II B- 10.8
SWE4403 Software Design Patterns and Architecture A- 14.8
Transcript of John Doe(ID:3333333)
Average Percentage: 81.66666666666667

Search for student with ID: 3333333
Student: John Doe(3333333), Business, Fredericton

Search for course with code: CS1073
Course[code='CS1073', name='Java I']

Search for enrollment with ID: 1
Enrollment (1): John Doe(3333333)	CS1083	70.0	pass

Process finished with exit code 0
```

