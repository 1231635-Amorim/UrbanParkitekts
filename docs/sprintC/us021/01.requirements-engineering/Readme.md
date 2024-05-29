# US 004 - Want to assign one or more skills to a collaborator.



## 1. Requirements Engineering

### 1.1. User Story Description

As an HRM (Human Resources Manager),
I want to assign one or more skills to a collaborator,
So that I can manage their skillsets effectively within the organization.
### 1.2. Customer Specifications and Clarifications

**From the specifications document**

>The HRM should be able to assign skills to collaborators.

>The system should provide a list of available skills for the HRM to choose from.

>The HRM should be able to assign multiple skills to a single collaborator.

>The system should accurately display the assigned skills for each collaborator.

>The assignment of skills should be done through a user-friendly interface to ensure ease of use for the HRM.

>The system should validate the selection of skills and provide feedback to the HRM if any errors occur during the assignment process.

**From the client clarifications**

> **Question:** In US04 it concerns the association of skills with an employee. My question is: 1. if there is a minimum and maximum number of skills; 2. if there is any special characteristic that the collaborator needs to have in order for these skills to be added.
>
> **Answer:** No; No.

> **Question:** Can any skill be registered to any collaborator/job? Or should they be associated in categories in association with a specific job
>
> **Answer:** There is no association, it totally depends of the CV of the collaborator.

> **Question:** Should it be possible to add the same skill to a collaborator multiple times?
>
> **Answer:** That does not make sense.

> **Question:** Is there any certification/proof needed to register a skill to a colaborator?
>
> **Answer:** No.

> **Question:** Can a collaborator have no skills assigned?
>
> **Answer:** Yes.

### 1.3. Acceptance Criteria
- AC1: There are no minimum or maximum limits on the number of skills that can be assigned to a collaborator.
- AC2: There are no special characteristics required for a collaborator in order to have skills added.
- AC3: Skills can be registered to any collaborator/job without any association or categorization requirements.
- AC4: It should not be possible to add the same skill to a collaborator multiple times.
- AC5: No certification or proof is needed to register a skill to a collaborator.
- AC6: A collaborator can have no skills assigned if necessary.
### 1.4 Found out Dependencies

- The assignment of skills to collaborators does not depend on any external factors or dependencies.

### 1.5 Input and Output Data

Input Data:

- Selected skill(s) to be assigned to a collaborator.

Output Data:

- Confirmation of successful skill assignment or relevant error message if assignment fails.

### 1.6. System Sequence Diagram (SSD)

**Other alternatives might exist.**

#### Alternative One

![US004-SSD](svg/us004-system-sequence-diagram.svg)

### 1.7 Other Relevant Remarks

- The system should include validation checks to prevent the addition of duplicate skills to a collaborator.
- A user-friendly interface should guide HRMs through the process of assigning skills, ensuring ease of use and reducing the likelihood of errors.
- The system should provide clear feedback to HRMs after skill assignments are made, indicating whether the operation was successful or unsuccessful.

