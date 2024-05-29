## 3. Design - User Story Realization

### 3.1. Rationale

**The rationale grounds on the SSD interactions and the identified input/output data.**

| Interaction ID | Question: Which class is responsible for... | Answer  | Justification (with patterns)  |
|:---------------|:--------------------- |:------------|:---------------------------- |
| Step 1  		     |	Assigning a skill to a user						 | RegisterSkillUI            | UI presents options and captures user input                             |
| Step 2  		     |	Providing the number of skills to assign					 | RegisterSkillUI            |  UI prompts the HR Manager for input                            |
| Step 3  		     |	Getting the list of collaborators						 | RegisterSkillController            | Controller interacts with CollaboratorRepository to retrieve collaborators                             |
| Step 4  		     |	Returning the list of collaborators						 | CollaboratorRepository            |  Repository interacts with the database to fetch collaborators                            |
| Step 5  		     |	Listing collaborators and selecting one						 | RegisterSkillUI            | UI displays a list and captures user selection                             |
| Step 6  		     |	Writing the skills						 | RegisterSkillUI            | UI prompts the HR Manager to input skills                             |              
| Step 7  		     |	Registering a skill						 | RegisterSkillController            |  Controller creates and registers the skill                            |
| Step 8  		     |	Returning the registered skill						 | RegisterSkillController            |  Controller interacts with Skill to return the registered skill                            |
| Step 9         |  Saving the skill to the database                                    |  SkillRepository                    | Repository interacts with the database to save the skill                             |
| Step 10        |  Confirming successful registration                                    | RegisterSkillUI                     | UI displays success message to HR Manager                             |

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are:

* Human Resources Manager
* Skill

Other software classes (i.e. Pure Fabrication) identified:

* RegisterSkillUI
* RegisterSkillController
* CollaboratorRepository
* SkillRepository

## 3.2. Sequence Diagram (SD)

_In this section, it is suggested to present an UML dynamic view representing the sequence of interactions between software objects that allows to fulfill the requirements._

![US004-SD](svg/us004-sequence-diagram.svg)

## 3.3. Class Diagram (CD)

_In this section, it is suggested to present an UML static view representing the main related software classes that are involved in fulfilling the requirements as well as their relations, attributes and methods._

![US004-CD](svg/us004-class-diagram.svg)
