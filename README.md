I'm<div align="center"> <img src="https://github.com/user-attachments/assets/dc6b5547-8896-4f19-a15a-5260dbf9955d">

  # CommUnity
 **Community Support System**</div>
 

**I. Project Overview**

------------------------------------------

  • The Community Support System (CommUnity) is designed to connect individuals or organizations in need with those offering assistance, fostering collaboration and community resilience. Its intuitive interface allows users to submit and manage support requests and offers efficiently while maintaining transparency and accountability. The application’s primary purpose is to streamline community-driven efforts to address social challenges, promote inclusivity, and support vulnerable populations.


**SDG 11: SUSTAINABLE CITIES AND COMMUNITIES**

------------------------------------------

•The Community Support System (CommUnity) aligns with Sustainable Development Goal 11: Sustainable Cities and Communities, which aims to promote inclusivity, resilience, and sustainability. This platform connects individuals and organizations by allowing users to submit and fulfill support requests or offers, helping to bridge gaps in local resources and services. By fostering collaboration and resource-sharing, CommUnity contributes to strengthening community resilience in addressing challenges such as disasters, economic crises, or social inequalities. The app's design prioritizes ease of use and accessibility for marginalized groups, empowering them to participate actively. In this way, the project supports the creation of more inclusive, sustainable, and resilient urban and rural communities.

CommUnity expands support and assistance within local communities, not only strengthening individuals' capacity but also promoting unity and cooperation on a larger scale. By leveraging technology, it helps improve living conditions and address critical needs in communities that may not always be reached by traditional support systems.


**OOP PRINCIPLES**

------------------------------------------

1. Encapsulation

Encapsulation is the bundling of data and methods that operate on that data within a single unit (class) and restricting direct access to some components.

Implementation:

Private fields: In classes like Request, Offer, and SupportItem, attributes such as name, supportType, description, status, and contactNumber are marked as private to prevent unauthorized access.

Getters and setters: Controlled access to these private fields is provided through public methods (e.g., getName(), setStatus()), allowing safe modifications and retrieval.



2. Inheritance

Inheritance allows one class (subclass) to acquire the properties and behaviors of another class (superclass), promoting reusability.

Implementation:

The Request and Offer classes inherit from the abstract SupportItem class, which defines common fields (name, supportType, description, contactNumber, status) and methods (getName(), fulfill()).

Specific behaviors such as fulfilling requests or offers are implemented in the Request and Offer subclasses.



3. Polymorphism

Definition: Polymorphism enables objects of different classes to be treated as objects of a common superclass, allowing a single interface to represent different underlying forms (method overriding).

Implementation:

The fulfill() method is declared as abstract in the SupportItem class and implemented differently in Request and Offer classes:

For Request, fulfill() updates the status to "Supplied" and stores the fulfiller's details.

For Offer, fulfill() updates the status to "Claimed" and stores the claimer's details.


This allows a consistent method (fulfill()) to be called on any SupportItem object without needing to know its exact type.




4. Abstraction

Abstraction involves hiding implementation details and exposing only essential features, focusing on what an object does rather than how it does it.

Implementation:

The SupportItem class serves as an abstraction for shared properties and methods among Request and Offer.

The CommunitySupportSystem class abstracts the logic for managing requests and offers, exposing high-level methods like addRequest(), addOffer(), and resetAll().

Users interact with the CommunitySupportApp GUI without needing to understand the backend logic.

# GETTING STARTED

**INSTALLATION**

1 .Ensure you have Java installed (minimum version 😎.

2. A text editor or IDE like IntelliJ IDEA or Eclipse is recommended for editing the code.

3. Place the program files (CommunitySupportApp.java, CommunitySupportSystem.java, Offer.java, Request.java, SupportItem.java) in the same directory.

**Setup:**

1.Create empty text files named requests.txt and offers.txt in the root directory of the program to store data persistently.

**RUNNING THE PROGRAM**

1. Execute the program with:

     java CommunitySupportApp

2. The GUI will open, allowing interaction with the features.

**Error Handling**

⚠️ TAKE NOTE: If any file-related error occurs (e.g., missing requests.txt or offers.txt), ensure the files are created and accessible.




