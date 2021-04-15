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
<img src="https://github.com/Dramir99/University-Database/blob/main/University_Database_Example_Images/Database_Menu.JPG" alt="Database Menu" />

Database Menu to click if you want to:

- Find person
- Compare People
- Add a person
- Delete a Person 
- Populate the Database With a CSV file

3. Find Person in the database
---
- Cant search for people who are in different Years
- if you want to find all the people in the database then you leave first name and last name blank and put the data type to be "Person" and it will return everyone in the database
- this works for each data type so if you want all Employees you do the same and for Students, Faculty and Staff each leaving their respective text fields blank as well.
- If you want to search through freshman or sophomore then you leave everything else blank other then the class rank
- same thing for th other fields depending on what you want to find or if you wan to use all available each works and if you don't find anything it will return with "no one found"
---

# You can see all the different people inside the database
<img src="https://github.com/Dramir99/University-Database/blob/main/University_Database_Example_Images/Find_Person_Type.JPG" alt="Different type of people" />

# You can search a person dynamcially and will return multiple matches
<img src="https://github.com/Dramir99/University-Database/blob/main/University_Database_Example_Images/Student_Example.jpg" alt="Different type of Students" />

# Looking at different Students years
<img src="https://github.com/Dramir99/University-Database/blob/main/University_Database_Example_Images/Find_Person_Student_Example.JPG" alt="Find Student example" />

4. Compare People in the database
---
- Compares if the two People are the exact same People
- I only allow you to checkbox at most 2 people 
- Program will set the visibility to all other checkbox to be false to only force you to compare them
---

# You can Compare two people from the Database
<img src="https://github.com/Dramir99/University-Database/blob/main/University_Database_Example_Images/Compare_Person_Menu.jpg" alt="Compare people example" />

# Example of comparing two people
<img src="https://github.com/Dramir99/University-Database/blob/main/University_Database_Example_Images/Compare_Person_result.jpg" alt="Compare people result" />

5. Add person to the database
---
- you will first choose which type of person you would like to add
- add the texts into the text fields and if you don't put a number into the zip code or phoneNumber or street/apartment number then it will add a label to tell you that the data type is wrong.
- if you leave the text fields blank a label will appear telling you to fil in something and if the phone number format is wrong then the label wil switch to tell you that the format is wrong.
- after adding someone you can use the find button to check that your person is added.
---

# you can choose which type of person to add to the Database
<img src="https://github.com/Dramir99/University-Database/blob/main/University_Database_Example_Images/add_person_menu.jpg" alt="Add a person menu" />

# Example of adding a student
<img src="https://github.com/Dramir99/University-Database/blob/main/University_Database_Example_Images/add_student_example.jpg" alt="Add a person example" />

6. delete a person from a database
---
- you can only delete one person at a time and a label will pop out and tell you who you deleted
- if you choose to delete more, the option is their but its not fully functional.
---

# you can select someone from the database to delete
<img src="https://github.com/Dramir99/University-Database/blob/main/University_Database_Example_Images/Delete_Menu.jpg" alt="Delete Menu" />

7. populate the database with a csv

---
- You will be automatically started in the /src location and then you go into the file to download a "People.csv" file
- I only allow you to see files that are .csv since that the only file that should be read.
- the output file works too and it will output the file in .txt format and it will show a label that your stuff is printed or read depending on the option that is selected.
---

# you can dowload a database or write a text file with the given database
<img src="https://github.com/Dramir99/University-Database/blob/main/University_Database_Example_Images/Populate_database_menu.jpg" alt="Populate Data Menu" />

