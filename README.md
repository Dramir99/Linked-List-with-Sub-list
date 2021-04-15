# Linked-List-with-Sub-list
Author: Daniel Ramirez

- implementing a new version of a linked list.  
- This is a linked list which has possible sublists descending from each node. 
- These sublists are used to group together all nodes which share a common category value.  
<img src="https://github.com/Dramir99/Linked-List-with-Sub-list/blob/main/Linked_List_Example/List_W_SubList.JPG" alt="New Linked List"/>

# 🛠 Installation & Set Up
1. Install the files
```
Open up the Folder Linked_List_W_Sub_List
```
```
Launch GUI_Main_Tester.java
```


# Running the JavaFX Application
1. Main Menu
<img src="https://github.com/Dramir99/Linked-List-with-Sub-list/blob/main/Linked_List_Example/Main_Menu_Example.jpg" alt="Main Menu"/>

- Click on the start button to start the JavaFX Application
- Click on setting button to populate the Data with a pre-populate .csv file
- Quit the JavaFX Application

2. Database
<img src="https://github.com/Dramir99/Linked-List-with-Sub-list/blob/main/Linked_List_Example/Linked_List_Menu_Example.jpg" alt="Database Menu" />

Database Menu to click if you want to:

- Add a Node
- Delete a Node
- Delete Last Node
- Delete First Node
- Delete any Node
- Get a Node's Category from the Main List
- Get a Node's Category from the Sub-list
- Update list to a new category
- Get the size of the Main List
- Get the size of the respective Sub-List
- Clear the List

3. Add a Node
---
- Need to type in the three parameters. 
- These parameters are the values of the categories in a Node.
---

4. Delete Last Node
---
- Allows you to delete the last Node from the List
---

5. Delete First Node
---
- Allows you to delete the first Node from the List
---

6. Delete Any Node
---
- method shall delete a specific node from anywhere in the list, given the mainIndex and subIndex.
---

# you can delete a specific Node to delete
<img src="https://github.com/Dramir99/Linked-List-with-Sub-list/blob/main/Linked_List_Example/Delete_Node_Example.jpg" alt="Delete Menu" />

7. Get a Node's Category from the Main List
---
- method shall have an mainIndex, which is an index (starting from 0) which indicates the Node from the main branch you want to retrieve.
---

# You can retreive a Node Category from the main List
<img src="https://github.com/Dramir99/Linked-List-with-Sub-list/blob/main/Linked_List_Example/Get_Category_Example.jpg" alt="Populate Data Menu" />

8. get a Node's category from the sub-list
---
- This method shall have an subIndex, which is an index (starting from 0) which indicates the Node from the sub-list of the chosen main branch Node.
- This method shall have another integer parameter, category, which is a category number (1 - 3) that will indicate which category's value you want to retrieve.
---

# You can retreive a Node Category from the Sub-List
<img src="https://github.com/Dramir99/Linked-List-with-Sub-list/blob/main/Linked_List_Example/Get_Sub_Category.jpg" alt="Populate Data Menu" />

9. Update list to a new Category
---
-  regrouping your LinkedList based on the given regrouping category number.
- Ex: I could take the above list from the diagram, which was initially grouped based on the Genre category (category 1), and I could regroup the list based on the ESRB Rating category (category 3).
---

# You can retreive a Node Category from the Sub-List
<img src="https://github.com/Dramir99/Linked-List-with-Sub-list/blob/main/Linked_List_Example/Regroup_the_List.jpg" alt="Populate Data Menu" />

10. Get the size of the Main list
---
- return the size of the Main list.
---

11. Get the size of the Sub-List relative to the Main-List
---
- return the size of the sub-list at the given index.
---

12. Clear the List
---
- Allows you to clear the list.
---

13. View the List

