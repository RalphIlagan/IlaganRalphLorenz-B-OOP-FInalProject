<div align="center"> <img src="https://github.com/user-attachments/assets/dc6b5547-8896-4f19-a15a-5260dbf9955d">

  # CommUnity
 **Community Support System**</div>
 

**I. Project Overview**

------------------------------------------

  • The Community Support System (CommUnity) is designed to connect individuals or organizations in need with those offering assistance, fostering collaboration and community resilience. Its intuitive interface allows users to submit and manage support requests and offers efficiently while maintaining transparency and accountability. The application’s primary purpose is to streamline community-driven efforts to address social challenges, promote inclusivity, and support vulnerable populations.


**II. Explanation of how OOP principles were applied**

1. Encapsulation:
 Encapsulation refers to the bundling of data (attributes) and methods (functions) that operate on the data within a single unit or class. It hides the internal details and only exposes necessary parts of an object, typically through getter and setter methods.
In my app:
Request and Offer classes encapsulate their specific data related to support requests and offers (e.g., name, description, contact number, status). These classes are responsible for managing their own internal state, making sure it is accessed and modified only through appropriate methods.
CommunitySupportSystem encapsulates the logic for managing requests and offers. For example, the methods addRequest, addOffer, getRequestsTableModel, and getOffersTableModel allow interaction with the system's data without exposing internal details. This ensures that the data is well-protected and can only be accessed or modified via specific operations.
Accuracy: This is a correct description of encapsulation in your system.
2. Inheritance:
Inheritance allows a class (subclass) to inherit attributes and behaviors (methods) from another class (superclass). This allows you to reuse code and create specialized behavior in subclasses.
In my App:
Request and Offer classes inherit from the abstract class SupportItem. The common properties (like name, description, contact number, status) are defined in SupportItem to avoid duplication in the Request and Offer classes.
The Request and Offer classes add their own specific behavior (e.g., how a request or offer is fulfilled), which is different from one another but still shares the common attributes defined in SupportItem.
Accuracy: This description of inheritance is accurate. You're using inheritance to define shared attributes and behaviors in a common superclass, while allowing subclasses to specialize certain aspects.
3. Polymorphism:
 Polymorphism allows different classes to define methods with the same name but potentially different implementations. The correct method is chosen at runtime based on the actual object type.
In my App:
Polymorphism is demonstrated by the fulfill(String name, String contactNumber) method. This method is declared in the SupportItem class as an abstract method and then implemented differently in the Request and Offer classes to suit the specific logic for fulfilling a request or an offer.
When you call the fulfill method on a SupportItem (which could be either a Request or an Offer), the Java runtime will automatically choose the correct implementation based on the object type. This is the polymorphic behavior.
CommunitySupportApp handles both requests and offers without needing to know the exact class. It interacts with the common superclass SupportItem, and this abstraction makes the code simpler and more flexible.
Accuracy: This is a correct explanation of how polymorphism is applied in your app. The fulfill method is overridden in both Request and Offer classes, and polymorphism ensures the correct version is called based on the object's type.
4. Abstraction:
What It Is: Abstraction hides complex implementation details and exposes only essential features. It simplifies interaction with complex systems by allowing the user to focus on high-level concepts rather than implementation details.
In Your App:
The SupportItem class provides an abstraction for both requests and offers. It defines common attributes (like name, description, status) and behaviors (like fulfill()), which are shared between the Request and Offer classes.
Users of the application don’t need to know whether they are interacting with a Request or an Offer because they are treated generically as SupportItem objects. The code interacting with these objects focuses on the high-level behavior (e.g., fulfilling an item) without needing to worry about the specifics of whether it's a request or an offer.
