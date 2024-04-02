# Supplementary Specification (FURPS+)

## Functionality

_Specifies functionalities that:  
&nbsp; &nbsp; (i) are common across several US/UC;  
&nbsp; &nbsp; (ii) are not related to US/UC, namely: Audit, Reporting and Security._
- The application must enable users to manage teams responsible for green space maintenance.
- It must facilitate the allocation of teams to specific green spaces.
- Users should be able to manage the organization's fleet of vehicles, machinery, and equipment.
- The application should optimize irrigation and lighting systems for green spaces.
- Users must be able to generate statistical indicators to assess the performance of green space management activities.
## Usability

_Evaluates the user interface. It has several subcategories,
among them: error prevention; interface aesthetics and design; help and
documentation; consistency and standards._

- The user interface should be intuitive and easy to navigate for efficient use.
- The system must provide a responsive interface to ensure a smooth user experience.

## Reliability

_Refers to the integrity, compliance and interoperability of the software. The requirements to be considered are: frequency and severity of failure, possibility of recovery, possibility of prediction, accuracy, average time between failures._

- The System must be invulnerable to crashes and data loss.
- The System must be prepared of handling multiple users at the same time without losing performance.

## Performance

_Evaluates the performance requirements of the software, namely: response time, start-up time, recovery time, memory consumption, CPU usage, load capacity and application availability._

- The system must provide fast response times for search and retrieval of property data.
- The application must be capable of handling large amounts of data and users.
- The system must be able to generate reports in a timely and efficient manner.
## Supportability

_The supportability requirements gathers several characteristics, such as:
testability, adaptability, maintainability, compatibility,
configurability, installability, scalability and more._

- All error messages should be detailed.
- All the input data must be tested.
- Should ve used JavaDoc to generate documentation.
- All the images have to be in svg format.

## +

### Design Constraints

_Specifies or constraints the system design process. Examples may include: programming languages, software process, mandatory standards/patterns, use of development tools, class library, etc._

- All the users must be authenticated with a password of seven alphanumeric characters, including three capital letters and two digits.

### Implementation Constraints

_Specifies or constraints the code or construction of a system such
such as: mandatory standards/patterns, implementation languages,
database integrity, resource limits, operating system._

- The application graphical interface is to be developed in JavaFX 11.
- To generate documents it should be used JavaDoc.
- The application must support the English language.
- The application must be design in Java language using the Intellij IDE or NetBeans.

### Interface Constraints

_Specifies or constraints the features inherent to the interaction of the
system being developed with other external systems._

(fill in here )

### Physical Constraints

_Specifies a limitation or physical requirement regarding the hardware used to house the system, as for example: material, shape, size or weight._

- The user must have the basic I/O Devices;