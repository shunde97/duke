# Double McSpicy User Guide  
Double McSpicy is an easy to use bot which helps you keep track of your tasks, or when you just need a friend.
## Features 

### Add tasks 
Adds a ToDo, Deadline, or Event task to the list of tasks.
### Generate list of tasks 
Generate the current list of tasks with their description and whether they are done or not
### Delete tasks 
Deletes a task from the list of tasks based on the index of the tasks.
### Find tasks 
Finds task(s) which contains the desired keyword in the list of tasks.
### Mark tasks as done 
Marks a tasks from the list of tasks as done, based on the position.
### Mass delete tasks  
Delete tasks which contains the desired keyword from the list of tasks.
### Mass mark done tasks 
Mark all tasks containing the desired keyword as done.
### Save list of tasks for future use 
Close the app and saves the current list of tasks so that when Double McSpicy is opened in future, the list of tasks is still accessible.

## Usage

### `todo` - Adds a ToDo task to the list of tasks
Adds a ToDo task to the list of task

Format is `todo [description]`

Example of usage: 

`todo submit iP`

Expected outcome:

![ToDo expected outcome](Todo.png)

### `event` - Adds an Event task to the list of tasks
Adds an Event task to the list of tasks, with information about the event. The information
about the event can be the time, date, or place that the event is happening or even a combination of the above, it need
not follow a format.
The important thing about the usage is the `/at` after the description.


Format is `Event [description] /at [information]`

Example of usage: 

`event ip celebration /at tuesday 2359`

`event buffet /at raffles place tuesday 05/08/1997 7pm`

Expected outcome:

![Event expected outcome](Event.png)

### `deadline` - Adds a Deadline task to the list of tasks
Adds a Deadline task to the list of tasks, with the date and/or time of the deadline. 

The important things about the usage is the `/by` after the description and to follow the format of the date and time
below.

Format is `Deadline [description] /by [date and/or time]`, the date must be in DD/MM/YYYY format or YYYY-MM-DD format
and the time must be in HHMM format.

Example of usage: 

`deadline submit ip /by 02/03/2020 2359`

`deadline submit ip /by 02/03/2020`

Expected outcome:

![Deadline expected outcome](Deadline.png)

### `list` - Generate the list of tasks
Generate the list of tasks and their information.

Format is `list`

Example of usage: 

`list`

Expected outcome:

![list expected outcome](list.png)

### `delete` - Deletes a task from the list
Deletes a task from the list based on its numerical position in the list 
The important things about the usage is number given must fall within the range of number of tasks on the list.

Format is `delete [position]`

Example of usage: 

`delete 3`

Expected outcome:

![delete expected outcome](Delete.png)

### `find` - Searches for tasks from the list which contains the desired keyword
Displays tasks from the list which contains the desired keyword

Format is `find [keyword]`

Example of usage: 

`find project`

Expected outcome:

![find expected outcome](find.png)

### `done` - mark the desired task as done based on the given position of task
Given the position of a task, marks it as done. It is not reversible until further editions of this bot.
It is important that the number/position given falls within the size of the list.

Format is `done [position]`

Example of usage: 

`done 2`

Expected outcome:

![done expected outcome](done.png)

### `massdelete` - delete all tasks containing the desired keyword
Deletes all tasks from the list which contains the desired keyword

Format is `massdelete [keyword]`

Example of usage: 

`massdelete project`

Expected outcome:

![massdelete expected outcome](massdelete.png)

### `massdone` - marks all tasks containing the desired keyword as done
Marks all tasks from the list which contains the desired keyword as done, it is not reversible as of this update.

Format is `massdone [keyword]`

Example of usage: 

`massdone project`

Expected outcome:

![massdone expected outcome](massdone.png)

### `bye` - saves the current list of tasks and closes the window
It saves all the tasks and their respective information and status of done/not done, and closes the window.

Format is `bye`

Example of usage: 

`bye`

Expected outcome:

The window closes




## Acknowledgements
Credits to Jeffry Lum for the tutorial and code for gradle, fxml, and javafx files -  [iP Tutorials](https://github.com/nus-cs2103-AY1920S2/duke/blob/master/tutorials/javaFxTutorialPart4.md)

Acknowledgements for images used:
[Double McSpicy](https://www.mcdonalds.com.sg/food-menu/double-mcspicy/) is from McDonalds Singapore, [Homer Drooling](https://www.pinterest.com/pin/488218415832350967/) is from Pinterest