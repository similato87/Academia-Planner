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
Interface: Department, Classes: CSDepartment, SWEDepartment, ECEDepartment
- **Adaptor** (record, recordAdaptor)
Classes: Record, RecordAdaptor
- **Iterator** (students, courses)
Interface: Iterator, Classes: StudentIterator, CourseIterator
- **Composite** (enrollment, transcript)
Interface: Registration, Classes: Transcript 

