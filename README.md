# SOFE 3650 – Assignment 2: Architectural MVC Patterns and Frameworks

**Course:** SOFE 3650 – Software Architecture  
**Instructor:** Dr. Hani Sami  
**Date:** 09 September 2025  
**Group Members:**  
- Mohid Sohail  100912993 - deliverable 3 and 2
- Hanzalah Imran  100912657 - deliverable 1 and 2 and 3
- Burhanuddin Mohammed 100943760 - deliverable 4 and 1 and 2

There was no single person working on one thing. We all worked as a group on each deliverable. 

---

## Assignment Overview

This assignment focuses on understanding the **Model-View-Controller (MVC)** architectural pattern and its implementation in **Java Swing**. Through this exercise, we explore how Swing supports GUI development, how MVC structure is realized in practice, and how it can be applied to a simple **Cash Register system**.

[Draw.io File](https://drive.google.com/file/d/1ZafGlkijgFtM5V7w3ryEmxI8YcMw8WFW/view?usp=sharing)

---

## Deliverable 1 – Swing Framework Investigation

The framework of **Java Swing** is a built-in library that provides tools for creating **Graphical User Interfaces (GUI)** in Java. Swing includes lightweight components such as **buttons, tables, windows, and labels** that make it easy to build responsive desktop applications. It is **platform-independent**, built entirely in Java, and follows the **MVC pattern**, which helps separate logic, control, and presentation.

At the top of Swing’s hierarchy, every class extends from `Object`, the root of all Java classes. The `Component` class provides the basic properties that all GUI elements share—such as size, color, and visibility. The `Container` class extends `Component` and groups other components using layout managers.

Most Swing widgets are derived from `JComponent`, which adds functionality like borders, tooltips, and custom rendering. From there, classes such as `AbstractButton` define clickable elements like `JButton`, `JToggleButton`, and `JCheckBox`. Other important elements include:
- `JLabel` — displays text or images  
- `JTextField` — allows text input  
- `JTable` — organizes data into rows and columns  
- `JPanel` — serves as a layout container  
- `JFrame` — represents the main application window that holds all components  

Together, these classes form the foundation for building interactive and structured Swing interfaces.

### UML Class Diagram of Java Swing Components
*<img width="1441" height="1036" alt="Screenshot 2025-10-09 163745" src="https://github.com/user-attachments/assets/a6d548ef-65f3-4f5d-b648-196fe8735b12" />*

---

## Deliverable 2 – MVC Implementation Analysis

The provided GitHub example demonstrates the **MVC pattern** using three main files: `Model.java`, `View.java`, and `Controller.java`.

- **Model.java** — Stores user data such as first and last names. It includes getters and setters to manage and update this information.  
- **View.java** — Defines the graphical user interface with labels and text fields, displaying data and handling user interaction.  
- **Controller.java** — Acts as the intermediary between the Model and View, processing user input and updating both layers accordingly.

While the example correctly reflects the MVC principles by keeping components separate and maintaining clear responsibilities, it differs from the **traditional MVC pattern**. Typically, the Model notifies the View and Controller of state changes automatically using the **Observer pattern**. However, in this implementation, the **Controller manually updates** both the Model and the View whenever a change occurs.

---

## Deliverable 3 – Cash Register Application (Swing MVC)

For this part, we extended the existing Swing MVC example to simulate a simple Cash Register system. A Scanner class was added to emulate product scanning. Each time the Scan button is pressed, it randomly selects a UPC code and displays the corresponding product name and price from a file. The Model (CashRegister.java) stores the product data and calculates the running subtotal. The Controller (Controller.java) handles the scan events and updates both the Model and View. The View (Display.java) shows all scanned items and their prices in a scrollable list, along with the updated subtotal. Each button press dynamically updates the interface, showing multiple scanned products and their total cost in real time.

---

## Deliverable 4 – Sequence Diagram

The following sequence diagram represents **a single press of the Scan button**, illustrating the interactions among the View, Controller, Model, and Scanner components.

### Sequence Diagram: “Scan” Button Press

*<img width="1617" height="1131" alt="Screenshot 2025-10-09 155908" src="https://github.com/user-attachments/assets/1af26421-ac73-40fe-864d-ccdefa3113d1" />*

---

