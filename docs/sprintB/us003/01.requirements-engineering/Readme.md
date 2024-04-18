# US 003 - Want to register a collaborator with a job and fundamental characteristics.



## 1. Requirements Engineering

### 1.1. User Story Description

As an HRM, I want to be able to register a collaborator with their assigned job and fundamental characteristics within the organization's system
### 1.2. Customer Specifications and Clarifications

**From the specifications document**

>The HRM needs to input collaborator details, including name, birthdate, admission date, address, contact information (mobile and email), ID document type, and respective number.

>After entering collaborator data, the system should allow the HRM to select the job for the collaborator and assign it.

>The system must generate a random password for each collaborator, which is then sent via email.

>Upon successful registration, the system should display "operation success".

**From the client clarifications**

> **Question:** What should be the accepted format for the emails? Should only specific email services be accepted?
>
> **Answer:** A valid email address consists of an email prefix and an email domain, both in acceptable formats.
The prefix appears to the left of the @ symbol. The domain appears to the right of the @ symbol.
For example, in the address example@mail.com, "example" is the email prefix, and "mail.com" is the email domain.

> **Question:** What is needed for the adress ?  Street, zipcode and a city?
>
> **Answer:** That would be enough.

> **Question:** I have some questions regarding the business rules of this US:
Is there any limitation regarding the length of the name of the collaborator?
Should we consider valid only the birthdates in which the collaborator has more than 18 years?
What should be the format for the phone number? 9 numbers?
What is the format for the numbers from the id doc types?
Are there any other business rules?
>
> **Answer:** According to the Portuguese law a name should contain at maximum six words;
yes;
validating 9 digits will be acceptable; validating with international format would be excelent;
each doc type has specific formats like taxpayer number, Citizen Card ou passport.

> **Question:** Should the system able the HRM to insert multiple collaborators in one interaction before saving them.
>
> **Answer:** it's not required to do so.

> **Question:**  Which information is mandatory to insert a collaborator in the program (fundamental characteristics)?
>
> **Answer:**  name, birth date, admission date, address, contact info (mobile and email), taxpayer number, ID doc type and respective number

> **Question:** Does the HRM select the job from a list that we display?
>
> **Answer:** displaying or not, It's a matter of UX, the dev team should decide about it, but the valid jobs are the ones created within the US02.

> **Question:** When creating a collaborator with an existing name ... What the system do?
>
> **Answer:** It's not common and most improbable to have different individual with same name in the same context, however it’s ID documentation number should be unique for sure.



### 1.3. Acceptance Criteria
- AC1: A password with eight characters, including three capital letters and two digits, is automatically generated and sent by email to the collaborator.
- AC2: The system should validate the email format as per the standard email address structure.
- AC3: The address should include street, zipcode, and city.
- AC4: The system should validate that the collaborator's birthdate meets the legal age requirement.
- AC5: The phone number should be validated to have exactly 9 digits.
- AC6: The ID document number should adhere to specific formats based on the selected document type.
- AC7: Upon successful registration, the system should generate an automatically generated password for the collaborator.
- AC8: The system should provide confirmation of the success or failure of the registration operation.
### 1.4 Found out Dependencies

- The system functionality for registering collaborators depends on accurate input of their personal and professional details.
- Validation of email addresses, phone numbers, and ID document numbers depends on predefined formats and rules.
- The generation of an automatically generated password relies on successful registration.

### 1.5 Input and Output Data

Input Data:

- Typed data:

    - Name of the collaborator
    - Birthdate
    - Admission date
    - Address
    - Contact information (mobile and email)
    - ID document type
    - ID document number
- Selected data:

    - Assigned job for the collaborator
- Output Data:

    - Automatically generated password for the collaborator.
    - Confirmation of the success or failure of the registration operation.
### 1.6. System Sequence Diagram (SSD)

**Other alternatives might exist.**

#### Alternative One

![US003-SSD](svg/us003-system-sequence-diagram-alternative-one.svg)

### 1.7 Other Relevant Remarks

- The system should consider incorporating international phone number format validation for enhanced usability.
- It's imperative to ensure that ID document numbers are unique to avoid conflicts in the system.
- Exception handling should be implemented to address scenarios such as duplicate names or failed registrations gracefully.
- The system should adhere to relevant legal regulations and standards, particularly concerning data privacy and protection.
